/*
*   homework5: Trivia quiz game!
*
*   Author: Omar Barazanji (osb0002)
*   Due: 4/26/19
*
*   Source: Class lecture / notes...
*/

#include <iostream>
#include <string>
#include <assert.h>
using namespace std;

// comment the line below to disable debug version.
define UNIT_TESTING

// structure for node
struct TriviaNode {
    string question;
    string answer;
    int points;
    TriviaNode *next;
};

void insert_node(string question, string answer, int points, TriviaNode *&head);
/*
*   function insert_node inserts question, answer, and points into a
*   linked list.
*
*   params: question - question to be inputted.
*           answer - answer to be inputted.
*           points - amount of points question is worth.
*           head - linked list containing questions.
*/

void prompt_user(int &count, TriviaNode *&head);
/*
* function prompt_user allows the user to input questions into the game.
*
*   params: count - current number of nodes in linked list.
*           head - linked list containing questions.
*/

int start_game(int num, int &count, TriviaNode *&curr);
/*
*   funtion start_game begins the main loop of the game, prompting
*   user to enter answers to questions.
*
*   param: num - number of questions to be asked.
*          count - current number of nodes in linked list.
*          curr - current question in linked list.
*
*   return 0 - success right answer
*   return 1 - success wrong answer
*   return -1 - error.
*/

void test_start_game(void);
/* Test driver for the function start_game */

int main() {
    #ifdef UNIT_TESTING
    cout << "*** This is a debug version ***" << endl;
    test_start_game();
    cout << "\n*** End of the Debug Version ***" << endl;
    #else

    cout << "*** Welcome to Omar's trivia quiz game ***" << endl;

    TriviaNode *head = new TriviaNode;
    int count = 0;

    string ques = "How long was the shortest "
    "war on record? (Hint: how many minutes)";
    string ans = "38";
    int points = 100;
    insert_node(ques, ans, points, head);
    count++;

    ques = "What was Bank of America's original "
    "name? (Hint: Bank of Italy or Bank of Germany)";
    ans = "Bank of Italy";
    points = 50;
    insert_node(ques, ans, points, head);
    count++;

    ques = "What is the best-selling video game "
    "of all time? (Hint: Minecraft or Tetris)";
    ans = "Tetris";
    points = 20;
    insert_node(ques, ans, points, head);
    count++;

    prompt_user(count, head);

    int curr_points = 0;
    int val;
    TriviaNode *curr = head;
    int curr_count = 1;
    while (curr->next != NULL) {
        curr = curr->next;
        cout << "Question: " << curr->question << endl;
        cout << "Answer: ";
        val = start_game(1, count, curr);
        if (val == 0) {
            cout << "Your answer is correct. You receive " << curr->points
                 << " points" << endl;
            curr_points += curr->points;
        } else if (val == 1){
            cout << "Your answer is wrong. The correct answer is: "
                 << curr->answer << endl;
        } else {
            exit(1);
        }
        cout << "Your total points: " << curr_points << endl << endl;
        curr_count++;
    }

    cout << "*** Thank you for playing the trivia quiz game. Goodbye! ***"
         << endl;

    #endif
    return 0;

}

/*****************/
/****Functions****/
/*****************/

void insert_node(string question, string answer, int points, TriviaNode *&head) {
    TriviaNode *current = head;
    TriviaNode *temp = new TriviaNode;

    temp->question = question;
    temp->answer = answer;
    temp->points = points;

    if (head->next == NULL) {
        temp->next = head->next;
        head->next = temp;
    } else {
        while (current->next != NULL) {
            current = current->next;
        }
        temp->next = current->next;
        current->next = temp;
    }
}

void prompt_user(int &count, TriviaNode *&head) {
    bool cont = true;
    string choice, question, answer;
    int points;
    while (cont) {
        cout << "Enter a question: ";
        getline (cin, question);
        cout << "Enter an answer: ";
        getline (cin, answer);
        cout << "Enter award points: ";
        cin >> points;
        count++;
        cout << "Continue? (Yes/No): ";
        cin >> choice;
        cin.ignore();
        cout << endl;
        insert_node(question, answer, points, head);
        if (choice == "Yes" || choice == "yes") {
            cont = true;
        }
        if (choice == "No" || choice == "no") {
            cont = false;
        }
    }
}

int start_game(int num, int &count, TriviaNode *&curr) {
    string usr_ans;
    string corr_ans = curr->answer;
    int ques_points;
    if (curr->next == NULL && count == 0) {
        cout << "Warning - the number of trivia to be asked must be equal to"
                 " or larger than 1" << endl;
        return -1;
    } else if (num >= count) {
        cout << "Warning - there are only three trivia in the list." << endl;
        return -1;
    }
    getline (cin, usr_ans);
    if (usr_ans == corr_ans) {
        return 0;
    } else {
        return 1;
    }
}

void test_start_game(void) {
    TriviaNode *curr = new TriviaNode;
    int count = 0;
    cout << "Unit Test Case 1: Ask no questions. The program should give a"
            " warning message." << endl;
    assert(-1 == start_game(1, count, curr));
    cout << endl;

    string ques = "Question: How long was the shortest "
    "war on record? (Hint: how many minutes)";
    string ans = "38";
    int points = 100;
    insert_node(ques, ans, points, curr);
    count++;

    ques = "Question: What was Bank of America's original "
    "name? (Hint: Bank of Italy or Bank of Germany)";
    ans = "Bank of Italy";
    points = 50;
    insert_node(ques, ans, points, curr);
    count++;

    ques = "Question: What is the best-selling video game "
    "of all time? (Hint: Minecraft or Tetris)";
    ans = "Tetris";
    points = 20;
    insert_node(ques, ans, points, curr);
    count++;

    curr = curr->next;
    cout << "Unit Test Case 2.1: Ask 1 question in the linked list. The tester"
             " enters an incorrect answer." << endl;
    cout << "Question: " << curr->question << endl;
    cout << "Answer: ";
    assert(1 == start_game(1, count, curr));
    cout << "Case 2.1 passed..." << endl << endl;

    cout << "Unit Test Case 2.2: Ask 1 question in the linked list. The tester"
            " enters a correct answer." << endl;
    cout << "Question: " << curr->question << endl;
    cout << "Answer: ";
    assert(0 == start_game(1, count, curr));
    cout << "Case 2.2 passed..." << endl << endl;

    int curr_count = 1;
    while(curr->next != NULL) {
        curr = curr->next;
        if (curr_count == count) {
            break;
        }
        curr_count++;
    }
    cout << "Unit Test Case 3: Ask the last trivia in the linked list.\n";
    cout << "Question: " << curr->question << endl;
    cout << "Answer: ";
    assert(0 == start_game(1, count, curr));

    cout << "\nUnit Test Case 4: Ask five questions in the linked list.\n";
    assert(-1 == start_game(5, count, curr));
}
