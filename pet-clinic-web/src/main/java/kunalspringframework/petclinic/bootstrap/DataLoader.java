package kunalspringframework.petclinic.bootstrap;

import kunalspringframework.petclinic.model.*;
import kunalspringframework.petclinic.services.OwnerService;
import kunalspringframework.petclinic.services.PetTypeService;
import kunalspringframework.petclinic.services.SpecialtyService;
import kunalspringframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count=petTypeService.findAll().size();
        if(count==0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogPetType=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("Cat");
        PetType savedCatPetType=petTypeService.save(cat);

        Specialty radiology=new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology=specialtyService.save(radiology);

        Specialty surgery=new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery=specialtyService.save(surgery);

        Specialty dentistry=new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry=specialtyService.save(dentistry);

        Owner owner1=new Owner();
        owner1.setFirstName("Michale");
        owner1.setLastName("waston");
        owner1.setAddress("123 brick");
        owner1.setCity("Miami");
        owner1.setTelephone("1322346554");

        Pet mikesPet=new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("Danny");
        owner2.setLastName("Rand");
        owner2.setAddress("123 brick");
        owner2.setCity("Miami");
        owner2.setTelephone("1322346554");

        Pet dannyCat=new Pet();
        dannyCat.setName("Meow");
        dannyCat.setBirthDate(LocalDate.now());
        dannyCat.setOwner(owner2);
        dannyCat.setPetType(savedCatPetType);
        owner2.getPets().add(dannyCat);
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1=new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setFirstName("Ward");
        vet2.setLastName("Meechum");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
