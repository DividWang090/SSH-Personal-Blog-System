package com.domain;

/**
 * Blog entity. @author MyEclipse Persistence Tools
 */
public class Blog extends AbstractBlog implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Blog() {
	}

	/** full constructor */
	public Blog(String title, String content) {
		super(title, content);
	}

}
