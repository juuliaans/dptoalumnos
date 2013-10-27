-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 27-10-2013 a las 00:17:47
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
  `fechaNacimiento` varchar(10) NOT NULL,
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`nroLegajo`, `nombre`, `apellido`, `fechaNacimiento`, `nroDoc`, `calle`, `nro`, `piso`, `depto`, `codPostal`, `localidad`, `telFijo`, `telCel`, `eMail`, `foto`) VALUES
(1, 'Lucas', 'Masiello', '16/03/1990', '35156843', 'Darragueira', '2270', '-', '-', '1609', 'San Isidro', '47378165', '1534017321', 'lucas380w@hotmail.com', ''),
(2, '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', NULL),
(3, 'Julian', 'Santa ana', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', NULL),
(4, '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE IF NOT EXISTS `cursos` (
  `codCurso` int(4) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `prof` varchar(50) NOT NULL,
  PRIMARY KEY (`codCurso`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`codCurso`, `nombre`, `prof`) VALUES
(1, 'Matemáticas', 'Mr Perez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE IF NOT EXISTS `pagos` (
  `nroLegajo` int(4) NOT NULL,
  `codCurso` int(4) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `importe` float NOT NULL,
  `comprobante` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `pagos`
--

INSERT INTO `pagos` (`nroLegajo`, `codCurso`, `fecha`, `importe`, `comprobante`) VALUES
(1, 1, '1', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE IF NOT EXISTS `prestamos` (
  `nroLegajo` int(4) NOT NULL,
  `codRecurso` int(4) NOT NULL,
  `fechaPres` varchar(10) NOT NULL,
  `fechaDevo` varchar(10) NOT NULL,
  `fechaPrevDevo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`nroLegajo`, `codRecurso`, `fechaPres`, `fechaDevo`, `fechaPrevDevo`) VALUES
(1, 1, '1', '1', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recursos`
--

CREATE TABLE IF NOT EXISTS `recursos` (
  `codRec` int(4) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(2) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `anio` int(4) NOT NULL,
  `cant` int(3) NOT NULL,
  `foto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codRec`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `recursos`
--

