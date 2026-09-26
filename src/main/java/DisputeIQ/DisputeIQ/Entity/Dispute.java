package DisputeIQ.DisputeIQ.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dispute {
    @Id
    public String DisputeNumber;
    public String customerId;
    public String transectionId;
    public String reason;
    public Double disputeAmount;
    private DisputeStatus status;
    private String description;
    private LocalDateTime createAt;
    private LocalDateTime resolveAt;
    private String imeUrl;

}
