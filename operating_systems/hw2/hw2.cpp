/*
* CPU scheduler.
*
*/

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

// Constants
int FCFS();
int pid, arrival_time, burst_time, interval;


int main() {
    string line;
    ifstream taskfile ("task.list");
    if (taskfile.is_open()) {
        while( getline (taskfile, line)) {
            cout << line << '\n';
        }
        taskfile.close();
    }
    return 0;
}

int FCFS() {
    return 0;
}