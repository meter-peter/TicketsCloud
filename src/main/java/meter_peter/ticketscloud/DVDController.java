package meter_peter.ticketscloud;

import meter_peter.ticketscloud.DVD;
import meter_peter.ticketscloud.DVDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dvds")
public class DVDController {
    private final DVDRepository dvdRepository;

    @Autowired
    public DVDController(DVDRepository dvdRepository) {
        this.dvdRepository = dvdRepository;
    }

    @PostMapping
    public ResponseEntity<String> createDVD(@Validated @RequestBody DVD dvd) {
        if (dvdRepository.findByTitle(dvd.getTitle()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("DVD with the same title already exists.");
        }
        DVD savedDVD = dvdRepository.save(dvd);
        return ResponseEntity.ok(savedDVD.getId().toString());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DVD> getDVDById(@PathVariable UUID id) {
        return dvdRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DVD>> getAllDVDs() {
        return ResponseEntity.ok(dvdRepository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDVD(@PathVariable UUID id, @Validated @RequestBody DVD updatedDVD) {
        return dvdRepository.findById(id)
                .map(dvd -> {
                    dvd.setGenre(updatedDVD.getGenre());
                    dvd.setQuantity(updatedDVD.getQuantity());
                    dvdRepository.save(dvd);
                    return ResponseEntity.ok("DVD updated successfully.");
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDVD(@PathVariable UUID id) {
        return dvdRepository.findById(id)
                .map(dvd -> {
                    dvdRepository.delete(dvd);
                    return ResponseEntity.ok("DVD deleted successfully.");
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
