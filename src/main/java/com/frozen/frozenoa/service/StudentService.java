package com.frozen.frozenoa.service;

import com.frozen.frozenoa.dao.StudentMapper;
import com.frozen.frozenoa.po.Student;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Frozen
 * @Date: 2019/1/3 19:19
 * @Description:
 */
@Service
public class StudentService {

    @Resource
    public StudentMapper studentMapper;

    public boolean insert(Student student) {
        return studentMapper.insert(student) > 0 ? true : false;
    }

    public String getAllStudent(){
        List<Student> list =studentMapper.findAll();
        return list.toString();
    }

}
