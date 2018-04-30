package eugene.neocortex.fm.sequencer;

import eugene.neocortex.fm.sequencer.model.Checks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ChecksRepository extends JpaRepository<Checks, Long> {
    Checks findByTailNumber(String tailNumber);
}
