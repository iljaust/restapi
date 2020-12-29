package com.iljaust.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "developers")
@JsonAutoDetect
public class Developer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Developers_Skills",
            joinColumns = { @JoinColumn(name = "developer_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id") }
    )
    private Set<Skill> skillSet;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    public Developer() {
    }

    public Developer(String name, Long id,Set<Skill> skillSet, Account account){
        this.name = name;
        this.id = id;
        this.skillSet = skillSet;
        this.account = account;
    }

    public Developer(String name, Long id){
        this.name = name;
        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Set<Skill> getSkillSet() {

        return skillSet;
    }

    public void setSkillSet(Set<Skill> skillSet) {

        this.skillSet = skillSet;
    }

    public Account getAccountStatus() {

        return account;
    }

    public void setAccountStatus(Account account) {

        this.account = account;
    }


    @Override
    public String toString() {
        return "Developer : \n" +
                "id=" + id +
                ", \nname='" + name + '\'' +
                ", \nskillSet=" + skillSet +
                ", \naccountStatus=" + account +
                ' ';
    }

}