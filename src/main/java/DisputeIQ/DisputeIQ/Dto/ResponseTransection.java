package DisputeIQ.DisputeIQ.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTransection {
    private String id;
    private String userId;
    private String txnId;
    private String date;
    private String Type;
    private double amount;
    private String status;
}
