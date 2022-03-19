package task_4;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTask {
	//Make two threads and connect them to play a Ping-Pong game.
	// One thread should write “ping” to the console, another - “pong”.
	// Each thread should add his own name to his message.
	// It will be good to finish that game after a few seconds.
	// Try to use Executors and different implementation of Thread

	private static final int MAX_PING_COUNT = 10;
	private static final AtomicInteger currentPingNumber = new AtomicInteger(0);

	public static void main(String[] args) {
		new Thread(() -> {
			while (currentPingNumber.get() < MAX_PING_COUNT) {
				synchronized (currentPingNumber) {
					currentPingNumber.notifyAll();
				}
				System.out.printf(
						"%s at %s with count %s%n",
						Thread.currentThread().getName(),
						new Date().getTime(),
						currentPingNumber.incrementAndGet()
				);
				try {
					currentPingNumber.wait();
				} catch (Exception ignored) {
				}
			}
		}, "Ping").start();

		new Thread(() -> {
			while (currentPingNumber.get() < MAX_PING_COUNT) {
				try {
					currentPingNumber.wait();
				} catch (Exception ignored) {
				}

				System.out.printf(
						"%s at %s with count %s%n",
						Thread.currentThread().getName(),
						new Date().getTime(),
						currentPingNumber.incrementAndGet()
				);
				synchronized (currentPingNumber) {
					currentPingNumber.notifyAll();
				}
			}
		}, "Pong").start();
	}
}
