package com.api.comp586.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "savings")
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Savings {

	@Id
	@Column(name="accountId")
	private String accoundId;
	@Column(name= "balance")
	private int balance;
	@Column(name="accountType")
	private String accountType;
	@ManyToOne
	@JoinColumn(name="userId", nullable = false)
	private Users user;
   

	public String getAccoundId() {
		return accoundId;
	}
	public void setAccoundId(String accoundId) {
		this.accoundId = accoundId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
