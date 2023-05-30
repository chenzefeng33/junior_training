package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BillsStateDetail {
    private String shipment_name;
    private List<Bills> bills;
    private List<State> state;
}
