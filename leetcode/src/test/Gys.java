package test;

import java.util.Scanner;
public class Gys {
	//求公约数，i*i<M c+2 i*i=M c++ 利用对称
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        s.nextInt();
        while(true){
            int m=s.nextInt();
            if(m==0)break;
            System.out.println(find(m));
        }
        s.close();
    }
    static int find(int m){
        int count=0;
        int i;
        for( i=1;i*i<m;i++){
            if(m%i==0)count+=2;
        }
        if(i*i==m)count++;
        return count;
    }
	
}
