package model;

public class User {

    private Long id;
    private String login;
    private String password;
    private String nickname;
    private Long basket_id;

    public User() {
    }

    public User(Long id, String login, String password, String nickname, Long basket_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.basket_id = basket_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(Long basket_id) {
        this.basket_id = basket_id;
    }
}
