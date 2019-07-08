package com.demo.task.service;

import com.demo.task.entity.Bank;
import com.demo.task.entity.User;
import com.demo.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public  User getById(Long id){
        return userRepository.getOne(id);
    }
    public void saveInfo(User user){
        userRepository.save(user);
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }
    public void putMoney(User user, Integer sum){
        BankService.giveMoney(user,sum);
    }
    public void takeMoney(User user, Integer sum){
        BankService.takeMoney(user,sum);
    }
    public Integer setBalance(User user, Long id, Integer sum){
        Scanner scanner = new Scanner(System.in);
        if (user.getId() == id){
            sum = scanner.nextInt();
        } else System.out.println("User not found");
        return  user.setSum(sum);
    }
    public void transMoney(User user1, User user2, Integer sum){
        if (user1.getSum() > 0 || user1.getSum() > sum){
            user1.setSum(user1.getSum()-sum);
            user2.setSum(user2.getSum()+sum);
            System.out.println("Transfer done");
        }else System.out.println("Invalid sum or you have not enough money");
    }
}
