package com.xbb.entity;

public class CartItem
{

	private Integer cartItemId ;
	private Integer quantity ;
	private Integer bId ;
	private Integer uId ;
	private Integer orderBy ;
	private Book book;

	public Integer getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "CartItem{" +
				"cartitemId=" + cartItemId +
				", quantity=" + quantity +
				", bId=" + bId +
				", uId=" + uId +
				", orderBy=" + orderBy +
				", book=" + book +
				'}';
	}
}
 