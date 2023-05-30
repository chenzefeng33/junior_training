package com.test.entity;

import lombok.Data;

@Data
public class ShipAccount {
    private Integer account_id;
    private String shipper;
    private String description;
    private String account_region;
    private String account_number;
    private String shipping_address;
}
