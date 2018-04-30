# zadanie_kalkulator_s

> Net earnings calculator on a contract in different countries


## Installation

- All the `code` except for src/main/frontend required to get started, Angular frontend is not ready

### Clone

- Clone this repo to your local machine using `https://github.com/kubiesh/zadanie_kalkulator_s.git`

### Build
> go to project directory
```shell
$ mvn install
```

### Run
> go to project directory
```shell
$ mvn spring-boot:run
```
- Default application port is 8080

## Tests
> go to project directory
```shell
$ mvn test
```


## How to use

- **How do to check if it works?**
>go to your web browser and type country ID and gross daily rate
```shell
http://localhost:8080/api/UK/120.00
http://localhost:8080/api/DE/210.50
http://localhost:8080/api/PL/180.50
```
- **How to show database?**
>go to your web browser and enter this URL
```shell
http://localhost:8080/data
```
Appeared content is unformatted database from JSON file

## Built with

* [Spring Boot](https://projects.spring.io/spring-boot/) - Application framework
* [Maven](https://maven.apache.org/) - Dependency Management

## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
