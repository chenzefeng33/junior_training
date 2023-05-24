package com.example.personaldemo.controller;

import com.example.personaldemo.entity.Bills;
import com.example.personaldemo.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Search")
public class BillsController {

    @Autowired
    private BillsService billsService;

    @GetMapping("/SearchBills")
    public List<Bills> findBills(@RequestParam("shipment_name") String shipment_name) {
        return billsService.findBills(shipment_name);
    }
}
