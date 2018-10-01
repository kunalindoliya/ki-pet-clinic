package kunalspringframework.petclinic.bootstrap;

import kunalspringframework.petclinic.model.Owner;
import kunalspringframework.petclinic.model.Vet;
import kunalspringframework.petclinic.services.OwnerService;
import kunalspringframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService){
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michale");
        owner1.setLastName("waston");
        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Danny");
        owner2.setLastName("Rand");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Ward");
        vet2.setLastName("Meechum");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
