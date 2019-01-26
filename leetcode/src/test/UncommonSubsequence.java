package test;

public class UncommonSubsequence {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		UncommonSubsequence u=new UncommonSubsequence();
		System.out.println(u.findLUSlength("aba", "cdc"));
	}
	
	public int findLUSlength(String a, String b) {
		int max=0;
		String s1,s2,s3;
		if(a.length()<b.length()) {
        	s2=a;
        	s1=b;
        }else {
        	s2=b;
        	s1=a;
        }
		for(int i=0;i<s1.length();i++) {
			for(int j=i;j<s1.length();j++) {
				s3=s1.substring(i, j);
				if(!s2.contains(s3)) {
					max=Math.max(max, j-i+1);
				}
			}
		}
		if(max>0)
		return max;
		else return -1;
    }
}
