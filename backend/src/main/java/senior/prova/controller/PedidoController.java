package senior.prova.controller;

import senior.prova.dto.PedidoDTO;
import senior.prova.enums.StatusPedido;
import senior.prova.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    PedidoService service;

    @CrossOrigin(origins = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoDTO create(@RequestBody @Valid PedidoDTO pedidoDTO) {
        return service.create(pedidoDTO);
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PedidoDTO update(@RequestBody @Valid PedidoDTO pedidoDTO) {
        return service.update(pedidoDTO);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/pendente")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PedidoDTO findByStatus() throws Exception {
        return service.findByStatus(StatusPedido.PENDENTE.toString());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/status")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PedidoDTO> findByCustom(@RequestParam("status") String status, @Param("filtro") String filtro) throws Exception {
        return service.retornaPorFiltro(status, filtro);
    }

}
