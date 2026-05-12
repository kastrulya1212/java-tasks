## Основная информация
Челноков Д.Ю. Вариант 0. Группа ПИ-2-2

## Архитектура
demo/src/main/java/com/univ_java_task_7/demo - основные файлы приложения
demo/src/main/resources - файлы со свойствами приложения + миграции
demo/src/test/java/com/univ_java_task_7/demo - файлы с тестами
DemoApplication.java - точка входа, главный файл запуска

## Пример логов
Testing findByRailcarNum with num 500101
Found railcars: Railcar(railcar_num=500101, railcar_type=cargo, railcar_capacity_tons=50.0, railcar_owner_company=government)

Testing updateRailcar with num 500103
Result: Railcar(railcar_num=500103, railcar_type=tank, railcar_capacity_tons=65.0, railcar_owner_company=roga i copita)

Testing updateRailcarOperation with id 1
Result: RailcarOperation(id=1, railcar_num=500101, operation_type=transfer, operation_status=done, station_from=Komarovo, station_to=Moscow)

Testing deleteByRailcarNum with num 500103
Result: [Railcar(railcar_num=500101, railcar_type=cargo, railcar_capacity_tons=50.0, railcar_owner_company=government), Railcar(railcar_num=500102, railcar_type=cargo, railcar_capacity_tons=70.0, railcar_owner_company=roga i copita)]

Testing insertRailcar with num 500114
Result: [Railcar(railcar_num=500101, railcar_type=cargo, railcar_capacity_tons=50.0, railcar_owner_company=government), Railcar(railcar_num=500102, railcar_type=cargo, railcar_capacity_tons=70.0, railcar_owner_company=roga i copita), Railcar(railcar_num=500114, railcar_type=passanger, railcar_capacity_tons=0.0, railcar_owner_company=government)]

Testing deleteRailcarOperationById with id 5
Result: [RailcarOperation(id=2, railcar_num=500101, operation_type=unload, operation_status=planed, station_from=null, station_to=null), RailcarOperation(id=3, railcar_num=500102, operation_type=transfer, operation_status=planed, station_from=Novosibirsk, station_to=Yakutsk), RailcarOperation(id=1, railcar_num=500101, operation_type=transfer, operation_status=done, station_from=Komarovo, station_to=Moscow)]

Testing findOperationsByOperationType with type transfer
Result: [RailcarOperation(id=3, railcar_num=500102, operation_type=transfer, operation_status=planed, station_from=Novosibirsk, station_to=Yakutsk), RailcarOperation(id=1, railcar_num=500101, operation_type=transfer, operation_status=done, station_from=Komarovo, station_to=Moscow)]
All oeprations: [RailcarOperation(id=2, railcar_num=500101, operation_type=unload, operation_status=planed, station_from=null, station_to=null), RailcarOperation(id=3, railcar_num=500102, operation_type=transfer, operation_status=planed, station_from=Novosibirsk, station_to=Yakutsk), RailcarOperation(id=1, railcar_num=500101, operation_type=transfer, operation_status=done, station_from=Komarovo, station_to=Moscow)]

Testing findOperationsByRailcarNum with num 500101
Restult: [RailcarOperation(id=2, railcar_num=500101, operation_type=unload, operation_status=planed, station_from=null, station_to=null), RailcarOperation(id=1, railcar_num=500101, operation_type=transfer, operation_status=done, station_from=Komarovo, station_to=Moscow)]

Testing insertRailcarOperation with num 500114
Result: [RailcarOperation(id=2, railcar_num=500101, operation_type=unload, operation_status=planed, station_from=null, station_to=null), RailcarOperation(id=3, railcar_num=500102, operation_type=transfer, operation_status=planed, station_from=Novosibirsk, station_to=Yakutsk), RailcarOperation(id=1, railcar_num=500101, operation_type=transfer, operation_status=done, station_from=Komarovo, station_to=Moscow), RailcarOperation(id=5, railcar_num=500114, operation_type=transfer, operation_status=in process, station_from=null, station_to=null)]


# Инструкция по запуску и проверке работы

! Помарка. Данная lab_6 сделана для варианта 0 из word-файла, а не как остальные работы для 1. К сожалению заметил это только во время работы lab_7,

1. Необходимо локально запустить docker контейнер с образом PostgreSQL. 
Порт 5432 (дефолтный для PSQL) пробросить на 5431 на локальной машине. !Важно postgres должен быть полностью пустой, в схеме public не должно быть таблиц flyway.

1.1* Запустить контейнер с пробросом на 5431: 
docker run -d --name <имя_нового_контейнера> -p 5431:5432 postgres:latest


2. Тесты написаны в файле DemoApplicationTests.java. (src/test/.../demo/DemoApplicationTests.java)
Применение схемы и успешное прохождение тестов происходит ТОЛЬКО при первичном запуске.
Для повторного запуска необходимо ВРУЧНУЮ очистить схемы:

*2.1 Очистка таблиц вручную
- Вход в запущенный контейнер postgres:
docker exec -it <название_контейнера> bash
- Вход в БД по умолчанию:
psql -U postgres -d postgres
- Удаление схем вручную:
DROP SCHEMA public CASCADE; DROP SCHEMA app_schem CASCADE;
- Далее снова запуск тестов



3*. Если необходимо произвести тесты ещё раз, 


P.S Для сборки Spring Boot приложения использовал официальный сайт Spring Boot