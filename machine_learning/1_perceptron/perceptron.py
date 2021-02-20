
class Perceptron:

    def __init__(self):
        self.bias_val = 1
        self.w_arr = [0,1,1]

    def perceptron(self, Xin):
        for x_n in Xin:
            # bias
            x_0 = self.bias_val * self.w_arr[0]
            # inputs
            x_1 = x_n[0] * self.w_arr[1]
            x_2 = x_n[1] * self.w_arr[2]
            summation = x_0 + x_1 + x_2
            print(summation)
            if summation > 0:
                if x_n[1] < 1:
                    self.w_arr[0] = self.w_arr[0] + 0.2*-1*self.bias_val
                    self.w_arr[1] = self.w_arr[1] + 0.2*-1*x_n[0]
                    self.w_arr[2] = self.w_arr[2] + 0.2*-1*x_n[1]
            
            else:
                return self.w_arr



if __name__ == "__main__":
    X1d = [(1,0),(2,0),(3,0),(4,0)]
    X2d = [(1,2),(2,-1),(3,2),(4,-1)]
    p = Perceptron()
    separator = p.perceptron(X1d)
