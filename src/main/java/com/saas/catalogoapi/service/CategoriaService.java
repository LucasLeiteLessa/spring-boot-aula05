package com.saas.catalogoapi.service;

import com.saas.catalogoapi.dto.CategoriaRequest;
import com.saas.catalogoapi.dto.CategoriaResponse;
import com.saas.catalogoapi.exception.CategoriaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class CategoriaService {

    private final List<CategoriaResponse> categorias = new ArrayList<>();

    private final AtomicLong contadorId = new AtomicLong(0);

    public CategoriaService() {
        categorias.add(new CategoriaResponse(
                contadorId.incrementAndGet(), "Camisetas", "Camisetas em geral"
        ));
        categorias.add(new CategoriaResponse(
                contadorId.incrementAndGet(), "Sapatos", "Calçados"
        ));
        categorias.add(new CategoriaResponse(
                contadorId.incrementAndGet(), "Eletronicos", "Eletronicos EX: TV, microondas etc"
        ));
    }

    public List<CategoriaResponse> listarTodos() {
        return categorias;
    }

    public CategoriaResponse buscarPorId(Long id) {
        return categorias.stream()
                .filter(p -> p.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }


    public CategoriaResponse criar(CategoriaRequest request) {
        CategoriaResponse novaCategoria = new CategoriaResponse(
                contadorId.incrementAndGet(),
                request.nome(),
                request.descricao()
        );
        categorias.add(novaCategoria);
        return novaCategoria;
    }



    public CategoriaResponse atualizar(Long id, CategoriaRequest request) {
        CategoriaResponse existente = buscarPorId(id);

        CategoriaResponse atualizado = new CategoriaResponse(
                existente.id(),
                request.nome(),
                request.descricao()
        );

        int index = categorias.indexOf(existente);
        categorias.set(index, atualizado);

        return atualizado;
    }

    public void deletar(Long id) {
        CategoriaResponse produto = buscarPorId(id);
        categorias.remove(produto);
    }

}
