package com.xbb.entity;

import java.util.List;

public class Category
{

	private Integer categoryId ;
	private String categoryName ;
	private String categoryDesc ;
	private Integer orderBy ;
	List<Classify> classifyList;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public List<Classify> getClassifyList() {
		return classifyList;
	}

	public void setClassifyList(List<Classify> classifyList) {
		this.classifyList = classifyList;
	}
}
 