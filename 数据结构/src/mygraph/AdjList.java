package mygraph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AdjList {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		AdjList a=new AdjList();
		a.initGraph();
		System.out.println("start dfs");
		a.bfs(a, a.vertexArray[0]);
	}
	Vertex1[] vertexArray=new Vertex1[5];
    int verNum=0;
    int edgeNum=0;
	public void initGraph() {
		try {
			FileInputStream fin=new FileInputStream("src/data.txt");
			InputStreamReader fir=new InputStreamReader(fin);
			BufferedReader bfr=new BufferedReader(fir);
			String s=bfr.readLine();
			int i=1;
			while(s!=null) {
				System.out.println(s);
				if(i==1) {
					String[] strName= s.split("#");
					for(int j=0;j<5;j++) {
						Vertex1 ver=new Vertex1(strName[j]);
						vertexArray[j]=ver;
					}
				}else {
					Vertex1 vp=new Vertex1(s.split(" ")[0]);
					Vertex1 vl=new Vertex1(s.split(" ")[1]);
					addNode(s.split(" ")[1], vp);
					addNode(s.split(" ")[0], vl);
				}
				i++;
				s=bfr.readLine();
			}
			bfr.close();
			fir.close();
			fin.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	public Vertex1 findNode(Vertex1[] Array,String val) {
		Vertex1 vec=null;
		for(Vertex1 v:Array) {
			if(v.val.equals(val)) {
				vec=v;
				break;
			}
		}
		return vec;
	}
	
	public void addNode(String name,Vertex1 node) {
		for(Vertex1 v:vertexArray) {
			if(v.val.equals(name)) {
				Vertex1 v1=v;
				while(v1.nextNode!=null) {
					v1=v1.nextNode;
				}
				v1.nextNode=node;
				break;
			}
		}
	}
	HashSet<String> h = new HashSet<String>();
	public void dfs(AdjList adj,Vertex1 v) {
		h.add(v.val);
		System.out.println(v.val);
		Vertex1 v2=v.nextNode;
		while(v2!=null) {
			if(h.contains(v2.val)) {
				v2=v2.nextNode;
			}else {
				Vertex1 v3=findNode(adj.vertexArray,v2.val);
				dfs(adj,v3);
				v2=v2.nextNode;
			}
		}
	}

	Queue<Vertex1> queue=new LinkedList<Vertex1>();
	public void bfs(AdjList adj,Vertex1 v) {
		System.out.println(v.val);
		h.add(v.val);
		while(v.nextNode!=null) {
			v=v.nextNode;
			queue.offer(v);
		}
		Vertex1 v1=queue.poll();
		while(v1!=null) {
			if(h.contains(v1.val)) {
				v1=queue.poll();
			}else {
				Vertex1 v3=findNode(adj.vertexArray,v1.val);
				bfs(adj,v3);
				v1=queue.poll();
			}
		}

	}
}
