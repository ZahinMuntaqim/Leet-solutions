class Solution {
    public int[] applyOperations(int[] nums) {
        int left=0;
        for (int right=1; right<nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                continue;
            }
            else {
                nums[left] = nums[left] *2;;
                nums[right] =0;
                left++;
            }
        }

        int nonZeroIndex=0;
        // Traverse the array, move non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }

        // Fill the remaining positions with zeroes
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex++] = 0;
        }
        return nums;
    }
}
