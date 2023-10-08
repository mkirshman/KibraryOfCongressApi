package com.mkmi.LibraryOfCongressService.controllers;

import com.mkmi.LibraryOfCongressService.models.Bill;
import com.mkmi.LibraryOfCongressService.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/bill")
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/all")
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/{congress}")
    public List<Bill> getBillsByCongress(@PathVariable(name = "congress") String congress) {
        return billService.getBillsByCongress(congress);
    }

    @GetMapping("/{congress}/{billType}")
    public List<Bill> getBillsByCongressAndType(
            @PathVariable(name = "congress") String congress,
            @PathVariable(name = "billType") String billType
    ) {
        return billService.getBillsByCongressAndType(congress, billType);
    }

    @GetMapping("/{congress}/{billType}/{billNumber}")
    public Bill getBillDetails(
            @PathVariable(name = "congress") String congress,
            @PathVariable(name = "billType") String billType,
            @PathVariable(name = "billNumber") String billNumber
    ) {
        return billService.getBillDetails(congress, billType, billNumber);
    }
}
