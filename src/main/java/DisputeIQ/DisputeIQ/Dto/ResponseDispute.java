package DisputeIQ.DisputeIQ.Dto;

import DisputeIQ.DisputeIQ.Entity.DisputeStatus;
import DisputeIQ.DisputeIQ.Entity.TransectionH;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseDispute {
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
    private String date;
    private String Type;

}
