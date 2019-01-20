package com.frozen.frozenoa.dao;

import com.frozen.frozenoa.po.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Frozen
 * @Date: 2019/1/3 19:21
 * @Description:
 */
@Mapper
public interface StudentMapper {
    /**
     * 插入学生
     * @param s
     * @return
     */
    Integer insert(Student s);

    /**
     * 查询所有学生
     * @return
     */
    List<Student> findAll();

    /**
     * 根据学号删除学生
     * @param pojo
     * @return
     */
    Integer delByStudentId(@Param("pojo") Student pojo);

    /**
     * 根据学生ID列表查询学生列表
     * @param studentIds
     * @return
     */
    List<Student> findByStudentIds(List<Integer> studentIds);
}
