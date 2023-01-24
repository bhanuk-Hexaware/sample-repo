package com.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Student")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Student {

	@Id
	private String id;
    private String name;
    private String rollno;

	public Student(String id, 
        String name, 
        String rollno
    ){
    this.id = id;
	this.name = name;
	this.rollno = rollno;
	}

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setRollno(String rollno){
        this.rollno = rollno;
    }

    public String getRollno(){
        return this.rollno;
    }

    public String toString(){
        return "[id = " + this.id +
                "name = " + this.name +
                "rollno = " + this.rollno +
            "]";
    }

}
