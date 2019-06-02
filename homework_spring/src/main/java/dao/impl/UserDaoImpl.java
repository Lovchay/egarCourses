package dao.impl;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rowMapper.UserRowMapper;

import java.util.List;
@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUsers() {
        String sql = "Select * from user";
//        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        RowMapper<User> rowMapper = new UserRowMapper();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public User getUserDyId(Long id) {
        String sql = "Select id,login,password,nickname,basket_id from user where id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql,rowMapper,id);
        return null;
    }

//    @Override
//    public void addUser(User user) {
//        String sql = "INSERT INTO (id,login,password,nickname,basket_id) values (?,?,?,?,?)";
//        jdbcTemplate.query(sql,
//                user.getId(),
//                user.getLogin(),
//                user.getPassword(),
//                user.getNickname(),
//                user.getBasket_id());
//
//        // fetch user id
//        sql = "SELECT id from user where login = ? and password = ?";
//        jdbcTemplate.queryForObject(sql,Long.class,user.getLogin(),user.getPassword());
//
//        // set user id
//        user.setId(5L);
//    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE user set login = ?, password = ? where id = ?";
        jdbcTemplate.update(sql,user.getLogin(),user.getPassword(),user.getId());
    }

    @Override
    public void deleteUser(Long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public boolean userExists(String login, String password) {
        String sql = "select count(*) from user where login = ? and password = ?";
        int count = jdbcTemplate.queryForObject(sql,Integer.class,login,password);
        if (count == 0){
            return false;
        }else {
            return true;
        }
    }
}
