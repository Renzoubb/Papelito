package com.api.Api.Rest.services;
import java.util.List;
import java.util.Optional;
import com.api.Api.Rest.entities.Producto;
import com.api.Api.Rest.repositories.ProductoRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class ProductoService implements BaseService<Producto> {
    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional
    public List<Producto> findAll() throws Exception {
        try{
            List<Producto> entities = productoRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producto findById(Long id) throws Exception {
        try{
            Optional<Producto> entityOptional = productoRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producto save(Producto entity) throws Exception {
        try{
            entity = productoRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producto update(Long id, Producto entity) throws Exception {
        try{
            Optional<Producto> entityOptional = productoRepository.findById(id);
            Producto producto = entityOptional.get();
            producto = productoRepository.save(producto);
            return producto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(productoRepository.existsById(id)){
                productoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
