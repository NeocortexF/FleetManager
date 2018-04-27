//package eugene.neocortex.fm.beer;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.stream.Stream;
//
////uses this repository and creates a default set of data.
//
///*
// * CommandLineRunner - Interface used to indicate that a bean should run when it is contained
// * within a SpringApplication.
// * Multiple CommandLineRunner beans can be defined within the same application context
// * and can be ordered using the Ordered interface or @Order annotation.
// *
// * Переоперделяем метод run для имплементации CommandLineRunner
// * и он запоняет базу H2 в памяти значениями
// *
// * Бин не обязательно помечать аннотацией autowired потому что есть
// * Констурктор  BeerCommandLineRunner(BeerRepository repository) и начиная со Spring 3
// * он автоматом инжектится
// */
//@Component
//public class BeerCommandLineRunner implements CommandLineRunner {
//
//    private final BeerRepository repository;
//
//    public BeerCommandLineRunner(BeerRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public void run(String... strings) throws Exception {
//        // Top beers from https://www.beeradvocate.com/lists/top/
//        Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy", "King Julius",
//                "Budweiser", "Coors Light", "PBR").forEach(name ->
//                repository.save(new Beer(name))
//        );
//        repository.findAll().forEach(System.out::println);
//    }
//}