package com.cydeo.entity;


import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//Specifically we didn't put AllArgConstructor cause class is extending and
// Lombok is not creating constructor which is including super class fields
//So we need to create Constructor manually for this class by including super class fields as well
@NoArgsConstructor
@Data
public class User extends BaseEntity{
    public User(Long id, LocalDateTime insertDateTime, Long insertUserId,
                LocalDateTime lastUpdateDateTime, Long lastUpdateUserId,
                String firstName, String lastName, String email,
                String password, boolean enabled, String phone,
                Role role, Gender gender) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.phone = phone;
        this.role = role;
        this.gender = gender;
    }


    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean enabled;
    private String phone;
    private Role role;
    private Gender gender;



}
