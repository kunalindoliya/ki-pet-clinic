package kunalspringframework.petclinic.bootstrap;

import kunalspringframework.petclinic.model.Owner;
import kunalspringframework.petclinic.model.PetType;
import kunalspringframework.petclinic.model.Vet;
import kunalspringframework.petclinic.services.OwnerService;
import kunalspringframework.petclinic.services.PetTypeService;
import kunalspringframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogPetType=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("Cat");
        PetType savedCatPetType=petTypeService.save(cat);

        Owner owner1=new Owner();
        owner1.setFirstName("Michale");
        owner1.setLastName("waston");
        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("Danny");
        owner2.setLastName("Rand");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1=new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setFirstName("Ward");
        vet2.setLastName("Meechum");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
