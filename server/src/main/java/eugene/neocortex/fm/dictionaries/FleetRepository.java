package eugene.neocortex.fm.dictionaries;

import eugene.neocortex.fm.dictionaries.model.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FleetRepository extends JpaRepository<Fleet, Long> {
}
