spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/demodb
    username: postgres
    password: password
    hikari:
      maximum-pool-size: 30

  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true

server:
  port: 8080