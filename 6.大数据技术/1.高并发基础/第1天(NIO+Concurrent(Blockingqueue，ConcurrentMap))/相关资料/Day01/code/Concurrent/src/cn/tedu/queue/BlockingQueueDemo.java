package cn.tedu.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

	public static void main(String[] args) throws InterruptedException {

		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

		// ���Ԫ��
		queue.add("a");
		queue.add("b");
		queue.add("c");
		queue.add("d");
		queue.add("e");

		// ��������
		// �׳��쳣
		// queue.add("f");
		// ����false
		// boolean b = queue.offer("g");
		// System.out.println(b);
		// ��������
		// queue.put("h");
		// ��ʱ����
		queue.offer("r", 5, TimeUnit.SECONDS);
		System.out.println(queue);

	}

}
