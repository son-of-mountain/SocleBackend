package fr.ubo.socle.socle.controller;

import fr.ubo.socle.socle.entity.Formation;
import fr.ubo.socle.socle.entity.Promotion;
import fr.ubo.socle.socle.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/promotions")
//@CrossOrigin("*")
public class PromotionController {

    @Autowired
    private PromotionRepository repository;

    @GetMapping
    public List<Promotion> findAll(){ return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Map<String,Object> body = new HashMap<>();
        Optional<Promotion> promotion = repository.findById(id);

        if(promotion.isPresent()){
            body.put("status", "success");
            body.put("data",promotion.get());
            return ResponseEntity.ok(body);
        }
        else{
            body.put("status", "error");
            body.put("message", "Promotion introuvable");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
    }

/*    @PostMapping
    public Promotion create(@RequestBody Promotion promotion){
        return repository.save(promotion);
    }*/

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Promotion promotion){
        Map<String,Object> body = new HashMap<>();
        try {
            if (repository.existsById(promotion.getAnneePro())) {
                body.put("status", "error");
                body.put("message", "Cette année de promotion existe déjà.");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
            }
            Promotion saved = repository.save(promotion);
            body.put("status", "success");
            body.put("data", saved);
            return ResponseEntity.status(HttpStatus.CREATED).body(body);
        } catch (Exception e) {
            body.put("status", "error");
            body.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(body);
        }
    }

    /*@DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        repository.deleteById(id);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Map<String, Object> body = new HashMap<>();
        if (!repository.existsById(id)) {
            body.put("status", "error");
            body.put("message", "Promotion introuvable.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
        try {
            repository.deleteById(id);
            body.put("status", "success");
            body.put("message", "Promotion supprimée.");
            return ResponseEntity.ok(body);
        } catch (Exception e) {
            body.put("status", "error");
            body.put("message", "Impossible de supprimer (Des étudiants sont inscrits ?).");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Promotion promotion){
        Map<String, Object> body = new HashMap<>();
        if (promotion.getAnneePro() == null || !repository.existsById(promotion.getAnneePro())) {
            body.put("status", "error");
            body.put("message", "Promotion introuvable.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
        Promotion updated = repository.save(promotion);
        body.put("status", "success");
        body.put("data", updated);
        return ResponseEntity.ok(body);
    }
}
