package Controller;

import Service.PrenotazioneService;
import entities.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prenotazioni")

public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    // Recupera le prenotazioni

    @GetMapping
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneService.getAllPrenotazioni();
    }

    // Crea nuova prenotazione

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione createPrenotazione(@RequestBody Prenotazione prenotazione) {
        return prenotazioneService.savePrenotazione(prenotazione);
    }

    // Recupera prenotazione per ID

    @GetMapping("/{id}")
    public Prenotazione getPrenotazioneById(@PathVariable UUID id) {
        return prenotazioneService.getPrenotazioneById(id);
    }

    // Aggiorna prenotazione per ID

    @PutMapping("/{id}")
    public Prenotazione updatePrenotazioneById(@PathVariable UUID id, @RequestBody Prenotazione prenotazione) {
        return prenotazioneService.updatePrenotazioneById(id, prenotazione);
    }

    // Elimina prenotazione per ID

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePrenotazioneById(@PathVariable UUID id) {
        prenotazioneService.deletePrenotazioneById(id);
    }
}
