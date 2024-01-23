# Javalin Animal App

## Introduction:

This project is a demo of a REST API made with Java and Javalin, that allow to create and get pet animals with
information about them.

I tried to use the good practices like dependency injection or db migration management.

## Architecture

### org.example

- App: main() entrypoint, get the startup class and boot it with the desired EntrypointType.
- AppModule: install the AnimalAppModule and bind the startup class
- Startup: get all the existing implementation of AppEntrypoint and launch the one matching the wanted EntrypointType,
  eg REST

### config

- EntrypointType: enum with differents kinds of entrypoint, like REST for REST API
- AppEntrypoint: Interface representing the class that will add routes and start the app on a port (but will not create
  the Javalin instance). To add the routes, it must inject all the classes extending Routing
- Routing: abstract generic class that represent a route. It declares the getControllerFromGenericType() method that
  will get the controller class from the type. This class instance can then get loaded with getController() method. The
  class also declare an abstract method binRoutes() where the extended classes will link for every route the controller
  method associated.

### animalapp

- Utils: Get connection parameters from env variables
- WebEntrypoint: implementation of AppEntrypoint, get all Routing extended classes through field injection, get a
  Javalin instance, and for each Routing call the bindRoutes method to the app and then start the app on a port.
- WebModule: A
  Guice [AbstractModule](https://google.github.io/guice/api-docs/4.2/javadoc/index.html?com/google/inject/Module.html)
  like every class named 'Module', in the create() method it create a Javalin app instance, then bind it in the
  configure() method so that every injection of a Javalin app will return this instance with this special configuration.
  It also bind the AppEntrypoint class extension to an EntrypointType like REST.
- AnimalAppModule: A module that add others module like the AnimalModule or the WebModule, it will add to the Guice
  container instance of all the controllers, service, repositories, and also the instance of Javalin created in the
  WebModule

### animal (and animal_kind, animal_race, owner)

- repository, service: contains the interface representing the structure, the implementation, and in the module class we
  bind the implementation to the interface
- dto, entities: juste POJO
- AnimalController: the controller
- AnimalRouting: the routing of the animal package, expanding Routing
- AnimalModule: the module that install the repository and service modules, bind the controller and multibind the
  AnimalRouter