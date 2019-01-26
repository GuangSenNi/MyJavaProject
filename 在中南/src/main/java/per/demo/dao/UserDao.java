package per.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import per.demo.model.User;

public interface UserDao extends JpaRepository<User,String> {

    public User findByUserid(String id);
}
