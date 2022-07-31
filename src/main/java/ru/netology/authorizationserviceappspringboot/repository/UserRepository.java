package ru.netology.authorizationserviceappspringboot.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationserviceappspringboot.model.Authorities;
import ru.netology.authorizationserviceappspringboot.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<User, List<Authorities>> listMap = new ConcurrentHashMap<>();
    private final List<Authorities> permissions = new ArrayList<>();

    public List<Authorities> getUserAuthorities(String user, String password) {

        //Create a User for the test
        listMap.put(new User("Vasilev", "Qwer2022"),
                Arrays.asList(Authorities.DELETE, Authorities.READ));

        for (Map.Entry<User, List<Authorities>> entry : listMap.entrySet()) {
            //System.out.println(entry.getKey() + "/" + entry.getValue());
            if (entry.getKey().getName().equals(user)
                    && entry.getKey().getPassword().equals(password)) {
                return entry.getValue();
            }
        }
        return permissions;
    }
}
