package com.xiaonei.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Usernet entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "usernet", catalog = "xiaonei")
public class Usernet implements java.io.Serializable {

	// Fields

	private Integer id;
	private Users users;
	private String name;
	private Short isPrimary;

	// Constructors

	/** default constructor */
	public Usernet() {
	}

	/** minimal constructor */
	public Usernet(String name) {
		this.name = name;
	}

	/** full constructor */
	public Usernet(Users users, String name, Short isPrimary) {
		this.users = users;
		this.name = name;
		this.isPrimary = isPrimary;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "name", nullable = false, length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "isPrimary")
	public Short getIsPrimary() {
		return this.isPrimary;
	}

	public void setIsPrimary(Short isPrimary) {
		this.isPrimary = isPrimary;
	}

}