/*
This program will calculate and print an amortization table for a loan.

Author: Omar Barazanji
Date: 3/1/19

Sources: Lecture notes...
*/

#include <iostream>
using namespace std;

int main()
{
  int loanAmt, interestRte, monthlyPmt;

  cout << "Loan Amount: ";
  cin >> loanAmt;

  cout << "Interest Rate (% per year): ";
  cin >> interestRte;

  cout << "Monthly Payments: ";
  cin >> monthlyPmt;

  return 0;
}
