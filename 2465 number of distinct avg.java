class Solution {
    public int distinctAverages(int[] nums) {
        if (nums.length <=2)
            return 1;

        Arrays.sort (nums);
        HashSet<Integer> set = new HashSet <>();
        int left=0, right = nums.length-1;
        while (left < right) {
            int avg = ( nums[left] + nums[right] );
            set.add (avg);
            left++;
            right--;
        }
        return set.size();
    }
}
