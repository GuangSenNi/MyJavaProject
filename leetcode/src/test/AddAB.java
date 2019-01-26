package test;
import java.util.Scanner;  
public class AddAB {  
    public static void main(String[] args) {  
      /*Scanner cin=new Scanner(System.in); 
      Long a=0l,b=0l;
        while(cin.hasNext()){  
          if((a=cin.nextLong())==0l||(b=cin.nextLong())==0l)
          break;
          System.out.println(a+b);  
        }  cin.close();*/
    	Scanner s=new Scanner(System.in);
    	long a=0l,b=0l;
    	while(s.hasNext()) {
    		a=s.nextLong();
    		b=s.nextLong();
    		System.out.println(a+b);
    	}
    	s.close();
    }  
    	
}

