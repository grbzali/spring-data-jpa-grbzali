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
        User user = new User();
        user.setName("user1");
        u.setName("user");


        Address address = new Address();
        address.setStreet("Gazi sokak");
        address.setNumber("7");
        address.setCity("Istanbul");

        Address address1 = new Address();
        address1.setStreet("Vatan Cad.");
        address1.setNumber("11");
        address1.setCity("Kahramanmaraş");
        user.setAddress(address1);
        u.setAddress(address);

        Order order = new Order();
        order.setTotal(10.00);

        Order order1 = new Order();
        order1.setTotal(15.0);

        Order order2 = new Order();
        order2.setTotal(17.0);
        u.setOrders(Arrays.asList(order, order1));
        user.setOrders(Arrays.asList(order2));

        repo.save(u);
        repo.save(user);

        System.out.println(repo.findAllByNameContainingIgnoreCase("user"));

    }
}