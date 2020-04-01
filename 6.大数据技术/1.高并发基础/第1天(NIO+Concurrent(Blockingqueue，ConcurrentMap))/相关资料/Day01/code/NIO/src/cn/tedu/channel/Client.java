package cn.tedu.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

	public static void main(String[] args) throws IOException {

		// ����һ���ͻ���ͨ��
		SocketChannel sc = SocketChannel.open();

		// ���Խ����ͨ���ֶ�����Ϊ������
		sc.configureBlocking(false);

		// ��������
		sc.connect(new InetSocketAddress("localhost", 8090));

		// ��Ϊ����Ϊ�˷�������������Ҫ��֤���ӽ���֮�����д������
		// ��ȥ�ж������Ƿ���
		while (!sc.isConnected())
			// ������������Զ����м�����������Ӷ��δ������
			// ��ô��Ϊ��������޷�����
			// ��ʱ���׳��쳣
			sc.finishConnect();

		// д������
		sc.write(ByteBuffer.wrap("hello server".getBytes()));

		// ����
		sc.close();
	}

}
