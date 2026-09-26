package DisputeIQ.DisputeIQ.Dto;

import lombok.*;
import org.springframework.data.repository.cdi.Eager;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseUser {
    private String id;
    private String username;
    private String email;
}
