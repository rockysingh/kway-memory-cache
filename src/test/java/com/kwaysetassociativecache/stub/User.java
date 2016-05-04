package com.kwaysetassociativecache.stub;

import java.util.Random;
import java.util.UUID;

public class User {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    
    public User(String firstName, String lastName, String email){
        long range = 1234567L;
        Random r = new Random();
        this.id = (long) (r.nextDouble()*range);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
