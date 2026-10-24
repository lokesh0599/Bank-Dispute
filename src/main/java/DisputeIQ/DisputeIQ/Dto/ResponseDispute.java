package DisputeIQ.DisputeIQ.Dto;

import DisputeIQ.DisputeIQ.Entity.DisputeStatus;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseDispute {
    public Long DisputeNumber;
    public Long userId;
    public String txnId;
    public String reason;
    public Double amount;
    private DisputeStatus status;
    private String description;
    private LocalDateTime createAt;
    private LocalDateTime resolveAt;
    private byte[] imgUrl;
}
