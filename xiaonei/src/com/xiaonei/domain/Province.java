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
 * Province entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "province", catalog = "xiaonei")
public class Province implements java.io.Serializable {

	// Fields

	private Integer id;
	private Country country;
	private String name;
	private Set<University> universities = new HashSet<University>(0);
	private Set<Users> userses = new HashSet<Users>(0);
	private Set<City> cities = new HashSet<City>(0);

	// Constructors

	/** default constructor */
	public Province() {
	}

	/** minimal constructor */
	public Province(String name) {
		this.name = name;
	}

	/** full constructor */
	public Province(Country country, String name, Set<University> universities,
			Set<Users> userses, Set<City> cities) {
		this.country = country;
		this.name = name;
		this.universities = universities;
		this.userses = userses;
		this.cities = cities;
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
	@JoinColumn(name = "countryId")
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "province")
	public Set<University> getUniversities() {
		return this.universities;
	}

	public void setUniversities(Set<University> universities) {
		this.universities = universities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "province")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "province")
	public Set<City> getCities() {
		return this.cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

}