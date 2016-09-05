package com.njupt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njupt.dao.MessageDao;
import com.njupt.dao.RevertDao;
import com.njupt.dao.UserDao;
import com.njupt.dao.impl.MessageDaoImpl;
import com.njupt.dao.impl.RevertDaoImpl;
import com.njupt.dao.impl.UserDaoImpl;
import com.njupt.model.Message;
import com.njupt.model.Revert;

/**
 * Servlet implementation class RevertServlet
 */
public class RevertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RevertDao revertDao = new RevertDaoImpl();
	MessageDao messageDao = new MessageDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if("sendRevert".equals(method)) {//发送回复的servlet代码块
			Revert revert = new Revert();
			UserDao userDao = new UserDaoImpl();
			String writer = request.getParameter("writer");
			int writerId = userDao.searchAdminByName(writer).getUserId();
			revert.setWriter(writerId);
			revert.setContent(request.getParameter("content"));
			int messageId = Integer.parseInt(request.getParameter("messageId"));
			revert.setMessageId(messageId);
			boolean flag = revertDao.sendRevert(revert);
			request.setAttribute("sendRevert", flag);
			Message message = new Message();
			message = messageDao.searchMessageById(messageId);
			request.setAttribute("searchMessage", message);
			request.getRequestDispatcher("main/messageDetail.jsp").forward(request, response);
		} else if("temp".endsWith(method)) {//临时跳转的servlet代码块
			int messageId = Integer.parseInt(request.getParameter("messageId"));
			request.setAttribute("messageId", messageId);
			request.getRequestDispatcher("main/sendRevert.jsp").forward(request, response);
		} else if("deleteRevert".equals(method)) {//删除回复的servlet代码块
			int revertId = Integer.parseInt(request.getParameter("revertId"));
			int messageId = Integer.parseInt(request.getParameter("messageId"));
			Revert revert = new Revert();
			revert.setRevertId(revertId);
			boolean flag = revertDao.deleteRevert(revert);
			request.setAttribute("deleteRevert", flag);
			Message message = new Message();
			message = messageDao.searchMessageById(messageId);
			request.setAttribute("searchMessage", message);
			request.getRequestDispatcher("main/messageDetail.jsp").forward(request, response);
		}
	}

}
