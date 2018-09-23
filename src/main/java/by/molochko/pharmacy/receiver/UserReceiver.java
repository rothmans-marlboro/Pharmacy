package by.molochko.pharmacy.receiver;

import java.util.ArrayList;
import java.util.List;

import by.molochko.pharmacy.dao.UserDao;
import by.molochko.pharmacy.entity.User;
import by.molochko.pharmacy.exception.DAOException;

public class UserReceiver {

	private UserDao userDao = UserDao.getInstance();

	private static UserReceiver instance = new UserReceiver();

	private UserReceiver() {
	}

	public static UserReceiver getInstance() {
		return instance;
	}

	public List<User> receiverUserFindAll() throws ReceiverException {
		ArrayList<User> users = null;
		try {
			users = (ArrayList<User>) instance.userDao.findAll();
		} catch (DAOException e) {
			new ReceiverException("Exception in receiverUserFindAll method", e);
		}
		return users;
	}

	public User receiverUserFindById(Integer id) throws ReceiverException {
		User user = null;
		try {
			user = instance.userDao.findEntityById(id);
		} catch (DAOException e) {
			new ReceiverException("Exception in receiverUserfindById method", e);
		}
		return user;
	}

	public User receiverUserFindByLoginAndPassword(String login, String password) throws ReceiverException {
		User user = null;
		try {
			user = instance.userDao.findEntityByLoginAndPassword(login, password);
		} catch (DAOException e) {
			new ReceiverException("Exception in receiverUserfindByLoginAndPassword method", e);
		}
		return user;
	}
	
	public boolean receiverUserDelete(Integer id) throws ReceiverException {
		try {
			instance.userDao.delete(id);
		} catch (DAOException e){
			new ReceiverException("Exception in receiverUserDelete method", e);
		}
		return true;
	}
	
	public boolean receiverUserDelete(User user) throws ReceiverException {
		try {
			instance.userDao.delete(user);
		} catch (DAOException e){
			new ReceiverException("Exception in receiverUserDelete method", e);
		}
		return true;
	}
	
	public boolean receiverUserAdd(User user) throws ReceiverException{
		try {
			instance.userDao.add(user);
		} catch (DAOException e){
			new ReceiverException("Exception in receiverUserAdd method", e);
		}
		return true;
	}
	
	public User receiverUserUpdate(User user) throws ReceiverException{
		try {
			instance.userDao.update(user);
		} catch (DAOException e){
			new ReceiverException("Exception in receiverUserUpdate method", e);
		}
		return user;
	}
	
	public User receiverUserfindByLogin(String login) throws ReceiverException{
		User user = null;
		try{
			instance.userDao.findEntityByLogin(login);
		} catch (DAOException e){
			new ReceiverException("Exception in receiverUserfindByLogin method", e);
		}
		return user;
	}
}