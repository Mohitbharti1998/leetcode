# [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning)

## Description

<!-- description:start -->

<p>Given a string <code>s</code>, partition <code>s</code> such that every <span data-keyword="substring-nonempty">substring</span> of the partition is a <span data-keyword="palindrome-string"><strong>palindrome</strong></span>. Return <em>all possible palindrome partitioning of </em><code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "aab"
<strong>Output:</strong> [["a","a","b"],["aa","b"]]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "a"
<strong>Output:</strong> [["a"]]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 16</code></li>
	<li><code>s</code> contains only lowercase English letters.</li>
</ul>

<!-- description:end -->

## Solutions

<!-- solution:start -->

### Solution 1

<!-- tabs:start -->

Approach
========

Backtracking.

Complexity
==========

-   Time complexity: O(2^n.n)

-   Space complexity: O(2^n.n)

Explanation
===========

1.  partition Method:

-   This initializes the result list and starts the backtracking process from index 0 with an empty path.

2.  backtrack Method:

-   It explores all possible partitions of the string s starting from a given index.
-   If the current start index equals the length of the string, it means we have a valid partition and we add it to the result list.
-   It iterates through possible end indices, forms substrings, and checks if they are palindromes.
-   If a substring is a palindrome, it's added to the current path, and we recursively call backtrack for the next part of the string.
-   After the recursive call, the last substring is removed to explore other partitions.

3.  isPalindrome Method:

-   It checks if a given substring is a palindrome by comparing characters from both ends towards the middle.

#### Java

```java


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String currentSub = s.substring(start, end);
            if (isPalindrome(currentSub)) {
                path.add(currentSub);
                backtrack(s, end, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String sub) {
        int left = 0, right = sub.length() - 1;
        while (left < right) {
            if (sub.charAt(left) != sub.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```

<!-- tabs:end -->

<!-- solution:end -->

<!-- problem:end -->
