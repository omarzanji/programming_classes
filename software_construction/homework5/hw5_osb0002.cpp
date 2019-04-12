/*
*   homework5: Trivia quiz game!
*
*   Author: Omar Barazanji (osb0002)
*   Due: 4/26/19
*
*   Sources:    1) class lecture / notes...
*/

#include <iostream>
#include <string>
using namespace std;

void init_list(TriviaNode Trivia);
/*
*   function init_list initializes the Trivia linked list
*   with three questions.
*/
int main() {

    // sructure for node to be used for trivia.
    struct TriviaNode {
        string question;
        string answer;
        int points;
        TriviaNode* next;
    };

    TriviaNode Trivia;
    init_list();

    return 0;
}


/*****************/
/****Functions****/
/*****************/
void init_list(TriviaNode Trivia) {
    
}
