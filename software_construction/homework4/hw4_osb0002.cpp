/*
* Homework 4 assignment.
*   Author: Omar Barazanji
*   Due Date: April 12th, 2019
*
*   Sources: 1) Class lecture notes / slides.
*            2) https://en.wikipedia.org/wiki/Sort_(C%2B%2B)
*/

#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>
using namespace std;

const int MAX_SIZE = 100;

// functions to be used:
int readfile(int input_array[], ifstream &file_stream);
/*
*   function readfile reads file and stores values into array.
*   params:
*       input_array[] - array to store values.
*       &file_stream - file ifstream.
*   return: index of last element (to use for size).
*/

void add_sort(int array1[], int size1, int array2[],
          int size2, int output_array[]);
/*
*   function sort sorts two arrays and outputs combined sorted.
*   params:
*       array1[] - first array.
*       size1 - size of first array.
*       array2[] - second array.
*       size2 - size of second array.
*       output_array - array to be outputted.
*/

void writefile(int output_array[], int out_arr_size);
/*
*   function writefile writes array to file.
*   params:
*       output_array[] - array to be outputted.
*       out_arr_size - size of output array.
*/

int main() {
    ifstream instream1;
    ifstream instream2;

    string file1 = "";
    string file2 = "";
    int file1_array[MAX_SIZE] = {};
    int file2_array[MAX_SIZE] = {};
    int sorted_array[MAX_SIZE] = {};

    bool is_open = false;


    cout << "*** Welcome to Omar Barazanji's sorting program ***" << endl;

    cout << "Enter the first input file name: ";
    cin >> file1;
    instream1.open(file1);
    if (!instream1) {
        cout << "Cannot open file. \n";
        return 1;
    }
    int size1 = readfile(file1_array, instream1);
    instream1.close();
    cout << "The list of " << size1 << " numbers in file " << file1 << " is: \n";
    for (int i = 0; i < size1; i++) {
        cout << file1_array[i] << endl;
    }

    cout << "\nEnter the second input file name: ";
    cin >> file2;
    instream2.open(file2);
    if (!instream2) {
        cout << "Cannot open file. \n";
        return 1;
    }
    int size2 = readfile(file2_array, instream2);
    instream2.close();
    cout << "The list of " << size2 << " numbers in file " << file2 << " is: \n";
    for (int i = 0; i < size2; i++) {
        cout << file2_array[i] << endl;
    }

    int fullSize = size1 + size2;

    cout << "\nThe sorted list of " << fullSize << " numbers is: ";
    add_sort(file1_array,size1,file2_array,size2,sorted_array);
    writefile(sorted_array, fullSize);

    return 0;
}

// ********************* //
// ******functions****** //
// ********************* //

int readfile(int input_array[], ifstream &file_stream) {
    int ndx = 0;
    while (!file_stream.eof()) {
        file_stream >> input_array[ndx];
        ndx++;
    }
    return ndx;
}

void add_sort(int array1[], int size1, int array2[],
          int size2, int sorted_array[]) {

    for (int i = 0; i < size1; i++) {
        sorted_array[i] = array1[i];
    }
    for (int i = 0; i < size2; i++) {
        sorted_array[size1+i] = array2[i];
    }

    int sizeboth = size1 + size2;
    sort(sorted_array, sorted_array + sizeboth);
    for (int i = 0; i < sizeboth; i++) {
        cout << sorted_array[i] << ' ';
    }
}

void writefile(int output_array[], int out_arr_size) {
    ofstream outFile("output.txt");
    for (int i = 0; i < out_arr_size; i++) {
        outFile << output_array[i] << endl;
    }
    cout << endl;
    outFile.close();
}
