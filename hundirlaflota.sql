CREATE DATABASE IF NOT EXISTS `hundirlaflota`;
USE `hundirlaflota`;
CREATE TABLE `jugador`(`nombre` varchar (30) PRIMARY KEY NOT NULL, `puntosfacil` int (10) DEFAULT NULL, `puntosnormal` int (15) DEFAULT NULL, `puntosdificil` int (20) DEFAULT NULL);
SELECT * FROM `jugador`;