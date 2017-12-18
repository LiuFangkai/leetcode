package search;
/*
 * 
 * 可以适用无序数列
 * */
public class LinearSearch {
	private static int m=100000;
	public void searchRange(int[] nums,int target){
		int[] targetRange=new int[m];
		for(int i=0;i<targetRange.length;i++)
			targetRange[i]=-1;                 //targetRange用来存储target，开始全部初始化为-1，因为target可能位于nums下标为0的位置
		for(int i=0;i<nums.length;i++){
			if(target==nums[i]){
				targetRange[i]=i;            //把nums中target的下标存在targetRange中
			}
		}
		int flag=0;
		for(int i=0;i<targetRange.length;i++){   //打印targetRange中不为0的元素，即nums中的下标
			if(targetRange[i]!=-1){
				System.out.print(targetRange[i]+"\t");
				flag++;
				if(flag%8==0&&flag!=0){
					System.out.println();
				}
				
			}	
		}
	}
	
	public static void main(String []args){
		long startime=System.currentTimeMillis();
		LinearSearch s=new LinearSearch();
		int[] nums=new int[m];
		for(int i=0;i<nums.length;i++)
			nums[i]=(int)(Math.random()*100);
		s.searchRange(nums,20);
		System.out.println();
		long endtime=System.currentTimeMillis();
		System.out.print("所用时间为:");
		System.out.println(endtime-startime);
	}
}
