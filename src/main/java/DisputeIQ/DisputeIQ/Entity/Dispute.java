package DisputeIQ.DisputeIQ.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dispute {
    @Id
    private Long DisputeNumber;
    private Long userId;
    private String txnId;
    private String reason;
    private Double amount;
    private DisputeStatus status;
    private String description;
    private LocalDateTime createAt;
    private LocalDateTime resolveAt;
    private byte[] imgUrl;
    private TransectionH transection;

}
