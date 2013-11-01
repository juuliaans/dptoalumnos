-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-11-2013 a las 22:32:34
-- Versión del servidor: 5.1.44
-- Versión de PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `dptoalumnos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE IF NOT EXISTS `alumnos` (
  `nroLegajo` int(4) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `nroDoc` varchar(8) NOT NULL,
  `calle` varchar(50) NOT NULL,
  `nro` varchar(6) NOT NULL,
  `piso` varchar(2) NOT NULL,
  `depto` varchar(1) NOT NULL,
  `codPostal` varchar(5) NOT NULL,
  `localidad` varchar(50) NOT NULL,
  `telFijo` varchar(20) NOT NULL,
  `telCel` varchar(20) NOT NULL,
  `eMail` varchar(50) NOT NULL,
  `foto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nroLegajo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Volcar la base de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`nroLegajo`, `nombre`, `apellido`, `fechaNacimiento`, `nroDoc`, `calle`, `nro`, `piso`, `depto`, `codPostal`, `localidad`, `telFijo`, `telCel`, `eMail`, `foto`) VALUES
(1, 'Lucas', 'Masiello', '1990-03-16', '12354729', 'La Rioja', '3232', '4', '8', '1492', 'CABA', '3029320320', '2942929429', 'masiello.el.mas.capo@hotmail.com', NULL),
(2, 'Julian', 'Santa Ana', '1992-12-05', '37170776', 'La Pampa', '3191', '6', 'A', '1428', 'CABA', '9239293923', '2939239293', 'julian.el.mas.capo@hotmail.com', NULL);
