package com.test.service;

import com.test.entity.ShipAccount;
import com.test.mapper.ShipAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipAccountService {

    @Autowired
    private ShipAccountMapper shipAccountMapper;

    public int save_account(ShipAccount shipAccount) {
        return shipAccountMapper.save_account(shipAccount);
    }

}
