package DisputeIQ.DisputeIQ.Service;

import DisputeIQ.DisputeIQ.Dto.RequestTransection;
import DisputeIQ.DisputeIQ.Dto.ResponseTransection;

import java.util.List;

public interface TransectionService {
    List<ResponseTransection> readTransection(String userId);

    ResponseTransection addTransection(RequestTransection requestTransection);

    ResponseTransection readTransectionById(String id);

    void deleteTrensectionById(String id);
}
