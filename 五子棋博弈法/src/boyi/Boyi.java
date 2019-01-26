package boyi;

import java.awt.Point;
import java.util.ArrayList;

public class Boyi {
	private static int[][] table;
	private static int sys=1;
	private static int	MAXN=99999;
	public Boyi(int[][] table) {
		super();
		Boyi.table = table;
	}

	public static boolean near(int i,int j) {
		int m=i,n=j;
		if(--m>=0&&table[m][n]!=0) {
			return true;
		}
		m=i;n=j;
		if(--n>=0&&table[m][n]!=0) {
			return true;
		}
		m=i;n=j;
		if(++n<15&&table[m][n]!=0) {
			return true;
		}
		m=i;n=j;
		if(++m<15&&table[m][n]!=0) {
			return true;
		}
		m=i;n=j;
		if(++m<15&&++n<15&&table[m][n]!=0) {
			return true;
		}
		m=i;n=j;
		if(++m<15&&--n>=0&&table[m][n]!=0) {
			return true;
		}
		m=i;n=j;
		if(--m>=0&&--n>=0&&table[m][n]!=0) {
			return true;
		}
		m=i;n=j;
		if(--m>=0&&++n<15&&table[m][n]!=0) {
			return true;
		}
		return false;
	}

	public static void tree(int deep,Node root,int alpha,int beta) {
		if(deep==3){  
            root.mark=getMark(table);  
            return;  
        }  
		
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(table[i][j]==0&&near(i,j)) {				
					Node node=new Node(); 
					Point p1=new Point(i, j); 
					node.setPoint(p1);
					root.addChild(node); 
					table[i][j]=((deep%2)==0)?sys:-sys; 
					if(isEnd(i,j)) {
						root.bestChild=node; 
		                root.mark=MAXN*table[i][j]; 
		                beta=Math.min(root.mark,beta);
		                alpha=Math.max(root.mark,alpha);
		                table[i][j]=0;  
		                return;  
					}
					tree(deep+1,node,alpha,beta);
					table[i][j]=0;
					
					if(deep%2==1) {//min
						if(root.bestChild==null || node.mark<root.bestChild.mark){ 
							root.bestChild=node;  
		                    root.mark=root.bestChild.mark;
		                    beta=Math.min(root.mark,beta);
						}
						if(root.mark<=alpha)  
		                    return;
					}else{  //max
		                if(root.bestChild==null || node.mark>root.bestChild.mark){  
		                    root.bestChild=node;  
		                    root.mark=root.bestChild.mark; 
		                    alpha=Math.max(root.mark,alpha); 
		                }  
		                if(root.mark>=beta)  
		                    return;  
		            }  
				}
			}
		}
	}

	public static int getMark(int[][] chessboard) {//评分函数
		int mark=0;
	for(int i=0;i<15;i++) {
		for(int j=0;j<15;j++) {
			if(chessboard[i][j]!=0) {//某一点有子，则四方搜索
				int x=i,y=j,num=1;
				boolean left=false,right=false;
				//左右搜索
				while(--x>=0&&chessboard[x][y]==chessboard[i][j])num++;
				if(x>=0&&chessboard[x][y]==0)left=true;
				x=i;y=j;
				while(++x<15&&chessboard[x][y]==chessboard[i][j])num++;
				if(x<15&&chessboard[x][y]==0)right=true;
				x=i;y=j;
				if(left&&right) {
					mark+=chessboard[i][j]*Math.pow(4,num);
				}else if(left||right) {
					mark+=chessboard[i][j]*Math.pow(4,num-1);
				}
				if(num>=5)mark=chessboard[i][j]*99999;
				//上下搜索
				num=1;left=false;right=false;
				while(--y>=0&&chessboard[x][y]==chessboard[i][j])num++;
				if(y>=0&&chessboard[x][y]==0)left=true;
				x=i;y=j;
				while(++y<15&&chessboard[x][y]==chessboard[i][j])num++;
				if(y<15&&chessboard[x][y]==0)right=true;
				x=i;y=j;
				if(left&&right) {
					mark+=chessboard[i][j]*Math.pow(4,num);
				}else if(left||right) {
					mark+=chessboard[i][j]*Math.pow(4,num-1);
				}
				if(num>=5)mark=chessboard[i][j]*99999;
				//左斜
				num=1;left=false;right=false;
				while(--x>=0&&--y>=0&&chessboard[x][y]==chessboard[i][j])
					num++;
				if(y>=0&&x>=0&&chessboard[x][y]==0)left=true;
				x=i;y=j;
				while(++x<15&&++y<15&&chessboard[x][y]==chessboard[i][j])
					num++;
				if(y<15&&x<15&&chessboard[x][y]==0)right=true;
				x=i;y=j;
				if(left&&right) {
					mark+=chessboard[i][j]*Math.pow(4,num);
				}else if(left||right) {
					mark+=chessboard[i][j]*Math.pow(4,num-1);
				}
				if(num>=5)mark=chessboard[i][j]*99999;
				//右斜
				num=1;left=false;right=false;
				while(--x>=0&&++y<15&&chessboard[x][y]==chessboard[i][j])
					num++;
				if(x>=0&&y<15&&chessboard[x][y]==0)left=true;
				x=i;y=j;
				while(++x<15&&--y>=0&&chessboard[x][y]==chessboard[i][j])
					num++;
				if(x<15&&y>=0&&chessboard[x][y]==0)right=true;
				if(left&&right) {
					mark+=chessboard[i][j]*Math.pow(4,num);
				}else if(left||right) {
					mark+=chessboard[i][j]*Math.pow(4,num-1);
				}
				if(num>=5)mark=chessboard[i][j]*99999;
			}
		}
	}
	return mark;
	}

	public static boolean isEnd(int y,int x){
		int cnt=1;  
		int col=x,row=y; 
		// 判断一行是否五子连珠 
		
		//System.out.println(table[x][y]);
		while(--col>=0 && table[row][col]==table[y][x])++cnt; 
		col=x;row=y;  
		while(++col<15 && table[row][col]==table[y][x]) ++cnt;  
		if(cnt>=5){  
			return true;  
		}  
		// 判断一列是否五子连珠  
		col=x;row=y;  
		cnt=1;  
		while(--row>=0 && table[row][col]==table[y][x]) ++cnt;  
		col=x;row=y;  
		while(++row<15 && table[row][col]==table[y][x]) ++cnt;  
		if(cnt>=5){  
			return true;  
		}  
		// 判断左对角线是否五子连珠  
		col=x;row=y;  
		cnt=1;  
		while(--col>=0 && --row>=0 && table[row][col]==table[y][x]) ++cnt;  
		col=x;row=y;  
		while(++col<15 && ++row<15 && table[row][col]==table[y][x]) ++cnt;  
		if(cnt>=5){  
			return true;  
		}  
		// 判断右对角线是否五子连珠  
		col=x;row=y;  
		cnt=1;  
		while(++row<15 && --col>=0 && table[row][col]==table[y][x]) ++cnt;  
		col=x;row=y;  
		while(--row>=0 && ++col<15 && table[row][col]==table[y][x]) ++cnt;  
		if(cnt>=5){  
			return true;  
		}  
		return false;  
	}  

}
