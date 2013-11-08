-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 08-11-2013 a las 02:16:34
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
  `nroDoc` varchar(12) NOT NULL,
  `calle` varchar(50) NOT NULL,
  `nro` varchar(6) NOT NULL,
  `piso` varchar(4) NOT NULL,
  `depto` varchar(4) NOT NULL,
  `codPostal` varchar(5) NOT NULL,
  `localidad` varchar(50) NOT NULL,
  `telFijo` varchar(20) NOT NULL,
  `telCel` varchar(20) NOT NULL,
  `eMail` varchar(50) NOT NULL,
  `foto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nroLegajo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29342 ;

--
-- Volcar la base de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`nroLegajo`, `nombre`, `apellido`, `fechaNacimiento`, `nroDoc`, `calle`, `nro`, `piso`, `depto`, `codPostal`, `localidad`, `telFijo`, `telCel`, `eMail`, `foto`) VALUES
(26051, 'Ariel', 'Dabbene', '1987-05-05', '33.422.999', 'Varela', '1200', '4', 'D', '1424', 'CABA', '45122479', '27364297', 'dabbene@yahoo.com.ar', NULL),
(28623, 'Juan Pablo Andrés', 'Sosa', '1983-11-30', '31.234.123', 'Humboldt', '1234', '', '', '2245', 'Villa Bosch', '43985222', '23235020', 'sosa@hotmail.com', NULL),
(29341, 'Zaiqi', 'Zhou', '1988-12-28', '93.777.813', 'Arribeños', '1234', 'P.B', 'F', '1450', 'CABA', '48071234', '40696890', 'zhou@gmail.com', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencias`
--

CREATE TABLE IF NOT EXISTS `asistencias` (
  `nroLegajo` int(4) NOT NULL,
  `codCurso` int(4) NOT NULL,
  `nroClase` int(4) NOT NULL,
  `asistencia` int(1) NOT NULL,
  KEY `nroLegajo` (`nroLegajo`),
  KEY `codCurso` (`codCurso`),
  KEY `nroClase` (`nroClase`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `asistencias`
--

INSERT INTO `asistencias` (`nroLegajo`, `codCurso`, `nroClase`, `asistencia`) VALUES
(29341, 98939, 3, 1),
(28623, 98939, 3, 1),
(26051, 98939, 3, 0),
(29341, 98939, 2, 1),
(26051, 98939, 2, 1),
(28623, 98939, 2, 0),
(29341, 98939, 1, 1),
(26051, 98939, 1, 1),
(28623, 98939, 1, 1),
(26051, 98939, 4, 1),
(28623, 98939, 4, 0),
(29341, 98939, 4, 1),
(26051, 98939, 5, 0),
(28623, 98939, 5, 1),
(29341, 98939, 5, 0),
(26051, 98939, 6, 1),
(28623, 98939, 6, 0),
(29341, 98939, 6, 1),
(26051, 98939, 7, 1),
(28623, 98939, 7, 1),
(29341, 98939, 7, 0),
(26051, 98939, 8, 1),
(28623, 98939, 8, 0),
(29341, 98939, 8, 1),
(26051, 98939, 9, 1),
(28623, 98939, 9, 0),
(29341, 98939, 9, 1),
(26051, 98939, 10, 1),
(28623, 98939, 10, 1),
(29341, 98939, 10, 0),
(26051, 98939, 11, 1),
(28623, 98939, 11, 0),
(29341, 98939, 11, 1),
(26051, 98939, 12, 0),
(28623, 98939, 12, 1),
(29341, 98939, 12, 1),
(26051, 98939, 13, 1),
(28623, 98939, 13, 0),
(29341, 98939, 13, 1),
(26051, 98939, 14, 1),
(28623, 98939, 14, 0),
(29341, 98939, 14, 1),
(26051, 98939, 15, 1),
(28623, 98939, 15, 0),
(29341, 98939, 15, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE IF NOT EXISTS `cursos` (
  `codCurso` int(4) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `prof` varchar(50) NOT NULL,
  `cantClases` int(10) NOT NULL,
  PRIMARY KEY (`codCurso`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=555556 ;

--
-- Volcar la base de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`codCurso`, `nombre`, `prof`, `cantClases`) VALUES
(98939, 'Programacion II', 'Corsi', 15),
(232323, 'pepe', 'pepe', 20),
(555555, 'asd', 'asd', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE IF NOT EXISTS `pagos` (
  `nroLegajo` int(4) NOT NULL,
  `codCurso` int(4) NOT NULL,
  `fecha` date NOT NULL,
  `importe` float NOT NULL,
  `comprobante` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `pagos`
--

INSERT INTO `pagos` (`nroLegajo`, `codCurso`, `fecha`, `importe`, `comprobante`) VALUES
(29341, 60251, '2013-07-01', 500, 'F-4953'),
(26051, 60251, '2013-07-01', 500, 'F-4955'),
(28623, 60251, '2013-07-01', 500, 'F-4957'),
(26051, 60251, '2013-08-01', 500, 'F-4958');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE IF NOT EXISTS `prestamos` (
  `nroLegajo` int(4) NOT NULL,
  `codRecurso` varchar(10) NOT NULL,
  `fechaPres` date NOT NULL,
  `fechaDevo` date DEFAULT NULL,
  `fechaPrevDevo` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`nroLegajo`, `codRecurso`, `fechaPres`, `fechaDevo`, `fechaPrevDevo`) VALUES
(29341, 'D2017', '2013-11-01', '2013-11-08', '2013-11-08'),
(28623, 'L1995', '2013-10-01', '2013-10-15', '2013-10-08'),
(26051, 'C2235', '2013-10-08', NULL, '2013-10-15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recursos`
--

CREATE TABLE IF NOT EXISTS `recursos` (
  `codRec` varchar(10) NOT NULL,
  `categoria` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `anio` int(4) NOT NULL,
  `cant` int(3) NOT NULL,
  `foto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codRec`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `recursos`
--

INSERT INTO `recursos` (`codRec`, `categoria`, `nombre`, `autor`, `anio`, `cant`, `foto`) VALUES
('C2235', 'CD', 'Turbo 7.0', 'R. Pérez', 2005, 2, NULL),
('D2017', 'DVD', 'Ubuntu 1.0', 'Desc.', 2002, 2, NULL),
('L1995', 'Libro', 'C - Guía Básica', 'JSA', 2008, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rel_alumnos_cursos`
--

CREATE TABLE IF NOT EXISTS `rel_alumnos_cursos` (
  `nroLegajo` int(11) NOT NULL,
  `codCurso` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `rel_alumnos_cursos`
--

INSERT INTO `rel_alumnos_cursos` (`nroLegajo`, `codCurso`) VALUES
(29341, 98939),
(28623, 98939),
(26051, 555555),
(29341, 555555),
(26051, 98939);
