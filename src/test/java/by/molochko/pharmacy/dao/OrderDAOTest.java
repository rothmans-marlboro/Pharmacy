package by.molochko.pharmacy.dao;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import by.molochko.pharmacy.entity.Order;
import by.molochko.pharmacy.entity.User;
import by.molochko.pharmacy.receiver.OrderReceiver;
import by.molochko.pharmacy.receiver.ReceiverException;

public class OrderDAOTest {
	private OrderReceiver ORDER_RECEIVER;
	private Order order;
	private User user;

	@Before
	public void setUp() throws Exception {
		ORDER_RECEIVER = OrderReceiver.getInstance();
		OrderDao.getInstance();
		user = new User();
		user.setId(3);
		user.setLogin("max");
		user.setPassword("max90");
		user.setEmail("unknown@gmail.com");
		user.setAccessLevel(3);
		user.setAccount(70);
	}

	@After
	public void tearDown() throws Exception {
		ORDER_RECEIVER = null;
		order = null;
		user = null;
	}

	@Test
	public void checkUserTest() throws ReceiverException {
		order = ORDER_RECEIVER.receiverOrderFindById(1);
		assertEquals(user, order.getUser());
	}

	@Test
	public void checkStatusTest() throws ReceiverException {
		order = ORDER_RECEIVER.receiverOrderFindById(1);
		String actualStatus = order.getStatus();
		assertEquals("Active", actualStatus);
	}
}
