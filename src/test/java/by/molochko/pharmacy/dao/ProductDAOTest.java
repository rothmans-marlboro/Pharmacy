package by.molochko.pharmacy.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import by.molochko.pharmacy.entity.Product;
import by.molochko.pharmacy.exception.DAOException;
import by.molochko.pharmacy.receiver.ProductReceiver;
import by.molochko.pharmacy.receiver.ReceiverException;

public class ProductDAOTest {
	private ProductReceiver PRODUCT_RECEIVER;
	private Product product;

	@Before
	public void setUp() throws Exception {
		PRODUCT_RECEIVER = ProductReceiver.getInstance();
		ProductDao.getInstance();
		product = new Product();
		product.setId(1);
		product.setName("Meldonium");
		product.setPrice(49);
		product.setDescription(
				"Meldonium positively affects the energy metabolism in the body, and also slightly activates the central nervous system. Meldonium restores the balance between the processes of supply and consumption of oxygen in cells, activates those metabolic processes in which, for energy production, requires less oxygen consumption. Under the influence of the preparation, blood vessels expand, improving the blood supply of tissues.");
		product.setPicturePath("images/products/Meldonium.jpg");
		product.setProducer("Olainfarm");
		product.setDosage(500);
		product.setDisease("Other");
	}

	@After
	public void tearDown() throws Exception {
		PRODUCT_RECEIVER = null;
		product = null;
	}

	@Test
	public void findProductTest() throws DAOException, ReceiverException {
		Product findProduct = PRODUCT_RECEIVER.receiverProductFindById(1);
		assertEquals(product, findProduct);
	}
}