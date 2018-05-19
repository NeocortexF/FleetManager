package eugene.neocortex.fm.dictionaries;

import eugene.neocortex.fm.dictionaries.model.Pilots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface PilotsRepository extends JpaRepository<Pilots, Long> {

    Pilots findByName(String name);

    Collection<Pilots> findAllBySquadron(Byte squad);
}
