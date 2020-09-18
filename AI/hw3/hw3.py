"""
author: Omar Barazanji
description: N-Queens Solver using Hill Climbing Algorithm.
date: 9/15/2020
class: COMP 5660 (Auburn University)
"""

import random
import time
import numpy as np

# State is a 1D array, length N, that for each index/column, i, it tells 
# us what row to place the queen.

class Board:
    def __init__(self, N):
        self.N = N

    def generate(self):
        random.seed()
        N = self.N
        self.board = [[0]*N for x in range(N)]
        self.state = [0]*N
        for i,x in enumerate(self.board):
            self.state[i] = random.randint(0,self.N-1)
            self.board[self.state[i]][i] = 1

    def generate_board(self, state):
        N = self.N
        ret_board = [[0]*N for x in range(N)]
        for i,x in enumerate(self.board):
            ret_board[state[i]][i] = 1
        return ret_board

    def print_board(self, board):
        for x in board:
            print(x)

    def get_score(self, board, state):
        N = self.N

        ticks = 0 # ticks are number of queens that can attack each other
        for i,x in enumerate(board):
            
            # checking left
            row = state[i]
            col = i
            # print("Queen: %d,%d" % (row,col))
            while col > 0:
                col -= 1
                if board[row][col] == 1:
                    # print("tick left")
                    ticks += 1

            # checking diagonally left
            row = state[i]
            col = i
            while row > 0 and col > 0:
                row -= 1
                col -= 1
                if board[row][col] == 1:
                    # print("tick d left")
                    ticks += 1
            
            # checking up
            row = state[i]
            col = i
            while row > 0:
                row -= 1
                if board[row][col] == 1:
                    # print("tick up")
                    ticks += 1

            # checking diagonally up right
            row = state[i]
            col = i
            while row > 0 and col < N-1:
                row -= 1
                col += 1
                if board[row][col] == 1:
                    # print("tick d right")
                    ticks += 1

            # checking right
            row = state[i]
            col = i
            while col < N-1:
                col += 1
                if board[row][col] == 1:
                    # print("tick right")
                    ticks += 1
            
            # checking diagonally down right
            row = state[i]
            col = i
            while row < N-1 and col < N-1:
                row += 1
                col += 1
                if board[row][col] == 1:
                    # print("tick dd right")
                    ticks += 1

            # checking down
            row = state[i]
            col = i
            while row < N-1:
                row += 1
                if board[row][col] == 1:
                    # print("tick down")
                    ticks += 1

            # checking diagonally down left
            row = state[i]
            col = i
            while row < N-1 and col > 0:
                row += 1
                col -= 1
                if board[row][col] == 1:
                    # print("tick dd l")
                    ticks += 1

            # print(i,ticks)
        return ticks

    def get_neighbor(self):
        N = self.N
        optimal_state = [0]*N
        for i,x in enumerate(self.neighbor_state):
            optimal_state[i] = x
        optimal_board = self.generate_board(optimal_state)
        optimal_score = self.get_score(optimal_board, optimal_state)

        temp_state = [0]*N
        for i,x in enumerate(self.neighbor_state):
            temp_state[i] = x
        temp_board = self.generate_board(temp_state)

        # iterating through all possible neighbors
        for x in range(N):
            for y in range (N):
                if y != self.neighbor_state[x]:

                    # creating temp board and state
                    temp_state[x] = y
                    temp_board[temp_state[x]][x] = 1
                    temp_board[self.neighbor_state[x]][x] = 0

                    temp_score = self.get_score(temp_board, temp_state)

                    if temp_score <= optimal_score:
                        optimal_score = temp_score
                        optimal_state = [0]*N
                        for i,x in enumerate(temp_state):
                            optimal_state[i] = x
                        optimal_board = self.generate_board(optimal_state)
                    
                    # putting temp board back to current state for next iteration
                    temp_board[temp_state[x]][x] = 0
                    temp_state[x] = self.neighbor_state[x]
                    temp_board[self.neighbor_state[x]][x] = 1

        self.neighbor_state = [0]*N
        for i,x in enumerate(optimal_state):
            self.neighbor_state[i] = x
        self.neighbor_board = self.generate_board(self.neighbor_state)

    def hill_climbing(self):
        N = self.N

        # initialize neighbor to current state
        self.neighbor_state = [0]*N
        for i,x in enumerate(self.state):
            self.neighbor_state[i] = x
        self.neighbor_board = self.generate_board(self.neighbor_state)


        while(True):

            # Always set current state to neighbor's because "get_neighbor"
            # returns local optimas.
            self.state = [0]*N
            for i,x in enumerate(self.neighbor_state):
                self.state[i] = x
            self.board = self.generate_board(self.state)
            
            self.get_neighbor()

            if self.state == self.neighbor_state:
                print("solution: ")
                self.print_board(self.board)
                break

            if self.get_score(self.board, self.state) == self.get_score(self.neighbor_board, self.neighbor_state):
                self.neighbor_state[random.randint(0, N-1)] = random.randint(0, N-1)
                self.neighbor_board = self.generate_board(self.neighbor_state)

    def get_random_neighbor(self):
        N = self.N
        temp_state = [0]*N
        while(True):
            for i,x in enumerate(temp_state):
                temp_state[i] = random.randint(0,N-1)
            if temp_state != self.state:
                break
        temp_board = self.generate_board(temp_state)

        self.neighbor_state = [0]*N
        for i,x in enumerate(temp_state):
            self.neighbor_state[i] = x
        self.neighbor_board = self.generate_board(self.neighbor_state)

    def simulated_annealing(self,T):
        N = self.N
        t = T

        # initialize neighbor to current state
        self.neighbor_state = [0]*N
        for i,x in enumerate(self.state):
            self.neighbor_state[i] = x
        self.neighbor_board = self.generate_board(self.neighbor_state)
        best = 9999
        while(t > 0):
            t *= 0.99
            
            self.get_random_neighbor()

            next_state = self.get_score(self.neighbor_board, self.neighbor_state)
            current = self.get_score(self.board, self.state)
            delta = next_state - current
            delta_best = next_state - best
            if delta < 0:
                best = next_state
                if delta_best < 0:
                    self.state = [0]*N
                    for i,x in enumerate(self.neighbor_state):
                        self.state[i] = x
                    self.board = self.generate_board(self.state)

                if next_state == 0:
                    self.state = [0]*N
                    for i,x in enumerate(self.neighbor_state):
                        self.state[i] = x
                    self.board = self.generate_board(self.state)
                    print("solution: ")
                    self.print_board(self.board)
                    break
            elif random.uniform(0,1) < np.exp(-delta/t):
                self.state = [0]*N
                for i,x in enumerate(self.neighbor_state):
                    self.state[i] = x
                self.board = self.generate_board(self.state)

            
     
if __name__ == "__main__":
    Board = Board(25)
    Board.generate()
    prob_board = Board.board
    prob_state = Board.state

    print("")
    print("Problem board:")
    Board.print_board(Board.board)
    print("")
    print("solving... please be patient!")
    print("")

    hill_time0 = time.perf_counter()
    Board.hill_climbing()
    hill_time1 = time.perf_counter()
    print("Hill Climbing Time: %d seconds" % (hill_time1-hill_time0))
    print("")

    Board.board = prob_board
    Board.state = prob_state

    print("")
    print("Simulated Annealing: ")
    print("solving... please be patient!")
    print("")

    annealiing_time0 = time.perf_counter()
    Board.simulated_annealing(300)
    annealiing_time1 = time.perf_counter()
    print("Simulated Annealing Time: %d seconds" % (annealiing_time1-annealiing_time0))
    print("")