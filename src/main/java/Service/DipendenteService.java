package Service;

import Repositories.RepositoryDipendente;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import entities.Dipendente;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Service
public class DipendenteService {

    @Autowired
    private RepositoryDipendente dipendenteRepository;

    @Autowired
    private Cloudinary cloudinaryUploader;


    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }


    public Dipendente getEmployeeById(UUID id) {
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dipendente con ID " + id + " non trovato"));
    }

    // Update an employee by ID
    public Dipendente updateDipendenteById(UUID id, Dipendente updatedData) {
        Dipendente dipendente = getEmployeeById(id);

        dipendente.setNome(updatedData.getNome());
        dipendente.setCognome(updatedData.getCognome());
        dipendente.setEmail(updatedData.getEmail());
        dipendente.setAvatar(updatedData.getAvatar());

        return dipendenteRepository.save(dipendente);
    }

    public void deleteDipendenteById(UUID id) {
        Dipendente employee = getEmployeeById(id);
        dipendenteRepository.delete(employee);
    }

    public String uploadDipendenteAvatar(UUID employeeId, MultipartFile file) throws IOException {
        String avatarUrl = (String) cloudinaryUploader.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        System.out.println("Uploaded avatar URL: " + avatarUrl);

        Dipendente dipendente = getEmployeeById(employeeId);
        dipendente.setAvatar(avatarUrl);
        dipendenteRepository.save(dipendente);

        return avatarUrl;
    }
}
