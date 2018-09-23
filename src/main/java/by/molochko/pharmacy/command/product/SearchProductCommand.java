package by.molochko.pharmacy.command.product;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;

import by.molochko.pharmacy.command.Command;
import by.molochko.pharmacy.constant.MessageKey;
import by.molochko.pharmacy.entity.Product;
import by.molochko.pharmacy.manager.ConfigurationManager;
import by.molochko.pharmacy.receiver.ReceiverException;

public class SearchProductCommand implements Command {

	/** product search class */

	@Override
	public String execute(HttpServletRequest request) {
		String text = request.getParameter("text_search");
		Pattern textPattern = Pattern.compile(text);
		try {
			List<Product> products = PRODUCT_RECEIVER.receiverProductFindAll();
			ArrayList<Product> findProducts = new ArrayList<Product>();
			for (Product product : products) {
				if (textPattern.matcher(product.getName()).find()) {
					findProducts.add(product);
				}
			}
			if (products.isEmpty()) {
				request.setAttribute("message", MessageKey.FIND_PRODUCT_ERROR);
				return ConfigurationManager.getProperty("path.page.error");
			} else {
				request.setAttribute("products", findProducts);
				return ConfigurationManager.getProperty("path.page.products");
			}
		} catch (ReceiverException e) {
			LOGGER.log(Level.ERROR, e.getMessage());
			request.setAttribute("message", MessageKey.DATABASE_ERROR);
			return ConfigurationManager.getProperty("path.page.error");
		}
	}
}