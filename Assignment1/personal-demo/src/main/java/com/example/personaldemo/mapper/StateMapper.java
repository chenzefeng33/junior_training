package com.example.personaldemo.mapper;

import com.example.personaldemo.entity.State;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StateMapper {
    @Select("select * from state where order_id = #{order_id}")
    List<State> findState(Integer order_id);
}
