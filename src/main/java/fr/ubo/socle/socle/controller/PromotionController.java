package fr.ubo.socle.socle.controller;

import fr.ubo.socle.socle.entity.Promotion;
import fr.ubo.socle.socle.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promotions")
//@CrossOrigin("*")
public class PromotionController {

    @Autowired
    private PromotionRepository repository;

    @GetMapping
    public List<Promotion> findAll(){ return repository.findAll(); }

    @PostMapping
    public Promotion create(@RequestBody Promotion promotion){
        return repository.save(promotion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        repository.deleteById(id);
    }

    @PutMapping
    public Promotion update(@RequestBody Promotion promotion){
        return repository.save(promotion);
    }
}
