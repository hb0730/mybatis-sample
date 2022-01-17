package com.hb0730.mybatis.example.xml.sql.annotation.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author bing_huang
 * @date 2021/7/30
 * @since 1.0.0
 */
public class SqlSessionFactory {
    private volatile static org.apache.ibatis.session.SqlSessionFactory sessionFactory;

    public static org.apache.ibatis.session.SqlSessionFactory getSqlSessionFactory() throws IOException {
        if (null == sessionFactory) {
            synchronized (SqlSessionFactory.class) {
                if (null == sessionFactory) {
                    String resource = "com/hb0730/mybatis/mybatis-config.xml";
                    InputStream inputStream = Resources.getResourceAsStream(resource);
                    sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                }
            }
        }
        return sessionFactory;
    }
}
