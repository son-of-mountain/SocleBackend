package fr.ubo.socle.socle.controller;

import fr.ubo.socle.socle.entity.Enseignant;
import fr.ubo.socle.socle.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/enseignants")
//@CrossOrigin("*")
public class EnseignantController {

    @Autowired
    private EnseignantRepository repository;

    @GetMapping
    public List<Enseignant> findAll(){ return repository.findAll(); }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        Map<String ,Object> body = new HashMap<>();

        Optional<Enseignant> enseignant = repository.findById(id);
        if(enseignant.isPresent()) {
            body.put("status","success");
            body.put("enseignant",enseignant.get());
            return ResponseEntity.ok().body(body);
        } else {
            body.put("status","error");
            body.put("message", "Enseignant introuvable avec l'ID : " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
    }
/*

    @PostMapping
    public Enseignant create(@RequestBody Enseignant enseignant){

        return repository.save(enseignant);
    }
*/
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Enseignant enseignant) {
        Map<String, Object> body = new HashMap<>();
        try {
            Enseignant saved = repository.save(enseignant);
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
    public ResponseEntity<?> delete(@PathVariable Long id){

        Map<String ,Object> body = new HashMap<>();

        if(!repository.existsById(id)) {
            body.put("status","error");
            body.put("message","Impossible de supprimer : ID: "+id+" introuvable");
            return ResponseEntity.ok().body(body);
        } try {
            repository.deleteById(id);
            body.put("status","success");
            body.put("message","Enseignant supprime avec succes.");
            return ResponseEntity.ok(body);
        } catch (Exception e) {
            body.put("status","error");
            body.put("message",e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

/*
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }
*/

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Enseignant enseignant){
        Map<String,Object> body = new HashMap<>();
        if (enseignant.getId() == null) {
            body.put("status","error");
            body.put("message","Mise à jour impossible : ID inconnu.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
        Enseignant newEnseignant = repository.save(enseignant);
        body.put("status","success");
        body.put("enseignant",newEnseignant);
        return ResponseEntity.ok(body);
    }

}
/*

@GetMapping
public ResponseEntity<?> getPromotions(){
    Map<String ,Object> body = new HashMap<>();
    try {
        List<Promotion> promotions = promotionService.getPromotions();
        body.put("status","success");
        body.put("promotions",promotions);
        return ResponseEntity.ok().body(body);
    } catch (Exception e) {
        body.put("status","Failed");
        body.put("message",e.getMessage());
        return ResponseEntity.badRequest().body(body);
    }
}
*/
