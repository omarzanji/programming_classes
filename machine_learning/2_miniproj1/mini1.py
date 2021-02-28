'''
Mini project for Machine Learning separating real data using 
Perceptron and KNN algorithms.

author: Omar Barazanji
date: 3/5/21

sources: Auburn University COMP 5630/6630
'''

import numpy as np

from matplotlib import pyplot as plt

from perceptron import Perceptron
from svm import SVM

class Binary:

    def __init__(self):
        self.file_name = 'data/a4a.txt'
        self.yn = []
        self.xn = []
        
        line = []
        with open(self.file_name, 'r') as f:
            self.data = f.readlines()
            for x in self.data:
                data = x.split(' ')
                self.yn.append(x[0]+x[1])
                line = []
                for point in data:
                    if ':' in point:
                        line.append(point.split(':'))
                self.xn.append(line)
    

if __name__ == "__main__":
    Bin = Binary()

    Svm = SVM(Bin.xn, Bin.yn)
    weights = Svm.svm(0.4, 100)
    Svm.plot_input(Bin.xn[0:60])
    Svm.plot_separator(weights)

    # Perc = Perceptron(Bin.xn, Bin.yi)
    # weights = Perc.perceptron()
    # Perc.plot_input(Bin.xn[0:1])
    # Perc.plot_separator(weights)

    plt.show()