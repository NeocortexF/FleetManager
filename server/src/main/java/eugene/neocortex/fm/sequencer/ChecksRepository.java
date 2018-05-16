package eugene.neocortex.fm.sequencer;

import eugene.neocortex.fm.sequencer.model.Checks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ChecksRepository extends JpaRepository<Checks, Long> {
    Collection<Checks> findAllByTailNumber(String tailNumber);
}
