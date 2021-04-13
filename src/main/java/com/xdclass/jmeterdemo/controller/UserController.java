package com.xdclass.jmeterdemo.controller;

import com.xdclass.jmeterdemo.model.User;
import com.xdclass.jmeterdemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@Api(value = "测试接口", tags = "用户管理相关的接口", description = "用户测试接口")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    @ResponseBody
    public String hello1(){
        System.out.println("666666");
        return "hello  this is my first springboot project1";
    }

    @RequestMapping("/hello")
    public String index(){
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("index login");
        return "login";
    }

    @PostMapping("/login")
    public String loginUser( User user){

        System.out.println(user);
        return "index";
    }

    @PostMapping("/loginjson")
    public String loginUserjson( @RequestBody User user){

        System.out.println(user);
        return "index";
    }

    //方法参数说明，name参数名；value参数说明，备注；dataType参数类型；required 是否必传；defaultValue 默认值
    //@ApiImplicitParam(name = "user", value = "新增用户数据")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "根据id获取用户", notes = "获取用户")
    @GetMapping("/getUserById/{id}")
    public @ResponseBody User getUser(@PathVariable long id){
        User user = userService.findBYId(id);
        return user;
    }

    @GetMapping("/getAllUser")
    public @ResponseBody List<User> getAllUser(){
        List<User> users = userService.getAllUser();
        return users;
    }

    //方法参数说明，name参数名；value参数说明，备注；dataType参数类型；required 是否必传；defaultValue 默认值
    @ApiImplicitParam(name = "user", value = "新增用户数据")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "添加用户", notes = "添加1用户")
    @PostMapping("/addUser")
    @ResponseBody
    public void  addUser(@RequestBody User user){
        userService.addUser(user);
    }


    @PostMapping("/updateUser")
    public void  upateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @GetMapping("/delete/{id}")
    public void  delete(@PathVariable long id){
        userService.deleteById(id);
    }



}
