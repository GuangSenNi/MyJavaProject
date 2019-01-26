package FireWorks;

public class VecT {
	public double x, y;

	public VecT(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// 向量加
	public VecT add(VecT p) {
		return new VecT(this.x + p.x, this.y + p.y);
	}

	// 向量乘
	public VecT multiply(double f) {
		return new VecT(this.x * f, this.y * f);
	}
	public VecT chu(double f) {
		return new VecT(this.x /f, this.y / f);
	}
}