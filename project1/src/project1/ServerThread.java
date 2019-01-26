package project1;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{
	 Socket socket=null;  
	 InputStream is=null;  
	 BufferedReader br=null;  
	 OutputStream os=null;  
	 PrintWriter pw=null;  
	 String info=null;
	  public ServerThread(Socket socket){  
	     this.socket=socket;  
	 }  
	  public void run(){  
	      try {  
	            is=socket.getInputStream();//����ֽ���  
	            br=new BufferedReader(new InputStreamReader(is));//�ֽ���ת��Ϊ�ַ�������ӻ���  
	            String info=null;  
	            while((info=br.readLine())!=null){  
	                System.out.println("���Ƿ����,�ͻ���˵:"+info);  
	            }  
	            socket.shutdownInput();//����Ҫ��ʱ�رգ���Ϊreadline�����������\r\n��Ϊ�綨���ģ����ڷ�����Ϣ����һ���õ���PrintWriter��write()���������������û����\r\n,���Ի�һֱ�ȴ�  
	            //�ظ��ͻ���  
	            os=socket.getOutputStream();  
	            pw=new PrintWriter(os);  
	            pw.write("hello");  
	            pw.flush();  
	              
	    } catch (IOException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    }finally{  
	        if (pw!=null)  
	        pw.close();  
	        try {  
	            if (os!=null)  
	            os.close();  
	            if (br!=null)  
	            br.close();  
	            if (is!=null)  
	            is.close();//�رշ��ص� InputStream ���رչ����׽��֡�   
	            socket.close();  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	    }  
	  }  

}
