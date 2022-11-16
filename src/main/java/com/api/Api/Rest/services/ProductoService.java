package com.api.Api.Rest.services;

import com.api.Api.Rest.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProductoService extends BaseService<Producto, Long> {

    List<Producto> ProductosPorCategoria(int categoria) throws Exception;

    Page<Producto> ProductosPorCategoriaPage(int categoria, Pageable pageable) throws Exception;

    Page<Producto> ProductosPorNombre(String nombre, Pageable pageable) throws Exception;

}
