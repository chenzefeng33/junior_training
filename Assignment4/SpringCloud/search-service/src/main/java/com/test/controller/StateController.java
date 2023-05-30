package com.test.controller;

import com.test.entity.Bills;
import com.test.entity.State;
import com.test.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Search")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/SearchState")
    @CrossOrigin
    public List<State> findBills(@RequestParam Integer order_id) {
        return stateService.findState(order_id);
    }

    @GetMapping("/SearchStateShipment")
    @CrossOrigin
    public List<State> findStateShipment(@RequestParam("shipment_name") String shipment_name) {
        return stateService.findStateShipment(shipment_name);
    }
}
