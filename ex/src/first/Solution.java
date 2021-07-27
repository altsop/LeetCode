package first;

class Solution {

    private int nums[];
    private int middleIndex = 0;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;

        TreeNode root = calculateRoot();
        fillTree(root, 0, middleIndex, nums.length);
        return root;
    }

    private void fillTree(TreeNode root, int startIndex, int currentIndex, int endIndex) {
        int leftIndex = getMiddle(startIndex, currentIndex);
        if (leftIndex < currentIndex) {
            root.left = new TreeNode(nums[leftIndex]);
            fillTree(root.left, startIndex, leftIndex, currentIndex);
        }

        int rightIndex = getMiddle(currentIndex, endIndex);
        if (rightIndex > currentIndex) {
            root.right = new TreeNode(nums[rightIndex]);
            fillTree(root.right, currentIndex + 1, rightIndex, endIndex);
        }
    }

    private TreeNode calculateRoot() {
        middleIndex = nums.length / 2;
        int middleValue = nums[middleIndex];
        return new TreeNode(middleValue);
    }

    private int getMiddle(int start, int end) {
        return (start + end) / 2;
    }

}