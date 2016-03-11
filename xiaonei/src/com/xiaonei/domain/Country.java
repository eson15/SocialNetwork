package com.xiaonei.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Country entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "country", catalog = "xiaonei")
public class Country implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<Province> provinces = new HashSet<Province>(0);
	private Set<University> universities = new HashSet<University>(0);

	// Constructors

	/** default constructor */
	public Country() {
	}

	/** minimal constructor */
	public Country(String name) {
		this.name = name;
	}

	/** full constructor */
	public Country(String name, Set<Province> provinces,
			Set<University> universities) {
		this.name = name;
		this.provinces = provinces;
		this.universities = universities;
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

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Province> getProvinces() {
		return this.provinces;
	}

	public void setProvinces(Set<Province> provinces) {
		this.provinces = provinces;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
	public Set<University> getUniversities() {
		return this.universities;
	}

	public void setUniversities(Set<University> universities) {
		this.universities = universities;
	}

}