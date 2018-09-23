package by.molochko.pharmacy.command.order;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;

import by.molochko.pharmacy.command.Command;
import by.molochko.pharmacy.constant.MessageKey;
import by.molochko.pharmacy.entity.Order;
import by.molochko.pharmacy.entity.Product;
import by.molochko.pharmacy.manager.ConfigurationManager;
import by.molochko.pharmacy.receiver.ReceiverException;

public class ShowConcreteOrderCommand implements Command {

	/** class for the user, where he can view his orders by number */

	@Override
	public String execute(HttpServletRequest request) {
		int orderId = Integer.parseInt(request.getParameter("order_id"));
		try {
			Order order = ORDER_RECEIVER.receiverOrderFindById(orderId);
			if (order == null) {
				request.setAttribute("message", MessageKey.FIND_ORDER_ERROR);
				return ConfigurationManager.getProperty("path.page.error");
			}
			int price = 0;
			for (Product product : order.getProducts()) {
				price += product.getPrice();
			}
			request.setAttribute("products", order.getProducts());
			request.setAttribute("full_price", price);
			request.setAttribute("order_id", order.getId());
			return ConfigurationManager.getProperty("path.page.order");
		} catch (ReceiverException e) {
			LOGGER.log(Level.ERROR, e.getMessage());
			request.setAttribute("message", MessageKey.DATABASE_ERROR);
			return ConfigurationManager.getProperty("path.page.error");
		}
	}
}