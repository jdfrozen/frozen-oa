package com.frozen.frozenoa;

import com.frozen.frozenoa.po.Student;
import com.frozen.frozenoa.service.StudentService;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Auther: 冯默风
 * @Date: 2019/1/27 13:40
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Resource
    public StudentService studentService;

    @Test
    public void testStudentInsert() {
        Student student = new Student();
        student.setStudentId(21);
        student.setAge(21);
        student.setName("hehe");
        Assert.assertEquals(studentService.insert(student), true);
    }
}
