import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
//        // Получение всех юзеров через SELECT(не параметризированный)
//        List<User> userList = userService.findAll();
//        for (User user1:userList) {
//            System.out.println(user1.toString());
//        }
//        // Получение всех юзеров через SELECT (параметризированный)
//        User user = userService.getOne(2L);
//        System.out.println(user);
//
//        // Добавление юзера через INSERT INTO
//        try{
//            String url = "jdbc:mysql://localhost:3306/shop?useSSL=false";
//            String username = "root";
//            String password = "root";
//            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
//
//            try (Connection conn = DriverManager.getConnection(url, username, password)){
//
//                Statement statement = conn.createStatement();
//                int rows = statement.executeUpdate("INSERT into user(id,login,password,nickname,basket_id) VALUES (4,'vvv','bbb','nnn',4)");
//                System.out.printf("Added %d rows", rows);
//            }
//        }
//        catch(Exception ex){
//            System.out.println("Connection failed...");
//
//            System.out.println(ex);
//        }
//        //Обновление юзера через UPDATE(параметризированный)
//        User user1 = userService.getOne( 2L);
//        System.out.println(user1);
//        user1 = userService.updateUser();
//        System.out.println(user1);

        // Использование CallableStatement и встроеной процедуры fun которая складывает 2 числа передаваемые в метод
        int user2= userService.CallableStatementExample();
        System.out.println(user2);
    }
}
