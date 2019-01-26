package per.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import per.demo.model.Friends;

import java.util.List;

public interface FriendsDao extends JpaRepository<Friends,Long> {
    public List<Friends> findByMyid(String id);
}
