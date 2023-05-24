package com.example.personaldemo.entity;

import lombok.Data;

@Data
public class State {
    private Integer order_id;
    private String Logistics_status;
    private String Transportation_status;
    private Integer state_id;
    private String shipment_name;
}
