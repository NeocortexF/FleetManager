package eugene.neocortex.fm.beer;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

//BeerController class to create an endpoint that filters out less-than-great beers
@RestController
public class BeerController {
    private BeerRepository repository;

    public BeerController(BeerRepository repository) {
        this.repository = repository;
    }

    //тут http://localhost:8080/good-beers front будет ловить данные отсюда
    @GetMapping("/good-beers")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
    public Collection<Beer> goodBeers() {
        return repository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Budweiser") &&
                !beer.getName().equals("Coors Light") &&
                !beer.getName().equals("PBR");
    }

    @GetMapping("/all")
    public Collection<Beer> allBears() {
        return repository.findAll();
    }

    @RequestMapping(value = "/one/{id}")
    @ResponseBody
    public Beer oneBeer(@PathVariable("id") long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "/update/{id}/{name}")
    @ResponseBody
    public Beer setBeerName(@PathVariable("id") long id, @PathVariable("name") String newName) {
        if (newName != null) {
            Beer beerToUpdate = repository.getOne(id);
            beerToUpdate.setName(newName);
            repository.save(beerToUpdate);
        }
        return repository.findOne(id);
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public boolean removeBeer(@PathVariable("id") long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "add/{name}")
    @ResponseBody
    public String addBeer(@PathVariable("name") String name) {
        if (name != null && !name.isEmpty()){
            Beer beerToSave = new Beer();
            beerToSave.setName(name);
            repository.save(beerToSave);
            return beerToSave.toString();
        } else {
            return "Please enter the name of beer";
        }
    }
}