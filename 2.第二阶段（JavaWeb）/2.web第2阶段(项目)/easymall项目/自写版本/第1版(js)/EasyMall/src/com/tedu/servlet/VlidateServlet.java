package com.tedu.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tedu.utils.VerifyCode;

public class VlidateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��֤�벻��ʹ�û���ͼƬ��������Ҫ�ر����������
		response.setDateHeader("Expires", -1);
		
		// ���ɹ�����Ķ���
		VerifyCode vc = new VerifyCode();
		// �����ɵ�ͼƬ���ظ�ҳ��
		vc.drawImage(response.getOutputStream());
		String code = vc.getCode();
		HttpSession session = request.getSession();
		// �����ɵ���֤����뵽session��
		session.setAttribute("code", code);
		System.out.println("ͼƬ���ɳɹ���code:"+code);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
