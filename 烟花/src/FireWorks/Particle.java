package FireWorks;

import java.awt.Color;

public class Particle {
	//���ӵ���㣬�ٶȣ�����
	public VecT position,velocity,acceleration;//λ�ã����ʣ����ٶ�
	public Color color;
	public double life,age,start_time;
	public int size;
	//�ڽ����ϻ���ʱ��x,y����
	public int x,y;
	public int getX(){
		return (int)position.x;
	}
	public int getY(){
		return (int)position.y;
	}
}
