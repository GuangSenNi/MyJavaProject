package test;


public class Surface {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Surface s=new Surface();
		int[][] a= {{1,1,1},{1,0,1},{1,1,1}};
		s.surfaceArea(a);
		
	}
	 int surfaceArea(int[][] grid) {
	        int num=0;
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[i].length;j++){
	            	if(grid[i][j]!=0) {
	            		num+=4*grid[i][j]+2;
	                    if((j-1)!=-1) {
	                    	num-=Math.min(grid[i][j],grid[i][j-1])*2;
	                    }
	                    if((i-1)!=-1) {
	                    	num-=Math.min(grid[i][j],grid[i-1][j])*2;
	                    }
	            	}
	            }
	        }
	        return num;
	    } 
}
