package com.test.entity;

import lombok.Data;

@Data
public class Bills {
    private Integer bills_id;
    private String shipper;
    private String fee;
    private String shipment_name;
}
