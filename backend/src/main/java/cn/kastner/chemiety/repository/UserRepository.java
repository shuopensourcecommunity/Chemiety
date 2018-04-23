package cn.kastner.chemiety.repository;

import cn.kastner.chemiety.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
    User findByUserId(String userId);
    User findByUserName(String userName);
}
