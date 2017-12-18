package searchDemo;

import java.util.Arrays;

class BinarySearchDemo {
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo+hi)/2;
            if (nums[mid] > target || (left && target == nums[mid])) {  //这个left用来控制真假
                hi = mid;              //当left为true时，有nums[mid]>=target==>hi=mid==>mid更新，lo=mid+1==>不断循环，直到lo=hi
            }							
            else {						//当left为false时，若nums[mid]<=target，==>lo=mid+1
                lo = mid+1;
            }
        }
        
        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};							//存储元素的范围，最左边，最右边

        int leftIdx = extremeInsertionIndex(nums, target, true);   //第三个元素为true，挑选出目标元素最左边的位置

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;   //第三个元素为false，挑选出元素最右边的位置

        return targetRange;
    }
    
    public static void main(String[] args){
    	int[] tarketRange={-1,-1};
    	int[] nums={1,2,3,4,5,6,6,7,7,7,8,8,8,8,8,9,1,14,15};
    	BinarySearchDemo s=new BinarySearchDemo();
    	tarketRange=s.searchRange(nums,14);
    	System.out.println(Arrays.toString(tarketRange));
    }
    
}