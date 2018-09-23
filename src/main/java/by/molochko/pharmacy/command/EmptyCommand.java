package by.molochko.pharmacy.command;

import javax.servlet.http.HttpServletRequest;

import by.molochko.pharmacy.manager.ConfigurationManager;

public class EmptyCommand implements Command {
	
	/**
     * EmptyCommand will be executed if a servlet has been accessed without a command.
     * @param request HttpServletRequest request
     * @return the path of main page.
     */

    @Override
    public String execute(HttpServletRequest request) {
    /*In case of error or empty command, redirect to main page */
        String page = ConfigurationManager.getProperty("path.page.main");
        return page;
    }
}