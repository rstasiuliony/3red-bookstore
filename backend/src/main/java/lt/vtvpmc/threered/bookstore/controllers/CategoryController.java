package lt.vtvpmc.threered.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.vtvpmc.threered.bookstore.model.Category;
import lt.vtvpmc.threered.bookstore.service.BookStoreService;

@RestController
@Api(value = "category")
@RequestMapping(value = "api/categories")
public class CategoryController {
	private BookStoreService service;
	
	@Autowired
	public CategoryController(BookStoreService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Add category", notes = "Adds new category to the BookStore")
	public void addCategory(@ApiParam @RequestBody Category category) {
		service.addCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get all categories", notes = "Returns all categories in the BookStore")
	public List<Category> getAllCategories(){
		return service.getAllCategories();
	}
	
	

}
