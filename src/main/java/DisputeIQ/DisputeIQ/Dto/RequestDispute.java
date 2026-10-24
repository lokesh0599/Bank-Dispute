package DisputeIQ.DisputeIQ.Dto;

import DisputeIQ.DisputeIQ.Entity.DisputeStatus;
import DisputeIQ.DisputeIQ.Entity.TransectionH;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Builder
public class RequestDispute {
    private String txnId;
    private String reason;
    private DisputeStatus status;
    private LocalDateTime createAt;
    private MultipartFile imgUrl;
    private TransectionH transection;
}
