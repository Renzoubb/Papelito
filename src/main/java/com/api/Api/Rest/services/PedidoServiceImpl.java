package com.api.Api.Rest.services;
import com.api.Api.Rest.dictionaries.EstadosPedidosDict;
import com.api.Api.Rest.dtos.DetallePedidoDTO;
import com.api.Api.Rest.dtos.PedidoDTO;
import com.api.Api.Rest.entities.*;
import com.api.Api.Rest.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EstadoPedidoRepository estadoPedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;


    public PedidoServiceImpl(BaseRepository<Pedido,Long> baseRepository){
        super(baseRepository);
    }

    @Override
    public PedidoDTO createPedido(PedidoDTO pedidoDTO) throws Exception {

        Pedido pedido = new Pedido();
        pedido.setDireccionEnvio(pedidoDTO.getDireccionEnvio());
        pedido.setFecha(new Date());

        Usuario usuario  = new Usuario();
        usuario.setId(pedidoDTO.getIdUsuario());
        pedido.setUsuario(usuario);


        EstadoPedido estadoPedido = estadoPedidoRepository.findByNombreEstado(EstadosPedidosDict.ESTADO_PENDIENTE);
        PedidoEstado pedidoEstado = new PedidoEstado();
        pedidoEstado.setEstadoPedido(estadoPedido);
        pedidoEstado.setVigente(true);
        pedido.setPedidoEstadoList(new ArrayList<PedidoEstado>(Arrays.asList(pedidoEstado)));

        pedido = pedidoRepository.save(pedido);

        for (DetallePedidoDTO detallePedidoDTO:pedidoDTO.getDetallePedidoList()){

            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setPedido(pedido);
            detallePedido.setCantidad(detallePedidoDTO.getCantidad());

            Producto producto = productoRepository.findById(detallePedidoDTO.getProducto().getId()).get();
            detallePedido.setProducto(producto);
            detallePedido.setSubtotal(detallePedidoDTO.getCantidad() * producto.getPrecioProducto());

    ;
            detallePedido = detallePedidoRepository.save(detallePedido);

            pedido.getDetallePedidoList().add(detallePedido);
        }

        pedido.setTotal(pedido.getDetallePedidoList().stream().map(e -> e.getSubtotal()).reduce(0f, Float::sum));
        pedido = pedidoRepository.save(pedido);
        pedidoEstado.setPedido(pedido);
        estadoPedidoRepository.save(estadoPedido);

        return null;
    }
}
