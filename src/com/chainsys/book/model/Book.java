package com.chainsys.book.model;

import java.time.LocalDate;

public class Book {
	
	private int id;
	private String name;
	private LocalDate publishedDate;
	
	public Book(int id, String name, LocalDate publishedDate) {
		super();
		this.id = id;
		this.name = name;
		this.publishedDate = publishedDate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", publishedDate=" + publishedDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((publishedDate == null) ? 0 : publishedDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (publishedDate == null) {
			if (other.publishedDate != null)
				return false;
		} else if (!publishedDate.equals(other.publishedDate))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
