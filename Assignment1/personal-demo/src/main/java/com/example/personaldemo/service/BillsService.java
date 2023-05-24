package com.example.personaldemo.service;

import com.example.personaldemo.entity.Bills;
import com.example.personaldemo.mapper.BillsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillsService {

    @Autowired
    private BillsMapper billsMapper;

    public List<Bills> findBills(String shipment_name){
        return billsMapper.findBills(shipment_name);
    }
}
