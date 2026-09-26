package DisputeIQ.DisputeIQ.Controller;

import DisputeIQ.DisputeIQ.Dto.RequestUser;
import DisputeIQ.DisputeIQ.Dto.ResponseUser;
import DisputeIQ.DisputeIQ.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/addUser")
    public ResponseEntity<ResponseUser> addUser(@RequestBody RequestUser requestUser){
        return ResponseEntity.ok(userService.addUser(requestUser));
    }
}
