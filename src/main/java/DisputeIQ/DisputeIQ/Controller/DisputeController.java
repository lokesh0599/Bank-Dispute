package DisputeIQ.DisputeIQ.Controller;

import DisputeIQ.DisputeIQ.Dto.ResponseDispute;
import DisputeIQ.DisputeIQ.Service.DisputeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dispute")
@RequiredArgsConstructor
public class DisputeController {

    private final DisputeService disputeService;

    @GetMapping("/read")
    public ResponseEntity<List<ResponseDispute>> readDispute (){
          List<ResponseDispute> responseDisputes = disputeService.readDispute();
          return ResponseEntity.ok(responseDisputes);
    }


}
