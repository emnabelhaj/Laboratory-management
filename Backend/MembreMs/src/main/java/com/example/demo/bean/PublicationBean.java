package com.example.demo.bean;

import java.util.Date;

public class PublicationBean {
	public PublicationBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Long id;
	private String type;
	private String titre;
	private String lien;
	private Date date;
	private String sourcePdf;
	
	public PublicationBean(String type, String titre, String lien, Date date, String sourcePdf) {
		super();
		this.type = type;
		this.titre = titre;
		this.lien = lien;
		this.date = date;
		this.sourcePdf = sourcePdf;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSourcePdf() {
		return sourcePdf;
	}
	public void setSourcePdf(String sourcePdf) {
		this.sourcePdf = sourcePdf;
	}
	
}
