package per.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import per.demo.model.Tie;

import java.util.List;

public interface TieDao extends JpaRepository<Tie,Long> {

    public List<Tie> findByType(String type);

    public List<Tie> findByOwner(String owner);


}
