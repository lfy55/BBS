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
 * Servlet implementation class LoginAndRegisterServlet
 */
public class LoginAndRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAndRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method= request.getParameter("method");
		if("login".equals(method)) {//登录功能的servlet代码块
			String name = request.getParameter("admin.userName");
			String pass = request.getParameter("admin.password");
			User admin = new User();
			admin.setUserName(name);
			admin.setUserPass(pass);
			admin = userDao.login(admin);
			if (admin != null) {
				request.getRequestDispatcher("main/main.jsp").forward(request,
						response);
			} else {
				request.getRequestDispatcher("main/login.jsp").forward(request,
						response);
			}
		}else if("addUser".equals(method)) {//添加用户功能的servlet代码块
			String name = request.getParameter("admin.adminName");
			String pass = request.getParameter("admin.adminPass");
			int limits = Integer.parseInt(request.getParameter("admin.adminLimits"));
			User user = new User();
			user.setUserName(name);
			user.setUserPass(pass);
			user.setUserLimits(limits);
			
			boolean flag = userDao.saveAdmin(user);
			request.setAttribute("amessage", flag);
			List<User> users =userDao.searchAdminAll();
            request.setAttribute("userList", users);
			request.getRequestDispatcher("main/userList.jsp").forward(request, response);
		}
		
	}

}
