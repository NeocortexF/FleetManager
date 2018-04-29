package eugene.neocortex.fm.sequencer.controller;


import eugene.neocortex.fm.sequencer.DeadlinesRepository;
import eugene.neocortex.fm.sequencer.model.Deadlines;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;

@RestController
public class DeadlineController {
    private DeadlinesRepository repository;

    public DeadlineController(DeadlinesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("deadline/all")
    public Collection<Deadlines> allDeadlines() {
        return repository.findAll();
    }

    @RequestMapping(value = "deadline/byId/{id}")
    @ResponseBody
    public Deadlines oneDeadlines(@PathVariable("id") long id) {
        return repository.findOne(id);
    }


    @PostMapping(value = "deadline/save")
    public ResponseEntity createCustomer(@RequestBody Deadlines deadlines) {
        repository.save(deadlines);
        return new ResponseEntity(deadlines, HttpStatus.OK);
    }


    @RequestMapping(value = "deadline/delete/{id}")
    @ResponseBody
    public boolean removeBeer(@PathVariable("id") long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else {
            return false;
        }
    }

//    @RequestMapping(value = "beer/add/{name}")
//    @ResponseBody
//    public String addBeer(@PathVariable("name") String name) {
//        if (name != null && !name.isEmpty()) {
//            Deadlines beerToSave = new Deadlines();
//            beerToSave.setName(name);
//            repository.save(beerToSave);
//            return beerToSave.toString();
//        } else {
//            return "Please enter the name of beer";
//        }
//    }
}