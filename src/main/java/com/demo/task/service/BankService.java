package com.demo.task.service;

import com.demo.task.entity.User;
import com.demo.task.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    BankRepository bankRepository;

    public static Integer giveMoney(User user,Integer sum){
        if ((user.getSum() > sum) && (sum % 100 == 0 || sum % 200 == 0 || sum % 500 == 0)) {
            sum = user.getSum()+sum;
        }else System.out.println("Incorrect sum");
        return user.setSum(sum);
    }
    public static Integer takeMoney(User user, Integer sum){
        if ((user.getSum() > sum) && (sum % 100 == 0 || sum % 200 == 0 || sum % 500 == 0)) {
            sum = user.getSum()-sum;
            } else System.out.println("Operation invalid");
        return user.setSum(sum);
    }
}
