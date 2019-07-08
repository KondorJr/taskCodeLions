package com.demo.task.controller;

import com.demo.task.entity.User;
import com.demo.task.service.BankService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankController {

    @PostMapping("/give")
    public void giveMoney(@RequestParam User user,
                          @RequestParam Integer sum){
        BankService.giveMoney(user, sum);
    }

    @PostMapping("/take")
    public void takeMoney(@RequestParam User user,
                          @RequestParam Integer sum){
        BankService.takeMoney(user, sum);
    }
}
