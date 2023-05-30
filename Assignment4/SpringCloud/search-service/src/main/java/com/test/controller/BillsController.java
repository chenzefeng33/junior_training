package com.test.controller;

import com.test.entity.Bills;
import com.test.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Search")
public class BillsController {

    @Autowired
    private BillsService billsService;

    @GetMapping("/SearchBills")
    @CrossOrigin
    public List<Bills> findBills(@RequestParam("shipment_name") String shipment_name) {
        return billsService.findBills(shipment_name);
    }
}
