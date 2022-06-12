package task02;

public class ConsumerBasket implements Runnable {
	private CircularQueue circularQueue;

	public ConsumerBasket(CircularQueue circularQueue) {
		this.circularQueue = circularQueue;
	}

	@Override
	public void run() {
		try {

			while (true) {
				int item = circularQueue.dequeue();
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
