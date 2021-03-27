# Coding Question

Write an interface for a data structure that can provide the moving average of the last N elements added, add elements to the structure and get access to the elements. Provide an efficient implementation of the interface for the data structure.

## MovingAverageImpl.java

We could simply keep track of all the incoming values with the data structure of Array or List. Then from the data structure, later we retrieve the necessary elements to calculate the average.

First, we initialize a variable list to store the values for the data, and the variable for the size of the moving window.

At each invocation of getMovingAverage, we retrieve the last n values from the list and calculate the average.

### Complexity:

Time Complexity: O(N) where N is the size of the moving window, since we need to retrieve N elements from the list for each getMovingAverage call. <br/>
Space Complexity: O(M), where M is the length of the list which would grow when we add an element.

## MovingAverageQueueImpl.java

We could do better than the first approach in both time and space complexity.

First of all, one might notice that we do not need to keep all values from the list, but rather the last n values which falls into the moving window.

By definition of the moving window, at each step, we add a new element to the window, and at the same time we remove the oldest element from the window. 
Here, we could apply a data structure called double-ended queue (deque) to implement the moving window, which would have the constant time complexity O(1) to add or remove an element from both its ends. 
With the deque, we could reduce the space complexity down to O(N) where N is the size of the moving window.

We could keep the sum of the previous moving window, then in order to obtain the sum of the new moving window, we simply add the new element and deduce the oldest element. 
With this measure, we then can reduce the time complexity to constant.

We can replace list with the deque and add a new variable windowSum in order to calculate the sum of moving window in constant time.

### Complexity

Time Complexity: O(1), as we explained above. <br/>
Space Complexity: O(N), where N is the size of the moving window.
