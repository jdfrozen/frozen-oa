package com.frozen.frozenadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Userdao extends JpaRepository<User, Long> {

    public User findByUsername(String name);
}