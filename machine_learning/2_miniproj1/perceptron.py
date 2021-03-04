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

        self.w_arr = [0,0.2,0.4]

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


    def perceptron2(self, T):
        for ndx,point in enumerate(self.Xin):
            if ndx+1 == T: break

            if ndx%3 == 0:
                yn = self.Yin[point[0]]
                x0 = self.bias_val
                x1 = self.Xin[ndx-3][2]
                x2 = self.Xin[ndx-2][2]
                x3 = self.Xin[ndx-1][2]
                x4 = point[2]

                # bias
                x_0 = x0 * self.w_arr[0]
                # inputs
                x_1 = x1 * self.w_arr[1]
                x_2 = x2 * self.w_arr[2]

                summation = x_0 + x_1 + x_2
                self.gen_sep()
                if yn*summation > 0:
                    # if int(x_n[1]) < self.sep_y[ndx]:
                    self.w_arr[0] = self.w_arr[0] + 0.2*yn*x0
                    self.w_arr[1] = self.w_arr[1] + 0.2*yn*x1
                    self.w_arr[2] = self.w_arr[2] + 0.2*yn*x2
                else:
                    self.w_arr[0] = self.w_arr[0] + 0.2*yn*x0
                    self.w_arr[1] = self.w_arr[1] + 0.2*yn*x1
                    self.w_arr[2] = self.w_arr[2] + 0.2*yn*x2
        return self.w_arr

    def perceptron(self, T):
        for ndx,point in enumerate(self.Xin):
            if ndx+1 == T: break
            yn = self.Yin[point[0]]
            x0 = self.bias_val
            x1 = 0
            x2 = point[1]

            # bias
            x_0 = x0 * self.w_arr[0]
            # inputs
            x_1 = x1 * self.w_arr[1]
            x_2 = x2 * self.w_arr[2]

            summation = x_0 + x_1 + x_2
            self.gen_sep()
            if yn*summation > 0:
                self.w_arr[0] = self.w_arr[0] + 0.2*yn*x0
                self.w_arr[1] = self.w_arr[1] + 0.2*yn*x1
                self.w_arr[2] = self.w_arr[2] + 0.2*yn*x2
            else:
                self.w_arr[0] = self.w_arr[0] + 0.2*yn*x0
                self.w_arr[1] = self.w_arr[1] + 0.2*yn*x1
                self.w_arr[2] = self.w_arr[2] + 0.2*yn*x2
        return self.w_arr
            
    def plot_separator1(self, weights):
        w0 = weights[0]
        w1 = weights[1]
        w2 = weights[2]
        sepr_x = np.linspace(-2,5,10).tolist()
        sepr_y = []
        for x in sepr_x:
            val = -((w1 / w2)*x) - w0
            sepr_y.append(val)
        plt.plot(sepr_x, sepr_y, label='separator')
        plt.legend()
        
    def plot_separator2(self, weights):
        w0 = weights[0]
        w1 = weights[1]
        w2 = weights[2]
        sepr_x = np.linspace(-2,5,10).tolist()
        sepr_y = []
        for x in sepr_x:
            val = -((w1 / w2)*x)
            sepr_y.append(val)
        plt.plot(sepr_x, sepr_y, label='separator')
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

        fig1 = plt.figure()
        plt.scatter(x_vals1, y_vals1, color='red', label='1 class')
        plt.scatter(x_vals2, y_vals2, color='blue', label='2 class')
        plt.title("Multiclass Perceptron Visualization on 2 Features")
        plt.legend()

    def plot_input(self, Xin, T):
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
        fig2 = plt.figure()
        plt.scatter(x_vals1, y_vals1, color='red', label='1 class')
        plt.scatter(x_vals2, y_vals2, color='blue', label='-1 class')
        plt.title("Binary Classification Perceptron Visualization")
        plt.legend()
