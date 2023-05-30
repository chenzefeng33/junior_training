package com.test.entity;

import lombok.Data;

@Data
public class Order {
    private Integer order_id;
    private String order_status;
    private String shipping_address;
    private String delivery_address;
    private String shipper;
    private String receiver;
}
