package com.StudentCurd.StudentApplication_CurdBase.entity;



import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String course;
	private int fee;
	private long mob;
	@CreationTimestamp
	private Date createDate;
	@UpdateTimestamp
	private Date updateDate;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long id, String name, String course, int fee, long mob, Date createDate, Date updateDate) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.fee = fee;
		this.mob = mob;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public long getMob() {
		return mob;
	}
	public void setMob(long mob) {
		this.mob = mob;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", fee=" + fee + ", mob=" + mob
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	
	
	
	
	

}
