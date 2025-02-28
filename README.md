# URL Shortener

## 📌 Sobre o Projeto
Este é um serviço backend de encurtamento de URL desenvolvido em Java 21 com Spring Boot 3.x.x. Ele permite transformar links longos em versões curtas e gerenciar redirecionamentos.

## 🚀 Funcionalidades
- 🔗 **Encurtamento de URLs**: Transforma URLs longas em versões curtas.
- 🔄 **Redirecionamento Rápido**: Ao acessar a URL curta, o usuário é redirecionado para a URL original.
- 📊 **Estatísticas**: Possibilidade de rastrear quantas vezes a URL encurtada foi acessada.
- 🔒 **Segurança**: Opção de definir tempo de expiração para URLs encurtadas.

## 🛠️ Tecnologias Utilizadas
- **Linguagem**: Java 21
- **Framework**: Spring Boot 3.x.x
- **Banco de Dados**: MongoDB
- **Segurança**: Spring Security (opcional)

## 📂 Estrutura do Projeto
```
📁 url-shortener
 ├── 📂 src
 │   ├── 📂 main
 │   │   ├── 📂 java/br/com/gustavo
 │   │   │   ├── UrlShortenerApplication.java  # Classe principal
 │   │   │   ├── controller
 │   │   │   │   ├── UrlController.java  # Controlador REST
 │   │   │   ├── service
 │   │   │   │   ├── UrlService.java  # Lógica de encurtamento
 │   │   │   ├── repository
 │   │   │   │   ├── UrlRepository.java  # Persistência de dados
 │   │   │   ├── model
 │   │   │   │   ├── dto
 │   │   │   │   │   ├── request
 │   │   │   │   │   │   ├── ShortenUrlRequestDTO.java  # DTO de requisição
 │   │   │   │   │   ├── response
 │   │   │   │   │   │   ├── ShortenUrlResponseDTO.java  # DTO de resposta
 │   │   │   │   ├── entities  # Entidades do banco
 ├── 📂 resources
 │   ├── 📂 static
 │   ├── 📂 templates
 │   ├── 📜 application.properties  # Configurações do Spring Boot
 ├── 📜 README.md
 ├── 📜 pom.xml  # Dependências do Maven
```
