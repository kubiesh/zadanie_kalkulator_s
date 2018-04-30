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

### Possible problem

There might be a problem with not found .properties files from /properties/ especially after command
```shell
$ mvn clean
```
Folder /properties/ is added to classpath, but after command program cannot find this file which cases NotFoundException and NullPointerException. Properties are neccessary for project to run. 
Found similiar problems, but solutions does not work for me
[Similiar problem](https://stackoverflow.com/questions/9698465/maven-clean-build-causes-project-in-eclipse-to-show-errors-until-clean-in-ecli`)

## Tests
> go to project directory
```shell
$ mvn test
```
## Specificaton

### **How it works?**
- backend gets from client selected country by countryID and daily rate
- It calculates net earnings in local currency substracted by tax and fixed costs
- If country is not Poland(by default, data.json) then it calculates earnings in PLN

### **Controllers**
EarningsCalculationController - gets countryID and daily rate, returns result of calculation specified in task, for wrong data returns 0
DataFileController - returns data.json, this is for frontend

### **Flexible components**
- INBPWebAPI - component is prepared for adding another strategy of getting data from NBP Web API, i.e. in XML or some new format in the future
- ICountryDAO - component is prepared for adding another strategy of getting database from file etc. for now primary strategy is parsing data from data.json file

### **Cons**
- Method CountryDAO_json.loadCountries() is not most elegant solution, I think it can be done better
- Program might be not secured for exceptions caused by not working NBP Web API

### **Pros**
- You don't have to change the code to add/modify/delete countries data(tax rates, fixed costs), work days and final currency. Just edit data.json file
- data.json file path and url for NBP Web API is stored outside the code in .properties files

## How to use

- **How do to check if it works?**
>as frontend is not finished, go to your web browser and type country ID and gross daily rate, i.e
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

- **How to modify database, add new countries?**
>edit data.json file, you can find it in /src/main/resources

## Built with

* [Spring Boot](https://projects.spring.io/spring-boot/) - Application framework
* [Maven](https://maven.apache.org/) - Dependency Management

## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
