package demoAnt23.packgae;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.annotation.Generated;

@Entity
@Table(name = "excelbook")
public class EntityClass {
	
	@Column(name ="Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="Name")
    private String name;
	
	@Column(name ="PhoneNo")
	private long phoneno;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	@Override
	public String toString() {
		return "EntityClass [id=" + id + ", name=" + name + ", phoneno=" + phoneno + "]";
	}
	
	

}
