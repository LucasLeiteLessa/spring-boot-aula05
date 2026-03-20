package com.saas.catalogoapi.dto;


/** DTO DE ENTRADA
 * Record que representa os dados enviados pelo cliente ao criar ou atualizar uma categoria.
 */

public record CategoriaRequest(
        String nome,
        String descricao
) {
}
