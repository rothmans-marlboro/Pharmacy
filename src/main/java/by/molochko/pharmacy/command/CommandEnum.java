package by.molochko.pharmacy.command;

import by.molochko.pharmacy.command.locale.ChangeLocaleCommand;
import by.molochko.pharmacy.command.order.CancelOrderCommand;
import by.molochko.pharmacy.command.order.DeleteOrderCommand;
import by.molochko.pharmacy.command.order.DeliverOrderCommand;
import by.molochko.pharmacy.command.order.MakeOrderCommand;
import by.molochko.pharmacy.command.order.ShowConcreteOrderCommand;
import by.molochko.pharmacy.command.order.ShowOrderCommand;
import by.molochko.pharmacy.command.page.AddProductPageCommand;
import by.molochko.pharmacy.command.page.AllOrderPageCommand;
import by.molochko.pharmacy.command.page.EditProductPageCommand;
import by.molochko.pharmacy.command.page.GoToPageCommand;
import by.molochko.pharmacy.command.page.UserPageCommand;
import by.molochko.pharmacy.command.product.AddProductCommand;
import by.molochko.pharmacy.command.product.DeleteProductCommand;
import by.molochko.pharmacy.command.product.EditProductCommand;
import by.molochko.pharmacy.command.product.SearchProductCommand;
import by.molochko.pharmacy.command.product.ShowConcreteProductCommand;
import by.molochko.pharmacy.command.product.ShowProductCommand;
import by.molochko.pharmacy.command.recipe.ConfirmRecipeCommand;
import by.molochko.pharmacy.command.recipe.MakeRecipeCommand;
import by.molochko.pharmacy.command.recipe.ShowRecipeCommand;
import by.molochko.pharmacy.command.user.AddAccountCommand;
import by.molochko.pharmacy.command.user.AddToCartCommand;
import by.molochko.pharmacy.command.user.LogInCommand;
import by.molochko.pharmacy.command.user.LogOutCommand;
import by.molochko.pharmacy.command.user.RegisterCommand;
import by.molochko.pharmacy.command.user.RemoveFromCartCommand;
import by.molochko.pharmacy.command.user.ShowAccountCommand;
import by.molochko.pharmacy.command.user.ShowCartCommand;

public enum CommandEnum {

	ADD_ACCOUNT {
		{
			this.command = new AddAccountCommand();
		}
	},
	ADD_PRODUCT {
		{
			this.command = new AddProductCommand();
		}
	},
	ADD_PRODUCT_PAGE {
		{
			this.command = new AddProductPageCommand();
		}
	},
	ADD_TO_CART {
		{
			this.command = new AddToCartCommand();
		}
	},
	ALL_ORDERS_PAGE {
		{
			this.command = new AllOrderPageCommand();
		}
	},
	CANCEL_ORDER {
		{
			this.command = new CancelOrderCommand();
		}
	},
	CHANGE_LOCALE {
		{
			this.command = new ChangeLocaleCommand();
		}
	},
	CONFIRM_RECIPE {
		{
			this.command = new ConfirmRecipeCommand();
		}
	},
	DELETE_ORDER {
		{
			this.command = new DeleteOrderCommand();
		}
	},
	DELETE_PRODUCT {
		{
			this.command = new DeleteProductCommand();
		}
	},
	DELIVER_ORDER {
		{
			this.command = new DeliverOrderCommand();
		}
	},
	EDIT_PRODUCT {
		{
			this.command = new EditProductCommand();
		}
	},
	EDIT_PRODUCT_PAGE {
		{
			this.command = new EditProductPageCommand();
		}
	},
	GO_TO_PAGE {
		{
			this.command = new GoToPageCommand();
		}
	},
	LOGIN {
		{
			this.command = new LogInCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogOutCommand();
		}
	},
	MAKE_ORDER {
		{
			this.command = new MakeOrderCommand();
		}
	},
	MAKE_RECIPE {
		{
			this.command = new MakeRecipeCommand();
		}
	},
	REGISTRATION {
		{
			this.command = new RegisterCommand();
		}
	},
	REMOVE_FROM_CART {
		{
			this.command = new RemoveFromCartCommand();
		}
	},
	SEARCH_PRODUCTS {
		{
			this.command = new SearchProductCommand();
		}
	},
	SHOW_CART_ACTION {
		{
			this.command = new ShowCartCommand();
		}
	},
	SHOW_ACCOUNT {
		{
			this.command = new ShowAccountCommand();
		}
	},
	SHOW_LIST_RECIPES {
		{
			this.command = new ShowRecipeCommand();
		}
	},
	SHOW_ORDER {
		{
			this.command = new ShowConcreteOrderCommand();
		}
	},
	SHOW_ORDERS {
		{
			this.command = new ShowOrderCommand();
		}
	},
	SHOW_PRODUCT {
		{
			this.command = new ShowConcreteProductCommand();
		}
	},
	SHOW_PRODUCTS {
		{
			this.command = new ShowProductCommand();
		}
	},
	USERS_PAGE {
		{
			this.command = new UserPageCommand();
		}
	};

	Command command;

	public Command getCurrentCommand() {
		return command;
	}
}