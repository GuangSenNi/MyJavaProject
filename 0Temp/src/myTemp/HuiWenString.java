package myTemp;


public class HuiWenString {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(countSubstrings("abcbcbdbc"));
		System.out.println(longestStr("abcbcbdbc"));
	}

	//字符串的回文子串数量
	//方法一：中心回文法
	static int countSubstrings(String str) 
	{
		char[] s=str.toCharArray();
		int n = s.length;
		int ans = 0;
		for (int i = 0; i < n;i++)
		{
			for (int j = 0; i + j < n && i - j>=0 && s[i - j] == s[i + j]; j++) ans++;//ji
			for (int j = 0; i + j < n && i - 1 - j>=0 && s[i - 1 - j] == s[i + j]; j++) ans++;//ou
		}
		return ans;
	}
	
	static int longestStr(String str) {
		char[] chararray=str.toCharArray();
		int l=chararray.length;
		int max=0;
		for(int i=0;i<l;i++) {
			int tem=0;
			for(int j=0;i-j>=0&&i+j<l&&chararray[i-j]==chararray[i+j];j++) {
				tem=tem+2;
			}
			max=Math.max(max, tem-1);
			tem=0;
			for(int j=0;i-j-1>=0&&i+j<l&&chararray[i-j-1]==chararray[i+j];j++) {
				tem=tem+2;
			}
			max=Math.max(max, tem);
		}
		return max;
	}

	

	

}
