// This code will process an array of 10 numbers and calculates:
// (1) a factorial value based on how many positive numbers the user inputs, and
// (2) the value of standard deviation.
//
// Author: Omar Barazanji
// Date: 1/23/2019

#include <iostream>
#include <cmath>
using namespace std;

float calculateSD(float data[], int n);

int main() {
	int i, n, factorial = 1;
	int deviation;
	bool err = true;

	while (err == true) {
		cout << "How many numbers (max 10) would you like to input? ";
		cin >> n;
		if (n > 10 || n < 0) {
			err = true;
			cout << "Please enter a number from 0 to 9..." << endl;
		} else {
			err = false;
		}
	}

	float data[n];
	cout << "Enter " << n << " numbers separated by space: ";
	for (i = 0; i < n; ++i) {
		cin >> data[i];
	}

	for (i = 1; i <= n; ++i) {
		factorial *= i;
	}

	cout << "Factorial of " << n << " = " << factorial;
	cout << endl;

	cout << "Standard deviation: " << calculateSD(data, n) << endl;
	return 0;
}

float calculateSD(float data[], int n) {
	float sum = 0.0, mean, standardDeviation = 0.0;

	int i;

	for (i = 0; i < n; ++i) {
		sum += data[i];
	}

	mean = sum/n;

	for (i = 0; i < n; ++i) {
		standardDeviation += pow(data[i] - mean, 2);
	}

	return sqrt(standardDeviation / n);
}
