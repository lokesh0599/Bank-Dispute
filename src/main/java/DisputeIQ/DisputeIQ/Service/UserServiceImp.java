package DisputeIQ.DisputeIQ.Service;

import DisputeIQ.DisputeIQ.Dto.RequestUser;
import DisputeIQ.DisputeIQ.Dto.ResponseUser;
import DisputeIQ.DisputeIQ.Entity.User;
import DisputeIQ.DisputeIQ.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public ResponseUser addUser(RequestUser requestUser) {
        User user = convertToEntity(requestUser);
        user = userRepository.save(user);
        return convertToResponse(user);
    }

    private User convertToEntity(RequestUser requestUser) {
        return User.builder()
                .email(requestUser.getEmail())
                .password(requestUser.getPassword())
                .username(requestUser.getUsername()).build();
    }

    private ResponseUser convertToResponse(User register) {
        return ResponseUser.builder()
                .id(register.getId())
                .username(register.getUsername())
                .email(register.getEmail()).build();
    }
}