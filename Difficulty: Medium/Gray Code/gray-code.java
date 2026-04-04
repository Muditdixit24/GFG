class Solution {
    public ArrayList<String> graycode(int n) {
        ArrayList<String> res = new ArrayList<>();
        
        int total = 1 << n; // 2^n
        
        for (int i = 0; i < total; i++) {
            int gray = i ^ (i >> 1);
            
            String bin = Integer.toBinaryString(gray);
            
            // pad with leading zeros
            while (bin.length() < n) {
                bin = "0" + bin;
            }
            
            res.add(bin);
        }
        
        return res;
    }
}