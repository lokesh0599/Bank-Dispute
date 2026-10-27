package DisputeIQ.DisputeIQ.Service;

import DisputeIQ.DisputeIQ.Dto.RequestDispute;
import DisputeIQ.DisputeIQ.Dto.ResponseDispute;

import java.io.IOException;
import java.util.List;

public interface DisputeService {
    List<ResponseDispute> readDispute();


    ResponseDispute createDispute(RequestDispute requestDispute) throws IOException;

    ResponseDispute readDisputeById(String DisputeNumber);

    void updateDisputeStatus(String disputeNumber, String status);
}
