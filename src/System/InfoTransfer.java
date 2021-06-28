package System;

public class InfoTransfer {
	private String numberCardSend;
	private String numberCardReceive;
	private String nameReceive;
	private String bankNameReceive;
	private int money;
	public InfoTransfer(String numberCardSend, String numberCardReceive, String nameReceive, String bankNameReceive,
			int money) {
		super();
		this.numberCardSend = numberCardSend;
		this.numberCardReceive = numberCardReceive;
		this.nameReceive = nameReceive;
		this.bankNameReceive = bankNameReceive;
		this.money = money;
	}
	public String getNumberCardSend() {
		return numberCardSend;
	}
	public void setNumberCardSend(String numberCardSend) {
		this.numberCardSend = numberCardSend;
	}
	public String getNumberCardReceive() {
		return numberCardReceive;
	}
	public void setNumberCardReceive(String numberCardReceive) {
		this.numberCardReceive = numberCardReceive;
	}
	public String getNameReceive() {
		return nameReceive;
	}
	public void setNameReceive(String nameReceive) {
		this.nameReceive = nameReceive;
	}
	public String getBankNameReceive() {
		return bankNameReceive;
	}
	public void setBankNameReceive(String bankNameReceive) {
		this.bankNameReceive = bankNameReceive;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
}
