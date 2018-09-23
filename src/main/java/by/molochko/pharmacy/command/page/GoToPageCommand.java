package by.molochko.pharmacy.command.page;

import javax.servlet.http.HttpServletRequest;

import by.molochko.pharmacy.command.Command;
import by.molochko.pharmacy.manager.ConfigurationManager;

public class GoToPageCommand implements Command {

	/** class for referencing elements */

	@Override
	public String execute(HttpServletRequest request) {
		String page = request.getParameter("page");
		return ConfigurationManager.getProperty(page);
	}
}
