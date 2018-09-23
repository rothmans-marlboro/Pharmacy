package by.molochko.pharmacy.command.user;

import javax.servlet.http.HttpServletRequest;

import by.molochko.pharmacy.command.Command;
import by.molochko.pharmacy.manager.ConfigurationManager;

public class LogOutCommand implements Command {

	/** class log out of user */

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.index");
		// destruction of a session
		request.getSession().invalidate();
		return page;
	}
}
