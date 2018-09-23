package by.molochko.pharmacy.command.user;

import javax.servlet.http.HttpServletRequest;

import by.molochko.pharmacy.command.Command;
import by.molochko.pharmacy.constant.MessageKey;
import by.molochko.pharmacy.entity.User;
import by.molochko.pharmacy.manager.ConfigurationManager;

public class ShowAccountCommand implements Command {

	/** class for the user so that he can see his account */

	@Override
	public String execute(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("message", MessageKey.LOG_IN_ERROR);
			return ConfigurationManager.getProperty("path.page.error");
		}
		return ConfigurationManager.getProperty("path.page.account");
	}
}