package senior.prova.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import senior.prova.domain.Pedido;
import senior.prova.enums.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Optional<Pedido> findFirstByStatusEquals(StatusPedido status);
    
    @Query(value = "select * from Pedido p " +
            "where p.status = :status " +
            "   and (lower(p.nome) like lower(concat('%', :filtro,'%')) " +
            "or lower(p.descricao) like lower(concat('%', :filtro,'%')))", nativeQuery = true)
    Optional<List<Pedido>> retornaPorFiltro(@Param("status") String status, @Param("filtro") String filtro);

}
