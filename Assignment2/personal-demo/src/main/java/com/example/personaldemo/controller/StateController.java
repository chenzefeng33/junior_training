package com.example.personaldemo.controller;

import com.example.personaldemo.entity.State;
import com.example.personaldemo.service.StateService;
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
}
