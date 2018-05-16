package eugene.neocortex.fm.sequencer;

import eugene.neocortex.fm.sequencer.model.CargoOnBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface CargoOnBoardRepository extends JpaRepository<CargoOnBoard, Long> {
    Collection<CargoOnBoard> findAllByFlightId(Long flightId);
}
