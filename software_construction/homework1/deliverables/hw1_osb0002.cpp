// Homework 1 assignment.
//
// Author: Omar Barazanji
// Date: 1/28/2019

#include <iostream>
using namespace std;

const double sweetPercent = 0.001;

int main ()
{
  double mouseWeight, fatalSweetner;
  int friendWeight, fatalCoke;

  cout << "Please input the weight of the mouse in kg: ";
  cin >> mouseWeight;

  cout << "Please input the fatal amount of sweetener for a mouse in kg: ";
  cin >> fatalSweetner;

  cout << "Please input the weight of your dear friend in kg: ";
  cin >>  friendWeight;

  fatalCoke = (fatalSweetner * friendWeight) / (mouseWeight * sweetPercent);

  cout << "The fatal amount of Coke for your friend is: " << fatalCoke;
  cout << "kg" << endl;
  return 0;
}
