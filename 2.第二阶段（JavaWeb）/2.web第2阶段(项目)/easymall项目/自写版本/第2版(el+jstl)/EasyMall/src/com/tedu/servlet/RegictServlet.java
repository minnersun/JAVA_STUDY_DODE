package com.tedu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.utils.JDBCUtils;
import com.tedu.utils.WEBUtils;

public class RegictServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���봦��
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		// ��ȡҳ���еĲ���
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String valistr = request.getParameter("valistr");
		
		// �жϲ����Ƿ�Ϊ��
		if(WEBUtils.isNull(username)){
			request.setAttribute("msg", "�û�������Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WEBUtils.isNull(password)){
			request.setAttribute("msg", "���벻��Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WEBUtils.isNull(password2)){
			request.setAttribute("msg", "ȷ�����벻��Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WEBUtils.isNull(nickname)){
			request.setAttribute("msg", "�ǳƲ���Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WEBUtils.isNull(email)){
			request.setAttribute("msg", "���䲻��Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(WEBUtils.isNull(valistr)){
			request.setAttribute("msg", "��֤�벻��Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		
		// ����һ����У��
		if(password==""||password2==""||(!password.equals(password2))){
			request.setAttribute("msg", "�������벻һ��");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		// ����У��
		Pattern pattern = Pattern.compile("[\\w]+@[\\w]+(.[\\w]+){1,3}");
		Matcher matcher = pattern.matcher(email);
		if(!matcher.matches()){
			request.setAttribute("msg", "�����ʽ����");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		// ��֤����֤
		// ��ȡ������е�session
		HttpSession session = request.getSession();
		String code = (String)session.getAttribute("code");
		// �Ƚ��û��������֤������ɵ���֤���ֵ
		if(!code.equalsIgnoreCase(valistr)){
			request.setAttribute("msg", "��֤����������");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
				
		
		// �������
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// ��ȡ���ӳض���
		ComboPooledDataSource source = JDBCUtils.getPoor();
		// �������ݿ�
		try {
			conn = source.getConnection();
			// ��ѯ�û���
			ps = conn.prepareStatement("select * from user where username=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				request.setAttribute("msg", "�û����Ѵ���");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}else{
				ps = conn.prepareStatement("insert into user values(null,?,?,?,?)");
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, nickname);
				ps.setString(4, email);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, ps, rs);
		}
		response.getWriter().write("<h1><font color='red'>ע��ɹ�,��ҳ��������󵽴�ս��</font><h1>");
		response.setHeader("refresh","3;url=http://www.easymall.com");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
