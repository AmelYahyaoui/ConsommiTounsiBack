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

@Entity
@Table(name="T_PRODUCT")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct ;
	private String titleProduct ;
	private String descriptionProduct ;
	private int quantityProduct ;
	private float priceProduct ;
	private String barcodeProduct ;
	private float weightProduct ;
	private float buyingPriceProduct ;
	private int maxQuantityProduct ;
	private String fileName;

	public Product(int idProduct, String titleProduct, String descriptionProduct, int quantityProduct,
			float priceProduct, String barcodeProduct, float weightProduct, float buyingPriceProduct,
			int maxQuantityProduct, String fileName, tn.esprit.spring.entities.UnderCategory underCategory) {
		super();
		this.idProduct = idProduct;
		this.titleProduct = titleProduct;
		this.descriptionProduct = descriptionProduct;
		this.quantityProduct = quantityProduct;
		this.priceProduct = priceProduct;
		this.barcodeProduct = barcodeProduct;
		this.weightProduct = weightProduct;
		this.buyingPriceProduct = buyingPriceProduct;
		this.maxQuantityProduct = maxQuantityProduct;
		this.fileName = fileName;
		UnderCategory = underCategory;
	}
	@ManyToOne
	UnderCategory UnderCategory;
	
	
	
	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getTitleProduct() {
		return titleProduct;
	}
	public void setTitleProduct(String titleProduct) {
		this.titleProduct = titleProduct;
	}
	public String getDescriptionProduct() {
		return descriptionProduct;
	}
	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}
	public int getQuantityProduct() {
		return quantityProduct;
	}
	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}
	public float getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}
	public String getBarcodeProduct() {
		return barcodeProduct;
	}
	public void setBarcodeProduct(String barcodeProduct) {
		this.barcodeProduct = barcodeProduct;
	}
	public float getWeightProduct() {
		return weightProduct;
	}
	public void setWeightProduct(float weightProduct) {
		this.weightProduct = weightProduct;
	}
	public float getBuyingPriceProduct() {
		return buyingPriceProduct;
	}
	public void setBuyingPriceProduct(float buyingPriceProduct) {
		this.buyingPriceProduct = buyingPriceProduct;
	}
	public int getMaxQuantityProduct() {
		return maxQuantityProduct;
	}
	public void setMaxQuantityProduct(int maxQuantityProduct) {
		this.maxQuantityProduct = maxQuantityProduct;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int idProduct, String titleProduct, String descriptionProduct, int quantityProduct,
			float priceProduct, String barcodeProduct, float weightProduct, float buyingPriceProduct,
			int maxQuantityProduct, String fileName) {
		super();
		this.idProduct = idProduct;
		this.titleProduct = titleProduct;
		this.descriptionProduct = descriptionProduct;
		this.quantityProduct = quantityProduct;
		this.priceProduct = priceProduct;
		this.barcodeProduct = barcodeProduct;
		this.weightProduct = weightProduct;
		this.buyingPriceProduct = buyingPriceProduct;
		this.maxQuantityProduct = maxQuantityProduct;
		this.fileName = fileName;
	}
	public Product(String titleProduct, String descriptionProduct, int quantityProduct, float priceProduct,
			String barcodeProduct, float weightProduct, float buyingPriceProduct, int maxQuantityProduct,
			String fileName) {
		super();
		this.titleProduct = titleProduct;
		this.descriptionProduct = descriptionProduct;
		this.quantityProduct = quantityProduct;
		this.priceProduct = priceProduct;
		this.barcodeProduct = barcodeProduct;
		this.weightProduct = weightProduct;
		this.buyingPriceProduct = buyingPriceProduct;
		this.maxQuantityProduct = maxQuantityProduct;
		this.fileName = fileName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barcodeProduct == null) ? 0 : barcodeProduct.hashCode());
		result = prime * result + Float.floatToIntBits(buyingPriceProduct);
		result = prime * result + ((descriptionProduct == null) ? 0 : descriptionProduct.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + idProduct;
		result = prime * result + maxQuantityProduct;
		result = prime * result + Float.floatToIntBits(priceProduct);
		result = prime * result + quantityProduct;
		result = prime * result + ((titleProduct == null) ? 0 : titleProduct.hashCode());
		result = prime * result + Float.floatToIntBits(weightProduct);
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
		Product other = (Product) obj;
		if (barcodeProduct == null) {
			if (other.barcodeProduct != null)
				return false;
		} else if (!barcodeProduct.equals(other.barcodeProduct))
			return false;
		if (Float.floatToIntBits(buyingPriceProduct) != Float.floatToIntBits(other.buyingPriceProduct))
			return false;
		if (descriptionProduct == null) {
			if (other.descriptionProduct != null)
				return false;
		} else if (!descriptionProduct.equals(other.descriptionProduct))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (idProduct != other.idProduct)
			return false;
		if (maxQuantityProduct != other.maxQuantityProduct)
			return false;
		if (Float.floatToIntBits(priceProduct) != Float.floatToIntBits(other.priceProduct))
			return false;
		if (quantityProduct != other.quantityProduct)
			return false;
		if (titleProduct == null) {
			if (other.titleProduct != null)
				return false;
		} else if (!titleProduct.equals(other.titleProduct))
			return false;
		if (Float.floatToIntBits(weightProduct) != Float.floatToIntBits(other.weightProduct))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", titleProduct=" + titleProduct + ", descriptionProduct="
				+ descriptionProduct + ", quantityProduct=" + quantityProduct + ", priceProduct=" + priceProduct
				+ ", barcodeProduct=" + barcodeProduct + ", weightProduct=" + weightProduct + ", buyingPriceProduct="
				+ buyingPriceProduct + ", maxQuantityProduct=" + maxQuantityProduct + ", fileName=" + fileName + "]";
	}
	public Product(String titleProduct, String descriptionProduct, int quantityProduct, float priceProduct,
			String barcodeProduct, float weightProduct, float buyingPriceProduct, int maxQuantityProduct,
			String fileName, tn.esprit.spring.entities.UnderCategory underCategory) {
		super();
		this.titleProduct = titleProduct;
		this.descriptionProduct = descriptionProduct;
		this.quantityProduct = quantityProduct;
		this.priceProduct = priceProduct;
		this.barcodeProduct = barcodeProduct;
		this.weightProduct = weightProduct;
		this.buyingPriceProduct = buyingPriceProduct;
		this.maxQuantityProduct = maxQuantityProduct;
		this.fileName = fileName;
		UnderCategory = underCategory;
	}
	public UnderCategory getUnderCategory() {
		return UnderCategory;
	}
	public void setUnderCategory(UnderCategory underCategory) {
		UnderCategory = underCategory;
	}
	





}