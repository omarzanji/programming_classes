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
    double loanAmt, interestRte, monthlyPmt;

    cout << "Loan Amount: ";
    cin >> loanAmt;

    cout << "Interest Rate (% per year): ";
    cin >> interestRte;

    cout << "Monthly Payments: ";
    cin >> monthlyPmt;

    // Calculates interest rate  per month.
    double rateMonth = (interestRte / 12) / 100;

    // Output header
    cout << "\n"
         << "*****************************************************************"
         << endl;
    cout << "\t\tAmortization Table" << endl;
    cout << "*****************************************************************"
         << endl;
    cout << "Month\t" << "Balance\t\t" << "Payment\t" << "Rate\t"
         << "Interest\t" << "Principle" << endl;

    // variables for Amortization Table generization
    int monthCnt = 0;
    double balance = loanAmt;
    double interest, principle, interestTot;
    int lastMonth = -1;
    bool whileLoop = true;
    bool passed = true;

    cout.precision(2);

    // While loop and switch statement for Amortization Table
    while (whileLoop) {
        if (monthCnt == 0) {
            cout << fixed << monthCnt << "\t" << "$" << balance << "\t" << "N/A"
                 << "\t" << "N/A" << "\t" << "N/A" << "\t\t"
                 << "N/A" << endl;
            monthCnt += 1;
        } else if (monthCnt == lastMonth) {
            whileLoop = false;
            interest = balance * (rateMonth);
            principle = balance;
            monthlyPmt = principle + interest;
            balance = 0.0;
            cout << monthCnt << "\t" << "$" << balance << "\t\t"
                 << "$" << monthlyPmt << "\t";
            cout << noshowpoint << rateMonth*100 
                 << "\t" << "$" << interest << "\t\t"
                 << "$" << principle << endl;
            interestTot += interest;
        } else {
            if (monthlyPmt < interest) {
                whileLoop = false;
                passed = false;
                cout << "\nInvalid parameters, monthly payments < interest...\n";
                break;
            }
            interest = balance * (rateMonth);
            interestTot += interest;
            principle = monthlyPmt - interest;
            balance -= principle;
            cout << monthCnt << "\t" << "$" << balance << "  \t"
                 << "$" << monthlyPmt << "\t";
            cout << noshowpoint << rateMonth*100
                 << "\t" << "$" << interest << "\t\t"
                 << "$" << principle << endl;
            monthCnt += 1;
            if (balance < monthlyPmt) {
                lastMonth = monthCnt;
            }
        }
    }
    if (passed) {
        cout << "****************************************************************\n"
             << endl;
        cout << "It takes " << monthCnt <<  " months to pay off the loan" << endl;
        cout << "Total interest paid is: " << "$" << interestTot << endl;
    }
    return 0;
}
