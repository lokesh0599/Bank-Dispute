package DisputeIQ.DisputeIQ.Repository;

import DisputeIQ.DisputeIQ.Entity.Dispute;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DisputeRepository extends MongoRepository<Dispute ,String> {
}
