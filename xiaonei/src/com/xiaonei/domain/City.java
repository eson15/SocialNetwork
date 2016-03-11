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
 * City entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "city", catalog = "xiaonei")
public class City implements java.io.Serializable {

	// Fields

	private Integer id;
	private Province province;
	private String name;
	private Set<Town> towns = new HashSet<Town>(0);
	private Set<Senior> seniors = new HashSet<Senior>(0);
	private Set<Primaryschool> primaryschools = new HashSet<Primaryschool>(0);
	private Set<Techschool> techschools = new HashSet<Techschool>(0);
	private Set<Users> userses = new HashSet<Users>(0);
	private Set<Junior> juniors = new HashSet<Junior>(0);

	// Constructors

	/** default constructor */
	public City() {
	}

	/** minimal constructor */
	public City(String name) {
		this.name = name;
	}

	/** full constructor */
	public City(Province province, String name, Set<Town> towns,
			Set<Senior> seniors, Set<Primaryschool> primaryschools,
			Set<Techschool> techschools, Set<Users> userses, Set<Junior> juniors) {
		this.province = province;
		this.name = name;
		this.towns = towns;
		this.seniors = seniors;
		this.primaryschools = primaryschools;
		this.techschools = techschools;
		this.userses = userses;
		this.juniors = juniors;
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
	@JoinColumn(name = "proId")
	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
	public Set<Town> getTowns() {
		return this.towns;
	}

	public void setTowns(Set<Town> towns) {
		this.towns = towns;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
	public Set<Senior> getSeniors() {
		return this.seniors;
	}

	public void setSeniors(Set<Senior> seniors) {
		this.seniors = seniors;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
	public Set<Primaryschool> getPrimaryschools() {
		return this.primaryschools;
	}

	public void setPrimaryschools(Set<Primaryschool> primaryschools) {
		this.primaryschools = primaryschools;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
	public Set<Techschool> getTechschools() {
		return this.techschools;
	}

	public void setTechschools(Set<Techschool> techschools) {
		this.techschools = techschools;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
	public Set<Junior> getJuniors() {
		return this.juniors;
	}

	public void setJuniors(Set<Junior> juniors) {
		this.juniors = juniors;
	}

}