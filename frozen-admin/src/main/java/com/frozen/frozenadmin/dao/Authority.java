package com.frozen.frozenadmin.dao;
import javax.persistence.*;


import java.util.List;
import java.util.Set;

@Entity
@Table(name = "AUTHORITY")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自动生成
    @Column(name="ID")
    private Long id;

    private String name;

    private String url;

    private int pid;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY)//懒加载   快速查询 不会查询role表
    @JoinTable(
            name = "ROlE_Auth",
            joinColumns = {@JoinColumn(name = "auth_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;

    public String getName(){
        return this.name;
    }
    //get set 略················

}