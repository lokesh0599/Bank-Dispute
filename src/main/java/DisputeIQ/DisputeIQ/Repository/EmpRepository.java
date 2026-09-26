package DisputeIQ.DisputeIQ.Repository;

import DisputeIQ.DisputeIQ.Entity.Emp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpRepository extends MongoRepository<Emp,String> {
}
