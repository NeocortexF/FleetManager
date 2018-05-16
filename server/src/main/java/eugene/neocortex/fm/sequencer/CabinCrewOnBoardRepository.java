package eugene.neocortex.fm.sequencer;

import eugene.neocortex.fm.sequencer.model.CabinCrewOnBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CabinCrewOnBoardRepository extends JpaRepository<CabinCrewOnBoard, Long> {
}
