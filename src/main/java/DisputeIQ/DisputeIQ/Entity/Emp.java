package DisputeIQ.DisputeIQ.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Emp {
    @Id
    public String id;
    public String username;
    public String password;
    public String email;
}
