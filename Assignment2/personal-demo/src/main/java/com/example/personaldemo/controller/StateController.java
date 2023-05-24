package com.example.personaldemo.controller;

import com.example.personaldemo.entity.State;
import com.example.personaldemo.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Search")
public class StateController {

        @Autowired
        private StateService stateService;

        @GetMapping("/SearchState")
        public List<State> findBills(@RequestParam Integer order_id) {
            return stateService.findState(order_id);
        }
}
