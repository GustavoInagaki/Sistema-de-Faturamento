# Sistema-de-Faturamento em Java

Projeto de desenvolvido com foco em **Programação Orientada a Objetos (POO)** utilizando Java puro, com entrada e saída de dados via **Terminal interativo**.

## Funcionalidades

- Cadastro de **Clientes** (com validação de CPF/CNPJ)
- Cadastro de **Produtos** (com controle de estoque e preço)
- Criação de **Faturas** com múltiplos itens
- Cálculo automático do **valor total**
- Tratamento de erros para garantir a robustez do sistema

## Tecnologias utilizadas

- Java 17+
- Colelções ('ArrayList')
- Entrada via 'Scanner'
- Tratamento de exceções com 'try-catch'
- Separação de responsabilidades via classes ('Cliente', 'Produto', 'Fatura', 'ItemFatura')

## Estrutura do Projeto

scr/
|----- Cliente.java
|----- Produto.java
|----- ItemFatura.java
|----- Fatura.java
|----- CadastroCLiente.java

## Próximos passos
- Adicionar persistência de dados (arquivos ou banco de dados)
- Criar interface gráfica com JavaFX ou Swing
- Criar testes automatizados
- Exportar faturas para PDF



Desenvolvido por Gustavo Barbosa Inagaki
