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
 * Photo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "photo", catalog = "xiaonei")
public class Photo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Album album;
	private String photo;
	private String descript;
	private Integer rtime;
	private Date addTime;
	private Set<Photocomment> photocomments = new HashSet<Photocomment>(0);

	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** full constructor */
	public Photo(Album album, String photo, String descript, Integer rtime,
			Timestamp addTime, Set<Photocomment> photocomments) {
		this.album = album;
		this.photo = photo;
		this.descript = descript;
		this.rtime = rtime;
		this.addTime = addTime;
		this.photocomments = photocomments;
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
	@JoinColumn(name = "albumId")
	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Column(name = "photo", length = 64)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "descript", length = 256)
	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	@Column(name = "rtime")
	public Integer getRtime() {
		return this.rtime;
	}

	public void setRtime(Integer rtime) {
		this.rtime = rtime;
	}

	@Column(name = "addTime", length = 19)
	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date date) {
		this.addTime = date;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "photo")
	public Set<Photocomment> getPhotocomments() {
		return this.photocomments;
	}

	public void setPhotocomments(Set<Photocomment> photocomments) {
		this.photocomments = photocomments;
	}

}