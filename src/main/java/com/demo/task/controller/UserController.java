package com.demo.task.controller;

import com.demo.task.entity.User;
import com.demo.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public void saveUser(@RequestBody @Valid User user){
        if (user == null) System.err.println(HttpStatus.BAD_REQUEST);
        else {
            userService.saveInfo(user);
            System.out.println(HttpStatus.CREATED);
        }
    }
    @PostMapping("/take")
    public void takeMoney(@RequestParam User user,
                          @RequestParam Integer sum){
        if (user == null) System.err.println(HttpStatus.BAD_REQUEST);
        else {
            userService.takeMoney(user, sum);
            System.out.println(HttpStatus.OK);
        }
    }

    @PostMapping("/give")
    public void giveMoney(@RequestParam User user,
                          @RequestParam Integer sum){
        if (user == null) System.err.println(HttpStatus.BAD_REQUEST);
        else {
            userService.putMoney(user, sum);
            System.out.println(HttpStatus.OK);
        }
    }

    @PostMapping("/money")
    public void setBalance(@RequestParam User user,
                           @RequestParam Long id,
                           @RequestParam Integer sum){
        if (user == null) System.err.println(HttpStatus.BAD_REQUEST);
        else {
            userService.setBalance(user, id, sum);
            System.out.println(HttpStatus.OK);
        }
    }

    @PostMapping("/trans")
    public void transMoney(@RequestParam User user1,
                           @RequestParam User user2,
                           @RequestParam Integer sum){
        if (user1 == null || user2 == null) System.err.println(HttpStatus.BAD_REQUEST);
        else {
            userService.transMoney(user1,user2, sum);
            System.out.println(HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public void getUserById(@PathVariable Long id){
        if (id == 0 || id < 0) System.err.println(HttpStatus.BAD_REQUEST);
        else userService.getById(id);
    }

    @GetMapping()
    public void getUsers(@RequestBody User user){
        if (user == null) System.err.println(HttpStatus.BAD_REQUEST);
        else userService.getAll();
    }

    @DeleteMapping("/{id}")
    public void search(@PathVariable Long id){
        userService.deleteById(id);
    }


}
