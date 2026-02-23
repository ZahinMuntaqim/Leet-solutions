/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int sum = 0;
        
        // Start after first 0 (guaranteed by problem)
        ListNode cur = head.next;
        
        while (cur != null) {
            if (cur.val != 0) {
                sum += cur.val;  // Accumulate non-zero
            } else {
                // Hit 0: create merged node if sum > 0
                if (sum > 0) {
                    tail.next = new ListNode(sum);
                    tail = tail.next;
                }
                sum = 0;
            }
            cur = cur.next;
        }
        
        return dummy.next;  // Skip dummy [web:1][page:0]
    }
}









<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# simulate the code with examples step by step.

The code traverses the input list once, summing non-zero values between zeros and building a new result list. Here's a step-by-step simulation with the example `0→3→1→0→4→5→2→0`.

## Initial Setup

```
Input:  0(HEAD) → 3 → 1 → 0 → 4 → 5 → 2 → 0(NULL)
Result: dummy → NULL
cur = 3 (head.next, skip first 0)
tail = dummy  
sum = 0
```


## Step-by-Step Execution

### Iteration 1: cur = 3

```
cur.val = 3 ≠ 0 → sum += 3 → sum = 3
cur = 1
```

```
Result: dummy → NULL
```


### Iteration 2: cur = 1

```
cur.val = 1 ≠ 0 → sum += 1 → sum = 4
cur = 0
```


### Iteration 3: cur = 0 (first delimiter!)

```
cur.val = 0 → Create node(4), attach, move tail, reset sum
tail.next = new ListNode(4)
tail = new node(4)
sum = 0
cur = 4
```

```
Result: dummy → 4 → NULL
```


### Iteration 4: cur = 4

```
cur.val = 4 ≠ 0 → sum += 4 → sum = 4  
cur = 5
```


### Iteration 5: cur = 5

```
cur.val = 5 ≠ 0 → sum += 5 → sum = 9
cur = 2
```


### Iteration 6: cur = 2

```
cur.val = 2 ≠ 0 → sum += 2 → sum = 11
cur = 0 (final)
```


### Iteration 7: cur = 0 (final delimiter!)

```
cur.val = 0 → Create node(11), attach, move tail, reset sum
tail.next = new ListNode(11)  
tail = new node(11)
sum = 0
cur = NULL → EXIT LOOP
```

```
Result: dummy → 4 → 11 → NULL
```


## Final Return

```
return dummy.next → 4 → 11 → NULL ✓
```


## Second Example: `0→2→3→0→5→0`

```
Step 1-3: sum=2+3=5 → create node(5)
Step 4-5: sum=5 → create node(5)  
Output: 5 → 5 ✓ [web:1]
```

**Key insight**: Each zero triggers creating one merged node with the accumulated sum between zeros. The dummy node simplifies returning the final head.
<span style="display:none">[^1][^10][^2][^3][^4][^5][^6][^7][^8][^9]</span>

<div align="center">⁂</div>

[^1]: https://algo.monster/liteproblems/2181

[^2]: https://www.jjweb3.com/post/2181-merge-nodes-in-between-zeros

[^3]: https://github.com/doocs/leetcode/blob/main/solution/2100-2199/2181.Merge Nodes in Between Zeros/README_EN.md

[^4]: https://www.youtube.com/watch?v=094E4Loa9HU

[^5]: https://leetcode.com/problems/merge-nodes-in-between-zeros/

[^6]: https://www.youtube.com/watch?v=F2H50ignMk4

[^7]: https://www.youtube.com/watch?v=sfXn_ukEQ24

[^8]: https://www.youtube.com/watch?v=N7JgJuN1P8Y

[^9]: https://www.youtube.com/watch?v=jrSav7fulJY

[^10]: https://www.youtube.com/watch?v=XIdigk956u0



<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# whats the role of tail here

**`tail` tracks the last node in the result list** for O(1) appends.

## Without Tail (Slow)

```java
// WRONG - O(n) per insertion!
while (dummy.next != null) {
    dummy = dummy.next;  // Traverse entire list every time
}
dummy.next = new ListNode(sum);  // Only now can append
```


## With Tail (Fast)

```java
tail.next = new ListNode(sum);  // Direct append - O(1)!
tail = tail.next;              // Just move pointer forward
```


## Visual Role in Our Code

```
Initial:    dummy → NULL
           ↑
        tail points here

After 1st 0: dummy → [^4] → NULL  
                 ↑
              tail moves here

After 2nd 0: dummy → [^4] → [^11] → NULL
                      ↑
                   tail moves here ✓
```


## Why Both dummy AND tail?

```
dummy = fixed entry point (never moves)
tail  = growing end pointer (moves forward)

return dummy.next  // Skip dummy, get real head: [^4]→[^11]
```

**Key**: `tail` eliminates traversal cost when building result list. Each new merged sum gets attached directly to current end in constant time.[^1]
<span style="display:none">[^10][^2][^3][^5][^6][^7][^8][^9]</span>

<div align="center">⁂</div>

[^1]: https://youcademy.org/find-tail-node-in-linked-list/

[^2]: https://www.youtube.com/watch?v=Apf4F3betuw

[^3]: https://www.interviewbit.com/blog/types-of-linked-list/

[^4]: https://people.hsc.edu/faculty-staff/robbk/Coms262/Lectures/Spring 2018/Lecture 18 - Linked Lists with Tail.pdf

[^5]: https://sbme-tutorials.github.io/2020/data-structure-FALL/notes/week03b.html

[^6]: https://stackoverflow.com/questions/71531097/removing-the-tail-of-a-linked-list-with-a-tail-pointer

[^7]: https://www.youtube.com/watch?v=9XBKlYHDsOY

[^8]: https://www.reddit.com/r/learnprogramming/comments/5n50tg/when_using_a_linked_list_why_dont_we_use_head_and/

[^9]: https://stackoverflow.com/questions/28733145/make-a-linked-list-with-head-and-tail-nodes

[^10]: https://fiveable.me/key-terms/data-structures/tail




