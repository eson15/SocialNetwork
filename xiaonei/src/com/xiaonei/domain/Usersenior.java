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
 * Usersenior entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "usersenior", catalog = "xiaonei")
public class Usersenior implements java.io.Serializable {

	// Fields

	private Integer id;
	private Senior senior;
	private Users users;
	private Integer seniorYear;
	private String grade1;
	private String grade2;
	private String grade3;

	// Constructors

	/** default constructor */
	public Usersenior() {
	}

	/** full constructor */
	public Usersenior(Senior senior, Users users, Integer seniorYear,
			String grade1, String grade2, String grade3) {
		this.senior = senior;
		this.users = users;
		this.seniorYear = seniorYear;
		this.grade1 = grade1;
		this.grade2 = grade2;
		this.grade3 = grade3;
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
	@JoinColumn(name = "seniorSchId")
	public Senior getSenior() {
		return this.senior;
	}

	public void setSenior(Senior senior) {
		this.senior = senior;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "seniorYear")
	public Integer getSeniorYear() {
		return this.seniorYear;
	}

	public void setSeniorYear(Integer seniorYear) {
		this.seniorYear = seniorYear;
	}

	@Column(name = "grade1", length = 64)
	public String getGrade1() {
		return this.grade1;
	}

	public void setGrade1(String grade1) {
		this.grade1 = grade1;
	}

	@Column(name = "grade2", length = 64)
	public String getGrade2() {
		return this.grade2;
	}

	public void setGrade2(String grade2) {
		this.grade2 = grade2;
	}

	@Column(name = "grade3", length = 64)
	public String getGrade3() {
		return this.grade3;
	}

	public void setGrade3(String grade3) {
		this.grade3 = grade3;
	}

}