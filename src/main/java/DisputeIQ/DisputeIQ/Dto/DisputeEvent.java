package DisputeIQ.DisputeIQ.Dto;

import DisputeIQ.DisputeIQ.Entity.DisputeStatus;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Builder
@Setter
@Getter
public class DisputeEvent {
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
