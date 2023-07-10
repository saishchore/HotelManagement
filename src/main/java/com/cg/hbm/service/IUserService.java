package com.cg.hbm.service;

import java.util.List;

import com.cg.hbm.entites.User;
import com.cg.hbm.exceptions.UserListEmptyException;
import com.cg.hbm.exceptions.UserNotFoundException;
import com.cg.hbm.pojo.MUser;

public interface IUserService 							//Service layer method
{
	public MUser removeUser(int userId);
	public List<MUser> showAllUsers();
	public MUser addUser(MUser user);
	public MUser showUserById(Integer userId);
	public MUser updateUser(MUser user);
	public MUser showUserByUsernameAndPassword(String userName, String password);
}
