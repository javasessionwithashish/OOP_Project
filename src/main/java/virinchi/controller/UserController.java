package virinchi.controller;

import java.util.List;

import virinchi.model.UserTable;

//Controller 
public interface UserController {
	
boolean userSignup(String username, String password);

boolean userExists(String username, String password);

	List<UserTable>  allData();
	
}
