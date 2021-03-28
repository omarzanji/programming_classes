'''
Mini project 2 for Machine Learning class.

author: Omar Barazanji
date: 3/29/21

sources: Auburn University COMP 5630/6630 (Machine Learning)
'''

import numpy as np
import pandas as pd
from sklearn.datasets import load_svmlight_file
from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix
import matplotlib.pyplot as plt

# perceptron from homework 5
from perceptron import Perceptron

if __name__ == "__main__":
    # x, y = load_svmlight_file('mnist.scale')
    # x = x.toarray()
    # y = y.astype(int)

    # X, X_test, Y, Y_test = train_test_split(x,y,test_size=0.90)

    X = [[2,1],[3,1],[3,2],[4,1],[4,2],[5,1],[5,2],[6,1],[1,4],[1,3],[2,4],[2,3],[3,4],[3,5],[2,5],[1,5]]
    Y = [-1,-1,-1,-1,-1,-1,-1,-1,1,1,1,1,1,1,1,1]

    P1 = Perceptron(X, Y)
    print("training, please wait...")
    P1.kernel_perceptron()
    predictions = P1.predict(X)
    print("feeding input back in to test label prediction: \n" + str(np.sign(predictions)))