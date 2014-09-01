package com.domain;

/**
 * AbstractBlog entity provides the base persistence definition of the Blog
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBlog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String content;

	// Constructors

	/** default constructor */
	public AbstractBlog() {
	}

	/** full constructor */
	public AbstractBlog(String title, String content) {
		this.title = title;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}