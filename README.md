# 🚗 Consulta de Veículos - Tabela FIPE (Java)

Aplicação Java que consome a [API pública da Tabela FIPE](https://deividfortuna.github.io/fipe/) para consultar **marcas**, **modelos**, **anos** e **valores de avaliação** de **carros**, **motos** e **caminhões**.

---

## Funcionalidades

- Escolha entre **carros**, **motos** ou **caminhões**.
- Visualização das **marcas disponíveis**.
- Seleção de modelos por número (sem digitar texto).
- Consulta de todos os **anos disponíveis para um modelo**.
- Exibição de **valores por ano**, com:
    - Marca, modelo, ano, tipo de combustível e valor.
- Filtros por:
    - 📅 **Ano** (ordenação e paginação)
    - 💰 **Preço**

---

## 🛠 Tecnologias Utilizadas

- **Java 17+**
- **API REST** (HTTP requests via `HttpClient`)
- **Gson** para conversão de JSON para objetos
- **Paradigma Orientado a Objetos**
- **Java Records** para modelagem de dados

---

## Como Executar

### Pré-requisitos:
- JDK 17 ou superior instalado
- IDE como IntelliJ ou VS Code, ou terminal com suporte a Java

### Passos:

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/veiculos-fipe-java.git
   cd veiculos-fipe-java
   ```
   
## Estrutura do Projeto
```css
    src
├── model
│   └── Veiculo.java, Dados.java, Modelos.java
├── service
│   └── ConsumoApi.java, ConverteDados.java
├── util
│   └── VeiculoFiltroUtil.java
└── view
    └── MenuView.java
```
## Melhorias Implementadas
- Interface interativa via terminal com mensagens claras.

- Escolha por número em todos os menus (marca, modelo, filtro).

- Evita entradas confusas como nomes parciais.

- Paginação e ordenação (ano ou preço).

## Exemplo de uso

```text
****** OPÇÕES DE VEÍCULOS *****
1 - CARRO
2 - MOTO
3 - CAMINHÃO
Digite o número da opção desejada: 1

***** MARCAS DISPONÍVEIS *****
1 - FIAT
2 - CHEVROLET
3 - FORD
...

Digite o número da marca desejada: 2

***** MODELOS DISPONÍVEIS *****
1 - ONIX
2 - S10
3 - SPIN
...

Digite o número do modelo desejado: 1

Como deseja visualizar os veículos?
1 - Ordenar por ANO
2 - Ordenar por PREÇO
Digite o número da opção desejada: 2
```

