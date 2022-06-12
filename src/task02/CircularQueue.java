package task02;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;

public class CircularQueue extends JFrame {

	private static final long serialVersionUID = -7895789760051863209L;
	Queue<Integer> queue = new LinkedList<Integer>();
	final int BUFFER_SIZE = 10;
	static Semaphore semaphoreProducer = new Semaphore(1);
	static Semaphore semaphoreConsumer = new Semaphore(0);

	public CircularQueue() {
		setSize(500, 500);
		setLocation(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawOval(150, 150, 100, 100);

	}

	public void enqueue(int productId) throws InterruptedException {
		semaphoreProducer.acquire();
		queue.add(productId);
		System.out.println(Thread.currentThread().getName() + " Putting(In Q) Product ID:" + productId);
		semaphoreConsumer.release();

	}

	public int dequeue() throws InterruptedException {
		semaphoreConsumer.acquire();
		int productId = (int) queue.remove();

		System.out.println(Thread.currentThread().getName() + " Getting (In Q) Product ID:" + productId);
		semaphoreProducer.release();
		return productId;
	}

}
