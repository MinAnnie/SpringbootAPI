package com.ingeneo.APIRest.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity	
@Table(name = "users")
public class User implements Serializable{
	
	@Id
	@Column(name = "user_id")
	private int id;
	
	@Column(name ="firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@PrePersist
	public void PrePersist(){
		this.createdAt = new Date();
	}
	
	
	@PreUpdate
	public void PreUpdate() {
		this.updatedAt = new Date();
	}
	

}
