package com.sunil.springpetclinic.services;

import com.sunil.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

    Owner findByLastName(String lastName);

}
