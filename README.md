# Moviestar

Sistema Java de console para gerenciamento de filmes, avaliações e coleções pessoais.

## Sobre o Projeto

Moviestar começou como um trabalho da disciplina de Programação Orientada a Objetos, mas se expandiu em um projeto pessoal mais completo. É um sistema de gerenciamento de filmes desenvolvido em Java que permite visualizar catálogos, criar avaliações, gerenciar coleções e interagir com usuários. Utiliza arquivos de texto para persistência e interface de console.

## Funcionalidades

-  **Catálogo de Filmes**: Visualize uma biblioteca completa com detalhes dos filmes
-  **Sistema de Reviews**: Crie e visualize avaliações com comentários e classificação por estrelas
-  **Gerenciamento de Usuários**: Sistema de registro e perfis de usuário
-  **Coleções Personalizadas**: Crie e gerencie listas temáticas de filmes

## Arquitetura do Projeto

O projeto segue o padrão **MVC (Model-View-Controller)** com camadas bem definidas:

```
src/
├── controller/          # Controladores da aplicação
├── model/
│   ├── entity/         # Entidades do domínio
│   └── factory/        # Factory Pattern para criação de objetos
├── repository/         # Camada de acesso a dados
├── service/           # Regras de negócio
└── view/              # Interface de usuário (console)

data/                  # Arquivos de dados
├── movies.txt
├── users.txt
├── reviews.txt
└── movie_user_collections.txt
```

## Tecnologias Utilizadas

- **Linguagem**: Java 24
- **IDE**: IntelliJ IDEA
- **Paradigma**: Orientação a Objetos
- **Padrões de Projeto**: MVC, Factory, Repository
- **Persistência**: Arquivos de texto (CSV-like)
- **Build System**: Projeto Java padrão

## Estrutura de Dados

### Filmes (movies.txt)
```
id;title;language;director;genres;releaseYear;runtime;
```

### Usuários (users.txt)
```
id;username;reviews;
```

### Reviews (reviews.txt)
```
id;user;movie;stars;comment;publishDate;
```

### Coleções (movie_user_collections.txt)
```
id;user;movies;description;
```

## Como Executar o Projeto

### Pré-requisitos

- Java Development Kit (JDK) 24 ou superior
- IntelliJ IDEA (recomendado) ou qualquer IDE Java
- Sistema operacional: Windows, macOS ou Linux

### Instalação e Execução

1. **Clone o repositório**
   ```bash
   git clone https://github.com/arturvrgs/moviestar.git
   cd moviestar
   ```

2. **Abra o projeto**
    - Abra o IntelliJ IDEA
    - File → Open → Selecione a pasta do projeto
    - Aguarde a indexação dos arquivos

3. **Configure o JDK**
    - File → Project Structure → Project
    - Defina o SDK como Java 24
    - Apply → OK

4. **Execute a aplicação**
    - Navegue até `src/Main.java`
    - Clique no botão "Run" ou pressione `Ctrl+Shift+F10`
    - O programa será executado no console

## Limitações Conhecidas

### Sistema de Usuários
- **Registro único por execução**: Apenas um usuário pode ser registrado por sessão
- **Usuário ativo fixo**: O sistema sempre usa o último usuário registrado

## Funcionalidades Técnicas

### Padrões Implementados

- **Factory Pattern**: Criação padronizada de objetos
- **Repository Pattern**: Abstração do acesso a dados
- **MVC Architecture**: Separação clara de responsabilidades
- **Service Layer**: Encapsulamento da lógica de negócio

### Tratamento de Dados

- Leitura automática de arquivos CSV
- Parsing inteligente de arrays (gêneros, IDs)
- Relacionamentos entre entidades
- Validação básica de entrada do usuário

## Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/NovaFuncionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/NovaFuncionalidade`)

5. Abra um Pull Request


