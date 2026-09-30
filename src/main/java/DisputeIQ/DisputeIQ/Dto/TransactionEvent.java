package DisputeIQ.DisputeIQ.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class TransactionEvent {
    private String userId;
    private String txnId;
    private String date;
    private String Type;
    private double amount;
    private String status;
}
