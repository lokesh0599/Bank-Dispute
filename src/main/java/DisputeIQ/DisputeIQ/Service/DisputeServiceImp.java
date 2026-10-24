package DisputeIQ.DisputeIQ.Service;

import DisputeIQ.DisputeIQ.Dto.RequestDispute;
import DisputeIQ.DisputeIQ.Dto.ResponseDispute;
import DisputeIQ.DisputeIQ.Entity.Dispute;
import DisputeIQ.DisputeIQ.Entity.DisputeStatus;
import DisputeIQ.DisputeIQ.Entity.TransectionH;
import DisputeIQ.DisputeIQ.Repository.DisputeRepository;
import DisputeIQ.DisputeIQ.Repository.TransectionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DisputeServiceImp implements DisputeService{

    private final DisputeRepository disputeRepository;
    private final TransectionRepository transectionRepository;

    public List<ResponseDispute> readDispute (){
        log.info("Read All Dispute Records");
       List<Dispute> dispute = disputeRepository.findAll();
        List<ResponseDispute> responseDisputes= dispute.stream()
                .map(this::EntityToResponse)
                .collect(Collectors.toList());
        return responseDisputes;
    }

    public ResponseDispute AddDispute(RequestDispute requestDispute) throws IOException {
        log.info("Add Dispute Successfully");

        //Verify Transection id
        if(requestDispute.getTxnId() == null || requestDispute.getTxnId().isBlank()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Txn ID Is Required");
        }

        //Verify Reason
        if(requestDispute.getReason() == null || requestDispute.getReason().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reason Is Required");
        }

        //Verify image
        if(requestDispute.getImgUrl() == null || requestDispute.getImgUrl().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Image Is Required");
        }

        //Verify File Size
        var file = requestDispute.getImgUrl();
        if(file.getSize() > 2 * 1024 *1024){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File size is to large");
        }


        TransectionH transectionH = transectionRepository.findByTxnId(requestDispute.getTxnId())
                .orElseThrow(() -> new RuntimeException("Transection Not Found"));

        //Copy Original Transection Information Into A Snapshot
        TransectionH transectionH1 = TransectionH.builder()
                .txnId(transectionH.getTxnId())
                .userId(transectionH.getUserId())
                .date(transectionH.getDate())
                .Type(transectionH.getType())
                .amount(transectionH.getAmount())
                .status(transectionH.getStatus())
                .build();


        Dispute dispute = new Dispute();
        dispute.setTransection(transectionH1);
        dispute.setReason(requestDispute.getReason());
        dispute.setStatus(DisputeStatus.valueOf("OPEN"));

        dispute.setCreateAt(requestDispute.getCreateAt());
        dispute.setImgUrl(file.getBytes());

        Dispute saveDispute = disputeRepository.save(dispute);
        return EntityToResponse(saveDispute);
    }

    public ResponseDispute EntityToResponse(Dispute dispute){
        return ResponseDispute.builder()
                .DisputeNumber(dispute.getDisputeNumber())
                .userId(dispute.getUserId())
                .txnId(dispute.getTxnId())
                .reason(dispute.getReason())
                .amount(dispute.getAmount())
                .status(dispute.getStatus())
                .createAt(dispute.getCreateAt())
                .imgUrl(dispute.getImgUrl())
                .build();
    }

}
