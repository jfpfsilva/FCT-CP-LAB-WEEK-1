package cp_lab_1;

import java.util.Random;

public class MonteCarloPIThread extends Thread{

	private int iter;
	private double sum = 0;
	private Random random = new Random(System.currentTimeMillis());
	
	public MonteCarloPIThread(ThreadGroup tg, String name, int iter) {
		super(tg, name);
		this.iter = iter;
	}

	public double getSum() {
		return sum;
	}
	
    @Override
	public void run() {
    	for(int i = 0;i<iter;i++) {
			double x = random.nextDouble();
			double y = random.nextDouble();
			double dist = (x*x) + (y*y);
			if(dist < 1) sum++;
    	}
	}
}
