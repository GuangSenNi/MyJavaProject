package per.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import per.demo.model.Comments;

import java.util.List;

public interface CommentsDao extends JpaRepository<Comments,Long> {
    public List<Comments> findByTid(String tid);
}
