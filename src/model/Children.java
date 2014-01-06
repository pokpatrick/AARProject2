package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({Child.class})
public class Children extends ArrayList<Child>{
	private static final long serialVersionUID = 1L;

	public Children() {}
	
	@XmlElement(name="child")
	public List<Child> getChildren() {
		return this;
	}
}
