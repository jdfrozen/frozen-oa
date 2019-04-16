package com.frozen.frozenadmin.dao;


import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(length = 25)
    private String name;
    //懒加载 不会查询role表
    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private List<User> users;
    //急加载 会查询role表
    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private List<Authority> Authoritys;

    public List<Authority> getAuthoritys(){
        return this.Authoritys;
    }

    //get  set方法略·········
}