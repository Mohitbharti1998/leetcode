<!-- problem:start -->

# [140. Word Break II](https://leetcode.com/problems/word-break-ii)

## Description

<!-- description:start -->

<p>Given a string <code>s</code> and a dictionary of strings <code>wordDict</code>, add spaces in <code>s</code> to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in <strong>any order</strong>.</p>

<p><strong>Note</strong> that the same word in the dictionary may be reused multiple times in the segmentation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;catsanddog&quot;, wordDict = [&quot;cat&quot;,&quot;cats&quot;,&quot;and&quot;,&quot;sand&quot;,&quot;dog&quot;]
<strong>Output:</strong> [&quot;cats and dog&quot;,&quot;cat sand dog&quot;]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;pineapplepenapple&quot;, wordDict = [&quot;apple&quot;,&quot;pen&quot;,&quot;applepen&quot;,&quot;pine&quot;,&quot;pineapple&quot;]
<strong>Output:</strong> [&quot;pine apple pen apple&quot;,&quot;pineapple pen apple&quot;,&quot;pine applepen apple&quot;]
<strong>Explanation:</strong> Note that you are allowed to reuse a dictionary word.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;catsandog&quot;, wordDict = [&quot;cats&quot;,&quot;dog&quot;,&quot;sand&quot;,&quot;and&quot;,&quot;cat&quot;]
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 20</code></li>
	<li><code>1 &lt;= wordDict.length &lt;= 1000</code></li>
	<li><code>1 &lt;= wordDict[i].length &lt;= 10</code></li>
	<li><code>s</code> and <code>wordDict[i]</code> consist of only lowercase English letters.</li>
	<li>All the strings of <code>wordDict</code> are <strong>unique</strong>.</li>
	<li>Input is generated in a way that the length of the answer doesn&#39;t exceed&nbsp;10<sup>5</sup>.</li>
</ul>

<!-- description:end -->

## Solutions

<!-- solution:start -->

### Solution 1

<!-- tabs:start -->


#### Java

```java
//Instead of list.contains we can also use Trie implementation of word searching
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            String substr = s.substring(0, i + 1);
            if (wordDict.contains(substr)) {
                helper(s, substr, i + 1, wordDict, ans);
            }
        }

        return ans;
    }

    public void helper(String s, String substr, int pos, List<String> wordDict, List<String> ans) {

        if (pos == s.length()) {
            ans.add(substr);
            return;
        }

        substr += " ";

        for (int i = pos; i < s.length(); i++) {
            String substr2 = s.substring(pos, i + 1);
            if (wordDict.contains(substr2)) {
                helper(s, substr + substr2, i + 1, wordDict, ans);
            }
        }

    }
}
```




<!-- tabs:end -->

<!-- solution:end -->

<!-- problem:end -->
