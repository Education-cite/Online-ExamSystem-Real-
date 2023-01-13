package com.exam.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Category;
import com.exam.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/")
	public Category addCategory(@RequestBody Category category){
		return this.categoryService.addCategory(category);
		
		
	}
	
	
	
	@GetMapping("/{categoryId}")
	
	
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		
		return this.categoryService.getCategory(categoryId);
	}
	
	
	@GetMapping("/")
	 public Set<Category> getCategories(){
	        return this. categoryService.getCategories();
	        
	    }
	
	
	@PutMapping("/")
	
	public Category updateCategory(@RequestBody Category category) {
		
	return	this.categoryService.updateCategory(category);
	}
	
	
	
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
		Category category= new Category();
				category.setCid(categoryId);
		this.categoryService.deleteCategory(categoryId);
	}
	
	
}
