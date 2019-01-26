package com.employ.dao;

import com.employ.model.Arrange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArrangeDao extends JpaRepository<Arrange,Long> {

    @Query(value = "select * from arrange where (cmajor = ?1 or cmajor ='不限制') and unix_timestamp(ctime) <= unix_timestamp(?2)", nativeQuery = true)//?1表示第一个参数，?2表示第二个参数
    public List<Arrange> findByMajor0(String major, String time);
    @Query(value = "select * from arrange where academic = ?1 and unix_timestamp(ctime) <= unix_timestamp(?2)", nativeQuery = true)//?1表示第一个参数，?2表示第二个参数
    public List<Arrange> findByAcademic0(String academic, String time);

}
