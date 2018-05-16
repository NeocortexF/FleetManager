package eugene.neocortex.fm.sequencer;


import eugene.neocortex.fm.sequencer.model.PassengersOnBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface PassengersOnBoardRepository extends JpaRepository<PassengersOnBoard, Long> {
    Collection<PassengersOnBoard> findAllByFlightId(Long flightId);
}
