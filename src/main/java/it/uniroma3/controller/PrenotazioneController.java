package it.uniroma3.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.DateValidator;
import org.postgresql.translation.messages_bg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import it.uniroma3.model.Medico;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.Prenotazione;
import it.uniroma3.model.TipologiaEsame;
import it.uniroma3.service.MedicoService;
import it.uniroma3.service.PazienteService;
import it.uniroma3.service.PrenotazioneService;
import it.uniroma3.service.TipologiaEsameService;

@Controller
@RequestMapping("/prenotazione")
public class PrenotazioneController extends WebMvcConfigurerAdapter{

	@Autowired
	private PrenotazioneService prenotazioneService;	
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private PazienteService pazienteService;
	@Autowired
	private TipologiaEsameService tipologiaEsameService;
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(value="/addPrenotazione",method=RequestMethod.POST)
	public String addPrenotazione(){
		DateValidator dateValidator = new DateValidator();
		Paziente paziente = this.pazienteService.findPaziente(request.getParameter("codiceFiscale"));
		Medico medico = this.medicoService.findByCodice(request.getParameter("medico"));
		TipologiaEsame tipologiaEsame = this.tipologiaEsameService.findByNome(request.getParameter("tipologia"));
		Prenotazione prenotazione = new Prenotazione(dateValidator.validate(request.getParameter("dataEsame"), "yyyy-mm-dd"),medico,paziente,tipologiaEsame);
		this.prenotazioneService.insertPrenotazione(prenotazione);
		return "success";
	}
}
