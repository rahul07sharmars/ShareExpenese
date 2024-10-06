package com.example.shareExpenese.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private String id;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String mobileNumber;
    private String defaultCurrency;
    private String profileImage;
    @ManyToMany
    @JoinTable(name = "user_groups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "groups_id"))
    private Set<Group> groups = new LinkedHashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expense_id")
    private Expense expense;
    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();  // Generate a new UUID and convert it to String
        }
    }

}
