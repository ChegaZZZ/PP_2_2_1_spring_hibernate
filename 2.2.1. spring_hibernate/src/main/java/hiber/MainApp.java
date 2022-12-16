package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("BMW", 7);
        Car car2 = new Car("Audi", 4);
        Car car3 = new Car("Opel", 1);
        Car car4 = new Car("Porsche", 9);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

        List<User> users = userService.listUsers();

        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        User user1 = userService.getUserByCar("Audi", 4);
        User user2 = userService.getUserByCar("Opel", 1);

        System.out.println();
        System.out.println(user1);
        System.out.println(user2);

        context.close();
    }
}