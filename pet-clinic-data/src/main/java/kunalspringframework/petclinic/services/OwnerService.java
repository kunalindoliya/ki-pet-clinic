package kunalspringframework.petclinic.services;

import kunalspringframework.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);
}
