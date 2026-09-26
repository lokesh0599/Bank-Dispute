package DisputeIQ.DisputeIQ.Service;

import DisputeIQ.DisputeIQ.Dto.RequestTransection;
import DisputeIQ.DisputeIQ.Dto.ResponseTransection;
import DisputeIQ.DisputeIQ.Entity.TransectionH;
import DisputeIQ.DisputeIQ.Entity.User;
import DisputeIQ.DisputeIQ.Repository.TransectionRepository;
import DisputeIQ.DisputeIQ.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransectionServiceImp implements TransectionService {

      private final TransectionRepository transectionRepository;
      private final UserRepository userRepository;
      @Override
      public List<ResponseTransection> readTransection(String userId){
       log.info("Fetch All Transections{}",userId);
       List<TransectionH> transectionH = transectionRepository.findByUserId(userId);
       List<ResponseTransection> responseTransections= transectionH.stream()
               .map(this::ConvertToResponse)
               .collect(Collectors.toList());

       log.info("Transection Read Successfully");
       return responseTransections;
     }

       public ResponseTransection addTransection(RequestTransection requestTransection){
          log.info("Add Transection");
          String userId = requestTransection.getUserId();
          User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
          TransectionH transectionEntity = TransectionToEntity(requestTransection);
          TransectionH savedTransection = transectionRepository.save(transectionEntity);
          return ConvertToResponse(savedTransection);
       }

       public ResponseTransection readTransectionById(String id){
          log.info("Read Transection");

          TransectionH transectionH = transectionRepository
                  .findById(id).orElseThrow(() -> new RuntimeException("Transection Id Not Found"));
          return ConvertToResponse(transectionH);
       }
       public void deleteTrensectionById(String id){
          TransectionH transectionH = transectionRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Transection Id Not Found"));
          transectionRepository.delete(transectionH);
       }

    private TransectionH TransectionToEntity(RequestTransection request){
          return TransectionH.builder()
                  .txnId(request.getTxnId())
                  .userId(request.getUserId())
                  .date(request.getDate())
                  .Type(request.getType())
                  .amount(request.getAmount())
                  .status(request.getStatus()).build();
    }
    private ResponseTransection ConvertToResponse(TransectionH transectionH){
        return ResponseTransection.builder()
                .id(transectionH.getId())
                .userId(transectionH.getUserId())
                .txnId(transectionH.getTxnId())
                .date(transectionH.getDate())
                .Type(transectionH.getType())
                .amount(transectionH.getAmount())
                .status(transectionH.getStatus())
                .build();
    }
}
