package com.example.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoRest {

	@Autowired
	private ProdutoDao produtoDao;
	
	@GetMapping
	public List<Produto> get(){
		return produtoDao.findAll();
	}
	
	@GetMapping("/{id}")
	public Produto get(@PathVariable("id") Integer id) {
		return produtoDao.findById(id).get();
	}
	
	@PostMapping
	public void post(@RequestBody Produto produto) {
		produtoDao.save(produto);
	}
	
	@PutMapping("/{id}")
	public void updateProduct(@PathVariable Integer id, @RequestBody Produto produto) {
	    produto.setId(id);
	    produtoDao.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		produtoDao.deleteById(id);
}
}