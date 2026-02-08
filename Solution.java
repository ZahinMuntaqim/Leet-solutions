class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;

        for (char ch: word.toCharArray())
            if(Character.isUpperCase(ch))
                capitalCount++;

        if (capitalCount == word.length() || (capitalCount==1 && Character.isUpperCase(word.charAt(0))) || capitalCount==0)
            return true;
        return false;
    }
}