package virinchi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import virinchi.controller.UserControllerImplements;
import virinchi.model.UserTable;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
request.getRequestDispatcher("login.jsp").forward(request, response);
}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
String username= request.getParameter("username");
String password= request.getParameter("password");

UserControllerImplements uc = new UserControllerImplements();

if(uc.userExists(username, password)==true)
{
request.setAttribute("username",username);	

List<UserTable> userList=	uc.allData();

request.setAttribute("userData", userList);

HttpSession session= request.getSession();

session.setAttribute("activeUser",username);
//request attribute is local, session attribute is global

request.getRequestDispatcher("home.jsp").forward(request, response);
}
else
{
request.setAttribute("error", "Username or Password Incorrect!");	
request.getRequestDispatcher("login.jsp").forward(request, response);
}

}

}
