package cn.tedu.buffer;

import java.nio.ByteBuffer;

public class ByteBufferDemo {

	public static void main(String[] args) {

		// ����ByteBuffer����
		// ByteBuffer�ײ��ǻ������ֽ��������洢
		// ������ʹ�õ�ʱ����Ҫָ���ֽ����������
		ByteBuffer buffer = ByteBuffer.allocate(10);

		// �������
		buffer.put("abc".getBytes());
		buffer.put("def".getBytes());

		// ��Ҫ��positionŲ��ָ����λ����
		// buffer.position(0);

		// ��ȡ����
		// ��ʾ��ȡһ���ֽ�
		// System.out.println(buffer.get());
		// System.out.println(buffer.get());
		// �����Ҫ���л������ı���
		// ��Ҫ�Ƚ�limitŲ��position��
		// Ȼ��position����
		// ��ת������
		// buffer.limit(buffer.position());
		// buffer.position(0);
		// �ȼ���������������
		buffer.flip();
		// ���position��limit�غϣ���˵�����е������Ѿ��������
		// while (buffer.position() < buffer.limit()) {
		while (buffer.hasRemaining()) {
			System.out.println(buffer.get());
		}

	}

}
