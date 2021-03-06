package com.hb0730.mybatis.example.xml.sql.annotation.mvc.entity;

import java.io.Serializable;

/**
 * @author bing_huang
 * @date 2021/7/30
 * @since 1.0.0
 */
public class UserEntity implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private Integer gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
