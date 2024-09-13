package Service;

import Repositories.RepositoryViaggio;
import Repositories.ViaggioRepository;
import entities.Viaggio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    // Ottenimento di tutti i viaggi

    public List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAll();
    }

    // Ottenimento viaggio per ID

    public Viaggio getViaggioById(UUID id) {
        return viaggioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Viaggio con ID " + id + " non trovato"));
    }

    // Aggiornamento del viaggio per ID

    public Viaggio updateViaggioById(UUID id, Viaggio updatedViaggio) {
        Viaggio viaggio = getViaggioById(id);

        viaggio.setDestinazione(updatedViaggio.getDestinazione());
        viaggio.setData(updatedViaggio.getData());


        return viaggioRepository.save(viaggio);
    }

    //Eliminazione viaggio per ID

    public void deleteViaggioById(UUID id) {
        Viaggio viaggio = getViaggioById(id);
        viaggioRepository.delete(viaggio);
    }

    // Salvataggio nuovo viaggio

    public Viaggio saveViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }
}

