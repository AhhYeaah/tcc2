package ifsp.edu.br.deuquadra.controllers;

import ifsp.edu.br.deuquadra.models.CompaniesModel;
import ifsp.edu.br.deuquadra.models.CourtsModel;
import ifsp.edu.br.deuquadra.services.CompaniesService;
import ifsp.edu.br.deuquadra.services.CourtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ComponentScan("ifsp.edu.br.deuquadra.*")
@RestController
@RequestMapping("/courts")
@CrossOrigin
public class CourtsController {

    @Autowired
    CourtsService courtsService;

    @GetMapping("/search")
    public ResponseEntity<List<CourtsModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(courtsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CourtsModel>> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(courtsService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CourtsModel> create(@RequestBody CourtsModel courtsModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courtsService.save(courtsModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourtsModel> update(@RequestBody CourtsModel courtsModel) {
        return ResponseEntity.status(HttpStatus.OK).body(courtsService.update(courtsModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        courtsService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}