package test;

import java.util.HashSet;

public class Solution {
	public static void main(String[] args) {
		Solution s=new Solution();
		int num=s.numJewelsInStones("ebd", "bbb");
		System.out.println(num);
	}
	public int numJewelsInStones(String J, String S) {
        HashSet<Character> set=new HashSet<Character>();
        HashSet<Character> set1=new HashSet<Character>();
        for(char i:J.toCharArray()){
            if(set.contains(i)){
                continue;
            }
            set.add(i);
        }
        int count=0;
        boolean m=false;
        for(char i:S.toCharArray()){
            if(set.contains(i)){
                m=true;
            }
            if(m){
                if(set1.add(i))
                    count++;
            }
        }
        return count;
    }
}
