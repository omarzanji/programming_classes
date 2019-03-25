// Homework 3 - Duel Simulation.
//
// Author: Omar Barazanji
// Date: 3/24/19
//
// Sources: class notes.

#include <iostream>
#include <stdlib.h>
#include <assert.h>
#include <ctime>
using namespace std;

const double aaron_prob = 33;  //percent
const double bob_prob = 50;  //percent
const int COUNT = 10000;
bool A_alive = true;
bool B_alive = true;
bool C_alive = true;

bool at_least_two_alive(bool A_alive, bool B_alive, bool C_alive);
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

void test_at_least_two_alive(void);
/* Test driver for function at_least_two_alive */


int main() {
    srand(time(0));
    cout << "*** Welcome to the Duel Simulator ***" << endl;
    test_at_least_two_alive();
    cout << "Press Enter to continue...";
    cin.get();  // Pause command for Linux terminal
    cout << "Ready to test strategy 1 (run 10000 times): ";
    cin.get();  // Pause command for Linux terminal
    cout << "Press Enter to continue...\n";

    int a_won = 0;
    int b_won = 0;
    int c_won = 0;

    A_alive = true;
    B_alive = true;
    C_alive = true;

    // strategy 1
    for (int i = 0; i < COUNT; i++) {
      while (at_least_two_alive(A_alive, B_alive, C_alive) == true) {
          if (A_alive) Aaron_shoots1(B_alive, C_alive);
          if (B_alive) Bob_shoots(A_alive, C_alive);
          if (C_alive) Charlie_shoots(A_alive, B_alive);
      }
        if (A_alive) a_won++;
        if (B_alive) b_won++;
        if (C_alive) c_won++;

        A_alive = true;
        B_alive = true;
        C_alive = true;
    }

    double a_percent1 = ((double)a_won / 10000) * 100;
    double b_percent = ((double)b_won / 10000) * 100;
    double c_percent = ((double)c_won / 10000) * 100;

    cout << "Aaron won " << a_won << "/10000 duels or " << a_percent1 << "%\n";
    cout << "Bob won " << b_won << "/10000 duels or " << b_percent << "%\n";
    cout << "Charlie won " << c_won << "/10000 duels or " << c_percent << "%\n";

    cout << "\nReady to test strategy 2 (run 10000 times): ";
    cin.get();  // Pause command for Linux terminal
    cout << "Press Enter to continue...\n";

    a_won = 0;
    b_won = 0;
    c_won = 0;

    // strategy 2
    for (int i = 0; i < COUNT; i++) {
      while (at_least_two_alive(A_alive, B_alive, C_alive) == true) {
          if (A_alive) Aaron_shoots2(B_alive, C_alive);
          if (B_alive) Bob_shoots(A_alive, C_alive);
          if (C_alive) Charlie_shoots(A_alive, B_alive);
      }
        if (A_alive) a_won++;
        if (B_alive) b_won++;
        if (C_alive) c_won++;

        A_alive = true;
        B_alive = true;
        C_alive = true;
    }

    double a_percent2 = ((double)a_won / 10000) * 100;
    b_percent = ((double)b_won / 10000) * 100;
    c_percent = ((double)c_won / 10000) * 100;

    cout << "Aaron won " << a_won << "/10000 duels or " << a_percent2 << "%\n";
    cout << "Bob won " << b_won << "/10000 duels or " << b_percent << "%\n";
    cout << "Charlie won " << c_won << "/10000 duels or " << c_percent << "%\n";

    if (a_percent1 < a_percent2) {
      cout << "\nStrategy 2 is better than strategy 1.\n";
    } else {
      cout << "\nStrategy 1 is better than strategy 2.\n";
    }

    return 0;
}

