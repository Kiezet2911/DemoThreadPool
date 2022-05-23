package com.demoThread.Thread.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Base64")
public class Base64Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "base64")
	private byte[] base64;

	public Base64Entity(Long id, byte[]  base64) {
		super();
		this.id = id;
		this.base64 = base64;
	}

	public Base64Entity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[]  getbase64() {
		return base64;
	}

	public void setbase64(byte[]  base64) {
		this.base64 = base64;
	}

}
