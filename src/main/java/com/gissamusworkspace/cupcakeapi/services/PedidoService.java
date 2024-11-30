package com.gissamusworkspace.cupcakeapi.services;

import com.gissamusworkspace.cupcakeapi.domains.dtos.PedidoDTO;
import com.gissamusworkspace.cupcakeapi.domains.entities.PedidoCupcakeEntity;
import com.gissamusworkspace.cupcakeapi.domains.entities.PedidoEntity;
import com.gissamusworkspace.cupcakeapi.domains.enums.StatusPedido;
import com.gissamusworkspace.cupcakeapi.domains.forms.PedidoForm;
import com.gissamusworkspace.cupcakeapi.mappers.PedidoEntityMapper;
import com.gissamusworkspace.cupcakeapi.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private static final PedidoEntityMapper mapper = PedidoEntityMapper.instance;

    private final PedidoRepository repository;

    private final CupcakeService cupcakeService;

    public Page<PedidoDTO> getPedidos(final Pageable page) {
        return repository.findAll(page).map(mapper::mapDto);
    }

    public PedidoDTO savePedido(final PedidoForm form) {
        PedidoEntity pedidoEntity = mapper.mapEntity(form);

        form.getCupcakesIds().forEach((cupcakeId, quantity) -> {
            PedidoCupcakeEntity pedidoCupcakeEntity = new PedidoCupcakeEntity();
            pedidoCupcakeEntity.setCupcake(cupcakeService.getCupcakeById(UUID.fromString(cupcakeId)));
            pedidoCupcakeEntity.setQuantity(quantity);
            pedidoCupcakeEntity.setPedido(pedidoEntity);

            pedidoEntity.getCupcakes().add(pedidoCupcakeEntity);
        });

        repository.save(pedidoEntity);

        return mapper.mapDto(pedidoEntity);
    }

    public void deletePedido(final String pedidoId) {
        findPedidoById(UUID.fromString(pedidoId));

        repository.deleteById(UUID.fromString(pedidoId));
    }

    public PedidoDTO updateStatusPedido(final String pedidoId, final Integer status) {
        PedidoEntity pedidoFound = findPedidoById(UUID.fromString(pedidoId));
        pedidoFound.setStatusPedido(StatusPedido.get(status));

        repository.save(pedidoFound);

        return mapper.mapDto(pedidoFound);
    }

    private PedidoEntity findPedidoById(final UUID pedidoId) {
        return repository.findById(pedidoId).orElseThrow();
    }

}
