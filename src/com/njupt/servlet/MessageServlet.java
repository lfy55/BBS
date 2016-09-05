package com.njupt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njupt.dao.MessageDao;
import com.njupt.dao.UserDao;
import com.njupt.dao.impl.MessageDaoImpl;
import com.njupt.dao.impl.UserDaoImpl;
import com.njupt.model.Message;

/**
 * Servlet implementation class MessageServlet
 */
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MessageDao messageDao = new MessageDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		// TODO Auto-generated method stub
		String method= request.getParameter("method");
		if("List".equals(method)) {//查询所有消息集合的servlet代码块
			List<Message> messages = messageDao.searchMessageAll();
			request.setAttribute("messageList", messages);
        	request.getRequestDispatcher("main/messageList.jsp").forward(request, response);
		} else if("searchById".equals(method)) {//通过消息Id获取消息功能的servlet代码块
			int messageId = Integer.parseInt(request.getParameter("messageId"));
			Message message = new Message();
			message = messageDao.searchMessageById(messageId);
			request.setAttribute("searchMessage", message);
        	request.getRequestDispatcher("main/messageDetail.jsp").forward(request, response);
		} else if("deleteMessage".equals(method)) {//删除消息的servlet代码块
			int messageId = Integer.parseInt(request.getParameter("messageId"));
			Message message = new Message();
			message.setMessageId(messageId);
			boolean flag = messageDao.deleteMessage(message);
			request.setAttribute("deleteMessage", flag);
			List<Message> messages = messageDao.searchMessageAll();
			request.setAttribute("messageList", messages);
			request.getRequestDispatcher("main/messageList.jsp").forward(request, response);
		} else if("sendMessage".equals(method)) {//发送消息的servlet代码块
			System.out.println("111");
			UserDao userDao = new UserDaoImpl();
			String writer = request.getParameter("writer");
			int writerId = userDao.searchAdminByName(writer).getUserId();
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Message message = new Message(0,title,content,writerId,null);
			boolean flag = messageDao.sendMessage(message);
			System.out.println(flag);
			request.setAttribute("sendResult", flag);
			List<Message> messages = messageDao.searchMessageAll();
			request.setAttribute("messageList", messages);
			request.getRequestDispatcher("main/messageList.jsp").forward(request, response);
		}
		
	}

}
