package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="",propOrder={})
@XmlRootElement(name = "present")
public class Present {
	private long id;
	private String name;
	private boolean isValid = false;
	private boolean isMade = false;

	public Present() {}
	
	public Present(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long value) {
		this.id = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	public boolean getIsMade() {
		return isMade;
	}

	public void setIsMade(boolean isMade) {
		this.isMade = isMade;
	}
	
}