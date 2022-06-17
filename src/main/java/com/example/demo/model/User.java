package com.example.demo.model;
import javax.persistence.Column;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name="users")
//
//public class user {
//
//	@Id
//	private String email;
//	private String password;
//	
//	public user(String email, String password){
//		this.email = email;
//		this.password = password;
//	}
//	
//	public String getEmail() {
//		return this.email;
//	}
//	
//	public String getPassword() {
//		return this.password;
//	}
//	
//}
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "users")
@DynamicUpdate
public class User {
    private @Id @GeneratedValue int id;
    @Column(unique=true)
    private @NotBlank String username;
    @Column(unique=true)
    private @NotBlank @Email String email;
    @Column(unique=true)
    private @NotBlank String password;
    private String phone_number;
    @Column(unique=true)
    private @NotBlank String cnic;
    private @NotBlank String type;
    private @NotBlank @CreationTimestamp Timestamp date_of_joining;
    private @NotBlank boolean loggedIn;

    public User() {
    }

    public User(@NotBlank String username,
    		    @NotBlank String email,
                @NotBlank String password,
                String phone_number,
                @NotBlank String cnic,
                @NotBlank String type) {
    	
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.cnic = cnic;
        this.type = type;
        this.loggedIn = false;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }	
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }	
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username, password, phone_number, cnic, type, date_of_joining, 
                            loggedIn);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", cnic='" + cnic + '\'' +
                ", type='" + type + '\'' +
                ", date_of_joining='" + date_of_joining + '\'' +
                ", loggedIn=" + loggedIn +
                '}';
    }


}