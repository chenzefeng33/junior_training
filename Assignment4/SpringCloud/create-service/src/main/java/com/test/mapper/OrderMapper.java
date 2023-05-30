package com.test.mapper;

import com.test.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO `order`(order_status,shipping_address,delivery_address,shipper,receiver) VALUES (#{order_status}," +
            "#{shipping_address},#{delivery_address},#{shipper},#{receiver})")
    int save_order(Order order);
}

