package fr.ubo.socle.socle.controller;

import fr.ubo.socle.socle.entity.Etudiant;
import fr.ubo.socle.socle.entity.Formation;
import fr.ubo.socle.socle.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
//@CrossOrigin("*")
public class FormationController {

    @Autowired
    private FormationRepository repository;

    @GetMapping
    public List<Formation> findAll(){ return repository.findAll(); }

    @PostMapping
    public Formation create(@RequestBody Formation formation){
        return repository.save(formation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        repository.deleteById(id);
    }

    @PutMapping
    public Formation update(@RequestBody Formation formation){
        return repository.save(formation);
    }

}
