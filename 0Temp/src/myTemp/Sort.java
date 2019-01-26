package myTemp;

public class Sort {

	static int[] myarr= {3,8,1,12,7,6,9,2,17,3}; 
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		//HeapSort(myarr);
		//show(myarr,"������");
		//MergeSort(myarr,0,myarr.length-1);
		//show(myarr,"�鲢����");
		QuickSort(myarr,0,myarr.length-1);
		show(myarr,"��������");
	}
	
	public static void QuickSort(int[] array,int low,int high) {
		if(low>=high)return;
		int key=array[low];
		int start=low;
		int end=high;
		while(start<end) {
			while(start<end&&array[end]>=key) {
				end--;
			}
			array[start]=array[end];
			while(start<end&&array[start]<=key) {//�ӵȺŽ���ظ�Ԫ������
				start++;
			}
			array[end]=array[start];
		}
		array[start]=key;
		QuickSort(array,low,start-1);
		QuickSort(array,start+1,high);
	}
	
	public static void MergeSort(int[] array,int low,int high) {//�鲢����
		int mid=(low+high)/2;
		if(high>low) {
			MergeSort(array,low,mid);
			MergeSort(array,mid+1,high);
			Merge(array,low,mid,high);
		}
	}
		
	public static void Merge(int[] array,int low,int mid,int high) {//�ϲ�����
		int[] temp=new int[high-low+1];
		int i=low;
		int j=mid+1;
		int k=0;
		while(i<=mid&&j<=high) {
			if(array[i]<array[j]) {
				temp[k]=array[i];
				i++;
			}else {
				temp[k]=array[j];
				j++;
			}
			k++;
		}//δ�ϲ������ӵ�������
		while(i<=mid) {
			temp[k]=array[i];
			i++;
			k++;
		}
		while(j<=high) {
			temp[k]=array[j];
			j++;
			k++;
		}
		for(int t=0;t<temp.length;t++) {
			array[low]=temp[t];
			low++;
		}
	}
	
	public static void HeapSort(int[] array) {//����
		for(int i=array.length/2-1;i>=0;i--) {
			HeapSortTip(array,i,array.length);
		}//��ʼ��
		for(int i=array.length-1;i>0;i--) {//������β������
			Swap(array,0,i);
			HeapSortTip(array,0,i);
		}
	}

	public static void HeapSortTip(int[] array,int i,int length) {//������һ�ν���
		for(int k=2*i+1;k<length;k=2*k+1) {
			if(k+1<length&&array[k]<array[k+1]) {
				k=k+1;
			}
			if(array[k]>array[i]) {
				Swap(array,k,i);
				i=k;
			}else {
				break;
			}
		}
	}
	
	public static void Swap(int[] array,int i,int j) {
		int t=array[i];
		array[i]=array[j];
		array[j]=t;
	}
	
	public static void show(int[] array,String name) {
		System.out.print(name+":");
		for(int i:array) {
			System.out.print(i+",");	
		}
		System.out.println("#");
	}

}
