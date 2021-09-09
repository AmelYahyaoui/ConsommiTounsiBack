package tn.esprit.spring.controller;

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
import com.sun.el.parser.ParseException;

import tn.esprit.spring.ResourceNotFoundException.ResourceNotFoundException;
import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.repository.PublicityRepository;
import tn.esprit.spring.response.Response;

import tn.esprit.spring.service.IPublicityService;
import tn.esprit.spring.service.PublicityServiceImpl;
@RestController
@CrossOrigin
public class PublicityControl {
	
	@Autowired
	IPublicityService PS;
	
	@Autowired
	PublicityServiceImpl PublicityServiceImpl;
	@Autowired
	PublicityRepository pr;
	@Autowired
	ServletContext context;
	
	//http://localhost:9091/SpringMVC/servlet/show-all-publicities
	@GetMapping("/show-all-publicities")
	@ResponseBody
	public List<Publicity> getAllPubs(){
		List <Publicity> list=PS.showAll();
		return list;
	}
	
	
	//http://localhost:9091/SpringMVC/servlet/get-by-Name-all-publicities-by-name/{PubName}
	//tjib les publicité par nom 
	@GetMapping("/get-by-Name-all-publicities-by-name/{PubName}")
	@ResponseBody 
	public List<Publicity> RetrieveByName(@PathVariable("PubName")String namePub){
		return PS.GetPublicitiesByName(namePub);
	}
	
	//http://localhost:9091/SpringMVC/servlet/get-by-id-publicity/{publicityId}
	@GetMapping("get-by-id-publicity/{publicityId}")
	@ResponseBody 
	public Publicity RetrieveById(@PathVariable("publicityId")int id){
		return PS.GetPublicityById(id);
	}
	
	//http://localhost:9091/SpringMVC/servlet/add-publicity
	@PostMapping("/add-publicity")
	@ResponseBody
	public Publicity addPublicity(@RequestBody Publicity pub) {
	Publicity publicty = PS.addPublicity(pub);
	return publicty;
	}
	
	//http://localhost:9091/SpringMVC/servlet/remove-publicity/{pubId}

	@DeleteMapping("/remove-publicity/{pubId}")
	@ResponseBody
	public void removePublicity(@PathVariable("pubId") int id) {
	PS.deletePublicity(id);
	}
	
	
	//http://localhost:9091/SpringMVC/servlet/update-publicity

	@PutMapping("/update-publicity/{Idpublicity}")
	@ResponseBody
	public Publicity updatepublicity(@PathVariable(value ="Idpublicity") int Idpublicity,@RequestBody Publicity pub) {
	return PS.updatePublicity(Idpublicity,pub);
			
	}
	


// tjib les images mta3 les pub kola 
@GetMapping("/GETALLPublicitiesImages")
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

////http://localhost:9091/SpringMVC/servlet/ImgPublcities/{id}
// tjib image mta3 publicité par idPub
		@GetMapping(path="/ImgPublcities/{id}")
		 public byte[] getPhoto(@PathVariable("id") int id) throws Exception{
			 Publicity pub  = pr.findById(id).get();
			 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+pub.getFileName()));
		 }
		
		
		
		
		
		 
		 
	

}
