package filemanage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FindFile extends Thread{//可以通过线程提高效率

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		FindFile f=new FindFile("E:\\Documents");
		FindFile f1=new FindFile("E:\\Downlaod");
		//f.CreateFile();
		f.start();
		f1.start();
	}

	private String path;
	public FindFile(String path) {
		super();
		this.path = path;
	}
	public void CreateFile() {
		File f=new File("src/myfile.txt");
		if(!f.exists()) {
			try {
				f.createNewFile();
				System.out.println("success created");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else {
			System.out.println("exist");
		}
	}
	public void run() {
		FindJava();
	}
	public void FindJava() {
		File file = new File(path);
		System.out.println(file);
		FChildF(file);
	}
	public void FChildF(File f) {
		File[] filelist=f.listFiles();
		if(filelist==null)return;
		for(int i=0;i<filelist.length;i++) {
			if(filelist[i].isDirectory()) {
				FChildF(filelist[i]);
			}else if(filelist[i].isFile()) {
				String fname=filelist[i].getName();
				String str = fname.substring(fname.lastIndexOf(".") + 1);
				if(str.equals("java")) {
					Wfile(fname);
				}
			}
		}
	}
	
	public void Wfile(String m) {
		try {
			FileWriter writer = new FileWriter("src/myfile.txt", true);
			writer.write(m+"\r\n");     
            writer.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
