package com.example.demo.entitie;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Publication implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private  Long id;
	@NonNull
	private String type ;
	@NonNull
	private String titre ;
	@NonNull
	private String lien ;
	@NonNull
	private Date date ;
	@NonNull
	private String sourcePdf ;
}
