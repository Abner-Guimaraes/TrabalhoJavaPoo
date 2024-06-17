# Projeto de Programação Orientada a Objetos (POO)

## Descrição do Projeto
Este projeto foi desenvolvido como parte do curso de Programação Orientada a Objetos (POO). O objetivo principal é a criação de uma aplicação com interface gráfica utilizando JavaFX e integração com um banco de dados MySQL. Além disso, o projeto inclui a criação de um vídeo explicativo detalhando os principais aspectos do desenvolvimento.

## Funcionalidades
- **Interface Gráfica com JavaFX**: Criação de uma interface de usuário intuitiva e responsiva.
- **Integração com Banco de Dados MySQL**: Implementação de operações CRUD (Create, Read, Update, Delete) para gerenciar dados.
- **Gerenciamento de Projeto no Jira**: O projeto está sendo gerenciado e organizado utilizando a plataforma Jira. Acesse o [projeto no Jira](https://abner66-team.atlassian.net/) para mais detalhes.

## Tecnologias Utilizadas
- **Java**
- **JavaFX**
- **MySQL**
- **Jira**

## Pré-requisitos
Antes de executar o projeto, certifique-se de ter os seguintes softwares instalados:
- **Java Development Kit (JDK)**
- **MySQL**
- **Maven** (opcional, para gerenciamento de dependências)
- **IDE** (como IntelliJ IDEA, Eclipse, etc.)

## Branches do Repositório
Este repositório possui as seguintes branches:
1. **main**: Contém o trabalho principal. As outras branches serão mescladas aqui no final do projeto.
2. **TOO-2-Interface-Gráfica**: Contém os códigos em JavaFX da interface gráfica.
3. **TOO-3-MySQL**: Contém os códigos SQL para criação e manipulação da tabela de produtos no banco de dados.

---

# Guia para Vídeo Explicativo: Interface Gráfica em JavaFX com MySQL

## Introdução
- **Apresentação do tema**: Explique que o objetivo do projeto é desenvolver uma interface gráfica utilizando JavaFX que se conecta a um banco de dados MySQL.
- **Objetivo do vídeo**: O vídeo deve mostrar como o código permite criar, atualizar, deletar e visualizar produtos em uma tabela.

## Configuração do Ambiente

### Instalação do JavaFX
- Explique a importância de adicionar as bibliotecas do JavaFX ao projeto.
- Mostre como fazer isso no ambiente de desenvolvimento integrado (IDE) utilizado (por exemplo, IntelliJ ou Eclipse).

### Configuração do MySQL
- Explique como instalar o MySQL no sistema.
- Demonstre como criar o banco de dados e a tabela de produtos necessária para o projeto.

## Estrutura do Projeto JavaFX

### Pacotes e Arquivos
- Descreva a organização dos pacotes, como `controller`.
- Explique brevemente o propósito de cada pacote.

### Classe Principal
- Apresente a classe principal que inicia a aplicação JavaFX(ProdutosControlador)
- Descreva o papel dessa classe na aplicação.

## Conexão com o Banco de Dados
- Explique a classe responsável pela conexão com o banco de dados MySQL.
- Enfatize a importância de configurar corretamente as credenciais de acesso ao banco de dados.

## Operações CRUD

### Modelo de Produto
- Descreva a classe que representa o modelo de produto.
- Explique os atributos principais da classe, como `id`, `nome`, `preco`, e `quantidade`.

### DAO de Produto
- Explique a função da classe DAO (Data Access Object) em realizar operações no banco de dados.
- Descreva brevemente as operações CRUD (Create, Read, Update, Delete) que essa classe realiza.

## Interface Gráfica

### JavaFX e Controlador
- Explique o que é um arquivo JavaFX e seu papel na definição da interface gráfica.
- Descreva o controlador associado ao arquivo JavaFX, que gerencia a interação entre a interface gráfica e a lógica do aplicativo.

## Demonstração Prática
- Mostre a execução da aplicação.
- Demonstre cada funcionalidade da aplicação: criar, atualizar, deletar e listar produtos.

## Conclusão
- Resuma os principais pontos abordados no vídeo.
- Faça um encerramento destacando possíveis próximos passos ou melhorias futuras.

## Referências
- Recomende a documentação oficial do JavaFX: [https://openjfx.io/](https://openjfx.io/)
- Sugira a documentação do MySQL: [https://dev.mysql.com/doc/](https://dev.mysql.com/doc/)

---
