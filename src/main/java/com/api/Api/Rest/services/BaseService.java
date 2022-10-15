package com.api.Api.Rest.services;
import java.util.List;


/*Declaramos en esta intercefa los metodos principales (crud) que necesitamos. La vamos a poder implementar
* en todos los servicios que necesitemos*/
public interface BaseService<E> {
    public List<E> findAll() throws Exception;
    public E findById(Long id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(Long id, E entity) throws Exception;
    public boolean delete(Long id) throws Exception;
}
