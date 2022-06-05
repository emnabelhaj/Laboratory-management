package com.example.demo.bean;

import java.util.Date;


public class EvenementBean {
	private  Long id;
	private String titre ;
	private Date date ;
	private String lieu ;
	public EvenementBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EvenementBean(String titre, Date date, String lieu) {
		super();
		this.titre = titre;
		this.date = date;
		this.lieu = lieu;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
}
