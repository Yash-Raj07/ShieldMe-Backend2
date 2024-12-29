package com.shieldme.authentication.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

@Data
@Document(collection = "forgot_password") // Annotation to define MongoDB collection
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ForgotPassword {

    @Id // Annotation for the unique identifier in MongoDB
    private String id;

    private Date expirationTime;

    @DBRef // Reference to another MongoDB document (User document)
    private User user;

    // Remove the explicit no-args constructor here as Lombok already provides it
    // public ForgotPassword() {
    // }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setOtp() {
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Custom Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Date expirationTime;
        private User user;

        public Builder otp(int otp) {
            return this;
        }

        public Builder expirationTime(Date expirationTime) {
            this.expirationTime = expirationTime;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public ForgotPassword build() {
            ForgotPassword forgotPassword = new ForgotPassword();
            forgotPassword.setOtp();
            forgotPassword.setExpirationTime(expirationTime);
            forgotPassword.setUser(user);
            return forgotPassword;
        }

        public Builder userId(String id) {
            return userId(id);
        }
    }
}
