package eugene.neocortex.fm.sequencer;

import eugene.neocortex.fm.sequencer.model.CabinCrewOnBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface CabinCrewOnBoardRepository extends JpaRepository<CabinCrewOnBoard, Long> {
    Collection<CabinCrewOnBoard> findAllByFlightId(Long flightId);
}
