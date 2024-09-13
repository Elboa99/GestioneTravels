package Service;

import Repositories.RepositoryPrenotazione;
import entities.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
    public class PrenotazioneService {

        @Autowired
        private RepositoryPrenotazione prenotazioneRepository;

        // Metodo per ottenere tutte le prenotazioni

        public List<Prenotazione> getAllPrenotazioni() {
            return prenotazioneRepository.findAll();
        }

        // Metodo per ottenere una prenotazione per ID

        public Prenotazione getPrenotazioneById(UUID id) {
            return prenotazioneRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Prenotazione con ID " + id + " non trovata"));
        }

        // Metodo per aggiornare una prenotazione per ID

        public Prenotazione updatePrenotazioneById(UUID id, Prenotazione updatedPrenotazione) {
            Prenotazione prenotazione = getPrenotazioneById(id);
            prenotazione.setNote(updatedPrenotazione.getNote());
            prenotazione.setDipendente(updatedPrenotazione.getDipendente());
            prenotazione.setViaggio(updatedPrenotazione.getViaggio());

            return prenotazioneRepository.save(prenotazione);
        }

        // Metodo per eliminare una prenotazione per ID

        public void deletePrenotazioneById(UUID id) {
            Prenotazione prenotazione = getPrenotazioneById(id);
            prenotazioneRepository.delete(prenotazione);
        }

        // Metodo per salvare una nuova prenotazione

        public Prenotazione savePrenotazione(Prenotazione prenotazione) {
            return prenotazioneRepository.save(prenotazione);
        }
}
