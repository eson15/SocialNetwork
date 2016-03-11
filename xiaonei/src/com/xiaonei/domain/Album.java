package com.xiaonei.domain;

import java.sql.Timestamp;
import java.util.Date;
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
 * Album entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "album", catalog = "xiaonei")
public class Album implements java.io.Serializable {

	// Fields

	private Integer id;
	private Users users;
	private String name;//œ‡≤·√˚≥∆
	private String virname;//–Èƒ‚√˚≥∆
	private String descript;
	private String people;
	private String photo;//œ‡≤·∑‚√Ê’’∆¨
	private Date creTime;
	private Date updTime;
	private Set<Photo> photos = new HashSet<Photo>(0);

	// Constructors

	/** default constructor */
	public Album() {
	}

	/** full constructor */
	public Album(Users users, String name, String descript, String photo,
			Timestamp creTime, Timestamp updTime, Set<Photo> photos) {
		this.users = users;
		this.name = name;
		this.descript = descript;
		this.photo = photo;
		this.creTime = creTime;
		this.updTime = updTime;
		this.photos = photos;
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

	@Column(name = "name", length = 128)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "virname", length = 100)
	public String getVirname() {
		return virname;
	}

	public void setVirname(String virname) {
		this.virname = virname;
	}

	@Column(name = "descript", length = 256)
	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}
	@Column(name="people", length = 50)
	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	@Column(name = "photo", length = 64)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "creTime", length = 19)
	public Date getCreTime() {
		return this.creTime;
	}

	public void setCreTime(Date date) {
		this.creTime = date;
	}

	@Column(name = "updTime", length = 19)
	public Date getUpdTime() {
		return this.updTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "album")
	public Set<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

}