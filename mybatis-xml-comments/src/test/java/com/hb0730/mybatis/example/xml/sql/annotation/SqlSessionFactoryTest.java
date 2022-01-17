package com.hb0730.mybatis.example.xml.sql.annotation;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class SqlSessionFactoryTest {

    @Test
    void getSqlSessionFactory() throws IOException {
        SqlSessionFactory sessionFactory = com.hb0730.mybatis.example.xml.sql.annotation.mybatis.SqlSessionFactory.getSqlSessionFactory();
        Assertions.assertNotNull(sessionFactory, "Get SqlSessionFactory Failed");
    }
}
