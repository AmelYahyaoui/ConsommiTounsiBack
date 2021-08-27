package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table (name = "T_UNDER_CATEGORY")
public class UnderCategory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idUnderCategory ;
	private String nameUnderCategory ;
	
	public UnderCategory(String nameUnderCategory, Set<Product> products) {
		super();
		this.nameUnderCategory = nameUnderCategory;
		Products = products;
	}
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="UnderCategory")
	private Set<Product> Products;
	
	@ManyToOne
	private Category category;
	
	
	
	public UnderCategory(String nameUnderCategory, Set<Product> products, Category category) {
		super();
		this.nameUnderCategory = nameUnderCategory;
		Products = products;
		this.category = category;
	}
	@JsonIgnore
	public Set<Product> getProducts() {
		return Products;
	}
	@JsonIgnore
	public void setProducts(Set<Product> products) {
		Products = products;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getIdUnderCategory() {
		return idUnderCategory;
	}
	public void setIdUnderCategory(int idUnderCategory) {
		this.idUnderCategory = idUnderCategory;
	}
	public String getNameUnderCategory() {
		return nameUnderCategory;
	}
	public void setNameUnderCategory(String nameUnderCategory) {
		this.nameUnderCategory = nameUnderCategory;
	}
	
	
	
	public UnderCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UnderCategory(int idUnderCategory, String nameUnderCategory) {
		super();
		this.idUnderCategory = idUnderCategory;
		this.nameUnderCategory = nameUnderCategory;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUnderCategory;
		result = prime * result + ((nameUnderCategory == null) ? 0 : nameUnderCategory.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnderCategory other = (UnderCategory) obj;
		if (idUnderCategory != other.idUnderCategory)
			return false;
		if (nameUnderCategory == null) {
			if (other.nameUnderCategory != null)
				return false;
		} else if (!nameUnderCategory.equals(other.nameUnderCategory))
			return false;
		return true;
	}
	
	
	

	
}