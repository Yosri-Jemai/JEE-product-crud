package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class ProductDaoImpl implements IProductDao{

	@Override
	public Product addProduct(Product p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps1 = connection.prepareStatement("INSERT INTO products (designation, price, quantity) VALUES (?,?,?)");
			ps1.setString(1, p.getDesignation());
			ps1.setDouble(2, p.getPrice());
			ps1.setLong(3, p.getQuantity());
			ps1.executeUpdate();
			ps1.close();
			//return the added product
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(id) AS MAX_ID FROM products");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			ps2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public List<Product> getProductsByKeyword(String kw) {
		Connection connection = SingletonConnection.getConnection();
		List<Product> products = new ArrayList<Product>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM products WHERE designation like CONCAT('%', ?, '%')");
			ps.setString(1, kw);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getLong("id"));
				p.setDesignation(rs.getString("designation"));
				p.setPrice(rs.getDouble("price"));
				p.setQuantity(rs.getLong("quantity"));
				products.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product getProduct(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProduct(Product p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Long id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM products WHERE id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
