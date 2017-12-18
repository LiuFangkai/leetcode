package search;
/*
 * 
 * ����������������
 * */
public class LinearSearch {
	private static int m=100000;
	public void searchRange(int[] nums,int target){
		int[] targetRange=new int[m];
		for(int i=0;i<targetRange.length;i++)
			targetRange[i]=-1;                 //targetRange�����洢target����ʼȫ����ʼ��Ϊ-1����Ϊtarget����λ��nums�±�Ϊ0��λ��
		for(int i=0;i<nums.length;i++){
			if(target==nums[i]){
				targetRange[i]=i;            //��nums��target���±����targetRange��
			}
		}
		int flag=0;
		for(int i=0;i<targetRange.length;i++){   //��ӡtargetRange�в�Ϊ0��Ԫ�أ���nums�е��±�
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
		System.out.print("����ʱ��Ϊ:");
		System.out.println(endtime-startime);
	}
}
