package lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lms.controller.Controller;
import lms.controller.HttpUtil;
import lms.service.Service;

public class LoginController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
	Service s=	Service.getInstance();
	boolean result =s.login(id,pwd);
	String path = null;

	if(result)
	{ 
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		path="/menu.jsp";
	}
	else {
		path ="/index.jsp";
	}
	HttpUtil.forward(request, response, path);
	}
}
