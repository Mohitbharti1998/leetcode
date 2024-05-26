# [139. Word Break](https://leetcode.com/problems/word-break)

## Description

<!-- description:start -->

<p>Given a string <code>s</code> and a dictionary of strings <code>wordDict</code>, return <code>true</code> if <code>s</code> can be segmented into a space-separated sequence of one or more dictionary words.</p>

<p><strong>Note</strong> that the same word in the dictionary may be reused multiple times in the segmentation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;leetcode&quot;, wordDict = [&quot;leet&quot;,&quot;code&quot;]
<strong>Output:</strong> true
<strong>Explanation:</strong> Return true because &quot;leetcode&quot; can be segmented as &quot;leet code&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;applepenapple&quot;, wordDict = [&quot;apple&quot;,&quot;pen&quot;]
<strong>Output:</strong> true
<strong>Explanation:</strong> Return true because &quot;applepenapple&quot; can be segmented as &quot;apple pen apple&quot;.
Note that you are allowed to reuse a dictionary word.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;catsandog&quot;, wordDict = [&quot;cats&quot;,&quot;dog&quot;,&quot;sand&quot;,&quot;and&quot;,&quot;cat&quot;]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 300</code></li>
	<li><code>1 &lt;= wordDict.length &lt;= 1000</code></li>
	<li><code>1 &lt;= wordDict[i].length &lt;= 20</code></li>
	<li><code>s</code> and <code>wordDict[i]</code> consist of only lowercase English letters.</li>
	<li>All the strings of <code>wordDict</code> are <strong>unique</strong>.</li>
</ul>

<!-- description:end -->

## Solutions

<!-- solution:start -->

### Solution 1

<!-- tabs:start -->


#### Java

```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (f[j] && words.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
```


<!-- tabs:end -->

### Solution 2

<!-- tabs:start -->


#### Java

```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return tabulorDP(s, wordDict);
    }

    // Approach-2: Tabulation DP
    public boolean tabulorDP(String s, List<String> wordDict) {
        int n = s.length();

        boolean[][] dp = new boolean[n + 1][n + 1];

        for (int len = 1; len <= n; len++) {

            // sliding windo
            int start = 1;
            int end = len;
            while (end <= n) {
                String subStr = s.substring(start - 1, end);
                if (wordDict.contains(subStr))
                    dp[start][end] = true;
                else {
                    boolean flag = false;
                    for (int i = start; i < end; i++) {
                        if (dp[start][i] && dp[i + 1][end]) {
                            flag = true;
                            break;
                        }
                    }
                    dp[start][end] = flag;
                }
                start++;
                end++;
            }
        }

        return dp[1][n];

    }

    // Solution - 1 : Backtracking and Memorization
    // n2.n time complexity
    public boolean helper(String s, int partitionIndex, List<String> wordDict, Set<Integer> mem) {

        if (partitionIndex == s.length()) {
            return true;
        }

        // Memorization
        if (mem.contains(partitionIndex))
            return true;

        for (int i = partitionIndex; i < s.length(); i++) {

            // left is valid then check for right part of string
            if (wordDict.contains(s.substring(partitionIndex, i + 1))) {
                // checking right part of string is valid or not
                // if valid then return true it means complete valid string
                // explore -- backtracking
                if (helper(s, i + 1, wordDict, mem)) {
                    mem.add(partitionIndex);
                    return true;
                }

            }
        }
        return false;
    }
}
```


<!-- tabs:end -->

<!-- solution:end -->

<!-- problem:end -->
