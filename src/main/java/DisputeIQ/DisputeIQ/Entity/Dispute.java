package DisputeIQ.DisputeIQ.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;


import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dispute {
    @Id
    private String disputeNumber;
    private String userId;
    private String txnId;
    private String reason;
    private Double amount;
    private DisputeStatus status;
    private LocalDateTime createAt;
    private LocalDateTime resolveAt;
    private byte[] imgUrl;
    private TransectionH transection;


}
