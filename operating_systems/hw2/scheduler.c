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


int main(int argc, char *argv[]) {
    char *name;
    FILE *fp;
    u_int count;
    task_struct task_arr[MAX_TASK_NUM];
    name = argv[1];
    open_file(name, &fp);
    read_file(fp, task_arr, &count);
    print_task_list(task_arr, count);
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
 */
void print_task_list(task_struct task_list[], int size) {
    int i;
    printf("There are %d tasks loaded...\n", size);
    /* print task_array to check input file */
    for (i = 0; i < size; i++) {
        printf("Task PID: %u, Arrival Time: %u, Burst Time: %u\n", task_list[i].pid, \
           task_list[i].arrival_time, task_list[i].burst_time);
    }
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

    printf("Open file: %s\n", name);

    return 0;
}