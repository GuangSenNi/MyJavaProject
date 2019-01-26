package number;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class InPicture {
	public void Wobject(HashMap<Integer, num> h) {
		try {
			OutputStream out=new FileOutputStream("src/result.txt");
			ObjectOutputStream oout=new ObjectOutputStream(out);
			oout.writeObject(h);
			oout.close();
			out.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	public HashMap<Integer, num> Robject(){
		try {
			InputStream in=new FileInputStream("src/result.txt");
			ObjectInputStream oin=new ObjectInputStream(in);
			@SuppressWarnings("unchecked")
			HashMap<Integer, num> h=(HashMap<Integer, num>) oin.readObject();
			//System.out.println(oin.readObject());读的时候光标定位，所以读两次会出错
			//System.out.println(h);//重写toString 才能输出文字
			oin.close();
			in.close();
			return h;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	/*
	FileInputStream fin;
	BufferedInputStream bfin;
	byte[] b;
	public void ReadPicture() {
		try {
			fin=new FileInputStream("");
			bfin=new BufferedInputStream(fin);
			int size =bfin.available();
			b=new byte[size];
			bfin.read(b);
			bfin.close();
			System.out.println(b);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public static byte[] imageToBytes(BufferedImage bImage) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
		ImageIO.write(bImage, "jpg", out);
		} catch (IOException e) {
		e.printStackTrace();
		}
		return out.toByteArray();
		}
	
	public int pic[][]=new int[10][10];
	public void changePic(BufferedImage bi) {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				int argb = bi.getRGB(i, j);
				int r = (argb >> 16) & 0xFF;  
				int g = (argb >> 8) & 0xFF; 
				int b = (argb >> 0) & 0xFF;
				int grayPixel = (int) ((b * 29 + g * 150 + r * 77 + 128) >> 8);
				pic[i][j]=grayPixel;
			}
		}
	}*/
		
}
