package com.example.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class MembrePubIds implements Serializable {
	private Long publication_id;
	private Long auteur_id;

	public MembrePubIds() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MembrePubIds(Long publication_id, Long membre_id) {
		super();
		this.publication_id = publication_id;
		auteur_id = membre_id;
	}
	public Long getPublication_id() {
		return publication_id;
	}

	public void setPublication_id(Long publication_id) {
		this.publication_id = publication_id;
	}

	public Long getMembre_id() {
		return auteur_id;
	}

	public void setMembre_id(Long membre_id) {
		auteur_id = membre_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteur_id == null) ? 0 : auteur_id.hashCode());
		result = prime * result + ((publication_id == null) ? 0 : publication_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MembrePubIds other = (MembrePubIds) obj;
		if (auteur_id == null) {
			if (other.auteur_id != null)
				return false;
		} else if (!auteur_id.equals(other.auteur_id))
			return false;
		if (publication_id == null) {
			if (other.publication_id != null)
				return false;
		} else if (!publication_id.equals(other.publication_id))
			return false;
		return true;
	}

	
	

}
