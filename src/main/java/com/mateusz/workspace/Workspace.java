package com.mateusz.workspace;

import com.mateusz.member.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "WORKSPACE")
public class Workspace {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "CREATION_DATE", nullable = false, updatable = false)
    private LocalDate creationDate;

    @ManyToMany(mappedBy = "workspaces")
    private Set<Member> members = new HashSet<>();

    public void addMember(Member member) {
        this.members.add(member);
    }

    public void removeMember(Member member) {
        this.members.remove(member);
    }
}
