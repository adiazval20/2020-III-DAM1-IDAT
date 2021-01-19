package edu.idat.idatgram.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String username;
    private String password;

    public Usuario() {
        this.id = 0;
        this.username = "";
        this.password = "";
    }

    public Usuario(String username, String password) {
        this.id = 0;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
