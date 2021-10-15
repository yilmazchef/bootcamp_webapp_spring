package com.stem.app;

import com.stem.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public void registerChildToBootCamp() {

        Child child = new Child();
        child.setId(1);

        Adult adult = new Adult();
        adult.setId(1);
        adult.setFirstName("Yilmaz");
        adult.setLastName("Mustafa");

        User adultUser = new User();

        adult.setUser(adultUser);

        child.setAdult(adult);

        child.setDateOfBirth(LocalDate.now().minusYears(7));

        User childUser = new User();

        child.setUser(childUser);

        BootcampEvent bootcamp = new BootcampEvent();
        bootcamp.setId(1);
        bootcamp.setTitle("Python");


        BootcampRegistration registration = new BootcampRegistration();
        registration.setChild(child);
        registration.setBootcamp(bootcamp);


    }

}
