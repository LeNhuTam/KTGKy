package com.example.kiemtra.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Hãy nhập tên")
    @Column(name = "name", length = 50, nullable = false)
    @Size(max = 50, message = "Tên không được vượt quá 50 kí tự")
    private String name;
    @Size(max = 250, message = "Mô tả không được vượt quá 250 kí tự")
    @Column(name = "description", length = 250)
    private String description;
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<User> users = new HashSet<>();
    @Override
    public String getAuthority() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return
                false;
        Role role = (Role) o;
        return getId() != null && Objects.equals(getId(), role.getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

