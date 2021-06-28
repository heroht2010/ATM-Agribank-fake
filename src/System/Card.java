package System;

import java.io.Serializable;

public class Card implements Serializable{
	private String number_card;
	private String name;
	private String bank_name;
	private int balance;
	public Card(String number_card, String name, String bank_name, int balance) {
		super();
		this.number_card = number_card;
		this.name = name;
		this.bank_name = bank_name;
		this.balance = balance;
	}
	public String getNumber_card() {
		return number_card;
	}
	public void setNumber_card(String number_card) {
		this.number_card = number_card;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
