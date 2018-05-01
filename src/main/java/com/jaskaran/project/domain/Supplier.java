package com.jaskaran.project.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Supplier
{	
	@Id
	@Column(name="SUPPLIERID")
	private String sid;
	@Column(name="SUPPLIERNAME")
	private String sname;
	@Column(name="SUPPLIERMOBILE")
	private String smobile;
	@Column(name="SUPPLIERADDRESS")
	private String saddress;
	
	public String getSmobile() {
		return smobile;
	}
	public void setSmobile(String smobile) {
		this.smobile = smobile;
	}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
	
}
