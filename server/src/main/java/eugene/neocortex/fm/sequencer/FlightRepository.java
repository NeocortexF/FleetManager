package eugene.neocortex.fm.sequencer;

import eugene.neocortex.fm.sequencer.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface FlightRepository extends JpaRepository<Flight, Long> {
}
