package com.xiaonei.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

/**
 * Useruniversity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "useruniversity", catalog = "xiaonei")
@DynamicInsert(true)
public class Useruniversity implements java.io.Serializable {

	// Fields

	private Integer id;
	private University university;
	private Users users;
	private Integer uniYear;
	private String userType;
	private String college;
	private String drom;

	// Constructors

	/** default constructor */
	public Useruniversity() {
	}

	/** full constructor */
	public Useruniversity(University university, Users users, Integer uniYear,
			String userType, String college, String drom) {
		this.university = university;
		this.users = users;
		this.uniYear = uniYear;
		this.userType = userType;
		this.college = college;
		this.drom = drom;
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
	@JoinColumn(name = "universityId")
	public University getUniversity() {
		return this.university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "uniYear")
	public Integer getUniYear() {
		return this.uniYear;
	}

	public void setUniYear(Integer uniYear) {
		this.uniYear = uniYear;
	}

	@Column(name = "userType", length = 32)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "college", length = 128)
	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	@Column(name = "drom", length = 128)
	public String getDrom() {
		return this.drom;
	}

	public void setDrom(String drom) {
		this.drom = drom;
	}

}