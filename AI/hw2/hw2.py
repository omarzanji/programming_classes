'''
Solving puzzle using A* by hand. 
'''

def create_state_space():
    arr = [[2,3,7,4,5],
           [1,0,11,0,8],
           [6,10,"",12,15],
           [9,0,14,0,20],
           [13,16,17,18,19]]
    return arr

def create_goal_state():
    arr = [[1,2,3,4,5],
           [6,0,7,0,8],
           [9,10,"",11,12],
           [13,0,14,0,15],
           [16,17,18,19,20]]
    return arr

if __name__ == "__main__":
    init = create_state_space()
    goal = create_goal_state()
    
    temp = 0
    move = 0

    state0 = init # state 0 will put "1" in the right place

    for line in state0:
        print(str(line))
    print("")

    #step1
    temp = state0[2][2]
    move = state0[1][2]
    state0[2][2] = move
    state0[1][2] = temp

    for line in state0:
        print(str(line))
    print("")

    #step2
    temp = state0[0][2]
    move = state0[1][2]
    state0[0][2] = move
    state0[1][2] = temp

    for line in state0:
        print(str(line))
    print("")

    #step3
    temp = state0[0][2]
    move = state0[0][1]
    state0[0][2] = move
    state0[0][1] = temp

    for line in state0:
        print(str(line))
    print("")

    #step4
    temp = state0[0][1]
    move = state0[0][0]
    state0[0][1] = move
    state0[0][0] = temp

    for line in state0:
        print(str(line))
    print("")

    #step5
    temp = state0[0][0]
    move = state0[1][0]
    state0[0][0] = move
    state0[1][0] = temp

    for line in state0:
        print(str(line))
    print("")

    state1 = state0 # state 1 will put "6" in the right place

    #step6
    temp = state1[1][0]
    move = state1[2][0]
    state1[1][0] = move
    state1[2][0] = temp

    for line in state1:
        print(str(line))
    print("")

    state2 = state1 # state 2 will put "9" in the right place

    #step7
    temp = state2[2][0]
    move = state2[3][0]
    state2[2][0] = move
    state2[3][0] = temp

    for line in state2:
        print(str(line))
    print("")

    state3 = state2 # state 3 will complete the puzzle

    #step8
    temp = state3[3][0]
    move = state3[4][0]
    state3[3][0] = move
    state3[4][0] = temp

    for line in state3:
        print(str(line))
    print("")

    #step9
    temp = state3[4][0]
    move = state3[4][1]
    state3[4][0] = move
    state3[4][1] = temp

    for line in state3:
        print(str(line))
    print("")

    #step10
    temp = state3[4][1]
    move = state3[4][2]
    state3[4][1] = move
    state3[4][2] = temp

    for line in state3:
        print(str(line))
    print("")

    #step11
    temp = state3[4][2]
    move = state3[4][3]
    state3[4][2] = move
    state3[4][3] = temp

    for line in state3:
        print(str(line))
    print("")

    #step12
    temp = state3[4][3]
    move = state3[4][4]
    state3[4][3] = move
    state3[4][4] = temp

    for line in state3:
        print(str(line))
    print("")

    #step13
    temp = state3[4][4]
    move = state3[3][4]
    state3[4][4] = move
    state3[3][4] = temp

    for line in state3:
        print(str(line))
    print("")

    #step14
    temp = state3[3][4]
    move = state3[2][4]
    state3[3][4] = move
    state3[2][4] = temp

    for line in state3:
        print(str(line))
    print("")

    #step15
    temp = state3[2][4]
    move = state3[2][3]
    state3[2][4] = move
    state3[2][3] = temp

    for line in state3:
        print(str(line))
    print("")

    #step16
    temp = state3[2][3]
    move = state3[2][2]
    state3[2][3] = move
    state3[2][2] = temp

    for line in state3:
        print(str(line))        
    print("")
