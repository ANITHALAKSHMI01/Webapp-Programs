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
public class DemoServlet1 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    public DemoServlet1()
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Demo> list=null;
		String name=request.getParameter("name");
		String email=request.getParameter("emailId");
		String password=request.getParameter("password");
		Demo demo=new Demo(name,email,password);
		DemoImplementation demoImpl=new DemoImplementation();
		try 
		{
			demoImpl.saveUser(demo);
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
		List<Demo> list=null;
		DemoImplementation demoImpl=new DemoImplementation();
		Demo demo=new Demo();
		String delete = request.getParameter("delete");
        if(delete != null && delete.equals("Delete"))
        {
        	int id=Integer.parseInt(request.getParameter("deleteId"));
        	demo.setId(id);
        	try 
        	{
        		demoImpl.deleteUser(demo);
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
	}
}
