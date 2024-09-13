package Controller;

import Service.DipendenteService;
import entities.Dipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    // Recupera i dipendenti

    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.getAllDipendenti();
    }

    // Crea nuovo dipendente

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente createDipendente(@RequestBody Dipendente dipendente) {
        return dipendenteService.saveDipendente(dipendente);
    }

    // Recupera dipendente per ID

    @GetMapping("/{id}")
    public Dipendente getDipendenteById(@PathVariable UUID id) {
        return dipendenteService.getEmployeeById(id);
    }

    // Aggiorna dipendente per ID

    @PutMapping("/{id}")
    public Dipendente updateDipendenteById(@PathVariable UUID id, @RequestBody Dipendente dipendente) {
        return dipendenteService.updateDipendenteById(id, dipendente);
    }

    // Elimina dipendente per ID

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDipendenteById(@PathVariable UUID id) {
        dipendenteService.deleteDipendenteById(id);
    }

    // Carica un avatar per dipendente

    @PostMapping("/{id}/upload-avatar")
    public ResponseEntity<String> uploadDipendenteAvatar(@PathVariable UUID id, @RequestParam("file") MultipartFile file) {
        try {
            String avatarUrl = dipendenteService.uploadDipendenteAvatar(id, file);
            return ResponseEntity.ok(avatarUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore nel il caricamento dell'avatar");
        }
    }
}
