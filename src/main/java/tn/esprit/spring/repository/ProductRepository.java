package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import tn.esprit.spring.entities.Product;



public interface ProductRepository extends CrudRepository<Product, Integer>  {
	
public Product findByTitleProduct(String name);
public List<Product> findAllByTitleProduct(String name);

	@Query("SELECT 'title :',p.titleProduct ,'---->','Gain :', (p.priceProduct) - (p.buyingPriceProduct) FROM Product p")
	public List<String> getgainproduct();
	
	@Query("SELECT  SUM((((p.priceProduct) - (p.buyingPriceProduct))*(p.quantityProduct))),'DT' FROM Product p")
	public float gettotalgainproduct();
	
	@Query("SELECT  SUM(p.buyingPriceProduct) FROM Product p")
	public float getallcostproduct();
	
	@Query("SELECT  SUM(p.priceProduct) FROM Product p")
	public float getallbuyproduct();


	@Query("Select MAX(p.buyingPriceProduct)FROM Product p")
	public float MostExpensiveProduct();
	

	@Query(value = "SELECT * FROM t_product t WHERE under_category_id_undercategory=?1", nativeQuery = true)
	public List<Product> findAllProductByIdUnderCategory(@Param("id")int id);

	
	
	
}
