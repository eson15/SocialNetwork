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
 * University entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "university", catalog = "xiaonei")
public class University implements java.io.Serializable {

	// Fields

	private Integer id;
	private Country country;
	private Province province;
	private String name;
	private Set<Useruniversity> useruniversities = new HashSet<Useruniversity>(
			0);

	// Constructors

	/** default constructor */
	public University() {
	}

	/** minimal constructor */
	public University(String name) {
		this.name = name;
	}

	/** full constructor */
	public University(Country country, Province province, String name,
			Set<Useruniversity> useruniversities) {
		this.country = country;
		this.province = province;
		this.name = name;
		this.useruniversities = useruniversities;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proId")
	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Column(name = "name", nullable = false, length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "university")
	public Set<Useruniversity> getUseruniversities() {
		return this.useruniversities;
	}

	public void setUseruniversities(Set<Useruniversity> useruniversities) {
		this.useruniversities = useruniversities;
	}

}