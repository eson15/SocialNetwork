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
 * Town entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "town", catalog = "xiaonei")
public class Town implements java.io.Serializable {

	// Fields

	private Integer id;
	private City city;
	private String name;
	private Set<Primaryschool> primaryschools = new HashSet<Primaryschool>(0);
	private Set<Techschool> techschools = new HashSet<Techschool>(0);
	private Set<Junior> juniors = new HashSet<Junior>(0);
	private Set<Senior> seniors = new HashSet<Senior>(0);

	// Constructors

	/** default constructor */
	public Town() {
	}

	/** minimal constructor */
	public Town(String name) {
		this.name = name;
	}

	/** full constructor */
	public Town(City city, String name, Set<Primaryschool> primaryschools,
			Set<Techschool> techschools, Set<Junior> juniors,
			Set<Senior> seniors) {
		this.city = city;
		this.name = name;
		this.primaryschools = primaryschools;
		this.techschools = techschools;
		this.juniors = juniors;
		this.seniors = seniors;
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
	@JoinColumn(name = "cityId")
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "town")
	public Set<Primaryschool> getPrimaryschools() {
		return this.primaryschools;
	}

	public void setPrimaryschools(Set<Primaryschool> primaryschools) {
		this.primaryschools = primaryschools;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "town")
	public Set<Techschool> getTechschools() {
		return this.techschools;
	}

	public void setTechschools(Set<Techschool> techschools) {
		this.techschools = techschools;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "town")
	public Set<Junior> getJuniors() {
		return this.juniors;
	}

	public void setJuniors(Set<Junior> juniors) {
		this.juniors = juniors;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "town")
	public Set<Senior> getSeniors() {
		return this.seniors;
	}

	public void setSeniors(Set<Senior> seniors) {
		this.seniors = seniors;
	}

}