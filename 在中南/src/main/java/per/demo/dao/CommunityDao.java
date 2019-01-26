package per.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import per.demo.model.Community;



public interface CommunityDao extends JpaRepository<Community,String> {
    public Community findByComid(String id);

    public Community findByComname(String name);
}
