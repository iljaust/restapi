package com.iljaust.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "developers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Developer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<Skill> skillSet;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    public Developer() {
    }

    public Developer(String name, Long id,List<Skill> skillSet, Account account){
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

    public List<Skill> getSkillSet() {

        return skillSet;
    }

    public void setSkillSet(List<Skill> skillSet) {

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