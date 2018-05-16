package eugene.neocortex.fm.sequencer;


import eugene.neocortex.fm.sequencer.model.PassangersOnBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface PassangersOnBoardRepository extends JpaRepository<PassangersOnBoard, Long> {
    Collection<PassangersOnBoard> findAllByFlightId(Long flightId);
}
