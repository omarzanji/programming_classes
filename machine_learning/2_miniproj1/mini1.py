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
from knn import KNN

from sklearn.datasets import load_svmlight_file
import scipy.sparse

class Data:

    def __init__(self, datapath):
        self.file_name = datapath
        self.xn, self.yn = load_svmlight_file(self.file_name)

        cx = scipy.sparse.coo_matrix(self.xn)
        self.xn = []
        for i,j,v in zip(cx.row, cx.col, cx.data):
            self.xn.append((i,j,v))

if __name__ == "__main__":
    path1 = 'data/a4a.txt'
    path2 = 'data/iris.scale.txt'
    path3 = 'data/a4a_testing.txt'

    dat1 = Data(path1)
    Perc1 = Perceptron(dat1.xn, dat1.yn)
    weights1 = Perc1.perceptron(400)
    Perc1.plot_input(dat1.xn, 400)
    Perc1.plot_separator1(weights1)

    dat2 = Data(path2)
    Perc2 = Perceptron(dat2.xn, dat2.yn)
    weights2 = Perc2.perceptron2(400)
    Perc2.plot_input2(dat2.xn, 400)
    Perc2.plot_separator2(weights2)

    test_dat = Data(path3)
    Knn1 = KNN(dat1.xn, dat1.yn)
    reference_sample = dat1.xn[(7*14):(8*14)+14]
    Knn1.plot_input1(reference_sample, 28)
    test_point = test_dat.xn[8*14 + 8]
    tst_pnt = test_point[1]
    print("test point: ", test_point)
    Knn1.knn(reference_sample, tst_pnt, k=3)
    
    Knn2 = KNN(dat2.xn, dat2.yn)
    reference_sample = dat2.xn[0:400]
    Knn2.plot_input2(reference_sample, 400)
    test_point = (dat2.xn[4*10], dat2.xn[4*10 + 1])
    tst_point = [test_point[0][2],test_point[1][2]]
    print("test point: ", tst_point)
    Knn2.knn2(reference_sample, tst_point, k=3)

    plt.show()