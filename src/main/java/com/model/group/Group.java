package com.model.group;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.enums.UserProfileType;

@Entity
@Table(name="group")
public class Group {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	@Column(name="type", length=15, unique=true, nullable=false)
	private String type = UserProfileType.USER.getUserProfileType();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
