package com.jaskaran.project.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Category
{
	@Id
	@Column(name="CATEGORYID")
	private String cid;
	@Column(name="CATEGORYNAME")
	private String cname;
	@Column(name="CATEGORYDESCRIPTION")
	private String cdescription;
	
	@OneToMany(mappedBy="category", fetch = FetchType.EAGER)
	private Set<Product> products;
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdescription() {
		return cdescription;
	}
	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
}