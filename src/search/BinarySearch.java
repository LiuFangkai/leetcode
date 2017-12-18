package search;

import java.util.Arrays;
/*
 * 针对的是有序数列
 * */
public class BinarySearch {
	public int binarySearch(int[] nums,int target,boolean flag){
		int len=nums.length;
		int left=0;
		int right=len;
		while(left<right){
			int mid=(left+right)/2;
			if(nums[mid]>target||(nums[mid]==target&&flag)){
				right=mid;	
			}
			else{
				left=mid+1;
			}
		}
		return left;
	}
	public int[] searchRange(int[] nums,int target){
		int[] targetRange={-1,-1};
		int leftIndex=binarySearch(nums,target,true);
		if(leftIndex==nums.length||nums[leftIndex]!=target){
			return targetRange;
		}
		int rightIndex=binarySearch(nums,target,false);
		targetRange[0]=leftIndex;
		targetRange[1]=rightIndex;
		return targetRange;
	}
	
	public static void main(String []args){
		int[] nums={1,2,3,4,5,6,6,7,7,7,8,8,8,8,8,9,1,14,15};
		BinarySearch b=new BinarySearch();
		int[] tarketRange={-1,-1};
		tarketRange=b.searchRange(nums, 7);
		System.out.println("所要查找元素的范围为:"+Arrays.toString(tarketRange));
	}
}
