package bench.test;

import bench.IBenchmark;
import bench.cpu.CPUThreading;
import bench.cpu.FlopPhoto;
import logging.ConsoleLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class executor {
	public float score;

	public void execute() {
		PCSpecs specs = new PCSpecs();
		((PCSpecs) specs).PCSpec();

		int cores = Integer.valueOf(specs.proc4);
		// int cores = 2;
		ITimer timer = new Timer();
		ILogger log = new ConsoleLogger();
		TimeUnit timeUnit = TimeUnit.milli;
		IBenchmark bench = new CPUThreading();
		long time;
		bench.initialize(10000000);
		for (int threads = 1; threads <= cores * 2; threads *= 2) {
			timer.start();
			bench.run(new Integer(threads));
			time = timer.stop();
			score = 0.0f;
			System.out.println("Threads: " + threads + " -> time: " + (time / 1000000) + " ms");
			time = time / 1000000;

			score += threads * 100000 / time;

			log.writeTime(timer.stop(), timeUnit);
		}
		
		/*bench = new FlopPhoto();
		bench.initialize(0);
		timer.start();
		bench.run();
		time = timer.stop();
		score = 0.0f;
		time = time / 1000000;
		score += 1000000 / time;
		*/
		log.close();
		System.out.println("SCORE: " + score);
	}
}
