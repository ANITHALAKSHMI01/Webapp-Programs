package com.chainsys.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.DemoImplementation;
import com.chainsys.model.Demo;
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateUser()
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Demo> list=null;
		DemoImplementation demoImpl=new DemoImplementation();
		Demo demo=new Demo();
		int id=Integer.parseInt(request.getParameter("id"));
		String email=request.getParameter("emailId");
		demo.setId(id);
		demo.setEmail(email);
		try 
		{
			demoImpl.updateUser(demo);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		try
		{
			list=demoImpl.DisplayUser();
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("displayUser.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//
	}

}
