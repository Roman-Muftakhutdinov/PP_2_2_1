package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",
              new Car("Range Rover", 2017)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",
              new Car("Q8", 2018)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",
              new Car("Superb", 2012)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",
              new Car("v90", 2020)));
      userService.add(new User("User11", "Lastname11", "user11@mail.ru",
              new Car("Range Rover Velar", 2021)));



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      List<User> usersCar = userService.getUserWithCar("Range Rover Velar", 2021);
      for (User userCar:usersCar ) {
         System.out.println("Id= "+userCar.getId());
         System.out.println("First Name= "+userCar.getFirstName());
         System.out.println("Last Name= "+userCar.getLastName());
         System.out.println("Email= "+userCar.getEmail());
         System.out.println("Car= " + userCar.getCar());
      }

      context.close();
   }
}
