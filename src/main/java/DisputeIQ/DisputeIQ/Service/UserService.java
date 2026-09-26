package DisputeIQ.DisputeIQ.Service;

import DisputeIQ.DisputeIQ.Dto.RequestUser;
import DisputeIQ.DisputeIQ.Dto.ResponseUser;

public interface UserService {
    ResponseUser addUser(RequestUser requestUser);
}
