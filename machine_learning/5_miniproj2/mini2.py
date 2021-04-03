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
from layers import activation_softmax_loss_categorical_cross_entropy
from layers import optimizer_sgd

import matplotlib.pyplot as plt

# perceptron from homework 5
from perceptron import Perceptron

if __name__ == "__main__":
    x, y = load_svmlight_file('mnist.scale')
    x = x.toarray()
    y = y.astype(int)

    X, X_test, Y, Y_test = train_test_split(x,y,test_size=0.70)

    # X = [[2,1],[3,1],[3,2],[4,1],[4,2],[5,1],[5,2],[6,1],[1,4],[1,3],[2,4],[2,3],[3,4],[3,5],[2,5],[1,5]]
    # Y = [0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1]
    num_classes = 10
    
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
    # combine output layer softmax activation with loss function
    activation2 = activation_softmax_loss_categorical_cross_entropy()

    # optimizer
    optimizer = optimizer_sgd()

    T = 100
    for itr in range(T):
        # forward pass
        L1.forward(X)
        activation1.forward(L1.output)
        L2.forward(activation1.output)
        loss = activation2.forward(L2.output, Y)


        # Calculate accuracy from output of activation2 and targets
        # calculate values along first axis
        predictions = np.argmax(activation2.output, axis=1)
        if len(np.array(Y).shape) == 2:
            Y = np.argmax(Y, axis=1)
        accuracy = np.mean(predictions == Y)

        if not T % 100:
            print(f'epoch: {itr}, ' +
            f'acc: {accuracy:.3f}, ' +
            f'loss: {loss:.3f}')
        
        # backward pass
        activation2.backward(activation2.output, Y)
        L2.backward(activation2.dinputs)
        activation1.backward(L2.dinputs)
        L1.backward(activation1.dinputs)

        # update weights and biases
        optimizer.update_params(L1)
        optimizer.update_params(L2)