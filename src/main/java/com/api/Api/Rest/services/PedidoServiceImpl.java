package com.api.Api.Rest.services;
import com.api.Api.Rest.dictionaries.EstadosPedidosDict;
import com.api.Api.Rest.dtos.CreacionDetallePedidoDTO;
import com.api.Api.Rest.dtos.CreacionPedidoDTO;
import com.api.Api.Rest.dtos.DetallePedidoDTO;
import com.api.Api.Rest.dtos.PedidoDTO;
import com.api.Api.Rest.entities.*;
import com.api.Api.Rest.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Destination;
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

    @Autowired
    private PedidoEstadoRepository pedidoEstadoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido,Long> baseRepository){
        super(baseRepository);
    }

    @Override
    public PedidoDTO createPedido(CreacionPedidoDTO creacionPedidoDTO) throws Exception {

        ModelMapper modelMapper = mapToPedidoDTO();

        Pedido pedido = new Pedido();
        pedido.setDireccionEnvio(creacionPedidoDTO.getDireccionEnvio());
        pedido.setFecha(new Date());

        Usuario usuario  = new Usuario();
        usuario.setId(creacionPedidoDTO.getIdUsuario());
        pedido.setUsuario(usuario);

        pedido = pedidoRepository.save(pedido);

        EstadoPedido estadoPedido = estadoPedidoRepository.findByNombreEstado(EstadosPedidosDict.ESTADO_PENDIENTE);
        PedidoEstado pedidoEstado = new PedidoEstado();
        pedidoEstado.setEstadoPedido(estadoPedido);
        pedidoEstado.setVigente(true);
        pedido = pedidoRepository.save(pedido);

        Float total = 0f;

        PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);

        for (CreacionDetallePedidoDTO detallePedidoDTO:creacionPedidoDTO.getDetallePedido()){

            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setPedido(pedido);
            detallePedido.setCantidad(detallePedidoDTO.getCantidad());

            Producto producto = productoRepository.findById(detallePedidoDTO.getProductoId()).get();
            detallePedido.setProducto(producto);
            detallePedido.setSubtotal(detallePedidoDTO.getCantidad() * producto.getPrecioProducto());
    ;
            detallePedidoRepository.save(detallePedido);
            total =total + detallePedido.getSubtotal();

            DetallePedidoDTO detallePedidoDTO1 = modelMapper.map(detallePedido, DetallePedidoDTO.class);

            pedidoDTO.getDetallePedido().add(detallePedidoDTO1);

        }

        pedido.setTotal(total);
        pedido = pedidoRepository.save(pedido);
        pedidoEstado.setPedido(pedido);
        pedidoEstadoRepository.save(pedidoEstado);


        pedidoDTO.setNombreEstado(pedidoEstado.getEstadoPedido().getNombreEstado());
        pedidoDTO.setTotal(total);

        return pedidoDTO;
    }

    @Override
    public PedidoDTO getPedidoDetail(Long idPedido) throws Exception {
        List<DetallePedido> detallePedidoList = detallePedidoRepository.findByPedidoId(idPedido);

        PedidoEstado pedidoEstado = pedidoEstadoRepository.findByPedidoIdAndVigente(idPedido, true);

        Pedido pedido = pedidoEstado.getPedido();
        EstadoPedido estadoPedido = pedidoEstado.getEstadoPedido();

        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.setFecha(pedido.getFecha());
        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setTotal(pedido.getTotal());
        pedidoDTO.setDireccionEnvio(pedido.getDireccionEnvio());
        pedidoDTO.setNombreEstado(estadoPedido.getNombreEstado());


        for (DetallePedido detallePedido: detallePedidoList) {
            DetallePedidoDTO detallePedidoDTO = new DetallePedidoDTO();
            detallePedidoDTO.setCantidad(detallePedido.getCantidad());
            detallePedidoDTO.setId(detallePedido.getId());
            detallePedidoDTO.setSubtotal(detallePedido.getSubtotal());
            detallePedidoDTO.setIdProducto(detallePedido.getProducto().getId());
            detallePedidoDTO.setNombreProducto(detallePedido.getProducto().getNombreProducto());
            detallePedidoDTO.setPrecioProducto(detallePedido.getProducto().getPrecioProducto());
            detallePedidoDTO.setNombreCategoria(detallePedido.getProducto().getCategoria().getNombreCategoria());
            pedidoDTO.getDetallePedido().add(detallePedidoDTO);
        }
        return pedidoDTO;
    }

    @Override
    public List<PedidoDTO> getAllPedidosDetail(Pageable pageable) throws Exception {
        Page<Pedido> pedidos = pedidoRepository.findAll(pageable);
        List<PedidoDTO> pedidoDTOS= new ArrayList<>();
        ModelMapper modelMapper = mapToPedidoDTO();

        for (Pedido pedido:  pedidos ) {
            List<DetallePedido> detallePedidoList = detallePedidoRepository.findByPedidoId(pedido.getId());
            List<DetallePedidoDTO> detallePedidoDTOList = Arrays.asList(modelMapper.map(detallePedidoList, DetallePedidoDTO[].class));
            //DetallePedidoDTO detallePedidoDTO = modelMapper.map(detallePedidoList, List<DetallePedidoDTO.class>);
            PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
            pedidoDTO.setDetallePedido(detallePedidoDTOList);
            pedidoDTOS.add(pedidoDTO);

            PedidoEstado pedidoEstado = pedidoEstadoRepository.findPedidoEstadoVigente(pedido.getId());
            pedidoDTO.setNombreEstado(pedidoEstado.getEstadoPedido().getNombreEstado());
        }

        return pedidoDTOS;
    }



    public ModelMapper mapToPedidoDTO()  {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(DetallePedido.class, DetallePedidoDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getProducto().getNombreProducto(),
                    DetallePedidoDTO::setNombreProducto);
            mapper.map(src -> src.getPedido().getId(),
                    DetallePedidoDTO::setIdPedido);
            mapper.map(src -> src.getProducto().getCategoria().getNombreCategoria(),
                    DetallePedidoDTO::setNombreCategoria);
            mapper.map(src -> src.getProducto().getId(),
                    DetallePedidoDTO::setIdProducto);
            mapper.map(src -> src.getProducto().getPrecioProducto(),
                    DetallePedidoDTO::setPrecioProducto);
        });
        return modelMapper;
    }
}