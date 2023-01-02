package com.oauth2jwt.authorizationresourceserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userId;

    private String userName;
    private String userRole;

    private String password;

    private String userType;

    private String emailId;

    private String contactNumber;

    private Integer rating;

    private String dateOfRegistration;

}
