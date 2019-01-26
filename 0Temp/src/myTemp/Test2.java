package myTemp;

public class Test2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] arr= {1,2,3,4,5};
		System.out.println(find(arr,1));
	}

	public static boolean find(int[] arr,int k) {
		return help(arr,0,arr.length-1,k);
	}
	public static boolean help(int[] arr,int start,int end,int k) {
		if(start>end)return false;
		int mid=(start+end)/2;
		if(arr[mid]==k)
			return true;
		if(arr[mid]<k) {
			return help(arr,mid+1,end,k);
		}
		if(arr[mid]>k) {
			return help(arr,start,mid-1,k);
		}
		return false;
	}
}
