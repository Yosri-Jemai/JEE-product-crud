package dao;

import entities.Product;

public class TestDao {

	public static void main(String[] args) {
		ProductDaoImpl pdi = new ProductDaoImpl();
		Product p1 = pdi.addProduct(new Product("HP",1200,45));
		Product p2 = pdi.addProduct(new Product("Lenovo",3050,27));

	}

}
