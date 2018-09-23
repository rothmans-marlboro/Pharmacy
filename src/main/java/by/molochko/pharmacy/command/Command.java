package by.molochko.pharmacy.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.molochko.pharmacy.receiver.OrderReceiver;
//import by.molochko.pharmacy.receiver.OrderReceiver;
import by.molochko.pharmacy.receiver.ProductReceiver;
import by.molochko.pharmacy.receiver.RecipeReceiver;
//import by.molochko.pharmacy.receiver.RecipeReceiver;
import by.molochko.pharmacy.receiver.UserReceiver;

public interface Command {

	/**
	 * The interface for processing of actions. Each action will be processed by
	 * the class realizing this interface. 
	 */

	final static Logger LOGGER = LogManager.getLogger();

	UserReceiver USER_RECEIVER = UserReceiver.getInstance();
	ProductReceiver PRODUCT_RECEIVER = ProductReceiver.getInstance();
	RecipeReceiver RECIPE_RECEIVER = RecipeReceiver.getInstance();
	OrderReceiver ORDER_RECEIVER = OrderReceiver.getInstance();

	String execute(HttpServletRequest request);
}
