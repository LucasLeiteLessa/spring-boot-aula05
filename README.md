# Catalogo API

API REST de catalogo de produtos desenvolvida com **Spring Boot 4.0.3** e **Java 21**.
Projeto didatico para aula de desenvolvimento de APIs REST.

## Como rodar a aplicacao

```bash
./mvnw spring-boot:run
```

A aplicacao vai iniciar na porta **8080**.

## Swagger UI (Documentacao interativa)

Apos iniciar a aplicacao, acesse:

```
http://localhost:8080/swagger-ui/index.html
```

## Endpoints disponives

| Metodo | Endpoint                       | Descricao              | Status de sucesso |
|--------|--------------------------------|------------------------|-------------------|
| GET    | /api/v1/produtos               | Listar todos produtos  | 200               |
| GET    | /api/v1/produtos/{id}          | Buscar produto por ID  | 200               |
| POST   | /api/v1/produtos               | Criar produto          | 201               |
| PUT    | /api/v1/produtos/{id}          | Atualizar produto      | 200               |
| DELETE | /api/v1/produtos/{id}          | Deletar produto        | 204               |
| GET    | /api/v1/categorias             | Listar todas categorias| 200               |
| GET    | /api/v1/categorias/{id}        | Buscar categoria por ID| 200               |
| POST   | /api/v1/categorias             | Criar categoria        | 201               |
| PUT    | /api/v1/categorias/{id}        | Atualizar categoria    | 200               |
| DELETE | /api/v1/categorias/{id}        | Deletar categoria      | 204               |

## Exemplos com curl

### Listar todos os produtos

```bash
curl -s http://localhost:8080/api/v1/produtos | json_pp
```

### Buscar produto por ID

```bash
curl -s http://localhost:8080/api/v1/produtos/1 | json_pp
```

### Criar um novo produto

```bash
curl -s -X POST http://localhost:8080/api/v1/produtos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Relogio Digital",
    "descricao": "Relogio digital a prova d agua",
    "preco": 89.90
  }' | json_pp
```

### Atualizar um produto

```bash
curl -s -X PUT http://localhost:8080/api/v1/produtos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Camiseta Basica Premium",
    "descricao": "Camiseta 100% algodao premium",
    "preco": 69.90
  }' | json_pp
```

### Deletar um produto

```bash
curl -s -X DELETE http://localhost:8080/api/v1/produtos/3 -w "\nHTTP Status: %{http_code}\n"
```

---

### Listar todas as categorias

```bash
curl -s http://localhost:8080/api/v1/categorias | json_pp
```

### Buscar categoria por ID

```bash
curl -s http://localhost:8080/api/v1/categorias/1 | json_pp
```

### Criar uma nova categoria

```bash
curl -s -X POST http://localhost:8080/api/v1/categorias \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Eletronicos",
    "descricao": "Dispositivos eletronicos e acessórios"
  }' | json_pp
```

### Atualizar uma categoria

```bash
curl -s -X PUT http://localhost:8080/api/v1/categorias/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Eletronicos e Gadgets",
    "descricao": "Dispositivos eletronicos, acessórios e gadgets"
  }' | json_pp
```

### Deletar uma categoria

```bash
curl -s -X DELETE http://localhost:8080/api/v1/categorias/2 -w "\nHTTP Status: %{http_code}\n"
```

## Colecao Postman

Importe o JSON abaixo no Postman (File > Import > Raw text):

```json
{
  "info": {
    "name": "Catalogo API",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "variable": [
    {
      "key": "baseUrl",
      "value": "http://localhost:8080/api/v1"
    }
  ],
  "item": [
    {
      "name": "Listar todos os produtos",
      "request": {
        "method": "GET",
        "url": "{{baseUrl}}/produtos"
      }
    },
    {
      "name": "Buscar produto por ID",
      "request": {
        "method": "GET",
        "url": "{{baseUrl}}/produtos/1"
      }
    },
    {
      "name": "Criar novo produto",
      "request": {
        "method": "POST",
        "url": "{{baseUrl}}/produtos",
        "header": [
          {
            "key": "Content-Type",
            "value": "application/json"
          }
        ],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"nome\": \"Relogio Digital\",\n  \"descricao\": \"Relogio digital a prova d agua\",\n  \"preco\": 89.90\n}"
        }
      }
    },
    {
      "name": "Atualizar produto",
      "request": {
        "method": "PUT",
        "url": "{{baseUrl}}/produtos/1",
        "header": [
          {
            "key": "Content-Type",
            "value": "application/json"
          }
        ],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"nome\": \"Camiseta Basica Premium\",\n  \"descricao\": \"Camiseta 100% algodao premium\",\n  \"preco\": 69.90\n}"
        }
      }
    },
    {
      "name": "Deletar produto",
      "request": {
        "method": "DELETE",
        "url": "{{baseUrl}}/produtos/3"
      }
    },
    {
      "name": "Listar todas as categorias",
      "request": {
        "method": "GET",
        "url": "{{baseUrl}}/categorias"
      }
    },
    {
      "name": "Buscar categoria por ID",
      "request": {
        "method": "GET",
        "url": "{{baseUrl}}/categorias/1"
      }
    },
    {
      "name": "Criar nova categoria",
      "request": {
        "method": "POST",
        "url": "{{baseUrl}}/categorias",
        "header": [
          {
            "key": "Content-Type",
            "value": "application/json"
          }
        ],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"nome\": \"Eletronicos\",\n  \"descricao\": \"Dispositivos eletronicos e acessórios\"\n}"
        }
      }
    },
    {
      "name": "Atualizar categoria",
      "request": {
        "method": "PUT",
        "url": "{{baseUrl}}/categorias/1",
        "header": [
          {
            "key": "Content-Type",
            "value": "application/json"
          }
        ],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"nome\": \"Eletronicos e Gadgets\",\n  \"descricao\": \"Dispositivos eletronicos, acessórios e gadgets\"\n}"
        }
      }
    },
    {
      "name": "Deletar categoria",
      "request": {
        "method": "DELETE",
        "url": "{{baseUrl}}/categorias/2"
      }
    }
  ]
}
```

## Estrutura do projeto

```
src/main/java/com/saas/catalogoapi/
├── controller/
│   ├── ProdutoController.java    # Endpoints REST de produto
│   └── CategoriaController.java  # Endpoints REST de categoria
├── service/
│   ├── ProdutoService.java       # Logica de negocio de produto
│   └── CategoriaService.java     # Logica de negocio de categoria
├── dto/
│   ├── ProdutoRequest.java       # Dados de entrada do produto
│   ├── ProdutoResponse.java      # Dados de saida do produto
│   ├── CategoriaRequest.java     # Dados de entrada da categoria
│   └── CategoriaResponse.java    # Dados de saida da categoria
├── exception/
│   ├── ProdutoNotFoundException.java   # Excecao customizada produto
│   ├── CategoriaNotFoundException.java # Excecao customizada categoria
│   └── GlobalExceptionHandler.java     # Tratamento global de erros
└── CatalogoApiApplication.java   # Classe principal
```
