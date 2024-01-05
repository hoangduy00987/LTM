package Model.BO;

import java.util.ArrayList;

import Model.BEAN.Wife;
import Model.DAO.checkLoginDAO;

public class checkLoginBO {
checkLoginDAO checkLoginDAO = new checkLoginDAO();

public boolean isValidUser(String username, String password) {
	return checkLoginDAO.isExitUser(username,password);
	
}
public ArrayList<Wife> getWifeList(String username){
	return checkLoginDAO.getWifeList(username);
}
}
