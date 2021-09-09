package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.UnderCategory;
import tn.esprit.spring.repository.UnderCategoryRepository;
import tn.esprit.spring.service.IUnderCategory;
import tn.esprit.spring.service.UnderCategoryImpl;
@CrossOrigin
@RestController
public class UnderCategoryRestController {

	@Autowired
	IUnderCategory IuC;
	@Autowired
	UnderCategoryRepository ucr;
	@Autowired
	UnderCategoryImpl uci;

	
	//http://localhost:9091/SpringMVC/servlet/add-underCategory

		@PostMapping("/add-underCategory/{CategoryId}")
		@ResponseBody
		public UnderCategory addUndercategory(@RequestBody UnderCategory uc,@PathVariable("CategoryId") int CategorytId) {
		UnderCategory ucat = IuC.addUndercategory(uc,CategorytId);
		return ucat;
		}
		
		
		//http://localhost:9091/SpringMVC/servlet/remove-under-category/{underCategorytId}
		@DeleteMapping("/remove-under-category/{underCategorytId}")
		@ResponseBody
		public void removeUnderCategory(@PathVariable("underCategorytId") int ucId) {
		IuC.deleteUnderCategory(ucId);
		}
		
		
		
		//http://localhost:9091/SpringMVC/servlet/update-under-category
		@PutMapping("/update-under-category")
		@ResponseBody
		public UnderCategory updateUnderCategory(@RequestBody UnderCategory uc) {
		return IuC.upadateUndercategory(uc);
				
		}
		
		
		//http://localhost:9091/SpringMVC/servlet/show-all-under-categories
		@GetMapping("/show-all-under-categories")
		@ResponseBody
		public List<UnderCategory> getAllUndercategories(){
			List <UnderCategory> list=IuC.showAllunderCategories();
			return list;
		}
	
		

		//http://localhost:9091/SpringMVC/servlet/GetByIdUnderCat/{underCategorytId}
		@GetMapping("/GetByIdUnderCat/{underCategorytId}")
		@ResponseBody
		public UnderCategory getById(@PathVariable("underCategorytId")int id){
			return IuC.findById(id);
		}
		
		//http://localhost:9091/SpringMVC/servlet/underCatProds/{idUnderCat}
		@GetMapping("/underCatProds/{idUnderCat}")
		 public List<Product> getProdsByIdUnderCat(@PathVariable("idUnderCat") int iddUnderCat){
				
				return  IuC.getByIdUnder(iddUnderCat);

		 
		 
		 }		 
	
	
	
}