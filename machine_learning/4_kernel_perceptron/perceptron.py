'''
Kernel Perceptron algorithm trained on provided data.

author: Omar Barazanji
date: 3/29/21

sources: Auburn University COMP 5630/6630 (Machine Learning)
'''

from numpy import dot
from numpy import sum
from numpy import zeros
from numpy import sign

from matplotlib import pyplot as plt
import pylab as pl
import numpy as np

class Perceptron:

    def __init__(self, X, Y):
        self.X = X
        self.Y = Y
        self.alpha = zeros(len(X))

    def poly_kernel(self, x, y, p):
        return (1 + dot(x, y)) ** p

    def kernel_perceptron(self):
        num_samples = len(self.X)
        k_matrix = np.zeros((num_samples, num_samples))

        for x in range(num_samples):
            for y in range(num_samples):
                k_matrix[x,y] = self.poly_kernel(self.X[x],self.X[y],1)

        for ndx in range(num_samples):
            decision = sign(sum(k_matrix[:,ndx] * self.alpha * self.Y))
            if decision != self.Y[ndx]:
                self.alpha[ndx] += self.Y[ndx]

    def predict(self, X):
        y = np.zeros(len(self.X))
        for i in range(len(self.X)):
            y[i] = sum(self.alpha[i] * self.Y[i] * self.poly_kernel(self.X,self.X[i],1))
        return y


if __name__ == "__main__":

    X = [[2,1],[3,1],[3,2],[4,1],[4,2],[5,1],[5,2],[6,1],[1,4],[1,3],[2,4],[2,3],[3,4],[3,5],[2,5],[1,5]]
    Y = [-1,-1,-1,-1,-1,-1,-1,-1,1,1,1,1,1,1,1,1]

    P1 = Perceptron(X, Y)
    print("training, please wait...")
    P1.kernel_perceptron()
    predictions = P1.predict(X)
    print("feeding input back in to test label prediction: \n" + str(np.sign(predictions)))