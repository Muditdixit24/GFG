class Solution {
    
    ArrayList<Integer> find(int arr[], int x) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int first = findFirst(arr, x);
        int last = findLast(arr, x);
        
        result.add(first);
        result.add(last);
        
        return result;
    }
    
    
    
    private int findFirst(int[] arr, int x) {
        
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;
        
        while (left <= right) {
            
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == x) {
                answer = mid;
                right = mid - 1;  
            }
            else if (arr[mid] < x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    
    
    private int findLast(int[] arr, int x) {
        
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;
        
        while (left <= right) {
            
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == x) {
                answer = mid;
                left = mid + 1;  
            }
            else if (arr[mid] < x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}