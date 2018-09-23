package by.molochko.pharmacy.dao;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import by.molochko.pharmacy.entity.User;
import by.molochko.pharmacy.exception.DAOException;
import by.molochko.pharmacy.receiver.ReceiverException;
import by.molochko.pharmacy.receiver.UserReceiver;

public class UserDAOTest {
	private UserReceiver USER_RECEIVER;
	private User user;

	@Before
	public void setUp() throws Exception {
		USER_RECEIVER = UserReceiver.getInstance();
		UserDao.getInstance();
		user = new User();
		user.setId(1);
		user.setLogin("admin");
		user.setPassword("admin13");
		user.setEmail("admin13@gmail.com");
		user.setAccessLevel(1);
		user.setAccount(150);
	}

	@After
	public void tearDown() throws Exception {
		USER_RECEIVER = null;
		user = null;
	}

	@Test
	public void findUserTest() throws DAOException, ReceiverException {
		User findUser = USER_RECEIVER.receiverUserFindById(1);
		assertEquals(user, findUser);
	}
}
