package com.sunil.springpetclinic.bootstrap;

import com.sunil.springpetclinic.model.Owner;
import com.sunil.springpetclinic.model.Vet;
import com.sunil.springpetclinic.services.OwnerService;
import com.sunil.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    //we had to write autowired before spring 5 but we dont need it now
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("sunil");
        owner1.setLastName("Niroula");
        ownerService.save(owner1);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Bhaskar");
        vet1.setLastName("Acharya");
        vetService.save(vet1);

        System.out.println("Loaded vets");


    }
}
