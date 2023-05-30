package com.test.controller;

import com.test.entity.ShipAccount;
import com.test.service.ShipAccountService;
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