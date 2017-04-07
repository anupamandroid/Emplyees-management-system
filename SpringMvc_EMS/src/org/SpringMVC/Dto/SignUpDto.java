package org.SpringMVC.Dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "signup_table")
public class SignUpDto implements Serializable {

	public SignUpDto() {
		System.out.println(this.getClass().getSimpleName() + "created ...");
	}

	@Id
	@GenericGenerator(name = "anyThing", strategy = "increment")
	@GeneratedValue(generator = "anyThing")
	@Column(name = "u_id")
	private int id;
	@Column(name = "u_f_name")
	private String fname;
	@Column(name = "u_l_name")
	private String lname;
	@Column(name = "u_mobile")
	private long mobile;
	@Column(name = "u_email")
	private String email;
	@Column(name = "u_password")
	private String password;
	@Column(name = "u_age")
	private int age;
	@Column(name="u_active")
	private boolean active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mob) {
		this.mobile = mob;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "SignupDTO [fname=" + fname + ", lname=" + lname + ", mobile=" + mobile + ", email=" + email
				+ ", gender=" + age + "]";
	}
}
