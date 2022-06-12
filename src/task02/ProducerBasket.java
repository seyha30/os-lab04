package task02;

public class ProducerBasket implements Runnable {

	CircularQueue circularQueue;

	ProducerBasket(CircularQueue circularQueue) {
		this.circularQueue = circularQueue;

	}

	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < 5; i++) {
				try {
					circularQueue.enqueue(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
