package com.frank.repositry;

import com.frank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: xu.wr
 * @create: 2019-02-28 17:05
 **/
public interface UserRepository extends JpaRepository<User,Integer> {
    /*
     * 根据用户名查询
     * */
//    @Query("select t from User t where t.name = :name")
//    User findByUserName(@Param("name") String name);

    /*
     * 查询全部
     * */
//    @Query("select t from User t")
    @Override
    List<User> findAll();

    /*
     * 删除  必须加入@Modifying和@Transactional
     * */
//    @Modifying
//    @Transactional
//    @Query("delete from User u where u.id=:id")
//    int deleteUserById(@Param("id") Integer id);
//
//
//    @Modifying
//    @Transactional
//    @Query("update User u set u.name = :name where u.id=:id")
//    int queryUserById(@Param("id") Integer id,@Param("name") String name);
//
//    @Query(value = "insert into User value(?,?,?)", nativeQuery = true)
//    @Transactional
//    @Modifying
//    int countUserBy(@Param("id")Integer id,@Param("name") String name,@Param("password") String password);
}
