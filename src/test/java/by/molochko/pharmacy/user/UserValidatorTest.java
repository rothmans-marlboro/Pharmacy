package by.molochko.pharmacy.user;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import by.molochko.pharmacy.entity.User;
import by.molochko.pharmacy.validation.UserValidator;

@RunWith(Parameterized.class)
public class UserValidatorTest {
	private String login;
	private String password;
	private String email;
	private User user;

	public UserValidatorTest(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}

	@Before
	public void setUp() throws Exception {
		user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setEmail(email);
	}

	@After
	public void tearDown() throws Exception {
		user = null;
	}

	@Parameters
	public static Collection<String[]> stepUpStringvalues() {
		return Arrays.asList(new String[][] { 
			    { "Vasia", "Vasvas", "vasia@gmail.com" },
				{ "Kano", "Kombo2", "mortal98@gmail.com" } });
	}

	@Test
	public void validationTest() {
		assertNull(UserValidator.validateUser(user));
	}
}
