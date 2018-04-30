package eugene.neocortex.fm.sequencer;


import eugene.neocortex.fm.sequencer.model.OneDeadline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface OneDeadlineRepository extends JpaRepository<OneDeadline, Long> {
    List<OneDeadline> findByTailNumber(String tailNumber);
}
