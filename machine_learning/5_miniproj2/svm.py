import numpy as np
from numpy import random

class Svm:

    def __init__(self, X, Y, num_classes):
        self.weights = 0.01 * random.randn(num_classes)
        self.x = np.array(X)
        self.y = np.array(Y)

    def train(self, learning_rate, T):
        self.weights[0] = 0
        for t in range(T):
            t = t+1
            i = random.randint(0,len(self.x))
            nt = 1 / (learning_rate*t)
            if self.y[i] * np.dot(self.weights, self.x[i]) < 1:
                self.weights = (1 - nt*learning_rate)*self.weights \
                    + nt*self.y[i]*self.x[i]
            elif self.y[i] * np.dot(self.weights, self.x[i]) >= 1:
                self.weights = (1 - nt*learning_rate) * self.weights

    def predict(self, X_test):
        self.preds = []
        self.labels = [0,1]
        for x in np.array(X_test):
            prediction = np.argmax(self.weights * x)
            self.preds.append(self.labels[prediction])




if __name__ == "__main__":
    X = [[2,1],[3,1],[3,2],[4,1],[4,2],[5,1],[5,2],[6,1],[1,4],[1,3],[2,4],[2,3],[3,4],[3,5],[2,5],[1,5]]
    Y = [0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1]
    
    num_classes = 2
    SVM = Svm(X,Y,num_classes)
    SVM.train(0.7, 10)
    SVM.predict(X)
    print(SVM.preds)