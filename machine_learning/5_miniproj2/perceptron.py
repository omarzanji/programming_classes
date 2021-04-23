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

    def train(self,X,Y, T):
        num_samples = len(X)
        k_matrix = np.zeros((num_samples, num_samples))
        if self.target_class > self.testing_class:
            Y = np.where(Y <= self.testing_class, -1, 1)
        else:
            Y = np.where(Y > self.target_class,-1,1)
        for x in range(num_samples):
            for y in range(num_samples):
                k_matrix[x,y] = self.poly_kernel(X[x],X[y],1)
        for t in range(T):
            for ndx in range(num_samples):
                decision = sign(sum(k_matrix[:,ndx] * self.alpha * Y))
                if decision != Y[ndx]:
                    self.alpha[ndx] += Y[ndx]

    def fit(self, num_classes):
        self.ecoc = np.identity(num_classes)
        self.learner_weights = []
        self.learner_predictions = []
        self.learner_labels = []
        for x in self.ecoc:
            self.target_class = np.argmax(x)
            for self.testing_class in x:
                if self.testing_class == self.target_class: continue
                x_testing = []
                x_target = []
                y_testing = []
                y_target = []
                for ndx,x_val in enumerate(self.X):
                    if self.Y[ndx] == self.target_class:
                        x_target.append(x_val)
                        y_target.append(self.target_class)
                    if self.Y[ndx] == self.testing_class:
                        x_testing.append(x_val)
                        y_testing.append(self.testing_class)
                x_learn = np.concatenate((x_target,x_testing))
                y_learn = np.concatenate((y_target,y_testing))
                self.alpha = zeros(len(x_learn))
                self.learner_labels.append(y_learn)
                self.train(x_learn,y_learn,1)
                self.learner_weights.append(self.alpha)
                predictions = self.predict(x_learn,self.alpha,y_learn)
                predictions = np.where(predictions == -1, 0,1)
                self.learner_predictions.append(predictions)

    def project(self, X, alpha, learn_y):
        y_preds = np.zeros(len(X))
        for i in range(len(X)):
            s = 0
            for j,a in enumerate(alpha):
                s += a * learn_y[i] * self.poly_kernel(X[i], X[j], 1)
            y_preds[i] = s
        return y_preds

    def predict(self, X, alpha, learn_y):
        return np.sign(self.project(X,alpha,learn_y))

    def ecoc_predict(self, X_test):
        self.ecoc_predict = []
        for x_ndx,point in enumerate(X_test):
            code = np.array([])
            for ndx,key in enumerate(self.ecoc):
                code = np.append(code, self.predict(X_test, self.learner_weights[ndx], self.learner_labels[ndx])[x_ndx])
            diffs = []
            code = np.where(code == -1, 0, 1)
            for ecoc in self.ecoc:
                diff = np.sum(np.abs(ecoc - code))
                diffs.append(diff)
            ans = np.argmin(diffs)
            self.ecoc_predict.append(ans)
        return self.ecoc_predict

if __name__ == "__main__":
    X = [[2,1],[3,1],[3,2],[4,1],[4,2],[5,1],[5,2],[6,1],[1,4],[1,3],[2,4],[2,3],[3,4],[3,5],[2,5],[1,5]]
    Y = [0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1]
    
    num_classes = 2
    Perc = Perceptron(X,Y)
    Perc.fit(num_classes)
    preds = Perc.ecoc_predict(X)
    print(preds)