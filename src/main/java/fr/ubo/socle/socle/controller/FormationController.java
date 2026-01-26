package fr.ubo.socle.socle.controller;

import fr.ubo.socle.socle.entity.Etudiant;
import fr.ubo.socle.socle.entity.Formation;
import fr.ubo.socle.socle.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/formations")
//@CrossOrigin("*")
public class FormationController {

    @Autowired
    private FormationRepository repository;

    @GetMapping
    public List<Formation> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Map<String, Object> body = new HashMap<>();
        Optional<Formation> opt = repository.findById(id);
        if (opt.isPresent()) {
            body.put("status", "success");
            body.put("data", opt.get());
            return ResponseEntity.ok(body);
        }
        body.put("status", "error");
        body.put("message", "Formation introuvable : " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Formation formation) {
        Map<String, Object> body = new HashMap<>();
        try {
            if (repository.existsById(formation.getCodeFormation())) {
                body.put("status", "error");
                body.put("message", "Code formation déjà existant.");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
            }
            Formation saved = repository.save(formation);
            body.put("status", "success");
            body.put("data", saved);
            return ResponseEntity.status(HttpStatus.CREATED).body(body);
        } catch (Exception e) {
            body.put("status", "error");
            body.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(body);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Map<String, Object> body = new HashMap<>();
        if (!repository.existsById(id)) {
            body.put("status", "error");
            body.put("message", "Formation introuvable.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
        try {
            repository.deleteById(id);
            body.put("status", "success");
            body.put("message", "Formation supprimée.");
            return ResponseEntity.ok(body);
        } catch (Exception e) {
            body.put("status", "error");
            body.put("message", "Suppression impossible (utilisée ailleurs).");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Formation formation) {
        Map<String, Object> body = new HashMap<>();
        if (formation.getCodeFormation() == null || !repository.existsById(formation.getCodeFormation())) {
            body.put("status", "error");
            body.put("message", "Formation introuvable pour mise à jour.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
        Formation updated = repository.save(formation);
        body.put("status", "success");
        body.put("data", updated);
        return ResponseEntity.ok(body);
    }
}
