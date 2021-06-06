package lms.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.controller.Controller;

import lms.controller.JoinController;
import lms.controller.LoginController;

public class FrontController {
	HashMap<String, Controller> map = null;
	//@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map = new HashMap<String, Controller>();
		map.put("/join.do",new JoinController());
		map.put("/login.do",new LoginController());
	}
	//@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path =uri.substring(contextPath.length());
		
		Controller cont = map.get(path);
		cont.execute(req, resp);
}
}