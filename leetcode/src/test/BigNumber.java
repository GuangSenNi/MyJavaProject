package test;
import java.math.*;
public class BigNumber {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		BigInteger b1=new BigInteger("11111");
		BigInteger b2=new BigInteger("911111");
		BigDecimal d1=new BigDecimal("111.0111");
		BigDecimal d2=new BigDecimal("0.59999");
		System.out.println(b1.add(b2));
		
		MathContext mc = new MathContext(3, RoundingMode.HALF_DOWN); 
		System.out.println(d2.divide(d1,mc));
		System.out.println(String.format("%.4f", 0.123456));
		System.out.printf("%.2f", 0.1664);
		
	}

}
