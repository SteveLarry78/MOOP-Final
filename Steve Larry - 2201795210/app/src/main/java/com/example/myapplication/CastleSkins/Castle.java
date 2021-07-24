package com.example.myapplication.CastleSkins;

public abstract class Castle {
	
	private String skinCastle;
	private Integer boostAmount;
	private String boostArmy;
	
	public Castle(String skinCastle, Integer boostAmount, String boostArmy) {
		super();
		this.skinCastle = skinCastle;
		this.boostAmount = boostAmount;
		this.boostArmy = boostArmy;
	}
	public String getSkinCastle() {
		return skinCastle;
	}
	public void setSkinCastle(String skinCastle) {
		this.skinCastle = skinCastle;
	}
	public Integer getBoostAmount() {
		return boostAmount;
	}
	public void setBoostAmount(Integer boostAmount) {
		this.boostAmount = boostAmount;
	}
	public String getBoostArmy() {
		return boostArmy;
	}
	public void setBoostArmy(String boostArmy) {
		this.boostArmy = boostArmy;
	}
	
	
	
	
	

}
