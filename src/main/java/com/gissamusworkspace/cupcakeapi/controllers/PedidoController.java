package com.gissamusworkspace.cupcakeapi.controllers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.PedidoDTO;
import com.gissamusworkspace.cupcakeapi.domains.forms.PedidoForm;
import com.gissamusworkspace.cupcakeapi.services.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cupcake-api/v1/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    public PagedModel<PedidoDTO> getPedidos(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 3) final Pageable page) {
        return new PagedModel<>(pedidoService.getPedidos(page));
    }

    @PostMapping
    @Transactional
    public PedidoDTO savePedido(@RequestBody @Valid final PedidoForm pedidoForm) {
        return pedidoService.savePedido(pedidoForm);
    }

    @DeleteMapping("/{pedidoId}")
    @Transactional
    public ResponseEntity<?> deletePedido(@PathVariable final String pedidoId) {
        try {
            pedidoService.deletePedido(pedidoId);

            return ResponseEntity.noContent().build();
        } catch (final NoSuchElementException noSuchElementException) {
            return ResponseEntity.notFound().build();
        } catch (final Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{pedidoId}/{status}")
    @Transactional
    public ResponseEntity<?> updateStatusPedido(@PathVariable final String pedidoId, @PathVariable final Integer status) {
        try {
            PedidoDTO pedidoDTO = pedidoService.updateStatusPedido(pedidoId, status);

            return ResponseEntity.ok(pedidoDTO);
        } catch (final NoSuchElementException noSuchElementException) {
            return ResponseEntity.notFound().build();
        } catch (final Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
