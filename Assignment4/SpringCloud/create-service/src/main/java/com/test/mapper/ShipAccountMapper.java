package com.test.mapper;

import com.test.entity.ShipAccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShipAccountMapper {

    @Insert("INSERT INTO ship_account(shipper,description,account_region,account_number,shipping_address) VALUES (#{shipper}," +
            "#{description},#{account_region},#{account_number},#{shipping_address})")
    int save_account(ShipAccount shipAccount);

}
