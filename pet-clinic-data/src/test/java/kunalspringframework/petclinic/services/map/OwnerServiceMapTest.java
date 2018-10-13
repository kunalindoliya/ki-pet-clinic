package kunalspringframework.petclinic.services.map;

import kunalspringframework.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;
    final Long owner_id=1L;
    final String last_name="Smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap=new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(owner_id).lastName(last_name).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet=ownerServiceMap.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(owner_id);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(owner_id));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void save() {
    }

    @Test
    void findById() {
        Owner owner=ownerServiceMap.findById(owner_id);
        assertEquals(owner_id,owner.getId());
    }

    @Test
    void findByLastName() {
        Owner smith=ownerServiceMap.findByLastName(last_name);
        assertNotNull(smith);
        assertEquals(owner_id,smith.getId());
    }
}