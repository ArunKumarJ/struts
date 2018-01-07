package com.app.domain.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "ncounter")
public class NCounter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7525622519307030702L;

	@Id
	@Column(name = "NKEY")
	private String key;
	@Column(name = "START")
	private Integer start = 0;
	@Column(name = "NEXT")
	private Integer next = 0;
	@Version
	@Column(name = "VERSION")
	private Integer version;

	public NCounter() {
		// TODO Auto-generated constructor stub
	}

	public NCounter(String key, Integer start) {
		super();
		this.key = key;
		this.start = start;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getNext() {
		return next;
	}

	public void setNext(Integer next) {
		this.next = next;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
