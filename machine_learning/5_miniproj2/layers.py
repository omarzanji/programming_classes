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
        self.output = np.maximum(0, inputs)

class activation_softmax:
    def forward(self, inputs):
        exp_vals = np.exp(inputs - np.max(inputs, axis=1, keepdims=True))
        norm_vals = exp_vals / np.sum(exp_vals, axis=1, keepdims=True) # sum rows
        self.output = norm_vals

class layer_dense:

    def __init__(self, num_inputs, num_neurons):
        self.weights = 0.01 * randn(num_inputs, num_neurons)
        self.biases = np.zeros((1, num_neurons))

    def forward(self, inputs):
        self.output = np.dot(inputs, self.weights) + self.biases

# generic loss class
class Loss:
    def calculate(self, output, y):
        # uses loss's forward function
        sample_loss = self.forward(output, y)
        data_loss = np.mean(sample_loss)
        return data_loss

class loss_categorical_cross_entropy(Loss):
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


if __name__ == "__main__":
    pass