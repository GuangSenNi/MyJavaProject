package daytime;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DatagramPacket implements Serializable {

	private String ip = "127.0.0.1";
	private int port = 6001;
	private String msg="Hello";
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String toString() {
	    return "[ip=" + ip + ", port=" + port + ", msg=" + msg+ "]";
	    }
	
}
