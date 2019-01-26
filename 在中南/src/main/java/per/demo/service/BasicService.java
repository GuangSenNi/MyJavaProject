package per.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.demo.dao.CommentsDao;
import per.demo.dao.FriendsDao;
import per.demo.dao.TieDao;
import per.demo.dao.UserDao;
import per.demo.model.Comments;
import per.demo.model.Friends;
import per.demo.model.Tie;
import per.demo.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BasicService {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/user")
    public User findById(){//demo
        System.out.print("come in");
        User u=new User();
        u.setUserid("1");
        u.setUsername("Tom");
        userDao.save(u);
        return userDao.findByUserid("1");
    }

    //查找感兴趣的内容
    @Autowired
    private TieDao tieDao;
    public List<Tie> findRelated(String userid){
        User u=userDao.findByUserid(userid);
        String[] interest=u.getInterested().split("#");
        List list1=new ArrayList();
        for(String i:interest){
            List list2=tieDao.findByType(i);
            list1.addAll(list2);
        }
        return list1;
    }

    //查找评论
    @Autowired
    private CommentsDao commentsDao;
    public List<Comments> findComments(String tid){
        return commentsDao.findByTid(tid);
    }

    //查找好友
    private FriendsDao friendsDao;
    private List<User> findFriends(String myid){
        List<Friends> list1=friendsDao.findByMyid(myid);
        List<User> list2=new ArrayList<>();
        for(Friends f:list1){
            User u=userDao.findByUserid(f.getFid());
            list2.add(u);
        }
        return list2;
    }
}
