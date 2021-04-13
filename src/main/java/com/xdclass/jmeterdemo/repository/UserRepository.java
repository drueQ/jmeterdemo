package com.xdclass.jmeterdemo.repository;

import com.xdclass.jmeterdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByNameAndAndPassword(String name, String password);

    @Modifying
    @Transactional(timeout = 10)
    @Query("update User u set u.password=?1 where u.id=?2")
    public void updateById(String password,long id);
}
