'''
Perceptron algorithm trained on simple 1D and 2D data.

author: Omar Barazanji
date: 2/20/21

sources: Auburn University COMP 5630/6630 (Machine Learning)
'''


from matplotlib import pyplot as plt
import numpy as np

class Perceptron:

    def __init__(self, Xin, Yin):
        self.bias_val = 1

        self.Xin = Xin
        self.Yin = Yin

        # should update to better values
        self.w_arr = [0,0.4,0.6]

        self.sep_x = []
        self.sep_y = []

    def gen_sep(self):
        w1 = self.w_arr[1]
        w2 = self.w_arr[2]
        sepr_x = np.linspace(-10,10,10).tolist()
        sepr_y = []
        for x in sepr_x:
            val = -(w1*x) / w2
            sepr_y.append(val)
        self.sep_x = sepr_x
        self.sep_y = sepr_y


    def perceptron(self):
        for ndx,line in enumerate(self.Xin):
            for x_n in line:
                # bias
                x_0 = self.bias_val * self.w_arr[0]
                # inputs
                x_1 = int(x_n[0]) * self.w_arr[1]
                x_2 = int(x_n[1]) * self.w_arr[2]
                summation = x_0 + x_1 + x_2
                # print("sum",summation)
                self.gen_sep()
                if summation > 0:
                    print(ndx)
                    if int(x_n[1]) < self.sep_y[ndx]:
                        self.w_arr[0] = self.w_arr[0] + 0.2*-1*self.bias_val
                        self.w_arr[1] = self.w_arr[1] + 0.2*-1*int(x_n[0])
                        self.w_arr[2] = self.w_arr[2] + 0.2*-1*int(x_n[1])
                    else:
                        self.w_arr[0] = self.w_arr[0] + 0.2*1*self.bias_val
                        self.w_arr[1] = self.w_arr[1] + 0.2*1*int(x_n[0])
                        self.w_arr[2] = self.w_arr[2] + 0.2*1*int(x_n[1])
        return self.w_arr

    def gen_data(self, dim=2):
        X = []
        for x in range(10):
            point = (np.random.randint(-4,5),np.random.randint(-4,5))
            X.append(point)
        return X
            
    def plot_separator(self, weights):
        # w1*x1 + w2*x2 = 0
        # solve for x2:
        # x2 = -(w1*x1) / w2
        w1 = weights[1]
        w2 = weights[2]
        sepr_x = np.linspace(-2,5,10).tolist()
        sepr_y = []
        for x in sepr_x:
            val = -(w1*x) / w2
            sepr_y.append(val)
        plt.plot(sepr_x, sepr_y, label='separator')

    def plot_input(self, Xin, color='blue', label='input'):
        x_vals = []
        y_vals = []
        for line in Xin:
            for x in line:
                x_vals.append(x[0])
                y_vals.append(x[1])
        plt.scatter(x_vals, y_vals, color=color, label=label)
        plt.legend()


if __name__ == "__main__":
    X1d = [(1,0),(2,0),(3,0),(4,0)]
    X2d = [(1,2),(2,-1),(3,2),(4,-1)]
    p = Perceptron()
    Xgen = p.gen_data(2)
    print(Xgen)
    # trained_weights = p.perceptron(X1d)
    for x in range(10):
        trained_weights = p.perceptron(Xgen)
    p.plot_separator(trained_weights)
    # p.plot_input(X1d, 'red', '1D (x2 = 0)')
    p.plot_input(Xgen, 'green', '2D')
    plt.title('Perceptron Separator for 2D data')
    plt.xlabel("x1")
    plt.ylabel("x2")
    # plt.legend(loc="upper left")
    plt.show()