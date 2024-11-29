package com.jobportal.Jobportal.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;


@Document(collection = "jobDB")
public class Post {
//POJO CLASS
    private String profile;
    private String desc;
    private int exp;

    public String getProfile() {
        return profile;
    }

    public Post() {
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    private String techs[];

    @Override
    public String toString() {
        return "Post{" +
                "profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
