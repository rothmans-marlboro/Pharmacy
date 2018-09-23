package by.molochko.pharmacy.command.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;

import by.molochko.pharmacy.command.Command;
import by.molochko.pharmacy.constant.MessageKey;
import by.molochko.pharmacy.entity.Order;
import by.molochko.pharmacy.entity.User;
import by.molochko.pharmacy.manager.ConfigurationManager;
import by.molochko.pharmacy.receiver.ReceiverException;

public class ShowOrderCommand implements Command {
	
	/** class for user to show his orders*/

	@Override
	public String execute(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user==null){
			request.setAttribute("message", MessageKey.USER_ERROR);
			return ConfigurationManager.getProperty("path.page.error");
		}
		List<Order> orders = null;
		try {
			orders = ORDER_RECEIVER.receiverFindOrdersByUserId(user.getId());
			if (orders.isEmpty()) {
				request.setAttribute("message", MessageKey.SHOW_ORDERS_ERROR);
				return ConfigurationManager.getProperty("path.page.error");
			} else {
				request.setAttribute("orders", orders);
				return ConfigurationManager.getProperty("path.page.orders");
			}
		} catch (ReceiverException e) {
			LOGGER.log(Level.ERROR, e.getMessage());
			request.setAttribute("message", MessageKey.DATABASE_ERROR);
			return ConfigurationManager.getProperty("path.page.error");
		}
	}
}