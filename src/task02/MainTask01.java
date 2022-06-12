package task02;

public class MainTask01 {

	public static void main(String[] args) {
		// MyFrame frame = new MyFrame("Bounded Buffer Problem Simulation");

		CircularQueue circularQueue = new CircularQueue();
		new Thread(new ProducerBasket(circularQueue)).start();
		new Thread(new ConsumerBasket(circularQueue)).start();
	}

}
