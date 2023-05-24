package com.example.personaldemo.service;

import com.example.personaldemo.entity.State;
import com.example.personaldemo.mapper.StateMapper;
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
}
