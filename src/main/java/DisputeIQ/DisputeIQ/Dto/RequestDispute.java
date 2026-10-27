package DisputeIQ.DisputeIQ.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestDispute {
    private String txnId;
    private String reason;
    private MultipartFile imgUrl;

}
