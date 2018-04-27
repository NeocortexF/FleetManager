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

    @RequestMapping(value="/one/{id}")
    @ResponseBody
    public Beer oneBeer(@PathVariable("id") long id){
        return repository.findOne(id);
    }

    @RequestMapping(value="/set/{id}/{name}")
    @ResponseBody
    public Beer setBeerName(@PathVariable("id") long id, @PathVariable("name") String newName){
//        repository.findOne(id).setName(name);

        Beer beerToUpdate = repository.getOne(id);
        beerToUpdate.setName(newName);
        repository.save(beerToUpdate);

        System.out.println(repository.findOne(id) + "name has been changed to " + newName);
        return repository.findOne(id);
    }

}