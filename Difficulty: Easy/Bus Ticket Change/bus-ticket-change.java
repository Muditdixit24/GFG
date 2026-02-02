class Solution {
    public boolean canServe(int[] arr) {
        // code here
        int five =0;
        int ten=0;
        
        for(int i=0;i<arr.length;i++){
            int result= arr[i];
            if(result==5){
                five++;
            }
            else if(result==10){
                if(five==0){
                    return false;
                }
                five--;
                ten++;
            }
            else{
                if(ten>0&& five>0){
                    five--;
                    ten--;
                }
                else if(five>=3){
                    five-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}