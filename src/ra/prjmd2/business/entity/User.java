package ra.prjmd2.business.entity;

import ra.prjmd2.utils.InputMethods;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private boolean status;
    private RoleName role;

    public User() {
    }

    public User(int id, String username, String password, String fullName, String email, String phone, boolean status, RoleName role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
    public void inputUsername(){
        this.username = InputMethods.getString();
    }
    public void inputPassword(){
        this.password = InputMethods.getString();
    }
    public void inputEmail(){
        this.email = InputMethods.getString();
    }
    public void inputPhoneNumber(){
        this.phone = InputMethods.getString();
    }
    public void inputFullname(){
        this.fullName = InputMethods.getString();
    }
}
