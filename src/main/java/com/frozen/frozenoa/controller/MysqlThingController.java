package com.frozen.frozenoa.controller;

import com.frozen.frozenoa.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Frozen
 * @Date: 2019/1/10 11:05
 * @Description:
 *  演示事物的传播性，和隔离性
 */
@Slf4j
@RestController
public class MysqlThingController {
    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "/getAllStudent")
    public String getAllStudent(){
        try {
            return studentService.getAllStudent();
        }catch (Exception e){
            return null;
        }
    }

}
