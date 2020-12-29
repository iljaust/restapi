package com.iljaust.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkillDTO {
    private Long id;
    private String name;

    public SkillDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SkillDTO() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
