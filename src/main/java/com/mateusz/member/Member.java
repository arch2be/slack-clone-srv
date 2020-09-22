package com.mateusz.member;

import com.mateusz.workspace.Workspace;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "MEMBER")
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ACTIVE")
    private boolean active = false;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "MEMBERS_WORKSPACES",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKSPACE_ID"))
    private Set<Workspace> workspaces = new HashSet<>();

    public void addWorkspace(Workspace workspace) {
        this.workspaces.add(workspace);
        workspace.addMember(this);
    }

    public void removeGroup(Workspace workspace) {
        this.workspaces.remove(workspace);
        workspace.removeMember(this);
    }
}
