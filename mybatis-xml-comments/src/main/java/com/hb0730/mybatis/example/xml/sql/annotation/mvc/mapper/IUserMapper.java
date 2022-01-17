package com.hb0730.mybatis.example.xml.sql.annotation.mvc.mapper;

import com.hb0730.mybatis.example.xml.sql.annotation.mvc.entity.UserEntity;

import java.util.List;

/**
 * @author bing_huang
 * @date 2021/7/30
 * @since 1.0.0
 */
public interface IUserMapper {
    List<UserEntity> selectAll();

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    UserEntity selectById(Integer id);
}
