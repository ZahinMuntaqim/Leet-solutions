class Solution {
    public int[] nextLargerNodes(ListNode head) {
        // Step 1: Traverse the linked list and store values in an array
        ListNode current = head;
        List<Integer> values = new ArrayList<>();
        
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        
        // Step 2: Create a result array with the same length as the values list
        int[] result = new int[values.size()];
        
        // Step 3: Use a stack to find the next larger element for each node
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < values.size(); i++) {
            // While the stack is not empty and the current value is greater than the value at the top of the stack
            while (!stack.isEmpty() && values.get(i) > values.get(stack.peek())) {
                int index = stack.pop();
                result[index] = values.get(i); // Set the next larger value for the popped index
            }
            stack.push(i); // Push the current index onto the stack
        }
        
        return result;
    }
}
