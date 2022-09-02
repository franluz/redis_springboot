package com.javatechie.redis.springdataredisexemplo;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.redis.springdataredisexemplo.entity.Product;
import com.javatechie.redis.springdataredisexemplo.repository.ProductDao;

@SpringBootApplication
@RestController
@RequestMapping("/produto")
public class SpringDataRedisExemploApplication {
	@Autowired
	private ProductDao repository;
	@PostMapping
	public Product save(@RequestBody Product produto) {
		return repository.save(produto);
		
	}
	@GetMapping
	public List<Product> getAll(){
		return repository.findAll();
	}
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id ) {
		return repository.findById(id);
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id ) {
		return repository.delete(id);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisExemploApplication.class, args);
	}

}
