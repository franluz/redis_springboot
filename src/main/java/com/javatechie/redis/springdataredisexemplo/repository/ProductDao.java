package com.javatechie.redis.springdataredisexemplo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.javatechie.redis.springdataredisexemplo.entity.Product;

@Repository
public class ProductDao {
	private static final String HASH_KEY = "Product";
	@Autowired
	private RedisTemplate template;
	public Product save( Product produto) {
		template.opsForHash().put(HASH_KEY,produto.getId(),produto);
		return produto;
	}
	public  List<Product> findAll(){
		return template.opsForHash().values(HASH_KEY);
	}
	public Product findById(int id) {
		return (Product) template.opsForHash().get(HASH_KEY,id);
	}
	public String delete(int id) {
		 template.opsForHash().delete(HASH_KEY,id);
		 return "Produto removido !!!";
	}
	
}
