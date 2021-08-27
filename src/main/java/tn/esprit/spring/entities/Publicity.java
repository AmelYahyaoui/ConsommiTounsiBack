package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table (name = "T_PUBLICITY")
public class Publicity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPublicity ;
	private String namePublicity ;
	@Temporal (TemporalType.DATE)
	private Date startDatePublicity ;
	@Temporal (TemporalType.DATE)
	private Date endDatePublicity ;
	@Enumerated (EnumType.STRING)
	private TargetPublicity targetPublicity ;
	@Enumerated (EnumType.STRING)
	private ChannelPublicity channelPublicity ;
	private float costPublicity ;
	private boolean statusPublicity ;
	private String mailOwnerPublicity ;
	private int phoneOwnerPublicity ;
	private String typePublicity ;
	private String descriptionPublicity ;
	private int InitialViewNumber ;
	private int finalViewNumber ;
	private String fileName;
	public int getIdPublicity() {
		return idPublicity;
	}
	public void setIdPublicity(int idPublicity) {
		this.idPublicity = idPublicity;
	}
	public String getNamePublicity() {
		return namePublicity;
	}
	public void setNamePublicity(String namePublicity) {
		this.namePublicity = namePublicity;
	}
	public Date getStartDatePublicity() {
		return startDatePublicity;
	}
	public void setStartDatePublicity(Date startDatePublicity) {
		this.startDatePublicity = startDatePublicity;
	}
	public Date getEndDatePublicity() {
		return endDatePublicity;
	}
	public void setEndDatePublicity(Date endDatePublicity) {
		this.endDatePublicity = endDatePublicity;
	}
	public TargetPublicity getTargetPublicity() {
		return targetPublicity;
	}
	public void setTargetPublicity(TargetPublicity targetPublicity) {
		this.targetPublicity = targetPublicity;
	}
	public ChannelPublicity getChannelPublicity() {
		return channelPublicity;
	}
	public void setChannelPublicity(ChannelPublicity channelPublicity) {
		this.channelPublicity = channelPublicity;
	}
	public float getCostPublicity() {
		return costPublicity;
	}
	public void setCostPublicity(float costPublicity) {
		this.costPublicity = costPublicity;
	}
	public boolean isStatusPublicity() {
		return statusPublicity;
	}
	public void setStatusPublicity(boolean statusPublicity) {
		this.statusPublicity = statusPublicity;
	}
	public String getMailOwnerPublicity() {
		return mailOwnerPublicity;
	}
	public void setMailOwnerPublicity(String mailOwnerPublicity) {
		this.mailOwnerPublicity = mailOwnerPublicity;
	}
	public int getPhoneOwnerPublicity() {
		return phoneOwnerPublicity;
	}
	public void setPhoneOwnerPublicity(int phoneOwnerPublicity) {
		this.phoneOwnerPublicity = phoneOwnerPublicity;
	}
	public String getTypePublicity() {
		return typePublicity;
	}
	public void setTypePublicity(String typePublicity) {
		this.typePublicity = typePublicity;
	}
	public String getDescriptionPublicity() {
		return descriptionPublicity;
	}
	public void setDescriptionPublicity(String descriptionPublicity) {
		this.descriptionPublicity = descriptionPublicity;
	}
	public int getInitialViewNumber() {
		return InitialViewNumber;
	}
	public void setInitialViewNumber(int initialViewNumber) {
		InitialViewNumber = initialViewNumber;
	}
	public int getFinalViewNumber() {
		return finalViewNumber;
	}
	public void setFinalViewNumber(int finalViewNumber) {
		this.finalViewNumber = finalViewNumber;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Publicity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Publicity(int idPublicity, String namePublicity, Date startDatePublicity, Date endDatePublicity,
			TargetPublicity targetPublicity, ChannelPublicity channelPublicity, float costPublicity,
			boolean statusPublicity, String mailOwnerPublicity, int phoneOwnerPublicity, String typePublicity,
			String descriptionPublicity, int initialViewNumber, int finalViewNumber, String fileName) {
		super();
		this.idPublicity = idPublicity;
		this.namePublicity = namePublicity;
		this.startDatePublicity = startDatePublicity;
		this.endDatePublicity = endDatePublicity;
		this.targetPublicity = targetPublicity;
		this.channelPublicity = channelPublicity;
		this.costPublicity = costPublicity;
		this.statusPublicity = statusPublicity;
		this.mailOwnerPublicity = mailOwnerPublicity;
		this.phoneOwnerPublicity = phoneOwnerPublicity;
		this.typePublicity = typePublicity;
		this.descriptionPublicity = descriptionPublicity;
		InitialViewNumber = initialViewNumber;
		this.finalViewNumber = finalViewNumber;
		this.fileName = fileName;
	}
	public Publicity(String namePublicity, Date startDatePublicity, Date endDatePublicity,
			TargetPublicity targetPublicity, ChannelPublicity channelPublicity, float costPublicity,
			boolean statusPublicity, String mailOwnerPublicity, int phoneOwnerPublicity, String typePublicity,
			String descriptionPublicity, int initialViewNumber, int finalViewNumber, String fileName) {
		super();
		this.namePublicity = namePublicity;
		this.startDatePublicity = startDatePublicity;
		this.endDatePublicity = endDatePublicity;
		this.targetPublicity = targetPublicity;
		this.channelPublicity = channelPublicity;
		this.costPublicity = costPublicity;
		this.statusPublicity = statusPublicity;
		this.mailOwnerPublicity = mailOwnerPublicity;
		this.phoneOwnerPublicity = phoneOwnerPublicity;
		this.typePublicity = typePublicity;
		this.descriptionPublicity = descriptionPublicity;
		InitialViewNumber = initialViewNumber;
		this.finalViewNumber = finalViewNumber;
		this.fileName = fileName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + InitialViewNumber;
		result = prime * result + ((channelPublicity == null) ? 0 : channelPublicity.hashCode());
		result = prime * result + Float.floatToIntBits(costPublicity);
		result = prime * result + ((descriptionPublicity == null) ? 0 : descriptionPublicity.hashCode());
		result = prime * result + ((endDatePublicity == null) ? 0 : endDatePublicity.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + finalViewNumber;
		result = prime * result + idPublicity;
		result = prime * result + ((mailOwnerPublicity == null) ? 0 : mailOwnerPublicity.hashCode());
		result = prime * result + ((namePublicity == null) ? 0 : namePublicity.hashCode());
		result = prime * result + phoneOwnerPublicity;
		result = prime * result + ((startDatePublicity == null) ? 0 : startDatePublicity.hashCode());
		result = prime * result + (statusPublicity ? 1231 : 1237);
		result = prime * result + ((targetPublicity == null) ? 0 : targetPublicity.hashCode());
		result = prime * result + ((typePublicity == null) ? 0 : typePublicity.hashCode());
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
		Publicity other = (Publicity) obj;
		if (InitialViewNumber != other.InitialViewNumber)
			return false;
		if (channelPublicity != other.channelPublicity)
			return false;
		if (Float.floatToIntBits(costPublicity) != Float.floatToIntBits(other.costPublicity))
			return false;
		if (descriptionPublicity == null) {
			if (other.descriptionPublicity != null)
				return false;
		} else if (!descriptionPublicity.equals(other.descriptionPublicity))
			return false;
		if (endDatePublicity == null) {
			if (other.endDatePublicity != null)
				return false;
		} else if (!endDatePublicity.equals(other.endDatePublicity))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (finalViewNumber != other.finalViewNumber)
			return false;
		if (idPublicity != other.idPublicity)
			return false;
		if (mailOwnerPublicity == null) {
			if (other.mailOwnerPublicity != null)
				return false;
		} else if (!mailOwnerPublicity.equals(other.mailOwnerPublicity))
			return false;
		if (namePublicity == null) {
			if (other.namePublicity != null)
				return false;
		} else if (!namePublicity.equals(other.namePublicity))
			return false;
		if (phoneOwnerPublicity != other.phoneOwnerPublicity)
			return false;
		if (startDatePublicity == null) {
			if (other.startDatePublicity != null)
				return false;
		} else if (!startDatePublicity.equals(other.startDatePublicity))
			return false;
		if (statusPublicity != other.statusPublicity)
			return false;
		if (targetPublicity != other.targetPublicity)
			return false;
		if (typePublicity == null) {
			if (other.typePublicity != null)
				return false;
		} else if (!typePublicity.equals(other.typePublicity))
			return false;
		return true;
	}

	
	
	
}