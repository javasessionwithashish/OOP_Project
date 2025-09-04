package virinchi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import virinchi.controller.UserController;
import virinchi.controller.UserControllerImplements;

//URL PATTERN


//Servlet handles get request and post request
//Servlet also helps open another html/jsp page after 
//its work on request is completed

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

	req.getRequestDispatcher("index.jsp").forward(req, resp);
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	System.out.println("Post Request Incoming");
	
	System.out.println(req.getParameter("username"));
	System.out.println(req.getParameter("password"));
	
	//Request Dispatcher to Response
	//Opens another page
	
	
	String username=req.getParameter("username");
	//req- object of HTTPServletRequest
	String password=req.getParameter("password");
	
	UserControllerImplements uc = new UserControllerImplements();
	
	if(uc.userSignup(username, password)==true)
	{
req.setAttribute("signupsuccessful", "SignedUp Successfully! Please Log In");
req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	else
	{
req.setAttribute("signupfail", "Sign Up Fail!!! Try Again!");
req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	
	

		
}

}
