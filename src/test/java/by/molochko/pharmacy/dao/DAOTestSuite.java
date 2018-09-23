package by.molochko.pharmacy.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({ OrderDAOTest.class, ProductDAOTest.class, UserDAOTest.class })
@RunWith(Suite.class)
public class DAOTestSuite {
}
