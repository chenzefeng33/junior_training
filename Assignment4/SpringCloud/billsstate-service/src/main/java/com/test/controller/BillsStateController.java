package com.test.controller;

import com.test.entity.BillsStateDetail;
import com.test.service.BillsStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/BillsState")
public class BillsStateController {

    @Autowired
    private BillsStateService billsStateService;

    @GetMapping("/SearchBillsState")
    @CrossOrigin
    public BillsStateDetail getBillsStateDetailByShipmentName(@RequestParam("shipment_name") String shipment_name) {
        return billsStateService.getBillsStateDetailByShipmentName(shipment_name);
    }
}
