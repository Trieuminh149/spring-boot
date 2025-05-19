package minhtrieu.local.minhtrieu.modules.users.services.impl;

import minhtrieu.local.minhtrieu.services.BaseService;
import minhtrieu.local.minhtrieu.modules.users.dtos.LoginResponse;
import minhtrieu.local.minhtrieu.modules.users.dtos.UserDTO;
import minhtrieu.local.minhtrieu.modules.users.dtos.LoginRequest;
import minhtrieu.local.minhtrieu.modules.users.services.interfaces.UserServiceInterface;

import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService implements UserServiceInterface {

    @Override
    public LoginResponse login(LoginRequest request) {
        try {
            String email = request.getEmail();
            String password = request.getPassword();

            // Tạm kiểm tra cứng: luôn thành công
            if (email != null && password != null) {
                String token = "random_token";
                UserDTO user = new UserDTO(1L, "trieuminh2109@gmail.com");
                return new LoginResponse(token, user);
            } else {
                throw new RuntimeException("Email hoặc mật khẩu không hợp lệ");
            }

        } catch (Exception e) {
            throw new RuntimeException("Có vấn đề xảy ra");
        }
    }
}
