package eugene.neocortex.fm.sequencer;


import eugene.neocortex.fm.sequencer.model.Deadline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DeadlineRepository extends JpaRepository<Deadline, Long> {
    List<Deadline> findByTailNumber(String tailNumber);
}
