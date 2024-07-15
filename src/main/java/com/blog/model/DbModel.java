package com.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class DbModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="desc")
	private String desc;
	
	@Column(name="publisher")
	private String publisher;

	public DbModel() {
		// TODO Auto-generated constructor stub
	}

	public DbModel(long id, String title, String desc, String publisher) {
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.publisher = publisher;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", desc=" + desc + ", published=" + publisher + "]";
	}
	
	
	

}