void Aaron_shoots1(bool& B_alive, bool& C_alive) {
    bool shot = false;
    int shoot_target_result = rand()%100;
    if (shoot_target_result <= aaron_prob) {
        shot = true;
    }
    enum targets {
      bob,
      charlie,
    };
    int target = -1;
    if (shot) {
      if (C_alive) {
        target = charlie;
      } else {
        target = bob;
      }
      switch(target) {
        case 0:
          B_alive = false;
          break;
        case 1:
          C_alive = false;
          break;
        default:
          break;
      }
    }
}

void Bob_shoots(bool& A_alive, bool& C_alive) {
    bool shot = false;
    int shoot_target_result = rand()%100;
    if (shoot_target_result <= bob_prob) {
        shot = true;
    }
    enum targets {
      aaron,
      charlie,
    };
    int target = -1;
    if (shot) {
      if (C_alive) {
        target = charlie;
      } else {
        target = aaron;
      }
      switch(target) {
        case 0:
          A_alive = false;
          break;
        case 1:
          C_alive = false;
          break;
        default:
          break;
      }
    }
}

void Charlie_shoots(bool& A_alive, bool& B_alive) {
    enum targets {
      aaron,
      bob,
    };
    int target = -1;
    if (B_alive) {
      target = bob;
    } else {
      target = aaron;
    }
    switch(target) {
      case 0:
        A_alive = false;
        break;
      case 1:
        B_alive = false;
        break;
      default:
        break;
    }
}

void Aaron_shoots2(bool& B_alive, bool& C_alive) {
    if (B_alive && C_alive) return;
    bool shot = false;
    int shoot_target_result = rand()%100;
    if (shoot_target_result <= aaron_prob) {
        shot = true;
    }
    enum targets {
      bob,
      charlie,
    };
    int target = -1;
    if (shot) {
      if (C_alive) {
        target = charlie;
      } else {
        target = bob;
      }
      switch(target) {
        case 0:
          B_alive = false;
          break;
        case 1:
          C_alive = false;
          break;
        default:
          break;
      }
    }
}

bool at_least_two_alive(bool A_alive, bool B_alive, bool C_alive) {
  int count = 0;
  if (A_alive == true) {
    count += 1;
  }
  if (B_alive == true) {
    count += 1;
  }
  if (C_alive == true) {
    count += 1;
  }
  if (count >= 2) {
    return true;
  } else {
    return false;
  }
}

void test_at_least_two_alive(void) {
  cout << "Unit Testing 1: Function - at_least_two_alive()" << endl;

  cout << "\tCase 1: Aaron alive, Bob alive, Charlie alive" << endl;
  assert(true == at_least_two_alive(true, true, true));
  cout << "\tCase passed ...\n";

  cout << "\tCase 2: Aaron dead, Bob alive, Charlie alive" << endl;
  assert(true == at_least_two_alive(false, true, true));
  cout << "\tCase passed...\n";

  cout << "\tCase 3: Aaron alive, Bob dead, Charlie alive" << endl;
  assert(true == at_least_two_alive(true, false, true));
  cout << "\tCase passed...\n";

  cout << "\tCase 4: Aaron alive, Bob alive, Charlie dead" << endl;
  assert(true == at_least_two_alive(true, true, false));
  cout << "\tCase passed...\n";

  cout << "\tCase 5: Aaron dead, Bob dead, Charlie alive" << endl;
  assert(false == at_least_two_alive(false, false, true));
  cout << "\tCase passed...\n";

  cout << "\tCase 6: Aaron dead, Bob alive, Charlie dead" << endl;
  assert(false == at_least_two_alive(false, true, false));
  cout << "\tCase passed...\n";

  cout << "\tCase 7: Aaron alive, Bob dead, Charlie dead" << endl;
  assert(false == at_least_two_alive(true, false, false));
  cout << "\tCase passed...\n";

  cout << "\tCase 8: Aaron dead, Bob dead, Charlie dead" << endl;
  assert(false == at_least_two_alive(false, false, false));
  cout << "\tCase passed...\n";
}
