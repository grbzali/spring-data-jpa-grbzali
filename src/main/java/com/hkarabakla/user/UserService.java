package com.hkarabakla.user;

import com.hkarabakla.adress.Address;
import com.hkarabakla.order.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserService {

    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public void userNameSearch() {
        User u = new User();
        u.setName("user");


        Address address = new Address();
        address.setStreet("Gazi sokak");
        address.setNumber("7");
        address.setCity("Istanbul");

        u.setAddress(address);

        Order order = new Order();
        order.setTotal(10.00);

        Order order1 = new Order();
        order1.setTotal(15.0);

        u.setOrders(Arrays.asList(order,order1));

        repo.save(u);

        System.out.println(repo.findAllByNameContainingIgnoreCase("se"));
    }
}