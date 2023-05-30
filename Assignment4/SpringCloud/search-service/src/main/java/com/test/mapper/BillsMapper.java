package com.test.mapper;

import com.test.entity.Bills;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BillsMapper {

    @Select("select * from bills where shipment_name = #{shipment}")
    List<Bills> findBills(String shipment);
}
