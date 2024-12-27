# Loan Service Application

## Description

This project is a Loan Service Application built with Java and Spring Boot. It determines the types of loans available for a client based on their income, age, and location. The application exposes a REST API endpoint to request loan information for a client.

## Features

- Determine loan types based on client information
- REST API endpoint to request loan information
- Uses a rule-based approach to determine loan eligibility

## How to Run

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/loan-service.git
   cd loan-service
   mvn clean install
   mvn spring-boot:run
## API Endpoint
POST /customer-loans
Request Body: Client object
Response: LoanResponse object containing the customer name and list of loans

# Aplicação de Serviço de Empréstimo

## Descrição

Este projeto é uma Aplicação de Serviço de Empréstimo construída com Java e Spring Boot. Ele determina os tipos de empréstimos disponíveis para um cliente com base em sua renda, idade e localização. A aplicação expõe um endpoint de API REST para solicitar informações de empréstimo para um cliente.

## Funcionalidades

- Determinar tipos de empréstimos com base nas informações do cliente
- Endpoint de API REST para solicitar informações de empréstimo
- Usa uma abordagem baseada em regras para determinar a elegibilidade para empréstimos

## Como Executar

1. Clone o repositório:
   ```sh
   git clone https://github.com/seuusuario/loan-service.git
   cd loan-service
   mvn clean install
   mvn spring-boot:run

## API Endpoint
POST /customer-loans
Corpo da Requisição: objeto Client
Resposta: objeto LoanResponse contendo o nome do cliente e a lista de empréstimos
