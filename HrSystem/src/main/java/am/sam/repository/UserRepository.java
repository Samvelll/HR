package am.sam.repository;

import am.sam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByRoleId(Long roleId);
    User findByEmail(String email);
}
