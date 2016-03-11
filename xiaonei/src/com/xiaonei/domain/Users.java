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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "xiaonei", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@DynamicInsert(true)//生成动态SQL语句，即在插入和修改数据的时候,语句中只包括要插入或者修改的字段。默认字段也会加进去
public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private Techschool techschool;
	private Junior junior;
	private Province province;
	private City city;
	private Primaryschool primaryschool;
	private String email;
	private String name;
	private String pwd;
	private String photo;
	private String sex;
	private Date birth;
	private String tel;
	private String mobile;
	private String oicq;
	private String msn;
	private String website;
	private Integer techSchYear;
	private Integer juniorYear;
	private Integer primaryYear;
	private String interest;
	private String music;
	private String movie;
	private String game;
	private String cartoon;
	private String sport;
	private String book;
	private String assn;
	private Integer visited;
	private String doing;
	private Short online;
	private Date registerDate;
	private Date loginDate;
	private Short level;
	private Short locked;
	private Set<Usersenior> userseniors = new HashSet<Usersenior>(0);
	private Set<Photocomment> photocomments = new HashSet<Photocomment>(0);
	private Set<Useruniversity> useruniversities = new HashSet<Useruniversity>(
			0);
	private Set<Usernet> usernets = new HashSet<Usernet>(0);
	private Set<Album> albums = new HashSet<Album>(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String email, String name, String pwd) {
		this.email = email;
		this.name = name;
		this.pwd = pwd;
	}

	/** full constructor */
	public Users(Techschool techschool, Junior junior, Province province,
			City city, Primaryschool primaryschool, String email, String name,
			String pwd, String photo, String sex, Date birth, String tel,
			String mobile, String oicq, String msn, String website,
			Integer techSchYear, Integer juniorYear, Integer primaryYear,
			String interest, String music, String movie, String game,
			String cartoon, String sport, String book, String assn,
			Integer visited, String doing, Short online,
			Timestamp registerDate, Timestamp loginDate, Short level,
			Short locked, Set<Usersenior> userseniors,
			Set<Photocomment> photocomments,
			Set<Useruniversity> useruniversities, Set<Usernet> usernets,
			Set<Album> albums) {
		this.techschool = techschool;
		this.junior = junior;
		this.province = province;
		this.city = city;
		this.primaryschool = primaryschool;
		this.email = email;
		this.name = name;
		this.pwd = pwd;
		this.photo = photo;
		this.sex = sex;
		this.birth = birth;
		this.tel = tel;
		this.mobile = mobile;
		this.oicq = oicq;
		this.msn = msn;
		this.website = website;
		this.techSchYear = techSchYear;
		this.juniorYear = juniorYear;
		this.primaryYear = primaryYear;
		this.interest = interest;
		this.music = music;
		this.movie = movie;
		this.game = game;
		this.cartoon = cartoon;
		this.sport = sport;
		this.book = book;
		this.assn = assn;
		this.visited = visited;
		this.doing = doing;
		this.online = online;
		this.registerDate = registerDate;
		this.loginDate = loginDate;
		this.level = level;
		this.locked = locked;
		this.userseniors = userseniors;
		this.photocomments = photocomments;
		this.useruniversities = useruniversities;
		this.usernets = usernets;
		this.albums = albums;
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
	@JoinColumn(name = "techSch")
	public Techschool getTechschool() {
		return this.techschool;
	}

	public void setTechschool(Techschool techschool) {
		this.techschool = techschool;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "juniorSch")
	public Junior getJunior() {
		return this.junior;
	}

	public void setJunior(Junior junior) {
		this.junior = junior;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "homePro")
	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "homeCity")
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "primarySch")
	public Primaryschool getPrimaryschool() {
		return this.primaryschool;
	}

	public void setPrimaryschool(Primaryschool primaryschool) {
		this.primaryschool = primaryschool;
	}

	@Column(name = "email", unique = true, nullable = false, length = 128)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "name", nullable = false, length = 128)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pwd", nullable = false, length = 128)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "photo", length = 128)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "sex", length = 16)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birth", length = 10)
	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Column(name = "tel", length = 32)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "mobile", length = 32)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "oicq", length = 32)
	public String getOicq() {
		return this.oicq;
	}

	public void setOicq(String oicq) {
		this.oicq = oicq;
	}

	@Column(name = "msn", length = 128)
	public String getMsn() {
		return this.msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	@Column(name = "website", length = 128)
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Column(name = "techSchYear")
	public Integer getTechSchYear() {
		return this.techSchYear;
	}

	public void setTechSchYear(Integer techSchYear) {
		this.techSchYear = techSchYear;
	}

	@Column(name = "juniorYear")
	public Integer getJuniorYear() {
		return this.juniorYear;
	}

	public void setJuniorYear(Integer juniorYear) {
		this.juniorYear = juniorYear;
	}

	@Column(name = "primaryYear")
	public Integer getPrimaryYear() {
		return this.primaryYear;
	}

	public void setPrimaryYear(Integer primaryYear) {
		this.primaryYear = primaryYear;
	}

	@Column(name = "interest", length = 256)
	public String getInterest() {
		return this.interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	@Column(name = "music", length = 256)
	public String getMusic() {
		return this.music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	@Column(name = "movie", length = 256)
	public String getMovie() {
		return this.movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	@Column(name = "game", length = 256)
	public String getGame() {
		return this.game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	@Column(name = "cartoon", length = 256)
	public String getCartoon() {
		return this.cartoon;
	}

	public void setCartoon(String cartoon) {
		this.cartoon = cartoon;
	}

	@Column(name = "sport", length = 256)
	public String getSport() {
		return this.sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	@Column(name = "book", length = 256)
	public String getBook() {
		return this.book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	@Column(name = "assn", length = 256)
	public String getAssn() {
		return this.assn;
	}

	public void setAssn(String assn) {
		this.assn = assn;
	}

	@Column(name = "visited")
	public Integer getVisited() {
		return this.visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	@Column(name = "doing", length = 128)
	public String getDoing() {
		return this.doing;
	}

	public void setDoing(String doing) {
		this.doing = doing;
	}

	@Column(name = "online")
	public Short getOnline() {
		return this.online;
	}

	public void setOnline(Short online) {
		this.online = online;
	}

	@Column(name = "registerDate", length = 19)
	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Column(name = "loginDate", length = 19)
	public Date getLoginDate() {
		return this.loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Column(name = "level")
	public Short getLevel() {
		return this.level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	@Column(name = "locked")
	public Short getLocked() {
		return this.locked;
	}

	public void setLocked(Short locked) {
		this.locked = locked;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Usersenior> getUserseniors() {
		return this.userseniors;
	}

	public void setUserseniors(Set<Usersenior> userseniors) {
		this.userseniors = userseniors;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Photocomment> getPhotocomments() {
		return this.photocomments;
	}

	public void setPhotocomments(Set<Photocomment> photocomments) {
		this.photocomments = photocomments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Useruniversity> getUseruniversities() {
		return this.useruniversities;
	}

	public void setUseruniversities(Set<Useruniversity> useruniversities) {
		this.useruniversities = useruniversities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Usernet> getUsernets() {
		return this.usernets;
	}

	public void setUsernets(Set<Usernet> usernets) {
		this.usernets = usernets;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

}