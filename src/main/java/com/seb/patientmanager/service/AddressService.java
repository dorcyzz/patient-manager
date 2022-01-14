package com.seb.patientmanager.service;

import com.seb.patientmanager.data.repository.AddressRepository;
import com.seb.patientmanager.data.model.Address;
import java.util.Optional;

public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        super();

        this.addressRepository = addressRepository;
    }

    public Address getAddress(Integer id) {
        Optional<Address> address = this.addressRepository.findById(id);

        return address.orElse(null);
    }

    public Address saveAddress(Address address) {
        return this.addressRepository.save(address);
    }

    public void deleteAddress(Integer id) {
        Address address = this.getAddress(id);

        if (address != null) {
            this.addressRepository.delete(address);
        }
    }
}
