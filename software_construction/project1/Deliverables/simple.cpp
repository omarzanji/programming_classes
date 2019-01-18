// This code will process an array of 10 numbers and calculates:
// (1) a factorial value based on how many positive numbers the user inputs, and
// (2) the value of standard deviation.
//
// Author: Omar Barazanji
// Date: 1/17/2019

#include <iostream>
using namespace std;

int main()
{
	int i, n, factorial = 1;
	cout << "Enter a positive integer: ";
	cin >> n;

	for (i = 1; i <= n; ++i) {
		factorial *= i;
	}
	cout << "Factorial of " << n << " = " << factorial;
	cout << endl;
	return 0;
}
