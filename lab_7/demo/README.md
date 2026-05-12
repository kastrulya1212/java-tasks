## Основная информация
Челноков Д.Ю. Вариант 0. Группа ПИ-2-2

## Архитектура
demo/src/main/java/com/univ_java_task_7/demo - основные файлы приложения
demo/src/main/resources - файлы со свойствами приложения + миграции
demo/src/test/java/com/univ_java_task_7/demo - файлы с тестами
DemoApplication.java - точка входа, главный файл запуска

## Пример логов успешного запуска
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.5)

2026-05-12T14:19:54.579+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] c.univ_java_task_7.demo.DemoApplication  : Starting DemoApplication using Java 23.0.2 with PID 36036 (D:\Programs\GitProjects\java tasks univ\lab_7\demo\target\classes started by 91547 in D:\Programs\GitProjects\java tasks univ\lab_7)
2026-05-12T14:19:54.579+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] c.univ_java_task_7.demo.DemoApplication  : No active profile set, falling back to 1 default profile: "default"
2026-05-12T14:19:54.674+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2026-05-12T14:19:54.674+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2026-05-12T14:19:56.103+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2026-05-12T14:19:56.125+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2026-05-12T14:19:56.125+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.31]
2026-05-12T14:19:56.184+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2026-05-12T14:19:56.186+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1510 ms
2026-05-12T14:19:56.531+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2026-05-12T14:19:56.665+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection org.postgresql.jdbc.PgConnection@7a5feb29
2026-05-12T14:19:56.666+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2026-05-12T14:19:56.690+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] org.flywaydb.core.FlywayExecutor         : Database: jdbc:postgresql://localhost:5431/postgres (PostgreSQL 16.12)
2026-05-12T14:19:56.749+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] o.f.core.internal.command.DbValidate     : Successfully validated 2 migrations (execution time 00:00.036s)
2026-05-12T14:19:56.783+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] o.f.core.internal.command.DbMigrate      : Current version of schema "public": 1
2026-05-12T14:19:56.785+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] o.f.core.internal.command.DbMigrate      : Schema "public" is up to date. No migration necessary.
2026-05-12T14:19:57.704+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2026-05-12T14:19:57.756+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2026-05-12T14:19:57.766+03:00  INFO 36036 --- [Lab7MyDb] [  restartedMain] c.univ_java_task_7.demo.DemoApplication  : Started DemoApplication in 3.486 seconds (process running for 3.851)
2026-05-12T14:20:05.163+03:00  INFO 36036 --- [Lab7MyDb] [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2026-05-12T14:20:05.165+03:00  INFO 36036 --- [Lab7MyDb] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2026-05-12T14:20:05.165+03:00  INFO 36036 --- [Lab7MyDb] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 0 ms
2026-05-12T14:20:05.827+03:00  INFO 36036 --- [Lab7MyDb] [nio-8080-exec-9] o.springdoc.api.AbstractOpenApiResource  : Init duration for springdoc-openapi is: 391 ms



# Инструкция по запуску и проверке работы

! Помарка. Данная lab_7 также как и lab_6 сделана для варианта 0 из word-файла, а не как остальные работы для 1. К сожалению заметил это только во время работы lab_7,

1. Необходимо локально запустить docker контейнер с образом PostgreSQL. 
Порт 5432 (дефолтный для PSQL) пробросить на 5431 на локальной машине. !Важно postgres должен быть полностью пустой, в схеме public не должно быть таблиц flyway.

1.1* Запустить контейнер с пробросом на 5431: 
docker run -d --name <имя_нового_контейнера> -p 5431:5432 postgres:latest


2. Запустить входную точку Spring Boot (файл) DemoApplication.java.
Далее по адресу "http://localhost:8080/swagger-ui/index.html" можно найти swagger


P.S Для сборки Spring Boot приложения использовал официальный сайт Spring Boot