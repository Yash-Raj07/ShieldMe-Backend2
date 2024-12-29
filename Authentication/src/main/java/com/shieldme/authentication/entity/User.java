package com.shieldme.authentication.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private String userId;

    private String name;

    private String email;

    private String password;

    private final String profileImage; // Base64

    private final Role role; // "ADMIN", "USER", "MODERATOR"

    public User(String userId, String profileImage) {
        this.userId = userId;
        this.profileImage = profileImage;
        this.role = Role.USER; // Default to "USER"
    }

    public User(String profileImage, Role role) {


        this.profileImage = profileImage;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImage() {
        return profileImage;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", role=" + role +
                '}';
    }

    public String getId() {
        return getId();
    }
}
