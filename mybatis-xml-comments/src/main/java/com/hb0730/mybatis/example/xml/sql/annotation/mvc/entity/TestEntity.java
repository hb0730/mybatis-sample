package com.hb0730.mybatis.example.xml.sql.annotation.mvc.entity;

import java.io.Serializable;

/**
 * @author bing_huang
 * @date 2021/8/2
 * @since 1.0.0
 */
public class TestEntity implements Serializable {
    private static final long serialVersionUID = 9033388369804867519L;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
