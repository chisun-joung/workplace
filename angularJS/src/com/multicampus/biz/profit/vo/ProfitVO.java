package com.multicampus.biz.profit.vo;

public class ProfitVO {
	private String year;
	private String month;
	private int profit;
	private int expenses;
	private int amount;
	private String comment;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public int getExpenses() {
		return expenses;
	}
	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "ProfitVO [year=" + year + ", month=" + month + ", profit="
				+ profit + ", expenses=" + expenses + ", amount=" + amount
				+ ", comment=" + comment + "]";
	}
}
