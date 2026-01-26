package fr.ubo.socle.socle.controller;

import fr.ubo.socle.socle.entity.Enseignant;
import fr.ubo.socle.socle.entity.Etudiant;
import fr.ubo.socle.socle.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/etudiants")
//@CrossOrigin("*")
public class EtudiantController {
    @Autowired
    private EtudiantRepository repository;

    @GetMapping
    public List<Etudiant> findAll(){ return repository.findAll(); }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id){
        Map<String ,Object> body = new HashMap<>();

        Optional<Etudiant> etudiant = repository.findById(id);
        if(etudiant.isPresent()) {
            body.put("status","success");
            body.put("etudiant",etudiant.get());
            return ResponseEntity.ok().body(body);
        } else {
            body.put("status","error");
            body.put("message", "Etudiant introuvable avec l'ID : " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Etudiant etudiant){
        Map<String ,Object> body = new HashMap<>();
        try{
            if(repository.existsById(etudiant.getNoEtudiantNat())){
                body.put("status","error");
                body.put("message", "Le etudiant n'existe pas");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
            }
            Etudiant saved = repository.save(etudiant);
            body.put("status","success");
            body.put("data",saved);
            return ResponseEntity.status(HttpStatus.CREATED).body(body);

        } catch (Exception e){
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
            body.put("message", "Impossible de supprimer : ID introuvable.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
        try {
            repository.deleteById(id);
            body.put("status", "success");
            body.put("message", "Etudiant supprimé avec succès.");
            return ResponseEntity.ok(body);
        } catch (Exception e) {
            body.put("status", "error");
            body.put("message", "Erreur lors de la suppression (Probablement lié à des données existantes).");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Etudiant etudiant) {
        Map<String, Object> body = new HashMap<>();
        // Vérification nullsafe
        String id = etudiant.getNoEtudiantNat();
        if (id == null || !repository.existsById(id)) {
            body.put("status", "error");
            body.put("message", "Mise à jour impossible : Etudiant introuvable.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
        try {
            Etudiant updated = repository.save(etudiant);
            body.put("status", "success");
            body.put("data", updated);
            return ResponseEntity.ok(body);
        } catch (Exception e) {
            body.put("status", "error");
            body.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(body);
        }
    }

}
