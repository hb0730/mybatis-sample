package com.hb0730.mybatis.example.xml.sql.annotation.mvc.mapper;

import com.hb0730.mybatis.example.xml.sql.annotation.mvc.entity.UserEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class IUserMapperTest {
    @Test
    void selectById() throws IOException {
        SqlSessionFactory sessionFactory = com.hb0730.mybatis.example.xml.sql.annotation.mybatis.SqlSessionFactory.getSqlSessionFactory();
        Assertions.assertNotNull(sessionFactory, "Get SqlSessionFactory Failed");
        try (SqlSession session = sessionFactory.openSession()) {
            IUserMapper mapper = session.getMapper(IUserMapper.class);
            Assertions.assertNotNull(mapper, "Get Mapper failed");
            UserEntity entity = mapper.selectById(1);
            Assertions.assertNotNull(entity, "Get Result failed");
        }
    }

    @Test
    void selectAll() throws IOException {
        SqlSessionFactory sessionFactory = com.hb0730.mybatis.example.xml.sql.annotation.mybatis.SqlSessionFactory.getSqlSessionFactory();
        Assertions.assertNotNull(sessionFactory, "Get SqlSessionFactory Failed");
        try (SqlSession session = sessionFactory.openSession()) {
            IUserMapper mapper = session.getMapper(IUserMapper.class);
            Assertions.assertNotNull(mapper, "Get Mapper failed");
            List<UserEntity> entities = mapper.selectAll();
            Assertions.assertNotNull(entities, "Get Result failed");
        }
    }
}
