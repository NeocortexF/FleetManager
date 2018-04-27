package eugene.neocortex.fm.beer;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}