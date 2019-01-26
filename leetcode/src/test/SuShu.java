package test;

import java.util.ArrayList;

public class SuShu {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	static int[] ans=new int[10001];
    static ArrayList<Integer> arr=new ArrayList<Integer>();
	 static void init(){
	        for(int i=2;i<10001;i++){
	            if(ans[i]==1)continue;
	            ans[i]=1;
	            if(i%10==1){
	                arr.add(i);
	            }
	            for(int j=i*i;j<10001;j+=i){
	                ans[j]=1;
	            }
	        }
	    }
}
