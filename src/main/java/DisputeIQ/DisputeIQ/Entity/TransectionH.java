package DisputeIQ.DisputeIQ.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransectionH {
    @Id
    private String id;
    private String userId;
    private String txnId;
    private String date;
    private String Type;
    private double amount;
    private String status;
}
