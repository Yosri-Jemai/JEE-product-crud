package model;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class ProductModel {
	private String keyword;
	private List<Product> p = new ArrayList<Product>();
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public List<Product> getP() {
		return p;
	}
	public void setP(List<Product> p) {
		this.p = p;
	}
	
	

}
