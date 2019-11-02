package com.xbb.entity;

import java.util.Date;

public class Book
{ 
 
	private Integer bId ;
	private String bName ;
	private String author ;
	private Double price ;
	private Double currPrice ;
	private Double discount ;
	private String press ;
	private Date publishTime ;
	private Integer edition ;
	private Integer pageNum ;
	private Integer wordNum ;
	private Date printTime ;
	private Integer bookSize ;
	private String paper ;
	private String imageUri ;
	private Integer orderBy ;
	private Integer classifyId ;
	private String isbn;

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getCurrPrice() {
		return currPrice;
	}

	public void setCurrPrice(Double currPrice) {
		this.currPrice = currPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getWordNum() {
		return wordNum;
	}

	public void setWordNum(Integer wordNum) {
		this.wordNum = wordNum;
	}

	public Date getPrintTime() {
		return printTime;
	}

	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}

	public Integer getBookSize() {
		return bookSize;
	}

	public void setBookSize(Integer bookSize) {
		this.bookSize = bookSize;
	}

	public String getPaper() {
		return paper;
	}

	public void setPaper(String paper) {
		this.paper = paper;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book{" +
				"bId=" + bId +
				", bName='" + bName + '\'' +
				", author='" + author + '\'' +
				", price=" + price +
				", currPrice=" + currPrice +
				", discount=" + discount +
				", press='" + press + '\'' +
				", publishTime=" + publishTime +
				", edition=" + edition +
				", pageNum=" + pageNum +
				", wordNum=" + wordNum +
				", printTime=" + printTime +
				", bookSize=" + bookSize +
				", paper='" + paper + '\'' +
				", imageUri='" + imageUri + '\'' +
				", orderBy=" + orderBy +
				", classifyId=" + classifyId +
				", isbn='" + isbn + '\'' +
				'}';
	}
}
 