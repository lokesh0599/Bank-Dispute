package DisputeIQ.DisputeIQ.Controller;

import DisputeIQ.DisputeIQ.Dto.RequestTransection;
import DisputeIQ.DisputeIQ.Dto.ResponseTransection;
import DisputeIQ.DisputeIQ.Service.TransectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class TransectionController {
    private final TransectionService transectionService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ResponseTransection>> readTransection(@PathVariable String userId){
        List<ResponseTransection> transections = transectionService.readTransection(userId);
        return ResponseEntity.ok(transections);
    }

    @PostMapping("/addTransection/{userId}")
    public ResponseEntity<ResponseTransection> addTransection(@RequestBody RequestTransection requestTransection){
       String userId = requestTransection.getUserId();
        if(userId == null || userId.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST ,"userId not found");
        }
        return ResponseEntity.ok(transectionService.addTransection(requestTransection));
    }

    @GetMapping("/readTransectin{id}")
    public ResponseEntity<ResponseTransection> readTransectionById(@PathVariable String id){
        ResponseTransection responseTransections = transectionService.readTransectionById(id);
        return ResponseEntity.ok(responseTransections);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransectionById(@PathVariable String id){
       transectionService.deleteTrensectionById(id);
    }
}
