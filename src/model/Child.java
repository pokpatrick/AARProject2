package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Child {
	private String name;
	private String city;
	private long id;
	private boolean isNaughty;
	private Present present;
	
	public Child() {}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public boolean getIsNaughty() {
		return isNaughty;
	}
	
	public void setIsNaughty(boolean isNaughty) {
		this.isNaughty = isNaughty;
	}
	
	public Present getPresent() {
		return present;
	}
	
	public void setPresent(Present present) {
		this.present = present;
	}
	
}
