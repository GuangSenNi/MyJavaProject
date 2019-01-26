package number;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class BYS {

	private HashMap<Integer, num> trainGroup=new HashMap<Integer, num>();
	
	public BYS() {
		for(int i=0;i<10;i++) {
			num n=new num();
			n.setId(i);
			trainGroup.put(i, n);
		}
	}
	//p(x|wi)
	public void trainData(BufferedImage bi,int key) {
		num n=trainGroup.remove(key);
		int numNuantity=n.getNum();
		numNuantity++;
		n.setNum(numNuantity);
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				int val = bi.getRGB(i, j);
				if(val!=-1) {
					n.eachNum[i][j]++;
					n.eachP[i][j]=n.eachNum[i][j]/numNuantity;
				}
			}
		}
		trainGroup.put(key, n);
	}
	
	public float testData(BufferedImage bi,int key) {
		num n=trainGroup.get(key);
		if(n.getNum()==0)return 0;
		float samePi=0;
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				int val = bi.getRGB(i, j);
				if(val!=-1) {
					samePi+=n.eachP[i][j];
				}else {
					samePi+=(1-n.eachP[i][j]);
				}
			}
		}
		//System.out.println(samePi);
		return samePi/400;
	}
	
	public int test(BufferedImage bi) {
		int finNum=0;
		float maxPi=0,pi;
		for(int i=0;i<10;i++) {
			pi=testData(bi,i);
			if(pi>maxPi) {
				maxPi=pi;
				finNum=i;
			}
		}
		//System.out.println(maxPi);
		return finNum;
	}
	public void save() {
		InPicture inPicture=new InPicture();
		inPicture.Wobject(trainGroup);
		System.out.println("Ð´Èë");
	}
	public void readData() {
		InPicture inPicture=new InPicture();
		trainGroup=inPicture.Robject();
		System.out.println("¶Á³ö");
	}
}
