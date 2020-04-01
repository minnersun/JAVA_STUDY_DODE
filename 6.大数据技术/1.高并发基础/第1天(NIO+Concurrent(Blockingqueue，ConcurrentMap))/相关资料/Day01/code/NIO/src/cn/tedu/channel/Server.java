package cn.tedu.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {

	public static void main(String[] args) throws IOException {

		// �����������˵�ͨ��
		ServerSocketChannel ssc = ServerSocketChannel.open();

		// ��Ҫ�����˿�
		ssc.bind(new InetSocketAddress(8090));

		// ����Ϊ������
		ssc.configureBlocking(false);

		// ��������
		SocketChannel sc = ssc.accept();

		// �ж��Ƿ���յ�������
		while (sc == null)
			sc = ssc.accept();

		// ��ȡ����
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		sc.read(buffer);
		buffer.flip();
		// ��ȡ�ֽ�����
		byte[] data = buffer.array();
		System.out.println(new String(data, 0, buffer.limit()));
		// while(buffer.hasRemaining())
		// System.out.println(buffer.get());

		// ����
		ssc.close();
	}

}
