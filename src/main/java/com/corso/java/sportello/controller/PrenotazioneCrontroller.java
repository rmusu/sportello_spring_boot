package com.corso.java.sportello.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.corso.java.sportello.entities.Prenotazione;
import com.corso.java.sportello.service.ServicePrenotazione;

@RestController
public class PrenotazioneCrontroller {

	@Autowired
	private ServicePrenotazione sp;

	@PostMapping("/nuovaPrenotazione")
	public void nuovaPrenotazione(@RequestBody Prenotazione prenotazione) {

		sp.nuovaPrenotazione(prenotazione);
	}

	@GetMapping("/prenotazioneCognome/{cognome}")
	public Long prenotazioneCognome(@PathVariable String cognome) {

		return sp.prenotazioneCognome(cognome);
	}

	@GetMapping("/prenotazioneNumeroOrdine/{numeroOrdine}")
	public String prenotazioneNumeroOrdine(@PathVariable Long numeroOrdine) {

		return sp.prenotazioneNumeroOrdine(numeroOrdine);
	}

	@GetMapping("/prenota/{nome}/{cognome}")
	public Long prenota(@PathVariable String nome, @PathVariable String cognome) {

		return sp.prenota(nome, cognome);
	}

	@GetMapping("/estrai")
	public Prenotazione estrai() {

		return sp.estrai();
	}
	
	@GetMapping("/tempoAttesa/{numeroOrdine}")
	public Long tempoAttesa(@PathVariable Long numeroOrdine) {

		return sp.tempoAttesa(numeroOrdine);
	}

	@DeleteMapping("/rinuncia/{numeroOrdine}")
	public void rinuncia(@PathVariable Long numeroOrdine) {

		sp.rinuncia(numeroOrdine);
		
	}

}
