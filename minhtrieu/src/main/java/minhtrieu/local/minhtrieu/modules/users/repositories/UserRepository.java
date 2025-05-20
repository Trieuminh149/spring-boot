package minhtrieu.local.minhtrieu.modules.users.repositories;

import minhtrieu.local.minhtrieu.modules.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
