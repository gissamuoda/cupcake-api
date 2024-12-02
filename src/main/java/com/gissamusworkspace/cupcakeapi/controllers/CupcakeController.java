package com.gissamusworkspace.cupcakeapi.controllers;

import com.gissamusworkspace.cupcakeapi.domains.dtos.CupcakeDTO;
import com.gissamusworkspace.cupcakeapi.domains.forms.CupcakeForm;
import com.gissamusworkspace.cupcakeapi.services.CupcakeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/cupcake-api/v1/cupcake")
@RequiredArgsConstructor
public class CupcakeController {

    private final CupcakeService cupcakeService;

    @GetMapping
    public PagedModel<CupcakeDTO> getCupcakes(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 9) Pageable page) {
        return new PagedModel<>(cupcakeService.getCupcakes(page));
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public CupcakeDTO saveCupcake(@RequestBody @Valid final CupcakeForm cupcakeForm) {
        return cupcakeService.saveCupcake(cupcakeForm);
    }

    @DeleteMapping("/{cupcakeId}")
    @Transactional
    public ResponseEntity<?> deleteCupcake(@PathVariable final String cupcakeId) {
        try {
            cupcakeService.deleteCupcake(cupcakeId);

            return ResponseEntity.noContent().build();
        } catch (final NoSuchElementException noSuchElementException) {
            return ResponseEntity.notFound().build();
        } catch (final Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{cupcakeId}/disable")
    @Transactional
    public ResponseEntity<?> disableCupcake(@PathVariable final String cupcakeId) {
        try {
            CupcakeDTO dto = cupcakeService.updateDisableFlagCupcake(cupcakeId, true);

            return ResponseEntity.ok(dto);
        } catch (final NoSuchElementException noSuchElementException) {
            return ResponseEntity.notFound().build();
        } catch (final Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{cupcakeId}/enable")
    @Transactional
    public ResponseEntity<?> enableCupcake(@PathVariable final String cupcakeId) {
        try {
            CupcakeDTO dto = cupcakeService.updateDisableFlagCupcake(cupcakeId, false);

            return ResponseEntity.ok(dto);
        } catch (final NoSuchElementException noSuchElementException) {
            return ResponseEntity.notFound().build();
        } catch (final Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
