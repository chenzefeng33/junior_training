package com.test.service.client;

import com.test.entity.Bills;
import com.test.entity.State;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("searchservice")
public interface SearchClient {
    @GetMapping("/Search/SearchBills")
    @CrossOrigin
    List<Bills> findBills(@RequestParam("shipment_name") String shipment_name);

    @GetMapping("/Search/SearchStateShipment")
    @CrossOrigin
    List<State> findStateShipment(@RequestParam("shipment_name") String shipment_name);
}
