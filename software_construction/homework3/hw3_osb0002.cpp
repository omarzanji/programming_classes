// Homework 3 - Duel Simulation.
//
// Author: Omar Barazanji
// Date: 2/29/19
//
// Sources: class notes.

#include <iostream>
#include <stdlib.h>
#include <assert.h>
#include <ctime>
using namespace std;

const double aaron_prob = 33;  //percent
const double bob_prob = 50;  //percent
bool A_alive = true;
bool B_alive = true;
bool C_alive = true;

//bool at_least_two_alive(bool A_alive, bool B_alive, C_alive)
/* Input: A_alive indicates whether Aaron is alive */
/*        B_alive indicates whether Bob is alive */
/*        C_alive indicates whether Charlie is alive */
/* Return: true if at least two are alive */
/*         otherwise return false */

void Aaron_shoots1(bool& B_alive, bool& C_alive);
/* Strategy 1: Use call by reference
* Input: B_alive indicates whether Bob alive or dead
*        C_alive indicates whether Charlie is alive or dead
* Return: Change B_alive into false if Bob is killed.
*         Change C_alive into false if Charlie is killed.
*/

void Bob_shoots(bool& A_alive, bool& C_alive);
/* Call by reference
* Input: A_alive indicates if Aaron is alive or dead
*        C_alive indicates whether Charlie is alive or dead
* Return: Change A_alive into false if Aaron is killed.
*         Change C_alive into false if Charlie is killed.
*/

void Charlie_shoots(bool& A_alive, bool& B_alive);
/* Call by reference
* Input: A_alive indicates if Aaron is alive or dead
*        B_alive indicates whether Bob is alive or dead
* Return: Change A_alive into false if Aaron is killed.
*        Change B_alive into false if Bob is killed.
*/

void Aaron_shoots2(bool& B_alive, bool& C_alive);
/* Strategy 2: Use call by reference
* Input: B_alive indicates whether Bob alive or dead
*        C_alive indicates whether Charlie is alive or dead
* Return: Change B_alive into false if Bob is killed.
*         Change C_alive into false if Charlie is killed.
*/

int main() {
    cout << "*** Welcome to the Duel Simulator ***" << endl;
    cout << "Unit Testing 1: Function - at_least_two_alive()" << endl;
    int count = 0;

    // strategy1
    while (count < 10000) {
        Aaron_shoots1(B_alive, C_alive);
        Bob_shoots(A_alive, C_alive);
        Charlie_shoots(A_alive, B_alive);
    }

    // strategy2
    while (count < 10000) {
        Aaron_shoots2(B_alive, C_alive);
        Bob_shoots(A_alive, C_alive);
        Charlie_shoots(A_alive, B_alive);
    }

    return 0;
}

void Aaron_shoots1(bool& B_alive, bool& C_alive) {
    srand(time(0));
    int shoot_target_result = rand()%100;
    if (shoot_target_result <= 33) {
        shot = true;
    }
    if (shot && B_alive) {
        C_alive = false;
    } else {
        B_alive = false;
    }
}

void Bob_shoots(bool& A_alive, bool& C_alive) {
    srand(time(0));
    int shoot_target_result = rand()%100;
    bool shot = false;
    if (shoot_target_result <= 50) {
        shot = true;
    }
    if (shot && C_alive) {
        C_alive = false;
    } else if(shot) {
        A_alive = false;
    }
}

void Charlie_shoots(bool& A_alive, bool& B_alive) {
    if (B_alive) {
        B_alive = false;
    } else {
        A_alive = false;
    }
}

void Aaron_shoots2(bool& B_alive, bool& C_alive) {
    srand(time(0));
    int shoot_target_result = rand()%100;
    if (shoot_target_result <= 33) {
        shot = true;
    }
    if (shot && B_alive && C_alive) {
        C_alive = false;
    } else if (shot && C_alive && B_alive == false) {
        C_alive = false;
    } else if (shot) {
        B_alive =false;
    }
}
