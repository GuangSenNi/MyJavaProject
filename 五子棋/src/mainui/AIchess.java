package mainui;

import java.util.HashMap;
import java.util.Random;

public class AIchess {
	static HashMap<String,Integer> map = new HashMap<String,Integer>();
	public int[][] weight = new int[16][16];
	private int[][] moni;

	public AIchess(int[][] moni) {
		super();
		this.moni = moni;
		inni();
	}
	public void inni() {
		map.put("0", 0);
		map.put("10", 10);
		map.put("110", 50);
		map.put("1110", 250);
		map.put("11110", 1000);
		map.put("-10", 10);
		map.put("-1-10", 50);
		map.put("-1-1-10", 250);
		map.put("-1-1-1-10", 1000);
		map.put("-110", 1);
		map.put("-1110", 10); 
		map.put("-11110", 50);
		map.put("-111110", 1000);
		map.put("1-10", 1);
		map.put("1-1-10", 10);
		map.put("1-1-1-10", 50);
		map.put("1-1-1-1-10", 1000);
	}
	public int[] ai() {
		int m=0;
		Random r=new Random();
		int[] a=new int[2];
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				weight[i][j]=0;
			}
		}
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				if(moni[i][j]==0) {
					find(i,j);
				}
			}
		}
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				if(weight[i][j]>m) {
					a[0]=i;
					a[1]=j;
					m=weight[i][j];
				}
			}
		}if(m==0) {
			a[0]=r.nextInt(6)+5;
			a[1]=r.nextInt(6)+5;
		}
		return a;
	}

	public void find(int x,int y) {
		String code = "0";
		int chess = 0;
		for(int c1=x-1;c1>=0;c1--){//左
			if(moni[c1][y]==0) {
				if(c1+1==x){
					break;	
				}else{
					//code=moni[c1][y]+code;//记录棋子相连情况
					break;
				}
			}else {
				if(chess==0){
					chess = moni[c1][y];
					code=moni[c1][y]+code;
				}else if(chess==moni[c1][y]){
					code=moni[c1][y]+code;
				}else{
					code=moni[c1][y]+code;
					break;
				}
			}
		}
		
		int weight1 = map.get(code);
		weight[x][y] += weight1;//累加权值 
		code = "0";
		chess = 0;

		for(int c1=x+1;c1<16;c1++){//右
			if(moni[c1][y]==0) {
				if(c1-1==x){
					break;	
				}else{
					//code=moni[c1][y]+code;//记录棋子相连情况
					break;
				}
			}else {
				if(chess==0){
					chess = moni[c1][y];
					code=moni[c1][y]+code;
				}else if(chess==moni[c1][y]){
					code=moni[c1][y]+code;
				}else{
					code=moni[c1][y]+code;
					break;
				}
			}
		}//System.out.println(code);
		weight1 = map.get(code);
		weight[x][y] += weight1;//累加权值 
		code = "0";
		chess = 0;

		for(int c1=y-1;c1>=0;c1--){//上
			if(moni[x][c1]==0) {
				if(c1+1==y){
					break;	
				}else{
					//code=moni[x][c1]+code;//记录棋子相连情况
					break;
				}
			}else {
				if(chess==0){
					chess = moni[x][c1];
					code=moni[x][c1]+code;
				}else if(chess==moni[x][c1]){
					code=moni[x][c1]+code;
				}else{
					code=moni[x][c1]+code;
					break;
				}
			}
		}
		weight1 = map.get(code);
		weight[x][y] += weight1;//累加权值 
		code = "0";
		chess = 0;

		for(int c1=y+1;c1<16;c1++){//下
			if(moni[x][c1]==0) {
				if(c1-1==y){
					break;	
				}else{
					//code=moni[x][c1]+code;//记录棋子相连情况
					break;
				}
			}else {
				if(chess==0){
					chess = moni[x][c1];
					code=moni[x][c1]+code;
				}else if(chess==moni[x][c1]){
					code=moni[x][c1]+code;
				}else{
					code=moni[x][c1]+code;
					break;
				}
			}
		}//System.out.println(code);
		weight1 = map.get(code);
		weight[x][y] += weight1;//累加权值 
		code = "0";
		chess = 0;

		for(int c1=x-1;c1>=0;c1--){//左上
			if(y+c1-x>=0) {
				if(moni[c1][y+c1-x]==0) {
					if(c1+1==x){
						break;	
					}else{
						//code=moni[c1][y+c1-x]+code;//记录棋子相连情况
						break;
					}
				}else {
					if(chess==0){
						chess = moni[c1][y+c1-x];
						code=moni[c1][y+c1-x]+code;
					}else if(chess==moni[c1][y+c1-x]){
						code=moni[c1][y+c1-x]+code;
					}else{
						code=moni[c1][y+c1-x]+code;
						break;
					}
				}
			}
			
		}
		//System.out.println(code);
		weight1 = map.get(code);
		weight[x][y] += weight1;//累加权值 
		code = "0";
		chess = 0;

		for(int c1=x-1;c1>=0;c1--){//左下
			if(y-c1+x<16) {
				if(moni[c1][y-c1+x]==0) {
					if(c1+1==x){
						break;	
					}else{
						//code=moni[c1][y-c1+x]+code;//记录棋子相连情况
						break;
					}
				}else {
					if(chess==0){
						chess = moni[c1][y-c1+x];
						code=moni[c1][y-c1+x]+code;
					}else if(chess==moni[c1][y-c1+x]){
						code=moni[c1][y-c1+x]+code;
					}else{
						code=moni[c1][y-c1+x]+code;
						break;
					}
				}
			}
			
		}//System.out.println(code);
		weight1 = map.get(code);
		weight[x][y] += weight1;//累加权值 
		code = "0";
		chess = 0;

		for(int c1=x+1;c1<16;c1++){//右下
			if(y+c1-x<16) {
				if(moni[c1][y+c1-x]==0) {
					if(c1-1==x){
						break;	
					}else{
					//	code=moni[c1][y+c1-x]+code;//记录棋子相连情况
						break;
					}
				}else {
					if(chess==0){
						chess = moni[c1][y+c1-x];
						code=moni[c1][y+c1-x]+code;
					}else if(chess==moni[c1][y+c1-x]){
						code=moni[c1][y+c1-x]+code;
					}else{
						code=moni[c1][y+c1-x]+code;
						break;
					}
				}
			}
			
		}//System.out.println(code);
		weight1 = map.get(code);
		weight[x][y] += weight1;//累加权值 
		code = "0";
		chess = 0;

		for(int c1=x+1;c1<16;c1++){//右上
			if(y-c1+x>=0) {
				if(moni[c1][y-c1+x]==0) {
					if(c1-1==x){
						break;	
					}else{
					//	code=moni[c1][y-c1+x]+code;//记录棋子相连情况
						break;
					}
				}else {
					if(chess==0){
						chess = moni[c1][y-c1+x];
						code=moni[c1][y-c1+x]+code;
					}else if(chess==moni[c1][y-c1+x]){
						code=moni[c1][y-c1+x]+code;
					}else{
						code=moni[c1][y-c1+x]+code;
						break;
					}
				}
			}
			
		}//System.out.println(code);
		weight1 = map.get(code);
		weight[x][y] += weight1;//累加权值 

	}

}
