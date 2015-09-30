package com.model.userrole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.enums.UserProfileType;

@Entity
@Table(name="userrole")
public class UserRole {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleid")
	private Integer roleid; 
	
	@Column(name = "type", length = 15, unique = true, nullable = false)
	private String type = UserProfileType.USER.getUserProfileType();

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
