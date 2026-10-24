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
    public Long DisputeNumber;
    public Long userId;
    public String txnId;
    public String reason;
    public Double amount;
    private DisputeStatus status;
    private String description;
    private LocalDateTime createAt;
    private LocalDateTime resolveAt;

}
