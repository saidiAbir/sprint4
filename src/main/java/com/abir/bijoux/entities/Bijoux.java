package com.abir.bijoux.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Bijoux {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBijoux;
	@NotNull
	@Size(min = 4, max = 15)
	private String nomBijoux;
	@Min(value = 10)
	@Max(value = 10000)
	private Double prix;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;

	@ManyToOne
	private Marque marque;

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Bijoux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bijoux(String nomBijoux, Double prix, Date dateCreation) {
		super();
		this.nomBijoux = nomBijoux;
		this.prix = prix;

		this.dateCreation = dateCreation;
	}

	public Long getIdBijoux() {
		return idBijoux;
	}

	public void setIdBijoux(Long idBijoux) {
		this.idBijoux = idBijoux;
	}

	public String getNomBijoux() {
		return nomBijoux;
	}

	public void setNomBijoux(String nomBijoux) {
		this.nomBijoux = nomBijoux;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Bijoux [idBijoux=" + idBijoux + ", nomBijoux=" + nomBijoux + ", prix=" + prix + ", dateCreation="
				+ dateCreation + "]";
	}

}
