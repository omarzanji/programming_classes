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

from layers import layer_dense
from layers import activation_relu
from layers import activation_softmax
from layers import loss_categorical_cross_entropy

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
    num_classes = 3
    # kernel perceptron
    # P1 = Perceptron(X, Y)
    # print("training, please wait...")
    # P1.kernel_perceptron()
    # predictions = P1.predict(X)
    # print("feeding input back in to test label prediction: \n" + str(np.sign(predictions)))

    # neural network
    neurons = 100
    L1 = layer_dense(len(X[0]), neurons)
    activation1 = activation_relu()
    L2 = layer_dense(neurons, num_classes)
    activation2 = activation_softmax()

    # loss function
    loss_func = loss_categorical_cross_entropy()

    # initialize weights and biases + init lowest_loss
    lowest_loss = 9999999
    best_L1_weights = L1.weights.copy()
    best_L1_biases = L1.biases.copy()
    best_L2_weights = L2.weights.copy()
    best_L2_biases = L2.biases.copy()

    T = 10000
    for itr in range(T):
        L1.weights += 0.05 * np.random.randn(len(X[0]),neurons)
        L1.biases += 0.05 * np.random.randn(1,neurons)
        L2.weights += 0.05 * np.random.randn(neurons,num_classes)
        L2.biases += 0.05 * np.random.randn(1,num_classes)

        # forward pass
        L1.forward(X)
        activation1.forward(L1.output)
        L2.forward(activation1.output)
        activation2.forward(L2.output)

        # calc loss
        loss = loss_func.calculate(activation2.output, Y)

        # Calculate accuracy from output of activation2 and targets
        # calculate values along first axis
        predictions = np.argmax(activation2.output, axis=1)
        accuracy = np.mean(predictions == Y)

        if loss < lowest_loss:
            print('New set of weights found, iteration:', itr,
                'loss:', loss, 'acc:', accuracy)
            best_L1_weights = L1.weights.copy()
            best_L1_biases = L1.biases.copy()
            best_L2_weights = L2.weights.copy()
            best_L2_biases = L2.biases.copy()
            lowest_loss = loss

        # Revert weights and biases
        else:
            L1.weights = best_L1_weights.copy()
            L1.biases = best_L1_biases.copy()
            L2.weights = best_L2_weights.copy()
            L2.biases = best_L2_biases.copy()