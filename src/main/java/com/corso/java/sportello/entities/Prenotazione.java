package com.corso.java.sportello.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prenotazioni")
public class Prenotazione implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_ordine")
	private Long numeroOrdine;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;

	public Prenotazione(Long numeroOrdine, String nome, String cognome) {

		this.numeroOrdine = numeroOrdine;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Prenotazione(String nome, String cognome) {

		this.nome = nome;
		this.cognome = cognome;

	}

	public Prenotazione() {

	}

	public Long getNumeroOrdine() {
		return numeroOrdine;
	}

	public void setNumeroOrdine(Long numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

}
