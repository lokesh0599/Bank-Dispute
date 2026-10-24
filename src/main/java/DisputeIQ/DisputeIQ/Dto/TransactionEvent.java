package DisputeIQ.DisputeIQ.Dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEvent {
    private String userId;
    private String txnId;
    private String date;
    private String Type;
    private Double amount;
    private String status;
    private String email;
}
