package virinchi.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import virinchi.model.UserTable;

public class UserControllerImplements implements UserController {

@Override
public boolean userSignup(String username, String password) {
	//Needs to add username and password to database
	try {
		Class.forName("com.mysql.jdbc.Driver");
Connection	conn=	DriverManager.getConnection("jdbc:mysql://localhost:3306/oop2","root","");

String hashPassword=DigestUtils.md5Hex(password.getBytes());

String sql="insert into usertable(username,password) values(?,?)";

PreparedStatement pstm= conn.prepareStatement(sql);
pstm.setString(1, username);
pstm.setString(2, hashPassword);

pstm.execute();

return true;


	} catch (ClassNotFoundException e) {
		System.out.println("Class bhettena mero controller ma");
	} catch (SQLException e) {
		System.out.println("Mero sql query bigryo");
	}
	
	
	
		return false;
	}

@Override
public boolean userExists(String username, String password) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/oop2","root","");
				
		String sql="select * from usertable where username=? and password=?";

		String hashPassword=DigestUtils.md5Hex(password.getBytes());
		
		PreparedStatement pstm= conn.prepareStatement(sql);
		pstm.setString(1, username);
		pstm.setString(2, hashPassword);

		ResultSet rs=	pstm.executeQuery(); //Execute Query gives a proper result
		//from the desired table with all the row data according to its column
		//ResultSet can store such information
		//If rs is the object of ResultSet as above, 
		//We can use looping to show row results one by one using the operation:
		//rs.next()

		if(rs.next())
		{
			return true;
		}
		else
		{
			return false;
		}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				
			}
			
			
			
			
			
	
	return false;
}

@Override
public List<UserTable> allData() {
	
	List<UserTable> userList= new ArrayList<>();
	try {
		Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/oop2","root","");
	
String sql="select * from usertable";
PreparedStatement pstm =conn.prepareStatement(sql);

ResultSet rs=	pstm.executeQuery();
while(rs.next())
{
	UserTable ut = new UserTable();
	ut.setId(rs.getInt("id"));
	ut.setUsername(rs.getString("username"));
	ut.setPassword(rs.getString("password"));
	
	userList.add(ut);
	
	
}


	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return userList;
}

}
