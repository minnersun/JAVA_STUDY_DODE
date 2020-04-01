package com.tedu.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.utils.JDBCUtils;

// ��ס�û������ܵ�ʵ��
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���봦��
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// ������ȡ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remname = request.getParameter("remname");
		
		// �ж��Ƿ�ѡ�� ����ס�û�����
		if("true".equals(remname)){
			// �����ѡ�����û�����������
			Cookie cookie = new Cookie("remname", URLEncoder.encode(username, "UTF-8"));
			//����cookie��·����ʱ��
			cookie.setPath(request.getContextPath()+"/");
			cookie.setMaxAge(60*60*24);
			// ��cookie���ص��������
			response.addCookie(cookie);
			
		}
		
		// �ж��û��������Ƿ�������ȷ
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ComboPooledDataSource source = JDBCUtils.getPoor();
		try {
			conn =source.getConnection();
			ps = conn.prepareStatement("select * from user where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(!rs.next()){
				request.setAttribute("msg", "<font color='red'>�û��������벻��ȷ</font>");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}else{
				// ����session �洢�û���
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("http://www.easymall.com");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			// �ر�����
			JDBCUtils.close(conn, ps, rs);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
