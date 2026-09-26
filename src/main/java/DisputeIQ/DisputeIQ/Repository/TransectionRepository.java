package DisputeIQ.DisputeIQ.Repository;

import DisputeIQ.DisputeIQ.Entity.TransectionH;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface TransectionRepository extends MongoRepository<TransectionH, String> {
    List<TransectionH> findByUserId(String userId);
    Optional<TransectionH> findById(String id);
}
