class Solution {
    
    static long inversionCount(int arr[]) {
        
        int n = arr.length;
        int temp[] = new int[n];
        
        return mergeSort(arr, temp, 0, n - 1);
    }
    
    
    static long mergeSort(int arr[], int temp[], int left, int right) {
        
        long count = 0;
        
        if (left < right) {
            
            int mid = (left + right) / 2;
            
            
            count += mergeSort(arr, temp, left, mid);
            
            
            count += mergeSort(arr, temp, mid + 1, right);
            
            
            count += merge(arr, temp, left, mid, right);
        }
        
        return count;
    }
    
    
    static long merge(int arr[], int temp[], int left, int mid, int right) {
        
        int i = left;
        int j = mid + 1;
        int k = left;
        
        long count = 0;
        
        while (i <= mid && j <= right) {
            
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            }
            else {
                
                temp[k] = arr[j];
                
               
                count += (mid - i + 1);
                
                j++;
            }
            
            k++;
        }
        
        
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        
        
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        
        
        for (int x = left; x <= right; x++) {
            arr[x] = temp[x];
        }
        
        return count;
    }
}
