class Solution {
    public int findMaxK(int[] nums) {

        //BRUTEFORCE 
        /*
        Arrays.sort(nums);

        // Reverse the array manually
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == 0)
                    return nums[i];
            }
        }
        return -1;

    */

    //hashset

        Set <Integer> negation = new HashSet<>();
        for (int num: nums) {
            if (num <0)
                negation.add (num);
        }

        int ans=-1;
        for (int num: nums) {
            if (num >ans && negation.contains (-num))
                ans = num;
        }
        return ans;
    }
}
