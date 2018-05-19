package eugene.neocortex.fm.dictionaries;

import eugene.neocortex.fm.dictionaries.model.Airports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AirportsRepository extends JpaRepository<Airports, Long> {

    Airports findByName(String name);

    Airports findByCodeICAO(String codeICAO);
}
