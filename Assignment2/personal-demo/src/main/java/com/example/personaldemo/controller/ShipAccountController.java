package com.example.personaldemo.controller;

import com.example.personaldemo.entity.ShipAccount;
import com.example.personaldemo.service.ShipAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Create")
public class ShipAccountController {

    @Autowired
    private ShipAccountService shipAccountService;

    @PostMapping("/CreateAccount")
    @CrossOrigin
    public Integer save_account(@RequestBody ShipAccount shipAccount)
    { return shipAccountService.save_account(shipAccount); }

}
