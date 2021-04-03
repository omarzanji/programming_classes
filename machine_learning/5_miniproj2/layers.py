'''
Multi-layer neural network.

author: Omar Barazanji
date: 4/2/21

sources: Auburn University COMP 5630/6630 (Machine Learning)
'''

import math
import numpy as np
from numpy.random import randn

np.random.seed(0)

class activation_relu:
    def forward(self, inputs):
        self.inputs = inputs
        self.output = np.maximum(0, inputs)

    def backward(self, dvals):
        self.dinputs = dvals.copy()
        self.dinputs[self.inputs <= 0] = 0 #zero gradient where input vals were neg.

class activation_softmax:
    def forward(self, inputs):
        self.inputs = inputs
        exp_vals = np.exp(inputs - np.max(inputs, axis=1, keepdims=True))
        norm_vals = exp_vals / np.sum(exp_vals, axis=1, keepdims=True) # sum rows
        self.output = norm_vals

    def backward(self, dvals):
        self.dinputs = np.empty_like(dvals)

        for ndx, (single_output, single_dvals) in enumerate(zip(self.output, dvals)):
            # flatten output array
            single_output = single_output.reshape(-1, 1)
            # jacobian matrix of output
            jacobian_matrix = np.diagflat(single_output) - \
                              np.dot(single_output, single_output.T)
            # sample-wise gradient 
            self.dinputs[ndx] = np.dot(jacobian_matrix, single_dvals)

class activation_softmax_loss_categorical_cross_entropy:

    def __init__(self):
        self.activation = activation_softmax()
        self.loss = loss_categorical_cross_entropy()

    # Forward pass
    def forward(self, inputs, y_true):
        self.activation.forward(inputs)
        self.output = self.activation.output
        # Calculate and return loss value
        return self.loss.calculate(self.output, y_true)

    # Backward pass
    def backward(self, dvals, y_true):
        # Number of samples
        samples = len(dvals)
        y_true = np.array(y_true)
        # If labels are one-hot encoded,
        # turn them into discrete values.
        if len(y_true.shape) == 2:
            y_true = np.argmax(y_true, axis=1)

        self.dinputs = dvals.copy()
        # Calculate gradient
        self.dinputs[range(samples), y_true] -= 1
        # Normalize gradient
        self.dinputs = self.dinputs / samples

class optimizer_sgd:

    def __init__(self, learning_rate=1.0):
        self.learning_rate = learning_rate

    def update_params(self, layer):
        layer.weights += -self.learning_rate * layer.dweights
        layer.biases += -self.learning_rate * layer.dbiases

class layer_dense:

    def __init__(self, num_inputs, num_neurons):
        self.weights = 0.01 * randn(num_inputs, num_neurons)
        self.biases = np.zeros((1, num_neurons))

    def forward(self, inputs):
        self.output = np.dot(inputs, self.weights) + self.biases
        self.inputs = inputs # will use for backprop

    def backward(self, dvals):
        # gradients on parms
        self.dweights = np.dot(np.array(self.inputs).T, dvals)
        self.dbiases = np.sum(dvals, axis=0, keepdims=True)
        # gradients on values
        self.dinputs = np.dot(dvals, self.weights.T)

# generic loss class
class loss:
    def calculate(self, output, y):
        # uses loss's forward function
        sample_loss = self.forward(output, y)
        data_loss = np.mean(sample_loss)
        return data_loss

class loss_categorical_cross_entropy(loss):
    def forward(self, y_pred, y_true):
        samples = len(y_pred)
        
        # clip data to prevent div by 0 errors.
        y_pred_clip = np.clip(y_pred, 1e-7, 1 - 1e-7)

        # probabilities for target values if categorical labels
        if len(np.array(y_true).shape) == 1:
            correct_confidences = y_pred_clip[
                range(samples),
                y_true
            ]
        # mask values - only for one-hot encoded labels
        elif len(np.array(y_true).shape) == 2:
            correct_confidences = np.sum(
                y_pred_clip*y_true,
                axis=1
            )
        # losses
        negative_log_likelihoods = -np.log(correct_confidences)
        return negative_log_likelihoods
    
    def backward(self, dvals, y_true):
        samples = len(dvals) # num samples
        labels = len(dvals[0]) # num labels

        if len(y_true.shape) == 1:
            y_true = np.eye(labels)[y_true]
        
        # calculating gradient
        self.dinputs = -y_true / dvals

        # normalizing gradient
        self.dinputs = self.dinputs / samples



if __name__ == "__main__":
    pass