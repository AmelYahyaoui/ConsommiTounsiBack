package tn.esprit.spring.controller;


import tn.esprit.spring.service.IProductService;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.Context;
import io.netty.handler.ipfilter.IpSubnetFilter;
import tn.esprit.spring.ResourceNotFoundException.ResourceNotFoundException;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.UnderCategory;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.repository.UnderCategoryRepository;
import tn.esprit.spring.response.Response;


@RestController
@CrossOrigin
public class ProductControl {

	@Autowired
	IProductService productService;
	@Autowired IProductService IPS;
	@Autowired
	ProductRepository PR;
	@Autowired
	ServletContext context;
	@Autowired
	UnderCategoryRepository ucr;
  
  
  @Autowired
	ProductRepository pr; 
	
	//http://localhost:9091/SpringMVC/servlet/show-all-products
  //st3mlneha fy tous les  produit
	@GetMapping("/show-all-products")
	@ResponseBody
	public List<Product> getAllProducts(){
		List <Product> list=productService.showAll();
		return list;
	}
	
	//http://localhost:9091/SpringMVC/servlet/GetByOneName/{productName}
	//st3melneha fy recherche byname lel produit wa7da
	@GetMapping("/GetByOneName/{productName}")
	@ResponseBody 
	public Product RetrieveByName(@PathVariable("productName")String nameProd){
		return productService.GetByName(nameProd);
	}
	
	
	//http://localhost:9091/SpringMVC/servlet/GetById/{productId}
	//st3mleha fy affichage mte3 component edit product
	@GetMapping("GetById/{productId}")
	@ResponseBody 
	public Product RetrieveById(@PathVariable("productId")int id){
		return productService.GetById(id);
	}
	
	
	//http://localhost:9091/SpringMVC/servlet/ShowAllByName/{productName}
	//recherche barcha produiyet 3ndhom nafs name
	@GetMapping("ShowAllByName/{productName}")
	@ResponseBody 
	public List<Product> RetrieveAllByName(@PathVariable("productName")String name){
		return productService.GetAllByName(name);
	}
	

	
	
	//http://localhost:9091/SpringMVC/servlet/add-product/{iduc}
	//ajouter produit
	@PostMapping("/add-product/{iduc}")
	//uc:under categorie
	@ResponseBody
	public Product addProduct(@RequestBody Product p,@PathVariable("iduc")int iduc) {
	Product prod = productService.addProduct(p,iduc);
	return prod;
	}
	
	
	
	//http://localhost:9091/SpringMVC/servlet/remove-product/{productId}	
	//delet product
	@DeleteMapping("/remove-product/{productId}")
	@ResponseBody
	public void removeProduct(@PathVariable("productId") int id) {
	productService.deleteProduct(id);
	}
	
	

	

	//http://localhost:9091/SpringMVC/servlet/update-Product
//update 
	@PutMapping("/update-Product/{id}")
	@ResponseBody
	public Product updateProduct(@PathVariable(value = "id") int id,@RequestBody Product p) {
	return productService.updateProduct(id, p);  
			
	}
	
	
		
		//tjib les image kolla mta3 les produits 
		@GetMapping("/GETALLS")
		public ResponseEntity<List<String>> getALL(){
			 List<String> listArt = new ArrayList<String>();
			String filesPath= context.getRealPath("/Images");
					File filefolder=new File(filesPath);
					if (filefolder != null)
					{
						for (File file :filefolder.listFiles())
						{
							if(!file.isDirectory())
							{
							  String encodeBase64 = null;
							  try { String extension = FilenameUtils.getExtension(file.getName());
							  FileInputStream fileInputStream = new FileInputStream(file);
						     
							  byte[] bytes = new byte[(int)file.length()];
						      fileInputStream.read(bytes);
						      encodeBase64 = Base64.getEncoder().encodeToString(bytes);
						      listArt.add("data:image/"+extension+";base64,"+encodeBase64);
						      fileInputStream.close();
						      
						      
						  }catch (Exception e){
							  
						  }
						}
					}
				 }
					return new ResponseEntity<List<String>>(listArt,HttpStatus.OK);
		}
		
		// http://localhost:9091/SpringMVC/servlet/Imgarticles/{id}
		//Imgarticles:njibo beha l'image mte3 produit
		@GetMapping(path="/Imgarticles/{id}")
		 public byte[] getPhoto(@PathVariable("id") int id) throws Exception{
			 Product prod  = pr.findById(id).get();
			 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+prod.getFileName()));
		 }
		// http://localhost:9091/SpringMVC/servlet/prod/{id}
		@GetMapping("/prod/{id}")
		public ResponseEntity<Product> getArticleById(@PathVariable(value = "id") int Id)
				throws ResourceNotFoundException {
			Product prod = pr.findById(Id)
					.orElseThrow(() -> new ResourceNotFoundException("Categorie not found for this id :: " + Id));
			return ResponseEntity.ok().body(prod);
		}
		
		 @PostMapping("/Productss")
		 public ResponseEntity<Response> createProduct (@RequestParam("file") MultipartFile file,int id,
				 @RequestParam("article") String product) throws JsonParseException , JsonMappingException , Exception
		 {
			 
	        Product prod = new ObjectMapper().readValue(product, Product.class);
	        UnderCategory uc=ucr.findById(id).get();
	        prod.setUnderCategory(uc);
	        
	        boolean isExit = new File(context.getRealPath("/Images/")).exists();
	        if (!isExit)
	        {
	        	new File (context.getRealPath("/Images/")).mkdir();
	        	System.out.println("mk dir.............");
	        }
	        String filename = file.getOriginalFilename();
	        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
	        try
	        {
	        	System.out.println("Image");
	        	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
	        	 
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }

	       
	        prod.setFileName(newFileName);
	        Product art = pr.save(prod);
	        if (art != null)
	        {
	        	return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
	        }
	        else
	        {
	        	return new ResponseEntity<Response>(new Response ("Article not saved"),HttpStatus.BAD_REQUEST);	
	        }
		 }
		 
		 
		 
		 
}
