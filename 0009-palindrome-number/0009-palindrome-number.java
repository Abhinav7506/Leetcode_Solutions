class Solution {
    public boolean isPalindrome(int x) {
        int rev=0;
        int flag=x;
        if(x<0) return false;
        while(x!=0){
            rev=(rev*10)+(x%10);
            x/=10;
        }
        if(flag==rev)
        return true;
        else return false;
    }
}