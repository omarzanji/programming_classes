'''
SVM algorithm implementation.

author: Omar Barazanji
date: 3/5/21

sources: Auburn University COMP 5630/6630
'''

import numpy as np
from matplotlib import pyplot as plt


class SVM:

    def __init__(self, Xin, Yin):
        self.weights = [0.2,0,1]
        self.bias_val = 1
        self.Xin = Xin
        self.Yin = Yin

    def svm(self, L, T):
        for t in range(T):
            i = np.random.randint(1,len(self.Xin))
            nt = 1 / (L*(t+1))
            xi_t = self.Xin[i]
            yi_t = int(self.Yin[i])

            for point in xi_t:
                x0 = self.bias_val # bias
                x1 = int(point[0])
                x2 = int(point[1])
                dot_product = x0*self.weights[0] + x1*self.weights[1] # x2*self.weights[2]
                if yi_t*dot_product < 1:
                    self.weights[0] = (1 - nt*L)*self.weights[0] + nt*yi_t*x0
                    self.weights[1] = (1 - nt*L)*self.weights[1] + nt*yi_t*x1
                    self.weights[2] = (1 - nt*L)*self.weights[2] + nt*yi_t*x2
                else:
                    self.weights[0] = (1 - nt*L)*self.weights[0]
                    self.weights[1] = (1 - nt*L)*self.weights[1]
                    self.weights[2] = (1 - nt*L)*self.weights[2] 
        return self.weights

    def plot_separator(self, weights):
        # w1*x1 + w2*x2 = -w0
        # solve for x2:
        # x2 = -(w1*x1) / w2
        w1 = weights[1]
        w2 = weights[2]
        sepr_x = np.linspace(-.5,.5,10).tolist()
        sepr_y = []
        sepr_y_val = - weights[0] / weights[1]
        for x in sepr_x:
        #     val = -(w1*x) / w2
            sepr_y.append(sepr_y_val)
        
        plt.plot(sepr_y, sepr_x, label='separator')
        plt.legend()

    def plot_input(self, Xin, color='blue', label='input'):
        x_vals = []
        y_vals = []
        for line in Xin:
            for point in line:
                x_vals.append(point[0])
                y_vals.append(point[1])
        plt.scatter(x_vals, y_vals, color=color, label=label)
        plt.legend()

if __name__ == "__main__":
    svm = SVM()
