# Clumsy Factorial Solution

This repository contains a solution to the problem of calculating the **clumsy factorial** of a number `n`. The clumsy factorial follows a sequence of operations on the number `n` and its decreasing values from `n-1` to 1. The operations are performed in a specific cycle: multiplication, division, push, and negation.

## Problem Statement

Given an integer `n`, perform the following operations starting from `n` and going down to 1, in a cyclic pattern:
1. **Multiply** the current number with the next.
2. **Divide** the current number by the next.
3. **Push** the current number onto a stack.
4. **Negate** the current number and push it onto the stack.

After completing these operations, sum all the numbers in the stack to compute the final result.

## Solution

The solution is implemented in Java using a stack data structure to store intermediate results while performing operations. The steps are as follows:

1. Initialize the stack with the input number `n`.
2. Perform operations in a cyclic manner:
   - **Multiplication** when `index % 4 == 0`
   - **Division** when `index % 4 == 1`
   - **Push** when `index % 4 == 2`
   - **Negation** when `index % 4 == 3`
3. After all operations, sum the values in the stack to obtain the result.

### Code Implementation

```java
import java.util.Stack;

public class Solution {
    public int clumsy(int n) {
        // Initialize stack to store intermediate results
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        n--;
        int index = 0;

        // Perform operations while n is not zero
        while (n != 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * n);  // Multiply top of stack with n
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / n);  // Divide top of stack by n
            } else if (index % 4 == 2) {
                stack.push(n);               // Push n itself onto stack
            } else {
                stack.push(-n);              // Negate n and push onto stack
            }
            n--;        // Decrement n
            index++;    // Increment index to cycle through operations
        }

        // Sum all elements in the stack to compute the final result
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();  // Pop each element and add to result
        }
        return ans;  // Return the final answer
    }
}
