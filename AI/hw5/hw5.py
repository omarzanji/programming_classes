"""
author: Omar Barazanji
description: Hierarchical Clustering algorithm.
date: 10/19/2021
class: COMP 660 (Auburn University)
"""

import numpy as np
from matplotlib import pyplot as plt

class Set:
    def __init__(self, set, name):
        self.set = set
        self.name = name
        self.clusters = []

    def show_plot(self):
        fig1 = plt.figure()
        plt.scatter(self.set[:,0], self.set[:,1])
        plt.title("Scatter Plot of Set %s" % self.name)

    def show_cluster(self):
        colors = ['blue', 'red', 'green', 'black']
        fig2 = plt.figure()
        for i,x in enumerate(self.clusters):
            points = x[0]
            x = []
            y = []
            for point in points:
                x.append(point[0])
                y.append(point[1])
            plt.scatter(x,y,color='%s' % colors[i],label='Cluster %d' % i)
        plt.title('Hierarchical Clustering on Set %s' % self.name)
        plt.legend()

    def init_clusters(self):
        for x in self.set:
            self.clusters.append([[(x[0],x[1])],0])

    def hier_cluster(self, k):
        self.init_clusters()
        while len(self.clusters) > k:
            best_delta = 9999
            best_point1 = self.clusters[0][0]
            best_point2 = self.clusters[1][0]
            best_ndx1 = 0
            best_ndx2 = 1
            for x in range(len(self.clusters)):
                for y in range(len(self.clusters)):
                    if y == x: continue
                    else:
                        point1 = self.clusters[x][0]
                        point2 = self.clusters[y][0]

                        x_point1 = []
                        y_point1 = []

                        for i in point1:
                            x_point1.append(i[0])
                            y_point1.append(i[1])

                        x_point2 = []
                        y_point2 = []
                        for i in point2:
                            x_point2.append(i[0])
                            y_point2.append(i[1])

                        # old method:
                        # x_point1_avg = np.average(x_point1)
                        # y_point1_avg = np.average(y_point1)
                        # x_point2_avg = np.average(x_point2)
                        # y_point2_avg = np.average(y_point2)
                        # del1 = (x_point1_avg-x_point2_avg)**2
                        # del2 = (y_point1_avg-y_point2_avg)**2
                        # delta = np.sqrt(del1+del2)

                        sub_delta_best = 9999
                        for i in range(len(point1)):
                            for j in range(len(point2)):
                                delx = (x_point1[i]-x_point2[j])**2
                                dely = (y_point1[i]-y_point2[j])**2
                                sub_delta = np.sqrt(delx+dely)
                                if sub_delta <= sub_delta_best:
                                    sub_delta_best = sub_delta
                    
                        delta = sub_delta_best

                        if delta <= best_delta:
                            best_delta = delta
                            best_point1 = self.clusters[x]
                            best_point2 = self.clusters[y]
                            best_ndx1 = x
                            best_ndx2 = y

            temp_point_list = []
            temp_point_list = self.clusters[best_ndx1][0] + self.clusters[best_ndx2][0]
            self.clusters.remove(best_point1)
            self.clusters.remove(best_point2)
            self.clusters.append([temp_point_list,best_delta])
            

if __name__ == "__main__":
    A = np.loadtxt("A.txt")
    B = np.loadtxt("B.txt")

    setA = Set(A, 'A')
    setB = Set(B, 'B')

    print('Calculating! Please wait...')
    setB.hier_cluster(2)
    setB.show_plot()
    setB.show_cluster()
    plt.show()