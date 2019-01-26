package myTemp;

public class EightQueue {

	public static void main(String[] args) {
		EightQueue e=new EightQueue();
		e.init(8);
		e.putQueue(0, 8);
		System.out.println(e.count);
	}
	int[] chessBoard;//���i�лʺ��λ��j
	int count=0;//����
	void init(int n) {//��ʼ������
		chessBoard=new int[n];
	}
	//���зŻʺ�,i��ʾ�У�nΪ���ʺ���+1
	void putQueue(int i,int n) {//�ݹ麯��
		if(i==n) {//���ŵ�nʱ��˵���ɹ�
			count++;
			return;
		}//i������n��������һ�����аڷ����
		for(int j=0;j<n;j++) {
			chessBoard[i]=j;//��ʾi��j�зŻʺ�
			if(checkVaild(i)) {//����Ϸ�������һ�м�����
				putQueue(i+1,n);
			}//�Ƿ�����ٽ���������
		}
	}
	boolean checkVaild(int i) {//��ͻ���
		for(int j=0;j<i;j++) {//��Ϊ���зŵĻʺ����Բ��ü��ͬ��
			if(chessBoard[i]==chessBoard[j]||//i,jͬ��
					chessBoard[i]-chessBoard[j]==i-j||//���϶Խ���
					chessBoard[j]-chessBoard[i]==i-j)//���϶Խ���
				return false;
		}
		return true;
	}

}
