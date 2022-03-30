package com.corso.java.sportello.service;

import com.corso.java.sportello.entities.Prenotazione;

public interface ServicePrenotazione {

	public void nuovaPrenotazione(Prenotazione prenotazione);

	public Long prenotazioneCognome(String cognome);

	public String prenotazioneNumeroOrdine(Long numeroOrdine);
	
	public Long prenota(String nome, String cognome);
	
	public Prenotazione estrai();

	public void rinuncia(Long numeroOrdine);
	
	public Long tempoAttesa(Long numeroOrdine);

}
