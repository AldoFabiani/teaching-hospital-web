package it.uniroma3.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable=false, unique=true)
	private String codice;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	private String specializzazione;
	
	public Medico() {
	}

	public Medico(String nome, String cognome, String specializzazione) {
		this.codice = UUID.randomUUID().toString();
		this.nome = nome;
		this.cognome = cognome;
		this.specializzazione = specializzazione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
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

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	@Override
	public int hashCode() {
		return this.codice.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Medico medico = (Medico) obj;
		return this.getCodice().equals(medico.getCodice());
	}

	
}
