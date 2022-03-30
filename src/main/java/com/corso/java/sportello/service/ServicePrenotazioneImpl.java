package com.corso.java.sportello.service;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corso.java.sportello.entities.Prenotazione;
import com.corso.java.sportello.repositories.PrenotazioneRepo;

@Service
public class ServicePrenotazioneImpl implements ServicePrenotazione {

	@Autowired
	private PrenotazioneRepo pr;

	public void nuovaPrenotazione(Prenotazione prenotazione) {

		pr.save(prenotazione);

	}

	public Long prenotazioneCognome(String cognome) {

		return pr.findByCognome(cognome).getNumeroOrdine();

	}

	public String prenotazioneNumeroOrdine(Long numeroOrdine) {

		return pr.findByNumeroOrdine(numeroOrdine).getCognome();

	}

	public Long prenota(String nome, String cognome) {

		Prenotazione preno = new Prenotazione(nome, cognome);

		nuovaPrenotazione(preno);
		return prenotazioneCognome(cognome);

	}

	public Prenotazione estrai() {

		Long min = pr.findAll().stream().mapToLong(v -> v.getNumeroOrdine()).min()
				.orElseThrow(NoSuchElementException::new);

		return pr.findByNumeroOrdine(min);

	}

	public void rinuncia(Long numeroOrdine) {

		if (prenotazioneNumeroOrdine(numeroOrdine) == null) {

			throw new IllegalArgumentException();
		}
		pr.deleteById(numeroOrdine);

	}

	public Long tempoAttesa(Long numeroOrdine) {

		if (prenotazioneNumeroOrdine(numeroOrdine) == null) {

			throw new IllegalArgumentException();
		}

		return pr.findAll().stream().filter(x -> x.getNumeroOrdine() < numeroOrdine).count();

	}

}
