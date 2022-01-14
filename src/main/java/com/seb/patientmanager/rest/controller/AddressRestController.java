package com.seb.patientmanager.rest.controller;

import com.seb.patientmanager.data.model.Address;
import com.seb.patientmanager.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressRestController {
    private final AddressService addressService;

    public AddressRestController(@Autowired AddressService addressService) {
        super();

        this.addressService = addressService;
    }

    @GetMapping
    public Address getAddress(@RequestParam Integer id) {
        return this.addressService.getAddress(id);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return this.addressService.saveAddress(address);
    }

    @PutMapping
    public Address updateAddress(@RequestBody Address address) {
        return this.addressService.saveAddress(address);
    }

    @DeleteMapping
    public void deleteAddress(@RequestParam Integer id) {
        this.addressService.deleteAddress(id);
    }
}
