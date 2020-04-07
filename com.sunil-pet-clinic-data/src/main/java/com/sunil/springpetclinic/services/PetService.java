package com.sunil.springpetclinic.services;

import com.sunil.springpetclinic.model.Owner;
import com.sunil.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
