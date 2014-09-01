package com.domain;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
public class Message extends AbstractMessage implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(String name, String content) {
		super(name, content);
	}

}
