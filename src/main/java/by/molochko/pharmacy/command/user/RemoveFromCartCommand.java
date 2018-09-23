package by.molochko.pharmacy.command.user;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import by.molochko.pharmacy.command.Command;
import by.molochko.pharmacy.constant.MessageKey;
import by.molochko.pharmacy.entity.Product;
import by.molochko.pharmacy.entity.User;
import by.molochko.pharmacy.manager.ConfigurationManager;

public class RemoveFromCartCommand implements Command {

	/** class to remove a product from the shopping cart */

	@Override
	public String execute(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("message", MessageKey.USER_ERROR);
			return ConfigurationManager.getProperty("path.page.error");
		}
		int id = Integer.parseInt(request.getParameter("product_id"));
		Iterator<Product> iterator = user.getPharmacyList().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == id) {
				iterator.remove();
				break;
			}
		}
		request.getSession().setAttribute("user", user);
		request.setAttribute("message", MessageKey.REMOVE_FROM_CART_SUCCESS);
		return ConfigurationManager.getProperty("path.page.success");
	}
}