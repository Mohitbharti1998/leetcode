<!-- problem:start -->

# [208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree)

## Description

<!-- description:start -->

<p>A <a href="https://en.wikipedia.org/wiki/Trie" target="_blank"><strong>trie</strong></a> (pronounced as &quot;try&quot;) or <strong>prefix tree</strong> is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.</p>

<p>Implement the Trie class:</p>

<ul>
	<li><code>Trie()</code> Initializes the trie object.</li>
	<li><code>void insert(String word)</code> Inserts the string <code>word</code> into the trie.</li>
	<li><code>boolean search(String word)</code> Returns <code>true</code> if the string <code>word</code> is in the trie (i.e., was inserted before), and <code>false</code> otherwise.</li>
	<li><code>boolean startsWith(String prefix)</code> Returns <code>true</code> if there is a previously inserted string <code>word</code> that has the prefix <code>prefix</code>, and <code>false</code> otherwise.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;Trie&quot;, &quot;insert&quot;, &quot;search&quot;, &quot;search&quot;, &quot;startsWith&quot;, &quot;insert&quot;, &quot;search&quot;]
[[], [&quot;apple&quot;], [&quot;apple&quot;], [&quot;app&quot;], [&quot;app&quot;], [&quot;app&quot;], [&quot;app&quot;]]
<strong>Output</strong>
[null, null, true, false, true, null, true]

<strong>Explanation</strong>
Trie trie = new Trie();
trie.insert(&quot;apple&quot;);
trie.search(&quot;apple&quot;);   // return True
trie.search(&quot;app&quot;);     // return False
trie.startsWith(&quot;app&quot;); // return True
trie.insert(&quot;app&quot;);
trie.search(&quot;app&quot;);     // return True
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word.length, prefix.length &lt;= 2000</code></li>
	<li><code>word</code> and <code>prefix</code> consist only of lowercase English letters.</li>
	<li>At most <code>3 * 10<sup>4</sup></code> calls <strong>in total</strong> will be made to <code>insert</code>, <code>search</code>, and <code>startsWith</code>.</li>
</ul>

<!-- description:end -->

## Solutions

<!-- solution:start -->

### Solution 1

<!-- tabs:start -->

#### Java

```java
class Node {

    Node link[] = new Node[26];
    boolean endFlag = false;

    public Node() {

    }

    boolean containsKey(char ch) {
        return link[ch - 'a'] != null;
    }

    Node get(char ch) {
        return link[ch - 'a'];
    }

    void put(char ch, Node node) {
        link[ch - 'a'] = node;
    }

    void setEnd() {
        endFlag = true;
    }

    boolean isEnd() {
        return endFlag;
    }

}

class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        int n = word.length();
        Node temp = root;
        for (int i = 0; i < n; i++) {
            if (!temp.containsKey(word.charAt(i))){
                temp.put(word.charAt(i), new Node());
            }
            temp = temp.get(word.charAt(i));
        }

        temp.setEnd();
    }

    public boolean search(String word) {
        int n = word.length();
        Node temp = root;
        for (int i = 0; i < n; i++) {
            if (!temp.containsKey(word.charAt(i))){
                return false;
            }
            temp = temp.get(word.charAt(i));
        }
        return temp.isEnd();
    }

    public boolean startsWith(String prefix) {
        int n = prefix.length();
        Node temp = root;
        for (int i = 0; i < n; i++) {
            if (!temp.containsKey(prefix.charAt(i))){
                return false;
            }
            temp = temp.get(prefix.charAt(i));
        }
        return true;
    }
}

```


<!-- tabs:end -->

<!-- solution:end -->

<!-- problem:end -->
