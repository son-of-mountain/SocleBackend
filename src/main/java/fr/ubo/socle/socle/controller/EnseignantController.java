package fr.ubo.socle.socle.controller;

import fr.ubo.socle.socle.entity.Enseignant;
import fr.ubo.socle.socle.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
//@CrossOrigin("*")
public class EnseignantController {

    @Autowired
    private EnseignantRepository repository;

    @GetMapping
    public List<Enseignant> findAll(){ return repository.findAll(); }

    @PostMapping
    public Enseignant create(@RequestBody Enseignant enseignant){
        return repository.save(enseignant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping
    public Enseignant update(@RequestBody Enseignant enseignant){
        return repository.save(enseignant);
    }

}
