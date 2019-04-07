/*
* Homework 4 assignment.
*   Author: Omar Barazanji
*   Due Date: April 12th, 2019
*
*   Sources: Class lecture notes / slides.
*/

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

// functions to be used:
int readfile(int inputArray[], ifstream &file);
/*
*   function readFile reads file and stores values into array.
*   params:
*       inputArray[] - array to store values.
*       &file - file ifstream.
*/

int getSize(string filename);
/*
*   funtion getSize gets size of file.
*   param:
*       filename - name of file.
*/

int sort(inputArray1[], inputArray1_size, inputArray2[],
         inputArray2_size, outputArray[]);

/*
void writefile(outputArray[], outputArray_size);
*/

int main() {
    ifstream fsIn;  // Input
    ofstream fsOut;  // Output
    fstream both;  // Input and output

    string file1 = "";
    string file2 = "";

    cout << "*** Welcome to Omar Barazanji's sorting program ***" << endl;

    cout << "Enter the first input file name: ";
    cin >> file1;
    ifstream openFile1(file1);
    int size1 = getSize(file1);
    int file1_array[size1-1] = {};
    cout << "The list of " << size1 << " numbers in file " << file1 << " is: \n";
    readfile(file1_array, openFile1);

    cout << "\nEnter the second input file name: ";
    cin >> file2;
    ifstream openFile2(file2);
    int size2 = getSize(file2);
    int file2_array[size2-1] = {};
    cout << "The list of " << size2 << " numbers in file " << file2 << " is: \n";
    readfile(file2_array, openFile2);

    int fullSize = size1 + size2;

    cout << "\nThe sorted list of " << fullSize << " numbers is: \n";

    return 0;
}

// ********************* //
// ******functions****** //
// ********************* //

int getSize(string filename) {
    ifstream openFile(filename);
    int size = 0;
    string line;
    while (!openFile.eof()) {
        getline(openFile, line);
        size += 1;
    }
    openFile.close();
    return size;
}

int readfile(int inputArray[], ifstream &file) {
    string line;
    while (!file.eof()) {
        getline(file, line);
        cout << line << endl;
    }
    return 0;
}


int sort(inputArray1[], inputArray1_size, inputArray2[],
         inputArray2_size, outputArray[]) {
    return 0;
    }

void writefile(outputArray[], outputArray_size) {

}
*/
