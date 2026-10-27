package DisputeIQ.DisputeIQ.Repository;

import DisputeIQ.DisputeIQ.Entity.Dispute;
import DisputeIQ.DisputeIQ.Entity.TransectionH;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DisputeRepository extends MongoRepository<Dispute ,String> {
    Optional<Dispute> findById(String DisputeNumber);
}
