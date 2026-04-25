 # VeiculoSpring                                                                                                                                                                                                                                                                                                           
  API REST para gerenciamento de consertos de veículos, desenvolvida com Spring Boot.                                                                         
                  
  ## Tecnologias

  - Java 21
  - Spring Boot
  - Spring Data JPA
  - H2 Database (arquivo local)
  - Flyway
  - Maven

  ## Como executar

  **Pré-requisitos:** Java 21 e Maven instalados.

  ```bash
  ./mvnw spring-boot:run

  A aplicação sobe em http://localhost:8080.

  O banco de dados é criado automaticamente na pasta data/ e as tabelas são geradas pelo Flyway na primeira execução.

  H2 Console

  Acesse http://localhost:8080/h2-console com as credenciais:

  - JDBC URL: jdbc:h2:file:./data/veiculospring                                                                                                               
  - User: sa                                                                                                                                                  
  - Password: (vazio)

  Endpoints

  ┌────────┬───────────────────┬────────────────────────────────────┐
  │ Método │       Rota        │             Descrição              │
  ├────────┼───────────────────┼────────────────────────────────────┤
  │ POST   │ /consertos        │ Cadastrar conserto                 │
  ├────────┼───────────────────┼────────────────────────────────────┤
  │ GET    │ /consertos        │ Listar todos (paginado)            │
  ├────────┼───────────────────┼────────────────────────────────────┤
  │ GET    │ /consertos/{id}   │ Buscar por ID                      │
  ├────────┼───────────────────┼────────────────────────────────────┤
  │ GET    │ /consertos/resumo │ Listar consertos ativos (resumido) │
  ├────────┼───────────────────┼────────────────────────────────────┤
  │ PUT    │ /consertos/{id}   │ Atualizar conserto                 │
  ├────────┼───────────────────┼────────────────────────────────────┤
  │ DELETE │ /consertos/{id}   │ Excluir conserto (soft delete)     │
  └────────┴───────────────────┴────────────────────────────────────┘

  Exemplos de requisição

  POST /consertos

  {
    "dataEntrada": "24/04/2026",
    "dataSaida": "30/04/2026",
    "mecanico": {
      "nome": "João Silva",
      "anosExperiencia": 5                                                                                                                                    
    },
    "veiculo": {
      "marca": "Toyota",
      "modelo": "Corolla",
      "ano": "2020",
      "cor": "Prata"                                                                                                                                          
    }
  }

  ▎ Campos obrigatórios: dataEntrada, mecanico.nome, veiculo.marca, veiculo.modelo, veiculo.ano

  PUT /consertos/{id}

  {
    "dataSaida": "30/04/2026",
    "nomeMecanico": "Carlos Lima",
    "anosExperienciaMecanico": 8                                                                                                                              
  }
