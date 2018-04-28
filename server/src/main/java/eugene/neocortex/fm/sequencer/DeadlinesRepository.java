package eugene.neocortex.fm.sequencer;

import eugene.neocortex.fm.sequencer.model.Deadlines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DeadlinesRepository extends JpaRepository<Deadlines, Long> {
}
