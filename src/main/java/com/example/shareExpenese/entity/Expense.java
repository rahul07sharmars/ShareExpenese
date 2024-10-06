package com.example.shareExpenese.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.example.shareExpenese.entity.User;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Data
@Table(name = "expenese")
public class Expense {
    @Id
    private String id;
    private String title;
    private String description;
    private Integer value;
    private String addedBy;
    private String profileImage;
    @OneToOne
    @JoinColumn(name = "group_id")
    private Group groupId;
    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> payedBy = new ArrayList<>();
    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();  // Generate a new UUID and convert it to String
        }
    }
}
