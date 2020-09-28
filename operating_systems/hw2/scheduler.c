/**
* Scheduler simulation using various algorithms.
* author: Omar Barazanji
* date: 9/23/2020
* sources: Auburn University 
*/

//imports
#include <stdio.h>
#include <string.h>

// Global variables
typedef unsigned int u_int;
#define MAX_TASK_NUM 32
typedef struct task_info {
    u_int pid;
    u_int arrival_time;
    u_int burst_time;
} task_struct;

// Function instantiations
void read_file(FILE *file_desc, task_struct task_list[], int *size);
int open_file(char *name, FILE **file_descriptor);
void print_task_list(task_struct task_list[], int size);
int open_file(char *name, FILE **file_descriptor);
void FCFS(task_struct task_list[], int size);


int main(int argc, char *argv[]) {
    char *name;
    char *type;
    FILE *fp;
    u_int count;
    task_struct task_arr[MAX_TASK_NUM];

    if (argc == 1 || argc > 4) {
        printf("Usage: command file_name [FCFS|RR|SRFT] [time_quantum]\n");
        return 0;
    }
    name = argv[1];
    type = argv[2];
    
    printf("Scheduling Policy: %s\n", type);

    open_file(name, &fp);
    read_file(fp, task_arr, &count);

    printf("==================================================================\n");

    if (strcmp(type, "FCFS") == 0) {
        FCFS(task_arr, count);
    }

    fclose(fp);

    return 0;
}


/**
 * 
 *
 */
void read_file(FILE *file_desc, task_struct task_list[], int *size) {
   int num = 0;
   while (fscanf(file_desc, "%u %u %u", &task_list[num].pid, &task_list[num].arrival_time, \
              &task_list[num].burst_time)!= EOF) {
        num++;
    }
    *size = num;
}

/**
 * 
 * 
 * 
 */
void FCFS(task_struct task_list[], int size) {
    int curr_pid, curr_arr_time, curr_burst;
    int time = 0;
    double wait_sum, turn_sum;
    double avg_wait, avg_turn;
    for (int i=0; i<size; i++) {
        curr_pid = task_list[i].pid;
        curr_arr_time = task_list[i].arrival_time;
        curr_burst = task_list[i].burst_time;
        int runtime = 0;
        while (runtime < curr_burst) {
            printf("<time %u> process %u is running\n", time, curr_pid);
            time++;
            runtime++;
        }
        turn_sum += time;
        wait_sum += (turn_sum - curr_burst);
        printf("<time %u> process %u is finished...\n", time, curr_pid);
    }
    avg_wait = wait_sum/size;
    avg_turn = turn_sum/size;
    printf("<time %u> All processes finshed...\n", time);
    printf("==================================================================\n");
    printf("Average waiting time: %f\n", avg_wait);
    printf("Average turnaround time: %f\n", avg_turn);
    printf("==================================================================\n");
}

/**
 * 
 * 
 */
void print_task_list(task_struct task_list[], int size) {
    int i;
    printf("There are %d tasks loaded...\n", size);
    /* print task_array to check input file */
    // for (i = 0; i < size; i++) {
    //     printf("Task PID: %u, Arrival Time: %u, Burst Time: %u\n", task_list[i].pid, \
    //        task_list[i].arrival_time, task_list[i].burst_time);
    // }
    printf("Press any key to continue ...\n");
    getchar();
}

/**
 * 
 * 
 */
int open_file(char *name, FILE **file_desc) {
    if (! (*file_desc = fopen(name, "r"))) {
        printf("File %s can't be opened. Please retry ...\n", name);
        return 1;
    }

    //printf("Open file: %s\n", name);

    return 0;
}