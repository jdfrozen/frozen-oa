package com.frozen.frozenoa.controller.rest;

import com.frozen.frozenoa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Frozen
 * @Date: 2019/1/30 17:09
 * @Description:
 */
@RestController
public class StudentRest {
    @Autowired
    private StudentService studentService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/getAllStudent")
    public String getAllStudent(){
        try {
            return studentService.getAllStudent();
        }catch (Exception e){
            return null;
        }
    }
}
