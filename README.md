# quarkus-sample project

This is a study project, it uses Quarkus, the Supersonic Subatomic Java Framework.

The project was bootstrapped with maven quarkus plugin:

```
mvn io.quarkus:quarkus-maven-plugin:2.8.3.Final:create \
    -DprojectGroupId=com.nickperov.stud \
    -DprojectArtifactId=quarkus-sample \
    -DclassName="com.nickperov.stud.quarkus.sample.GreetingResource" \
    -Dpath="/hello"
```

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `quarkus-sample-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/quarkus-sample-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/quarkus-sample-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

## Running application

Test application consists of H2 DB (with a single table __PARTICIPANTS__ which contains first and last name of a person), __Participants__ service and __Participants__ controller.

Application initializes table data on startup.

Some query examples to try application:

Get list of all participants:

    curl localhost:8080/participants/all
    
Get specific participant by id:

    curl localhost:8080/participants?id=4

Find participants by first/last name:
    
    curl -X POST -H "Content-type: application/json"  -d '{"firstName":"Nick", "lastName":"Lee"}' localhost:8080/participants/find    
    
Add new participant:
    
    curl -X POST -H "Content-type: application/json"  -d '{"firstName":"John", "lastName":"Black"}' localhost:8080/participants/add
    
## Remarks

Embedded H2 in memory DB (jdbc:h2:mem:test) doesn't work with native-image.

## Authors

Nikolay Perov

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
