package myTemp;

public class EightQueue {

	public static void main(String[] args) {
		EightQueue e=new EightQueue();
		e.init(8);
		e.putQueue(0, 8);
		System.out.println(e.count);
	}
	int[] chessBoard;//存第i行皇后的位置j
	int count=0;//计数
	void init(int n) {//初始化棋盘
		chessBoard=new int[n];
	}
	//按行放皇后,i表示行，n为最多皇后数+1
	void putQueue(int i,int n) {//递归函数
		if(i==n) {//当放到n时，说明成功
			count++;
			return;
		}//i不等于n，则尝试这一行所有摆放情况
		for(int j=0;j<n;j++) {
			chessBoard[i]=j;//表示i行j列放皇后
			if(checkVaild(i)) {//如果合法，在下一行继续放
				putQueue(i+1,n);
			}//非法或穷举结束，回溯
		}
	}
	boolean checkVaild(int i) {//冲突检测
		for(int j=0;j<i;j++) {//因为按行放的皇后，所以不用检测同行
			if(chessBoard[i]==chessBoard[j]||//i,j同列
					chessBoard[i]-chessBoard[j]==i-j||//左上对角线
					chessBoard[j]-chessBoard[i]==i-j)//右上对角线
				return false;
		}
		return true;
	}

}
