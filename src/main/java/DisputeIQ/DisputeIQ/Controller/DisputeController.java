package DisputeIQ.DisputeIQ.Controller;

import DisputeIQ.DisputeIQ.Dto.RequestDispute;
import DisputeIQ.DisputeIQ.Dto.ResponseDispute;
import DisputeIQ.DisputeIQ.Service.DisputeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @PostMapping(
            value = "addDispute",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseDispute> createDispute(@RequestParam("txnId") String txnId,
                                                         @RequestParam("reason") String reason,
                                                         @RequestParam("imgUrl")MultipartFile imgUrl
                                                         ) throws IOException {
        RequestDispute requestDispute = new RequestDispute();
        requestDispute.setTxnId(txnId);
        requestDispute.setReason(reason);
        requestDispute.setImgUrl(imgUrl);

        return ResponseEntity.ok(disputeService.createDispute(requestDispute));
    }
    @GetMapping("read/{disputeNumber}")
    public ResponseEntity<ResponseDispute> readDisputeById(@PathVariable("disputeNumber") String disputeNumber) {
        ResponseDispute responseDisputes= disputeService.readDisputeById(disputeNumber);
        return ResponseEntity.ok(responseDisputes);
    }
    @PatchMapping("status/{disputeNumber}")
    public void updateDisputeStatus(@PathVariable("disputeNumber") String disputeNumber, @RequestParam String status){
        disputeService.updateDisputeStatus(disputeNumber,status);
    }
}
