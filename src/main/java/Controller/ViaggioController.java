package Controller;

import Service.ViaggioService;
import entities.Viaggio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    // Recupera i viaggi

    @GetMapping
    public List<Viaggio> getAllViaggi() {
        return viaggioService.getAllViaggi();
    }

    // Crea nuovo viaggio

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio createViaggio(@RequestBody Viaggio viaggio) {
        return viaggioService.saveViaggio(viaggio);
    }

    // Recupera viaggio per ID

    @GetMapping("/{id}")
    public Viaggio getViaggioById(@PathVariable UUID id) {
        return viaggioService.getViaggioById(id);
    }

    // Aggiorna viaggio per ID

    @PutMapping("/{id}")
    public Viaggio updateViaggioById(@PathVariable UUID id, @RequestBody Viaggio viaggio) {
        return viaggioService.updateViaggioById(id, viaggio);
    }

    // Elimina viaggio per ID

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteViaggioById(@PathVariable UUID id) {
        viaggioService.deleteViaggioById(id);
    }
}
