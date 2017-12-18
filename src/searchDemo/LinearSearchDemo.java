package searchDemo;

import java.util.Arrays;
/*
 * 针对的是有序数列
 * */
public class LinearSearchDemo {
	public int[] linearSearch(int[] nums,int target){
		int[] targetRange={-1,-1};
		for(int i=0;i<nums.length;i++){
			if(nums[i]==target){
				targetRange[0]=i;
				break;
			}
		}
		if(targetRange[0]==-1){
			return targetRange;
		}
		for(int j=nums.length-1;j>=0;j--){
			if(nums[j]==target){
				targetRange[1]=j;
				break;
			}
		}
		
		return targetRange;
	}
	
	public static void main(String[] args){
		LinearSearchDemo l=new LinearSearchDemo();
		int[] targetRange={-1,-1};
		int[] nums={1,2,3,4,5,6,6,7,7,7,8,8,8,8,8,9,1,14,15};
		targetRange=l.linearSearch(nums, 8);
		System.out.println("经过查找查找发现的元素范围为:"+Arrays.toString(targetRange));
	}
}
