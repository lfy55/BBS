package com.njupt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njupt.dao.UserDao;
import com.njupt.dao.impl.UserDaoImpl;
import com.njupt.model.User;

/**
 * Servlet implementation class login
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("List".equals(method)) {//获取全部用户集合的servlet代码块
			List<User> users = userDao.searchAdminAll();
			System.out.println(users.size());
			request.setAttribute("userList", users);
			request.getRequestDispatcher("main/userList.jsp").forward(request,
					response);
		} else if ("deleteUser".equals(method)) {//删除用户的servlet代码块
			int userId = Integer.parseInt(request.getParameter("userId"));
			User user = new User();
			user.setUserId(userId);
			boolean flag = userDao.deleteAdmin(user);
			request.setAttribute("dmessage", flag);
			List<User> users = userDao.searchAdminAll();
			request.setAttribute("userList", users);
			request.getRequestDispatcher("main/userList.jsp").forward(request,
					response);
		} else if ("searchById".equals(method)) {//ͨ通过用户Id获取用户的servlet代码块
			int userId = Integer.parseInt(request.getParameter("userId"));
			User user = new User();
			user = userDao.searchAdminById(userId);
			request.setAttribute("user", user);
		} else if ("updateUser".equals(method)) {//删除用户的servlet代码块
			User user = new User();
			user.setUserId(Integer.parseInt(request.getParameter("userId")));
			int limits = Integer.parseInt(request.getParameter("limits"));
			int limit = 1;
			if (limits == 0) {
				limit = 1;
			} else if (limits == 1) {
				limit = 0;
			}
			user.setUserLimits(limit);
			boolean flag = userDao.updateAdmin(user);
			request.setAttribute("umessage", flag);
			List<User> users = userDao.searchAdminAll();
			request.setAttribute("userList", users);
			request.getRequestDispatcher("main/userList.jsp").forward(request,
					response);
		}
	}

}
