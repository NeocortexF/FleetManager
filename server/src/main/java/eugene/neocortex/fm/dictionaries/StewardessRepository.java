package eugene.neocortex.fm.dictionaries;

import eugene.neocortex.fm.dictionaries.model.Stewardess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface StewardessRepository extends JpaRepository<Stewardess, Long> {

    Stewardess findByName(String name);

    Collection<Stewardess> findAllByBrigade(Byte brigade);
}
