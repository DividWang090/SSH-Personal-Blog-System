package com.domain;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
public class Users extends AbstractUsers implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(Integer id, String username, String password) {
		super(id, username, password);
	}

}
