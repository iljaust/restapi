package com.iljaust.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iljaust.model.Account;
import com.iljaust.model.Skill;

import java.util.Set;

public class DeveloperDTO {

    private Long id;
    private String name;
    private Set<Skill> skillSet;
    private Account account;

    public DeveloperDTO() {
    }

    public DeveloperDTO(String name, Long id,Set<Skill> skillSet, Account account){
        this.name = name;
        this.id = id;
        this.skillSet = skillSet;
        this.account = account;
    }

    public DeveloperDTO(String name, Long id){
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
