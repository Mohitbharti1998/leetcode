class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        findSubSets(nums, 0, new ArrayList<>());
        return ans;
    }

    public void findSubSets(int[] nums, int index, List<Integer> subList) {

        // base case
        if (index == nums.length) {
            ans.add(new ArrayList<>(subList));
            return;
        }

        // pick
        subList.add(nums[index]);
        findSubSets(nums, index + 1, subList);

        // while backtracking, we need to remove the last added element
        subList.remove(subList.size() - 1);

        // no pick
        findSubSets(nums, index + 1, subList);

        // since we have not added any element so, no need
        // to remove anything while backtracking

    }
}
