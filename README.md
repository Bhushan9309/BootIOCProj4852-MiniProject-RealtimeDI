| Topic                                | What to Describe                                                                                                                          |
| ------------------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------- |
| **Project setup**                    | How the project is initialized: Maven, Spring Boot version, directory structure.                                                          |
| **Dependencies**                     | What’s in `pom.xml`: spring-boot starter(s) used, any extras.                                                                             |
| **Bean definitions**                 | What classes are beans, how annotated. Interfaces vs implementations. How they are discovered (component scan).                           |
| **Dependency injection methods**     | Constructor injection, setter, field? Which did you use and why. Pros & cons.                                                             |
| **Bean scope**                       | Are beans singleton (default)? Did you try prototype or others?                                                                           |
| **Configuration properties**         | Any usage of `application.properties` / `@Value` / `@ConfigurationProperties`. How to switch behavior via config.                         |
| **Conditional wiring**               | If you have multiple implementations, how does Spring choose which one at runtime (e.g. via profile, qualifier, primary)?                 |
| **Application flow**                 | What happens on start: which beans are created, which services are called. If using `CommandLineRunner` or web layer, what the user sees. |
| **IOC container lifecycle**          | How Spring Boot starts ApplicationContext, instantiates beans, injects dependencies, and shuts down.                                      |
| **Advantages of IOC / DI**           | Decoupling, easier testing, swapping implementations without code changes, better maintainability.                                        |
| **Limitations / what you didn't do** | For example: not much error handling, no scope change / advanced features, no real web UI or database, maybe no unit tests, etc.          |
