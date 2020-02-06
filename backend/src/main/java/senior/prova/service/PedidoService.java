package senior.prova.service;

import senior.prova.domain.Pedido;
import senior.prova.dto.PedidoDTO;
import senior.prova.enums.StatusPedido;
import senior.prova.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    public PedidoDTO create(PedidoDTO pedidoDTO) {
        pedidoDTO.setStatus(StatusPedido.PENDENTE);
        return toSave(pedidoDTO);
    }

    public PedidoDTO update(PedidoDTO pedidoDTO) {
        return toSave(pedidoDTO);
    }

    private PedidoDTO toSave(PedidoDTO pedidoDTO) {
        ModelMapper modelMapper = new ModelMapper();

        Pedido fromDto = modelMapper.map(pedidoDTO, Pedido.class);
        Pedido retorno = repository.save(fromDto);

        return modelMapper.map(retorno, PedidoDTO.class);
    }

    public PedidoDTO findByStatus(String status) throws Exception {
        ModelMapper modelMapper = new ModelMapper();

        StatusPedido statusPedido = StatusPedido.valueOf(status.toUpperCase());

        Optional<Pedido> pedido = repository.findFirstByStatusEquals(statusPedido);
        if (pedido.isPresent()) {
            return modelMapper.map(pedido.get(), PedidoDTO.class);
        }

        throw new Exception("Não há pedidos com este status");
    }
    
    public List<PedidoDTO> retornaPorFiltro(String status, String filtro) throws Exception {
        if (filtro == null) {
            List<PedidoDTO> pedidos = new ArrayList<>();
            pedidos.add(this.findByStatus(status));

            return pedidos;
        }

        ModelMapper modelMapper = new ModelMapper();
        Optional<List<Pedido>> pedidos = repository.retornaPorFiltro(status, filtro);
        if (pedidos.isPresent()) {
            return pedidos.get().stream()
                    .map(x -> modelMapper.map(x, PedidoDTO.class))
                    .collect(Collectors.toList());
        }

        throw new Exception("Não há pedidos com este filtro");
    }

}
