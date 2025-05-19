package minhtrieu.local.minhtrieu.modules.users.services.interfaces;

import minhtrieu.local.minhtrieu.modules.users.dtos.LoginRequest;
import minhtrieu.local.minhtrieu.modules.users.dtos.LoginResponse;

public interface UserServiceInterface {
    LoginResponse login(LoginRequest request);
}
