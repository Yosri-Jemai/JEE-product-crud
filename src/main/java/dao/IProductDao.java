package dao;

import java.util.List;

import entities.Product;

public interface IProductDao {
	public Product addProduct(Product p); 
	public List<Product> getProductsByKeyword(String kw); //return a list of products where designation like %kw%
	public Product getProduct(long id); //get a product by id
	public Product updateProduct(Product p); 
	public void deleteProduct (Long id);
}
