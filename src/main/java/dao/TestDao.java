package dao;

import java.util.List;

import entities.Product;

public class TestDao {
	public static void main(String[] args) {
		
		ProductDaoImpl pdi = new ProductDaoImpl();

		List<Product> p = pdi.getProductsByKeyword("");
		for (Product product : p) {
			System.out.println(product.toString());
		}
		
	}
}
