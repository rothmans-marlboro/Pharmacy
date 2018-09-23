package by.molochko.pharmacy.command.locale;

import javax.servlet.http.HttpServletRequest;

import by.molochko.pharmacy.command.Command;
import by.molochko.pharmacy.manager.ConfigurationManager;

public class ChangeLocaleCommand implements Command {
	
	/** class for changing locale */
	
	@Override
	public String execute(HttpServletRequest request) {
		String language = request.getParameter("locale");
		request.getSession().setAttribute("locale", language);
		return ConfigurationManager.getProperty("path.page.main");
	}
}
