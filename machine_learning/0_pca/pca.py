'''
Implementation of the Principal Component Analysis (PCA) algorithm.

author: Omar Barazanji
sources: Auburn Universiry COMP 5630/6630
'''

import numpy as np
from scipy.sparse.linalg import eigs
import matplotlib.pyplot as plt

def PCA(X, k):
    mu = np.mean(X)
    N = X.shape[0]
    X = X - mu*np.ones((N, 1))
    fig2 = plt.figure()
    plt.scatter(X[0], X[1])
    plt.title("Data Centered")
    covX = np.cov(X)
    U, lamda = eigs(covX, k)
    E = np.transpose(X)*U
    return E, U, lamda

if __name__ == "__main__":
    x = np.random.rand(100)
    y = np.append(np.random.uniform(0.30, 0.35, 50), np.random.uniform(0.35, 0.40, 50))
    X = np.array([x,y])
    fig1 = plt.figure()
    plt.scatter(x,y)
    plt.title("Original Data")
    E,U,lamda = PCA(X,2)
    fig3 = plt.figure()
    projx = []
    projy = []
    for x in E:
        projx.append(x[0])
        projy.append(x[1])
    plt.scatter(projx,projy)
    plt.title("Projection")
    plt.show()
