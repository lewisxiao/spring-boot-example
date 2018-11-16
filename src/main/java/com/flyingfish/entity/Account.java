package com.flyingfish.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Account extends BaseModel {
    @NotEmpty
    private String salt;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUsername() {
        return this.username;
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
}
