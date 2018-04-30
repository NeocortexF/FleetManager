package eugene.neocortex.fm.sequencer.controller;


import eugene.neocortex.fm.sequencer.DeadlinesRepository;
import eugene.neocortex.fm.sequencer.model.Deadlines;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class DeadlineController {
    private DeadlinesRepository repository;

    public DeadlineController(DeadlinesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("deadline/all")
    public Collection<Deadlines> getAllDeadlines() {
        return repository.findAll();
    }

    @RequestMapping(value = "deadline/byId/{id}")
    @ResponseBody
    public Deadlines findDeadlineById(@PathVariable("id") long id) {
        return repository.findOne(id);
    }


    @PostMapping(value = "deadline/save")
    public ResponseEntity createDeadline(@RequestBody Deadlines deadlines) {
        repository.save(deadlines);
        return new ResponseEntity(deadlines, HttpStatus.OK);
    }


    @RequestMapping(value = "deadline/delete/{id}")
    @ResponseBody
    public boolean removeDeadlineById(@PathVariable("id") long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
