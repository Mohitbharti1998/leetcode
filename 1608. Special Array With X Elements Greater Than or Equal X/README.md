# [1608. Special Array With X Elements Greater Than or Equal X](https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x)

## Description

<!-- description:start -->

<p>You are given an array <code>nums</code> of non-negative integers. <code>nums</code> is considered <strong>special</strong> if there exists a number <code>x</code> such that there are <strong>exactly</strong> <code>x</code> numbers in <code>nums</code> that are <strong>greater than or equal to</strong> <code>x</code>.</p>

<p>Notice that <code>x</code> <strong>does not</strong> have to be an element in <code>nums</code>.</p>

<p>Return <code>x</code> <em>if the array is <strong>special</strong>, otherwise, return </em><code>-1</code>. It can be proven that if <code>nums</code> is special, the value for <code>x</code> is <strong>unique</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,5]
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are 2 values (3 and 5) that are greater than or equal to 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0]
<strong>Output:</strong> -1
<strong>Explanation:</strong> No numbers fit the criteria for x.
If x = 0, there should be 0 numbers &gt;= x, but there are 2.
If x = 1, there should be 1 number &gt;= x, but there are 0.
If x = 2, there should be 2 numbers &gt;= x, but there are 0.
x cannot be greater since there are only 2 numbers in nums.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,4,3,0,4]
<strong>Output:</strong> 3
<strong>Explanation:</strong> There are 3 values that are greater than or equal to 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
</ul>

<!-- description:end -->

## Solutions

<!-- solution:start -->

### Solution 1: Brute Force Enumeration

We enumerate $x$ in the range of $[1..n]$, and then count the number of elements in the array that are greater than or equal to $x$, denoted as $cnt$. If there exists $cnt$ equal to $x$, return $x$ directly.

The time complexity is $O(n^2)$, where $n$ is the length of the array. The space complexity is $O(1)$.

<!-- tabs:start -->


#### Java

```java
class Solution {
    public int specialArray(int[] nums) {

        int res = -1;

        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            if(checkSpecialElement(nums, i))
                return i;
        }

        return res;
    }

    public boolean checkSpecialElement(int[] nums, int ele){

        int temp = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] >= ele){
                temp++;
            }

        }
        if(temp == ele)
            return true;

        return false;
    }
}
```

<!-- tabs:end -->

<!-- solution:end -->

<!-- solution:start -->

### Solution 2: Sorting + Binary Search

We can also sort `nums` first.

Next, we still enumerate $x$, and use binary search to find the first element in `nums` that is greater than or equal to $x$, quickly counting the number of elements in `nums` that are greater than or equal to $x$.

The time complexity is $O(n \times \log n)$, and the space complexity is $O(\log n)$. Where $n$ is the length of the array.

<!-- tabs:start -->

#### Java

```java
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int x = 1; x <= n; ++x) {
            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (nums[mid] >= x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int cnt = n - left;
            if (cnt == x) {
                return x;
            }
        }
        return -1;
    }
}
```


<!-- tabs:end -->

<!-- solution:end -->


<!-- solution:start -->

### Solution 3: Counting Sort

<!-- tabs:start -->

#### Java

```java
class Solution {
    public int specialArray(int[] nums) {

        int n = nums.length;

        // counting sort
        int[] count = new int[1001];

        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }

        for (int i = 1000 - 1; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        for (int i = 0; i <= 1000; i++) {
            if (count[i] == i)
                return i;
        }

        return -1;
    }
}
```


<!-- tabs:end -->

<!-- solution:end -->

<!-- problem:end -->
