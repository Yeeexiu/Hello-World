package com.Hugh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hugh.entity.StdEntity;
import com.Hugh.service.StdService;

@WebServlet("/AddStdServlet")
public class AddStdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String userNum = request.getParameter("userNum");
		String userName = request.getParameter("userName");
		String sex = request.getParameter("sex");
		String born = request.getParameter("born");
		String face = request.getParameter("face");
		String grade = request.getParameter("grade");
		String prof = request.getParameter("prof");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		System.out.println(">>1" + userNum + "<<");
		System.out.println(">>2" + userName + "<<");
		System.out.println(">>3" + sex + "<<");
		System.out.println(">>4" + born + "<<");
		System.out.println(">>5" + face + "<<");
		System.out.println(">>6" + grade + "<<");
		System.out.println(">>7" + prof + "<<");
		System.out.println(">>8" + phone + "<<");
		System.out.println(">>9" + email + "<<");
		System.out.println(">>10" + addr + "<<");

		StdEntity std = new StdEntity(userNum, userName, sex, born, grade, prof, face, phone, email, addr);
		StdService stdService = new StdService();
		int result = stdService.addStd(std);
		if (result > 0) {
			out.println("<script>alert('添加成功');location.href='manager.jsp'</script>");
		} else {
			out.println("<script>alert('添加失败');location.href='manager.jsp'</script>");
		}

	}

}
