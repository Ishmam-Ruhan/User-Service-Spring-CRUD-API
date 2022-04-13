package com.ishmamruhan.UserService.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ishmamruhan.UserService.Enums.Role;
import com.ishmamruhan.UserService.Helpers.DateGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Size(min = 3, max = 40)
    private String name;

    @Email
    private String email;

    @Size(min = 11, max = 11, message = "Phone Number Must Contains 11 Digit")
    private String phoneNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"user"})
    private Address address;

    @Enumerated(EnumType.STRING)
    private Role userType;

    private Boolean isActive;

    private String createAt = new DateGenerator().getDate();

    private String updatedAt;
}
