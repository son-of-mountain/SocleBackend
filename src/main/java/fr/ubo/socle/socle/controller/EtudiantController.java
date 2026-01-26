package fr.ubo.socle.socle.controller;

import fr.ubo.socle.socle.entity.Etudiant;
import fr.ubo.socle.socle.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
//@CrossOrigin("*")
public class EtudiantController {
    @Autowired
    private EtudiantRepository repository;

    @GetMapping
    public List<Etudiant> findAll(){ return repository.findAll(); }

    @PostMapping
    public Etudiant create(@RequestBody Etudiant etudiant){
        return repository.save(etudiant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        repository.deleteById(id);
    }

    @PutMapping
    public Etudiant update(@RequestBody Etudiant etudiant){
        return repository.save(etudiant);
    }


}
