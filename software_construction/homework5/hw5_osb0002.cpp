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

// structure for node
struct TriviaNode {
    string question;
    string answer;
    int points;
    TriviaNode *next;
};

void insert_node(string question, string answer, int points, TriviaNode *head);
/*
*   function insert_node inserts question, answer, and points into a
*       linked list.
*/

int main() {
    TriviaNode *head = new TriviaNode;

    string ques = "Question: How long was the shortest "
    "war on record? (Hint: how many minutes)";
    string ans = "38";
    int points = 100;
    insert_node(ques, ans, points, head);

    ques = "Question: What was Bank of America's original "
    "name? (Hint: Bank of Italy or Bank of Germany)";
    ans = "Bank of Italy";
    points = 50;
    insert_node(ques, ans, points, head);

    ques = "Question: What is the best-selling video game "
    "of all time? (Hint: Minecraft or Tetris)";
    ans = "Tetris";
    points = 20;
    insert_node(ques, ans, points, head);

    return 0;

}

/*****************/
/****Functions****/
/*****************/

void insert_node(string question, string answer, int points, TriviaNode *head){
    TriviaNode *current = head;
    TriviaNode *temp = new TriviaNode;

    while (!(current->next == NULL)) {
        current = current->next;
    }

    temp->question = question;
    temp->answer = answer;
    temp->points = points;
    current->next = temp;
}
