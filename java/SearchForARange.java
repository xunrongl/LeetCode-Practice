import java.util.Arrays;

public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        int[] array = {-1, -1};
        if(nums == null || nums.length == 0) {
            return array;
        }
        
        int start = 0, end = nums.length - 1;
    
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                //set the end to mid to find the first element
                end = mid;
            } else if(nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        //check the start position first
        if(nums[start] == target) {
            array[0] = start;
        } else if(nums[end] == target) {
            array[0] = end;
        } else {
            array[0] = array[1] = -1;
            return array;
        }
        
        start = 0;
        end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                //set the start to mid to find the last element
                start = mid;
            } else if(nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        //check the end position first
        if(nums[end] == target) {
            array[1] = end;
        }else if(nums[start] == target) {
            array[1] = start;
        } else {
            array[1] = array[0] = -1;
            return array;
        }

        return array;
            
    }

    public static void main(String[] args) {
        int[] a = {2, 2};
        System.out.println(Arrays.toString(searchRange(a, 2)));
    }   
}