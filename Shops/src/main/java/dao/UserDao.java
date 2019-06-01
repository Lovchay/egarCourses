package dao;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL = "SELECT * FROM USER";

    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(SQL);

        for(Map<String,Object> row : rows){
            User user = new User();
            user.setId((Long) row.get("id"));
            user.setLogin((String) row.get("login"));
            user.setPassword((String) row.get("password"));
            user.setNickname((String) row.get("nickname"));
            user.setBasket_id((Long) row.get("basket_id"));

            users.add(user);
        }

        return users;
    }
}
