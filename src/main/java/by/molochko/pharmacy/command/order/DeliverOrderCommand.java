package by.molochko.pharmacy.command.order;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;

import by.molochko.pharmacy.command.Command;
import by.molochko.pharmacy.constant.MessageKey;
import by.molochko.pharmacy.constant.OrderStatus;
import by.molochko.pharmacy.entity.Order;
import by.molochko.pharmacy.entity.User;
import by.molochko.pharmacy.manager.ConfigurationManager;
import by.molochko.pharmacy.receiver.ReceiverException;

public class DeliverOrderCommand implements Command{
	
	/**class for the admin to deliver an order */

	@Override
	public String execute(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null || user.getAccessLevel() != 1) {
			request.setAttribute("message", MessageKey.USER_ERROR);
			return ConfigurationManager.getProperty("path.page.error");
		}
		int orderId = Integer.parseInt(request.getParameter("order_id"));
		try {
			Order order = ORDER_RECEIVER.receiverOrderFindById(orderId);
			if (order == null) {
				request.setAttribute("message", MessageKey.FIND_ORDER_ERROR);
				return ConfigurationManager.getProperty("path.page.error");
			}
			if (OrderStatus.ACTIVE.equals(order.getStatus())) {
				order.setStatus(OrderStatus.DELIVERED);
				if (ORDER_RECEIVER.receiverUpdateStatus(order)) {
					request.setAttribute("message", MessageKey.DELIVER_ORDER_SUCCESS);
					return ConfigurationManager.getProperty("path.page.success");
				}
			}
			request.setAttribute("message", MessageKey.DELIVER_ORDER_ERROR);
			return ConfigurationManager.getProperty("path.page.error");
		} catch (ReceiverException e) {
			LOGGER.log(Level.ERROR, e.getMessage());
			request.setAttribute("message", MessageKey.DATABASE_ERROR);
			return ConfigurationManager.getProperty("path.page.error");
		}
	}
}