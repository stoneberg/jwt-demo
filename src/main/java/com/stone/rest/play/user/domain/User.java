package com.stone.rest.play.user.domain;

import com.stone.rest.play.common.audit.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(	name = "rt_users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User extends BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 30)
    @Column(length = 30, nullable = false)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Column(length = 50, nullable = false)
    private String email;

    @NotBlank
    @Size(max = 120)
    @Column(length = 120, nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "rt_user_roles",
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_RT_USERS")),
            inverseJoinColumns = @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "FK_RT_ROLES")),
            foreignKey = @ForeignKey(name = "FK_RT_USERS"),
            inverseForeignKey = @ForeignKey(name = "FK_RT_ROLES")
    )
    private Set<Role> roles = new HashSet<>();

    @Builder
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // set user roles
    public void addUserRoles(List<Role> userRoles) {
        roles.addAll(userRoles);
    }

}
