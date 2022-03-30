package com.corso.java.sportello.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corso.java.sportello.entities.Prenotazione;

@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {

	public Prenotazione findByCognome(String cognome);

	public Prenotazione findByNumeroOrdine(Long numeroOrdine);

	public List<Prenotazione> findAll();

}
