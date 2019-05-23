package model;

public class User {

    private Long id;
    private String login;
    private String password;
    private String nickName;
    private Long basketId;

    public User() {
    }

    public User(Long id, String login, String password, String nickName, Long basketId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nickName = nickName;
        this.basketId = basketId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", basketId=" + basketId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
