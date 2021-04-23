import numpy as np
from numpy import random

class Svm:

    def __init__(self, X, Y, learning_rate, T):
        self.x = np.array(X)
        self.y = np.array(Y)
        self.bias = 0
        self.learning_rate = learning_rate
        self.T = T

    def train(self, x, y):
        self.weights = np.zeros(x.shape[1])
        if self.target_class > self.testing_class:
            y = np.where(y <= self.testing_class, -1, 1)
        else:
            y = np.where(y > self.target_class,-1,1)
        for t in range(self.T):
            # print("progress: %f" % ((t/self.T)*100))
            t = t+1
            nt = 1 / (self.learning_rate*t)
            i = np.random.randint(0,len(x))
            if y[i] * np.dot(self.weights, x[i]) - self.bias < 1:
                self.weights = (1 - nt*self.learning_rate)*self.weights \
                    + nt*y[i]*x[i]
                self.bias -= self.learning_rate*y[i]
            elif y[i] * np.dot(self.weights, x[i]) - self.bias >= 1:
                self.weights = (1 - nt*self.learning_rate) * self.weights

    def fit(self, num_classes):
        self.ecoc = np.identity(num_classes)
        self.learner_weights = []
        self.learner_predictions = []
        for x in self.ecoc:
            self.target_class = np.argmax(x)
            for self.testing_class in x:
                if self.testing_class == self.target_class: continue
                x_testing = []
                x_target = []
                y_testing = []
                y_target = []
                for ndx,x_val in enumerate(self.x):
                    if self.y[ndx] == self.target_class:
                        x_target.append(x_val)
                        y_target.append(self.target_class)
                    if self.y[ndx] == self.testing_class:
                        x_testing.append(x_val)
                        y_testing.append(self.testing_class)
                x_learn = np.concatenate((x_target,x_testing))
                y_learn = np.concatenate((y_target,y_testing))
                self.train(x_learn,y_learn)
                self.learner_weights.append(self.weights)
                predictions = self.predict(x_learn,self.weights)
                predictions = np.where(predictions == -1, 0,1)
                self.learner_predictions.append(predictions)

    def predict(self, X_test, weights):
        self.output = np.dot(X_test, weights) - self.bias
        self.preds = np.sign(self.output)
        return self.preds
        
    def ecoc_predict(self, X_test):
        self.ecoc_predict = []
        for point in X_test:
            code = np.array([])
            for ndx,key in enumerate(self.ecoc):
                weights = self.learner_weights[ndx]
                code = np.append(code, (np.sign(np.dot(weights, point) - self.bias)))
            diffs = []
            code = np.where(code == -1, 0, 1)
            for ecoc in self.ecoc:
                diff = np.sum(np.abs(ecoc - code))
                diffs.append(diff)
            ans = np.argmin(diffs)
            self.ecoc_predict.append(ans)
        print(self.ecoc_predict)

if __name__ == "__main__":
    X = [[2,1],[3,1],[3,2],[4,1],[4,2],[5,1],[5,2],[6,1],[1,4],[1,3],[2,4],[2,3],[3,4],[3,5],[2,5],[1,5]]
    Y = [0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1]
    
    num_classes = 2
    SVM = Svm(X,Y,0.3,50)
    SVM.fit(num_classes)
    SVM.ecoc_predict(X)
