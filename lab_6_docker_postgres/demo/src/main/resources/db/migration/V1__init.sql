-- Main table creation --
DROP SCHEMA IF EXISTS app_schem CASCADE;
DROP SCHEMA IF EXISTS public CASCADE;

CREATE SCHEMA IF NOT EXISTS app_schem;

CREATE TABLE IF NOT EXISTS app_schem.railcars (
    railcar_num BIGINT PRIMARY KEY,
    railcar_type VARCHAR(255) NOT NULL,
    railcar_capacity_tons BIGINT NOT NULL DEFAULT 0,
    railcar_owner_company VARCHAR(255) NOT NULL DEFAULT 'government'
);

CREATE TABLE IF NOT EXISTS app_schem.railcar_operations (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    railcar_num BIGINT NOT NULL REFERENCES app_schem.railcars(railcar_num) ON DELETE CASCADE,
    operation_type VARCHAR(255) NOT NULL,
    operation_status VARCHAR(255) NOT NULL DEFAULT 'unknown',
    station_from VARCHAR(255),
    station_to VARCHAR(255)
);


-- Table test filling --
INSERT INTO app_schem.railcars (railcar_num, railcar_type, railcar_capacity_tons)
VALUES (500101, 'cargo', 50);
INSERT INTO app_schem.railcars (railcar_num, railcar_type, railcar_capacity_tons, railcar_owner_company)
VALUES (500102, 'cargo', 70, 'roga i copita');
INSERT INTO app_schem.railcars (railcar_num, railcar_type, railcar_capacity_tons)
VALUES (500103, 'tank', 65);

INSERT INTO app_schem.railcar_operations (railcar_num, operation_type, operation_status, station_from, station_to)
VALUES (500101, 'transfer', 'in process', 'Komarovo', 'Moscow');
INSERT INTO app_schem.railcar_operations (railcar_num, operation_type, operation_status)
VALUES (500101, 'unload', 'planed');
INSERT INTO app_schem.railcar_operations (railcar_num, operation_type, operation_status, station_from, station_to)
VALUES (500102, 'transfer', 'planed', 'Novosibirsk', 'Yakutsk');
INSERT INTO app_schem.railcar_operations (railcar_num, operation_type, operation_status)
VALUES (500103, 'load', 'done');