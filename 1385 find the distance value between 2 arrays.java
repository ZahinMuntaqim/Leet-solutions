class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int flag=0, counter=0;
        for (int i=0; i<arr1.length; i++) {
            for (int j=0;j<arr2.length; j++) {
                if (Math.abs (arr1[i] - arr2[j]) >d)
                    flag=1;
                else {
                    flag=0;
                    break;
                }
            }
            if (flag ==1)
                counter++;
        }
        return counter;
    }
}
