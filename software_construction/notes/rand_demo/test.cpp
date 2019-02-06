/*
This will demonstrate how rand and srand work.

Author: Omar Barazanji
Date: 2/6/19
*/

#include <iostream>
#include <ctime>
#include <cstdlib>
using namespace std;

int main()
{

	int random, random_time;
	cout << "0 to 10: ";
	random = rand() % 11;
	cout << random << endl;

	srand(time(0));
	cout << "To make truly random upon each execution, need srand with system time...\n";
	random_time = rand() % 11;
	cout << "0 to 10 (random every time): " << random_time << endl;
	return 0;
}
