package cn.tedu.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {

	public static void main(String[] args) throws IOException {

		// �����������˵�ͨ��
		ServerSocketChannel ssc = ServerSocketChannel.open();
		// ��Ҫ�����Ķ˿�
		ssc.bind(new InetSocketAddress(8090));
		// ����Ϊ������
		ssc.configureBlocking(false);
		// ����ѡ����
		Selector selc = Selector.open();
		// ��ͨ��ע�ᵽѡ������
		ssc.register(selc, SelectionKey.OP_ACCEPT);

		while (true) {

			// ����ѡ��
			selc.select();

			// ��ȡ���ѡ��������¼�����
			Set<SelectionKey> keys = selc.selectedKeys();
			// ��ȡ����������
			// ���ݲ�ͬ���¼����������в�ͬ�Ĵ���
			Iterator<SelectionKey> it = keys.iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();
				// �ɽ���
				if (key.isAcceptable()) {
					// ������¼��н�ͨ��ȡ����
					ServerSocketChannel sscx = (ServerSocketChannel) key.channel();
					// ��������
					SocketChannel sc = sscx.accept();
					System.out.println("���ӳɹ�~~~");
					// ע��ɶ��Լ���д�¼�
					sc.configureBlocking(false);
					sc.register(selc, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
				}
				// �ɶ�
				if (key.isReadable()) {
					// ���¼��л�ȡ��ͨ��
					SocketChannel sc = (SocketChannel) key.channel();
					// ��ȡ����
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					sc.read(buffer);
					// ��������
					byte[] data = buffer.array();
					System.out.println(new String(data, 0, buffer.position()));
					// ע����read�¼���Ŀ����Ϊ�˷�ֹ�ظ���ȡ
					// ��ȡ���ͨ���ϵ����е��¼�
					// sc.register(selc, key.interestOps() -
					// SelectionKey.OP_READ);
					sc.register(selc, key.interestOps() ^ SelectionKey.OP_READ);
				}
				// ��д
				if (key.isWritable()) {
					// ���¼��л�ȡͨ��
					SocketChannel sc = (SocketChannel) key.channel();
					// д������
					sc.write(ByteBuffer.wrap("hello client".getBytes()));
					// ע������д�¼�
					sc.register(selc, key.interestOps() - SelectionKey.OP_WRITE);
				}
				it.remove();
			}
		}
	}

}
