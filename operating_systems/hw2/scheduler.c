/**
* Scheduler simulation using various algorithms.
* author: Omar Barazanji
* date: 9/23/2020
* sources: Auburn University 
*/

//imports
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Global variables
typedef unsigned int u_int;
#define MAX_TASK_NUM 32
typedef struct task_info {
    u_int pid;
    u_int arrival_time;
    u_int burst_time;
} task_struct;

// Function declarations
void read_file(FILE *file_desc, task_struct task_list[], int *size);
int open_file(char *name, FILE **file_descriptor);
void print_task_list(task_struct task_list[], int size);
void FCFS(task_struct task_list[], int size);
void RR(task_struct task_list[], int size, int quantum);
void SRTF(task_struct task_list[], int size);


//main
int main(int argc, char *argv[]) {
    char *name;
    char *type;
    char *qntm;
    int qntm_int;
    FILE *fp;
    u_int count;
    task_struct task_arr[MAX_TASK_NUM];

    if (argc == 1 || argc > 4) {
        printf("Usage: command file_name [FCFS|RR|SRFT] [time_quantum]\n");
        return 1;
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
    else if (strcmp(type, "RR") == 0) {
        if (argc != 4) {
            printf("please enter a time quantum!\n");
            return 1;
        }
        qntm_int = strtol(argv[3], &qntm, 10);
        RR(task_arr, count, qntm_int);
    }
    else if (strcmp(type, "SRTF") == 0) {
        SRTF(task_arr, count);
    }

    fclose(fp);
    return 0;
}


/**
 * From class.
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
 * First Come First Serve.
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
        wait_sum += (time - curr_burst);
        printf("<time %u> process %u is finished...\n", time, curr_pid);
    }
    avg_wait = wait_sum/size;
    avg_turn = turn_sum/size;
    printf("<time %u> All processes finished...\n", time);
    printf("==================================================================\n");
    printf("Average waiting time: %0.2f\n", avg_wait);
    printf("Average turnaround time: %0.2f\n", avg_turn);
    printf("Average CPU usage: 100 %%\n");
    printf("==================================================================\n");
}

/**
 * Round Robin.
 */
void RR(task_struct task_list[], int size, int quantum) {
    int curr_pid, curr_arr_time, curr_burst;
    int time = 0;
    double wait_sum, turn_sum;
    double avg_wait, avg_turn;
    int temp[size];
    int ignore[size];
    ignore[0] = 0;
    int completed = 0;
    for (int i=0; i<size; i++) {
        temp[i] = task_list[i].burst_time;
    }
    while (completed < size) {
        for (int i=0; i<size; i++) {
            if (ignore[i] == 1) {
                continue;
            }
            curr_pid = task_list[i].pid;
            curr_arr_time = task_list[i].arrival_time;
            curr_burst = task_list[i].burst_time;
            int runtime = 0;
            while (runtime < quantum) {
                printf("<time %u> process %u is running\n", time, curr_pid);
                time++;
                runtime++;
                temp[i]--;
                if (temp[i] == 0) {
                    ignore[i] = 1;
                    completed++;
                    runtime = quantum;
                }
            }
            if (ignore[i] == 1) {
                turn_sum += time;
                wait_sum += (time - curr_burst);
                printf("<time %u> process %u is finished...\n", time, curr_pid);
            }
        }
    }
    avg_wait = wait_sum/size;
    avg_turn = turn_sum/size;
    printf("<time %u> All processes finished...\n", time);
    printf("==================================================================\n");
    printf("Average waiting time: %0.2f\n", avg_wait);
    printf("Average turnaround time: %0.2f\n", avg_turn);
    printf("Average CPU usage: 100 %%\n");
    printf("==================================================================\n");
}

/**
 * Shortest remaining time first.
 */
void SRTF(task_struct task_list[], int size) {
    int curr_pid, curr_arr_time, curr_burst;
    int time = 0;
    double wait_sum, turn_sum;
    double avg_wait, avg_turn;

    int times[size];
    int arr_times[size];

    for (int i=0; i<size; i++) {
        times[i] = task_list[i].burst_time;
        arr_times[i] = task_list[i].arrival_time;
    }
    
    int completed = 0;
    int shortest = 0;
    while (completed < size) {
        for (int i=0; i<size; i++) {
            if (time >= arr_times[i]) { 
                if ((times[i] <= times[shortest]) && (times[i] != 0)) {
                    shortest = i;
                    curr_burst = task_list[i].burst_time;
                    curr_pid = task_list[i].pid;
                } else {
                    continue;
                }
            }
            printf("<time %u> process %u is running\n", time, curr_pid);
            times[shortest]--;
            time++;
            if (times[shortest] == 0) {
                for (int i=0; i<size; i++) {
                    if (times[i] != 0) {
                        shortest = i;
                    }
                }
                turn_sum += time;
                wait_sum += (time - curr_burst);
                completed++;
                printf("<time %u> process %u is finished...\n", time, curr_pid);            
            }
        }
    }
    avg_wait = wait_sum/size;
    avg_turn = turn_sum/size;
    printf("<time %u> All processes finished...\n", time);
    printf("==================================================================\n");
    printf("Average waiting time: %0.2f\n", avg_wait);
    printf("Average turnaround time: %0.2f\n", avg_turn);
    printf("Average CPU usage: 100 %%\n");
    printf("==================================================================\n");
}

/**
 * From class.
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
 * From class.
 */
int open_file(char *name, FILE **file_desc) {
    if (! (*file_desc = fopen(name, "r"))) {
        printf("File %s can't be opened. Please retry ...\n", name);
        return 1;
    }

    //printf("Open file: %s\n", name);

    return 0;
}
