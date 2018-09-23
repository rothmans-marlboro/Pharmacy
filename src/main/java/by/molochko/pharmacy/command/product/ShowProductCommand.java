package by.molochko.pharmacy.command.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;

import by.molochko.pharmacy.command.Command;
import by.molochko.pharmacy.constant.MessageKey;
import by.molochko.pharmacy.entity.Product;
import by.molochko.pharmacy.manager.ConfigurationManager;
import by.molochko.pharmacy.receiver.ReceiverException;

public class ShowProductCommand implements Command {

	/**
	 * this class describes the finding of the preparations depending on the
	 * type
	 */

	@Override
	public String execute(HttpServletRequest request) {
		String type = request.getParameter("product_type");
		try {
			List<Product> products = PRODUCT_RECEIVER.receiverProductFindType(type);
			if (products.isEmpty()) {
				request.setAttribute("message", MessageKey.FIND_PRODUCTS_ERROR);
				return ConfigurationManager.getProperty("path.page.error");
			} else {
				request.setAttribute("products", products);
				return ConfigurationManager.getProperty("path.page.products");
			}
		} catch (ReceiverException e) {
			LOGGER.log(Level.ERROR, e.getMessage());
			request.setAttribute("message", MessageKey.DATABASE_ERROR);
			return ConfigurationManager.getProperty("path.page.error");
		}
	}
}