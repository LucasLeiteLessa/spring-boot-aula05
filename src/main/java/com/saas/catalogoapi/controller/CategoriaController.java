package com.saas.catalogoapi.controller;


import com.saas.catalogoapi.dto.CategoriaRequest;
import com.saas.catalogoapi.dto.CategoriaResponse;
import com.saas.catalogoapi.service.CategoriaService;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/categorias")
@Tag(name = "Categorias", description = "Endpoints para gerenciamento de categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService service) {this.categoriaService = service;}

    /**
     * GET /api/v1/categorias
     * Retorna a lista completa de categorias.
     */
    @GetMapping
    @Operation(summary = "Listar todos as categorias", description = "Retorna a lista completa de categorias cadastradas")
    public ResponseEntity<List<CategoriaResponse>> listarTodos() {
        return ResponseEntity.ok(categoriaService.listarTodos());
    }


    /**
     * GET /api/v1/categorias/{id}
     * Retorna uma categoria especifica pelo ID.
     * Se nao encontrar, o GlobalExceptionHandler retorna 404.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoria por ID", description = "Retorna uma unica categoria pelo seu identificador")
    public ResponseEntity<CategoriaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    /**
     * POST /api/v1/categorias
     * Cria uma nova categoria e retorna HTTP 201 (Created).
     */
    @PostMapping
    @Operation(summary = "Criar nova categoria", description = "Cadastra uma nova categoria")
    public ResponseEntity<CategoriaResponse> criar(@RequestBody CategoriaRequest request) {
        CategoriaResponse criado = categoriaService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    /**
     * PUT /api/v1/categorias/{id}
     * Atualiza uma categoria existente. Retorna 404 se nao encontrar.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar categoria", description = "Atualiza os dados de uma categoria existente")
    public ResponseEntity<CategoriaResponse> atualizar(@PathVariable Long id, @RequestBody CategoriaRequest request) {
        return ResponseEntity.ok(categoriaService.atualizar(id, request));
    }

    /**
     * DELETE /api/v1/categorias/{id}
     * Remove um produto. Retorna HTTP 204 (No Content) em caso de sucesso.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar categoria", description = "Remove uma categoria do catalogo pelo ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
