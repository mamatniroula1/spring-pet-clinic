package com.sunil.springpetclinic.bootstrap;

import com.sunil.springpetclinic.model.*;
import com.sunil.springpetclinic.services.OwnerService;
import com.sunil.springpetclinic.services.PetTypeService;
import com.sunil.springpetclinic.services.SpecialtiesService;
import com.sunil.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;

    //we had to write autowired before spring 5 but we dont need it now
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtiesService.save(dentistry);


        Owner owner1 = new Owner();

        owner1.setFirstName("sunil");
        owner1.setLastName("Niroula");
        owner1.setAddress("3910 william dehaes");
        owner1.setCity("Irving");
        owner1.setTelephone("4695378917");
        ownerService.save(owner1);

        Pet sunilsPet = new Pet();
        sunilsPet.setPetType(savedDogType);
        sunilsPet.setOwner(owner1);
        sunilsPet.setBirthDate(LocalDate.now());
        sunilsPet.setName("Rocky");
        owner1.getPets().add(sunilsPet);
        System.out.println("Loaded owners");

        Vet vet1 = new Vet();

        vet1.setFirstName("Bhaskar");
        vet1.setLastName("Acharya");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Arjun");
        vet2.setLastName("Lamichane ");
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);
        System.out.println("Loaded vets");
    }
}
