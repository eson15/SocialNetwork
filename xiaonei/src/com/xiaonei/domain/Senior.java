package com.xiaonei.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Senior entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "senior", catalog = "xiaonei")
public class Senior implements java.io.Serializable {

	// Fields

	private Integer id;
	private Town town;
	private City city;
	private String name;
	private Set<Usersenior> userseniors = new HashSet<Usersenior>(0);

	// Constructors

	/** default constructor */
	public Senior() {
	}

	/** minimal constructor */
	public Senior(String name) {
		this.name = name;
	}

	/** full constructor */
	public Senior(Town town, City city, String name, Set<Usersenior> userseniors) {
		this.town = town;
		this.city = city;
		this.name = name;
		this.userseniors = userseniors;
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
	@JoinColumn(name = "townId")
	public Town getTown() {
		return this.town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cityId")
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Column(name = "name", nullable = false, length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "senior")
	public Set<Usersenior> getUserseniors() {
		return this.userseniors;
	}

	public void setUserseniors(Set<Usersenior> userseniors) {
		this.userseniors = userseniors;
	}

}