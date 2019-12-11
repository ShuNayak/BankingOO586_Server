package com.api.comp586.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pass")
@Getter
@Setter
public class Passwords {


@ManyToOne(targetEntity = Users.class)
@JoinColumn(name="userId")
private int customerId;
@Column(name="password")
private String password;
@Id
@Column(name="userName")
private String userName;
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}



}
