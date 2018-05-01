package com.jaskaran.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Product 
{
	@Id
	@Column(name="PRODUCTID")
	private String pid;
	@Column(name="PRODUCTNAME")
	private String pname;
	@Column(name="PRODUCTDESCRIPTION")
	private String pdescription;
	@Column(name="PRODUCTPRICE")
	private int pprice;
	@Column(name="SUPPLIERID")
	private String supplierid;
	@Column(name="CATEGORYID")
	private String categoryid;
	
	public String getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="categoryid", updatable=false, insertable=false, nullable=false)
	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="supplierid", updatable=false, insertable=false, nullable=false)
	private Supplier supplier;



	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdescription() {
		return pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}