package it.uniroma3.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

@NamedQuery(name = "findAllPrenotazioni", query = "SELECT p FROM Prenotazione p")

@Entity
public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = true)
	private String codice;
	@Temporal(TemporalType.DATE)
	private Date dataAvvenutaPrenotazione;
	@Temporal(TemporalType.DATE)
	private Date dataEsame;
	@ManyToOne
	private Medico medico;
	@ManyToOne
	private Paziente paziente;
	@ManyToOne
	private TipologiaEsame tipologiaEsame;

	public Prenotazione() {
	}

	// E' davvero utile passare subito nel costruttore Medico e Paziente (in
	// relazione ai casi d'uso?)
	public Prenotazione(Date dataEsame, Medico medico, Paziente paziente, TipologiaEsame tipologiaEsameCorrente) {
		this.codice = UUID.randomUUID().toString();
		this.dataAvvenutaPrenotazione = Calendar.getInstance().getTime();
		this.dataEsame = dataEsame;
		this.medico = medico;
		this.paziente = paziente;
		this.tipologiaEsame=tipologiaEsameCorrente;
		//this.paziente.addPrenotazione(this);
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Date getDataAvvenutaPrenotazione() {
		return dataAvvenutaPrenotazione;
	}

	public void setDataAvvenutaPrenotazione(Date dataAvvenutaPrenotazione) {
		this.dataAvvenutaPrenotazione = dataAvvenutaPrenotazione;
	}

	public Date getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(Date dataEsame) {
		this.dataEsame = dataEsame;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	// TODO equals e hashcode sul codice

	@Override
	public boolean equals(Object obj) {
		Prenotazione exam = (Prenotazione) obj;
		return this.getCodice().equals(exam.getCodice());
	}

	@Override
	public int hashCode() {
		return this.getCodice().hashCode();
	}
}
