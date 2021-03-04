'''
KNN algorithm implementation.

author: Omar Barazanji
date: 3/5/21

sources: Auburn University COMP 5630/6630
'''

import numpy as np
from matplotlib import pyplot as plt


class KNN:

    def __init__(self, Xin, Yin):
        self.Xin = Xin
        self.Yin = Yin

    def knn(self, Xin, test_point, k):
        x_vals1 = []
        y_vals1 = []
        x_vals2 = []
        y_vals2 = []
        T=28
        for ndx,point in enumerate(Xin):
            if ndx+1 == T: break
            if self.Yin[point[0]] == 1:
                x_vals1.append(0)
                y_vals1.append(point[1])
            elif self.Yin[point[0]] == -1:
                x_vals2.append(0)
                y_vals2.append(point[1])
                    
        dist1 = []
        dist2 = []
        for ndx in range(13):
            dist1.append( [float(np.sqrt((test_point-y_vals1[ndx])**2)), ndx] )
            dist2.append( [float(np.sqrt((test_point-y_vals2[ndx])**2)), ndx] )
        dist1 = np.array(dist1)
        dist1 = np.sort(dist1, 0)
        dist2 = np.array(dist2)
        dist2 = np.sort(dist2, 0)
        ans = 0
        for x in range(k):
            if dist1[x][0] < dist2[x][0]:
                ans = 1
            else: ans = -1
        print(ans)
        plt.scatter(0,test_point,s=40, color='green', label='test point, predict: %d'%ans)
        plt.legend()

    def knn2(self, Xin, test_point, k):
        x_vals1 = []
        y_vals1 = []
        x_vals2 = []
        y_vals2 = []
        T = 400
        for ndx,point in enumerate(Xin):
            if ndx+1 == T: break
            if ndx%3 == 0:
                if self.Yin[point[0]] == 1:
                    x_vals1.append(Xin[ndx-3][2])
                    y_vals1.append(Xin[ndx-2][2])
                elif self.Yin[point[0]] == 2:
                    x_vals2.append(Xin[ndx-3][2])
                    y_vals2.append(Xin[ndx-2][2])
                    
        dist1 = []
        dist2 = []

        print(x_vals2)
        print(y_vals2)
        print(test_point)
        for ndx in range(len(y_vals1)-1):
            dist1.append( [float(np.sqrt( (test_point[0]-x_vals1[ndx])**2 + (test_point[1]-y_vals1[ndx])**2)) , ndx] )
            dist2.append( [float(np.sqrt( (test_point[0]-x_vals2[ndx])**2 + (test_point[1]-y_vals2[ndx])**2)) , ndx] )
        
        dist1 = np.array(dist1)
        dist1 = np.sort(dist1, 0)
        dist2 = np.array(dist2)
        dist2 = np.sort(dist2, 0)
        ans = 0
        for x in range(k):
            if dist1[x][0] < dist2[x][0]:
                ans = 1
            else: ans = -1
        print(ans)
        plt.scatter(test_point[0],test_point[1],s=40, color='green', label='test point, predicted: %d'%ans)
        plt.legend()

    def plot_input1(self, Xin, T):
        x_vals1 = []
        y_vals1 = []
        x_vals2 = []
        y_vals2 = []
        for ndx,point in enumerate(Xin):
            if ndx+1 == T: break
            if self.Yin[point[0]] == 1:
                x_vals1.append(0)
                y_vals1.append(point[1])
            elif self.Yin[point[0]] == -1:
                x_vals2.append(0)
                y_vals2.append(point[1])
        fig3 = plt.figure()
        plt.scatter(x_vals1, y_vals1, color='red', label='1 class')
        plt.scatter(x_vals2, y_vals2, color='blue', label='-1 class')
        plt.title("Binary Classification KNN Visualization")
        plt.legend()

    def plot_input2(self, Xin, T):
        x_vals1 = []
        y_vals1 = []
        x_vals2 = []
        y_vals2 = []
        for ndx,point in enumerate(Xin):
            if ndx+1 == T: break
            if ndx%3 == 0:
                if self.Yin[point[0]] == 1:
                    x_vals1.append(Xin[ndx-3][2])
                    y_vals1.append(Xin[ndx-2][2])
                elif self.Yin[point[0]] == 2:
                    x_vals2.append(Xin[ndx-3][2])
                    y_vals2.append(Xin[ndx-2][2])
        fig4 = plt.figure()
        plt.scatter(x_vals1, y_vals1, color='red', label='1 class')
        plt.scatter(x_vals2, y_vals2, color='blue', label='2 class')
        plt.title("Multiclass KNN Visualization on 2 Features")
        plt.legend()