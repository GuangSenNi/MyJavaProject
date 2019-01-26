package bpNetwork;

public class BpNet {
	//输入
	private static double[] inFirst;
	private static double[] outFirst;
	//隐藏
	private static double[] inSecond;
	private static double[] outSecond;
	//输出
	private static double[] inThird;
	private static double[] outThird;
	//权值1
	private static double[][] weight1_2;
	//权值2
	private static double[][] weight2_3;
	//各层节点数
	private static int cellNum1;
	private static int cellNum2;
	private static int cellNum3;
	//误差
	public double error;
	public double sqr_error;
	private double[] delta_hidden;
	private double[] delta_out;

	//速率
	private double rate_w;
	private double rate_y;
	//隐藏层和输出层的阈值hidden_y,out_y
	private double[] hidden_y;
	private double[] out_y;
	public BpNet(int cellNum1, int cellNum2, int cellNum3, double rate_w, double rate_y) {
		super();
		this.cellNum1 = cellNum1;
		this.cellNum2 = cellNum2;
		this.cellNum3 = cellNum3;
		this.rate_w = rate_w;
		this.rate_y = rate_y;
		initNet();
	}
	
	private void initNet() {
		inFirst=new double[cellNum1];
		outFirst=new double[cellNum1];
		inSecond=new double[cellNum2];
		outSecond=new double[cellNum2];
		delta_hidden=new double[cellNum2];
		inThird=new double[cellNum3];
		outThird=new double[cellNum3];
		delta_out=new double[cellNum3];
		weight1_2=new double[cellNum1][cellNum2];
		weight2_3=new double[cellNum2][cellNum3];
		hidden_y = new double[cellNum2+1];
		out_y = new double[cellNum3+1];//?+1
		initWei(weight1_2,hidden_y,cellNum1,cellNum2);
		initWei(weight2_3,out_y,cellNum2,cellNum3);
	}
	
	private void initWei(double w[][],double val[],int m,int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				w[i][j]=Math.random()*0.1;
			}
			val[i]=Math.random()*0.1;
		}
	}
	
	private double Sigmoid(double d) {
		// TODO Auto-generated method stub
		return 1/(1+Math.exp(-d));
	}
	
	private void forward(int inNum,int nextNum,double in[],
			double next_in[],double next_out[],double wei[][],double yu[]) {
		for(int i=0;i<nextNum;i++) {
			double sum=0;
			for(int j=0;j<inNum;j++) {
				sum+=wei[j][i]*in[j];
			}
			next_in[i]=sum-yu[i];
			next_out[i]=Sigmoid(next_in[i]);
		}
	}
	
	private void Calculate_err() {
		Calculate_err_out();
		Calculate_err_hidden();
		
	}
	private void Calculate_err_out() {//???
		sqr_error = 0;
		for(int k=0;k<cellNum3;k++)
		{
			delta_out[k] = (outFirst[k]-outThird[k]) * outThird[k] * (1-outThird[k]);
			sqr_error += (outFirst[k]-outThird[k])*(outFirst[k]-outThird[k])/k;
		}
	}
	
	private void Calculate_err_hidden() {
		for(int n=0;n<cellNum2;n++)
		{
			double sum = 0;
			for(int k=0;k<cellNum3;k++)
				sum += delta_out[k] * weight2_3[n][k];
			delta_hidden[n] = sum * outSecond[n] * (1-outSecond[n]);
		}
	}
	
	private void UpData_out() {
		for(int k=0;k<cellNum3;k++)
		{
			for(int n=0;n<cellNum2;n++)
				weight2_3[n][k] = weight2_3[n][k] + rate_w * delta_out[k] * outSecond[n];
			out_y[k] = out_y[k] + rate_w * delta_out[k]; 
		}
	}
	
	private void UpData_hide() {
		for(int n=0;n<cellNum2;n++)
		{
			for(int m=0;m<cellNum1;m++)
				weight1_2[m][n] = weight1_2[m][n] + rate_y * delta_hidden[n] * inFirst[m];
			hidden_y[n] = hidden_y[n] + rate_y * delta_hidden[n];
		}
	}
	
	public double[] test(double[] in)
	{
		inFirst = in;
		forward(cellNum1,cellNum2,inFirst,inSecond,outSecond,weight1_2,hidden_y);
		forward(cellNum2,cellNum3,outSecond,inThird,outThird,weight2_3,out_y);
		return outThird;
	}
}
