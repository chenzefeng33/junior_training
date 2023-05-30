package com.test.service;

import com.test.entity.State;
import com.test.mapper.StateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateMapper stateMapper;

    public List<State> findState(Integer order_id){
        return stateMapper.findState(order_id);
    }

    public List<State> findStateShipment(String shipment_name){
        return stateMapper.findStateShipment(shipment_name);
    }
}
