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
            if (nums[mid] > target || (left && target == nums[mid])) {  //���left�����������
                hi = mid;              //��leftΪtrueʱ����nums[mid]>=target==>hi=mid==>mid���£�lo=mid+1==>����ѭ����ֱ��lo=hi
            }							
            else {						//��leftΪfalseʱ����nums[mid]<=target��==>lo=mid+1
                lo = mid+1;
            }
        }
        
        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};							//�洢Ԫ�صķ�Χ������ߣ����ұ�

        int leftIdx = extremeInsertionIndex(nums, target, true);   //������Ԫ��Ϊtrue����ѡ��Ŀ��Ԫ������ߵ�λ��

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;   //������Ԫ��Ϊfalse����ѡ��Ԫ�����ұߵ�λ��

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