package cp_lab_1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("main");
		int numThreads = 4;
		int iter = 1000000000;
		List<MonteCarloPIThread> list = new ArrayList<MonteCarloPIThread>();
		
		long start = System.nanoTime();
		
		for(int i = 0;i<numThreads;i++)
			list.add(new MonteCarloPIThread(tg,"Thread"+i,iter/numThreads));
			
		for(MonteCarloPIThread mPI : list)
			mPI.start();
		
		while(tg.activeCount()>0)
		{
			try {Thread.sleep(100);} 
				catch (InterruptedException e) {e.printStackTrace();}
		}
		
		double sum = 0;
		
		for(MonteCarloPIThread mPI : list)
			sum += mPI.getSum();
		
		long end  = System.nanoTime();
		System.out.println("valor "+ (int)sum);
		System.out.printf("PI approx. %gn", 4.0*(sum/(double)iter));
		System.out.printf("Simulation took %.2g secondsn", (double)(end-start)/1e9);
	}

}
