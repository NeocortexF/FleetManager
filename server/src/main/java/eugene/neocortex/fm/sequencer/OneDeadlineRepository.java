package eugene.neocortex.fm.sequencer;


import eugene.neocortex.fm.sequencer.models.OneDeadline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OneDeadlineRepository extends JpaRepository<OneDeadline, Long> {
}
