# Sobre o projeto:
Após uma conversa entre amigos pensando no melhor local para se tirar férias, foi iniciado uma pesquisa para criar um itinerário de férias, foi visto a dificuldade para escolher o melhor meio de transporte, locais de hospedagem, opções de passeios, meios de locomoção, plano para emergências e o principal média de gastos. Com isso nasceu a ideia de construir uma plataforma que pudesse facilitar essa tomada de decisão.

# Pré-requisitos:
* Docker (ou Postgres instalado em sua máquina, entretanto este tutorial está escrito para o caso do Docker)
* Java SDK 17

# Como executar:
Em alguma pasta de sua preferência abra o terminal e clone o projeto:
```
git clone https://github.com/Tatu-Armadillo/trips.git
```

Antes de executar o programa, há a necessidade de criar e executar uma imagem de um container Postgres, que será usado como banco de dados. Na pasta /trips

```
docker compose -f docker-compose.yml run db
```

Após verificar se o container está rodando corretamente, execute o arquivo .java

```
src/main/java/br/com/fiap/pos/challenge/trips/TripsApplication.java
```

Caso esteja enfrentando erros com o Flyway Migration, pare a execução do container de banco de dados, exclua-o e exclua sua imagem também. Após esse processo, realize o processo de docker compose novamente:

```
docker compose -f docker-compose.yml run db
```
