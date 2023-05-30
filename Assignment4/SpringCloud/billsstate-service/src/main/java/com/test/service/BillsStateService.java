package com.test.service;

import com.test.entity.Bills;
import com.test.entity.BillsStateDetail;
import com.test.entity.State;
import com.test.service.client.SearchClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BillsStateService {

    @Resource
    SearchClient searchClient;

    public BillsStateDetail getBillsStateDetailByShipmentName(String shipment_name){

        List<Bills> billsList = searchClient.findBills(shipment_name);

        List<State> stateList = searchClient.findStateShipment(shipment_name);

        return new BillsStateDetail(shipment_name,billsList,stateList);
    }
}
