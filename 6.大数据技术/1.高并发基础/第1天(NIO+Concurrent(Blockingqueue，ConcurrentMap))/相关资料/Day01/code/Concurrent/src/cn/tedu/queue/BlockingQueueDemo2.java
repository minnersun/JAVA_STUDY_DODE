package cn.tedu.queue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo2 {

	public static void main(String[] args) throws InterruptedException {

		// ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

		// ����Ϊ��
		// �׳��쳣
		// System.out.println(queue.remove());
		// ����null
		// System.out.println(queue.poll());
		// ��������
		// System.out.println(queue.take());
		// ��ʱ����
		System.out.println(queue.poll(5, TimeUnit.SECONDS));
	}

}
