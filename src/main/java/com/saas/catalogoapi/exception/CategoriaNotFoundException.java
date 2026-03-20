package com.saas.catalogoapi.exception;

/**
 * Excecao lancada quando um produto nao e encontrado pelo ID informado.
 * Estende RuntimeException para nao precisar de try/catch obrigatorio.
 */
public class CategoriaNotFoundException extends RuntimeException {

    public CategoriaNotFoundException(Long id) {
        super("Categoria nao encontrada com o ID: " + id);
    }
}
