package com.xiaonei.domain;

import java.sql.Timestamp;
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
 * Photocomment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "photocomment", catalog = "xiaonei")
public class Photocomment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Users users;
	private Photo photo;
	private String content;
	private Timestamp comTime;

	// Constructors

	/** default constructor */
	public Photocomment() {
	}

	/** full constructor */
	public Photocomment(Users users, Photo photo, String content,
			Timestamp comTime) {
		this.users = users;
		this.photo = photo;
		this.content = content;
		this.comTime = comTime;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "photoId")
	public Photo getPhoto() {
		return this.photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Column(name = "content", length = 256)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "comTime", length = 19)
	public Timestamp getComTime() {
		return this.comTime;
	}

	public void setComTime(Timestamp comTime) {
		this.comTime = comTime;
	}

}