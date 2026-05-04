class Solution {
    public boolean isBinaryPalindrome(int n) {
        // code here
        String temp=Integer.toBinaryString(n);
        for( int i=0;i<temp.length();i++){
            if(temp.charAt(i)!=temp.charAt(temp.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}