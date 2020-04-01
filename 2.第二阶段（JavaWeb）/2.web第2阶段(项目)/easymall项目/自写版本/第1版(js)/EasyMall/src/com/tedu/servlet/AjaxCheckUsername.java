package com.tedu.servlet;

import java.io.IOException;
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

public class AjaxCheckUsername extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���봦��
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		// ��ȡ����
		String username = request.getParameter("username");
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// ��ȡ���ӳ�
		ComboPooledDataSource source = JDBCUtils.getPoor();
		try {
			conn = source.getConnection();
			ps = conn.prepareStatement("select * from user where username=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				response.getWriter().write("�û��Ѵ���");
			}else{
				response.getWriter().write("�û�������ʹ��");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Cookie cookie = new Cookie("username", username);
		cookie.setPath("");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
