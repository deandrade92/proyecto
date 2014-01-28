-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 26-01-2014 a las 18:35:42
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `centroodontologico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora`
--

CREATE TABLE IF NOT EXISTS `bitacora` (
  `bitacora` int(11) NOT NULL AUTO_INCREMENT,
  `bit_nombreusuario` varchar(30) NOT NULL,
  `bit_modulo` varchar(50) NOT NULL,
  `bit_accion` varchar(50) NOT NULL,
  `bit_fechahora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`bitacora`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `bitacora`
--

INSERT INTO `bitacora` (`bitacora`, `bit_nombreusuario`, `bit_modulo`, `bit_accion`, `bit_fechahora`) VALUES
(1, 'jesus', 'Registro y Consulta de Pacientes', 'Guardo paciente CI: E-21203413', '2014-01-02 19:12:16'),
(2, 'jesus', 'Registro y Consulta de Pacientes', 'Guardo paciente CI: V-21203417', '2014-01-02 19:19:16'),
(3, 'null', 'Registro y Consulta de Pacientes', 'Guardo paciente CI: V-24156088', '2014-01-04 15:28:58'),
(4, 'null', 'Registro y Consulta de Pacientes', 'Guardo paciente CI: V-12345678', '2014-01-17 12:42:08'),
(5, 'null', 'Registro y Consulta de Servicios', 'Guardo Servicio: Limpieza', '2014-01-26 03:54:35'),
(6, 'null', 'Registro y Consulta de Servicios', 'Guardo Servicio: extrancion', '2014-01-26 03:54:58'),
(7, 'null', 'Registro y Consulta de Servicios', 'Guardo Servicio: blaquiamiento', '2014-01-26 03:55:29'),
(8, 'null', 'Registro y Consulta de Usuario', 'Consulto Usuario CI: V-21203413 ', '2014-01-26 04:30:28'),
(9, 'null', 'Registro y Consulta de Usuario', 'Consulto Usuario CI: V-8741965 ', '2014-01-26 04:30:41'),
(10, 'null', 'Registro y Consulta de Usuario', 'Consulto Usuario CI: V-21203413 ', '2014-01-26 04:32:10'),
(11, 'null', 'Registro y Consulta de Usuario', 'Consulto Usuario CI: V-8741965 ', '2014-01-26 04:32:23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE IF NOT EXISTS `detalleventa` (
  `detalleventa` int(11) NOT NULL,
  `dven_nomser` varchar(50) NOT NULL,
  `dven_cantidad` int(11) NOT NULL,
  `dven_precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detalleventa`
--

INSERT INTO `detalleventa` (`detalleventa`, `dven_nomser`, `dven_cantidad`, `dven_precio`) VALUES
(6, 'blaquiamiento', 2, 477),
(6, 'blaquiamiento', 1, 477);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `pac_paciente` int(11) NOT NULL AUTO_INCREMENT,
  `pac_tipocedula` varchar(2) NOT NULL,
  `pac_cedula` varchar(10) NOT NULL,
  `pac_nombres` varchar(35) NOT NULL,
  `pac_apellidos` varchar(35) NOT NULL,
  `pac_sexo` varchar(1) NOT NULL,
  `pac_fecha` date NOT NULL,
  `pac_edad` varchar(2) NOT NULL,
  `pac_direccion` varchar(100) NOT NULL,
  `pac_nombrespm` varchar(35) NOT NULL,
  `pac_apellidospm` varchar(35) NOT NULL,
  `pac_codtmovil` varchar(4) NOT NULL,
  `pac_numtmovil` varchar(7) NOT NULL,
  `pac_codtfijo` varchar(4) NOT NULL,
  `pac_numtfijo` varchar(7) NOT NULL,
  `pac_usuariocorreo` varchar(40) NOT NULL,
  `pac_tipocorreo` varchar(7) NOT NULL,
  `pac_extensioncorreo` varchar(4) NOT NULL,
  `pac_status` varchar(1) NOT NULL,
  PRIMARY KEY (`pac_paciente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`pac_paciente`, `pac_tipocedula`, `pac_cedula`, `pac_nombres`, `pac_apellidos`, `pac_sexo`, `pac_fecha`, `pac_edad`, `pac_direccion`, `pac_nombrespm`, `pac_apellidospm`, `pac_codtmovil`, `pac_numtmovil`, `pac_codtfijo`, `pac_numtfijo`, `pac_usuariocorreo`, `pac_tipocorreo`, `pac_extensioncorreo`, `pac_status`) VALUES
(11, 'V-', '21203413', 'jesus manuel', 'de andrade rodriguez', 'M', '1992-09-25', '20', 'cabudare', '', '', '0414', '4921942', '', '', '', '', '', 'A'),
(12, 'V-', '21203411', 'manuel alejandro', 'molina', 'M', '2013-12-16', '0', 'wadawdawdawdawd', '', '', '', '', '', '', '', '', '', 'A'),
(13, 'V-', '1234567', 'awdad', 'wdadawdaw', 'M', '2000-06-08', '13', 'wdawdawdwa', '', '', '', '', '', '', '', '', '', 'A'),
(14, 'V-', '8741965', 'awdawdwadaw', 'wdadada', 'F', '1999-06-10', '14', 'esfsefsefsef', '', '', '', '', '', '', '', '', '', 'A'),
(15, 'V-', '21203415', 'jeje', 'sasa', 'M', '1984-01-12', '29', 'skefksekfmesfsef', '', '', '0414', '1597854', '', '', '', '', '', 'A'),
(16, 'V-', '2149875', 'ddawdawd', 'dawdaw', 'M', '1978-03-07', '35', 'dawdawd', '', '', '', '', '', '', '', '', '', 'A'),
(17, 'V-', '2587419', 'esfsf', 'esfsfs', 'M', '1987-02-19', '26', 'vdrrdrdgdrgrdgrd', '', '', '', '', '', '', '', '', '', 'A'),
(18, 'E-', '21203413', 'efsef', 'sefsefes', 'M', '1999-01-12', '14', 'eefwffwfefw', '', '', '0414', '1234567', '', '', '', '', '', 'A'),
(19, 'V-', '21203417', 'esfsefsefse', 'wdawdawd', 'M', '1987-02-11', '26', 'efesfesfesf', '', '', '', '', '', '', '', '', '', 'A'),
(20, 'V-', '24156088', 'ariany crisel', 'rodriguez rangel', 'F', '1992-09-07', '21', 'ruezga sur', '', '', '0426', '3527278', '0251', '9296475', 'ariany', 'hotmail', 'com', 'A'),
(21, 'V-', '12345678', 'manuel', 'aesefes', 'M', '2006-03-17', '8', 'sbfhibeshbflskf', 'sfesfs', 'aesefes', '0414', '1597862', '', '', 'esfsefsefsef', 'hotmail', 'com', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE IF NOT EXISTS `servicio` (
  `servicio` int(11) NOT NULL AUTO_INCREMENT,
  `ser_nombre` varchar(50) NOT NULL,
  `ser_precio` varchar(10) NOT NULL,
  `ser_descripcion` varchar(70) NOT NULL,
  `ser_status` varchar(1) NOT NULL,
  PRIMARY KEY (`servicio`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`servicio`, `ser_nombre`, `ser_precio`, `ser_descripcion`, `ser_status`) VALUES
(1, 'fefse', '123', 'esf', 'I'),
(2, 'sesfsef', '123', 'efsfse', 'I'),
(3, 'Limpieza', '1500', 'limpieza', 'A'),
(4, 'extrancion', '800', 'extraccion', 'A'),
(5, 'blaquiamiento', '477', 'blanquiamiento', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `usuario` int(11) NOT NULL AUTO_INCREMENT,
  `usu_tipocedula` varchar(2) NOT NULL,
  `usu_cedula` varchar(8) NOT NULL,
  `usu_nombres` varchar(30) NOT NULL,
  `usu_apellidos` varchar(30) NOT NULL,
  `usu_id` varchar(20) NOT NULL,
  `usu_contraseña` varchar(15) NOT NULL,
  `usu_nivel` varchar(1) NOT NULL,
  `usu_status` varchar(1) NOT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario`, `usu_tipocedula`, `usu_cedula`, `usu_nombres`, `usu_apellidos`, `usu_id`, `usu_contraseña`, `usu_nivel`, `usu_status`) VALUES
(1, 'V-', '21203413', 'jesus', 'de andrade', 'deandrade92', '4294967296', '1', 'A'),
(2, 'V-', '8741965', 'mercedes', 'de andrade', 'merce', '123456', '1', 'A'),
(3, 'V-', '24308951', 'tulio', 'vargas', 'tulito', '12345', '1', 'A'),
(4, 'V-', '18432760', 'a', 'c', 'v', 'aa', '1', 'A'),
(5, 'V-', '00000000', 'a', 'c', 'v', '12', '1', 'A'),
(6, 'V-', '24156088', 'ariany crisel', 'rodriguez rangel', 'ary', '12345', '1', 'A'),
(7, 'V-', '21203411', 'efesf', 'wadada', 'sefefesf', '123', '1', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE IF NOT EXISTS `ventas` (
  `ventas` int(11) NOT NULL AUTO_INCREMENT,
  `ven_tipocecula` varchar(2) NOT NULL,
  `ven_cedula` varchar(8) NOT NULL,
  `ven_fecha` varchar(12) NOT NULL,
  `ven_tfactura` float NOT NULL,
  PRIMARY KEY (`ventas`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`ventas`, `ven_tipocecula`, `ven_cedula`, `ven_fecha`, `ven_tfactura`) VALUES
(6, 'V-', '8741965', '2014-01-25', 2136.96);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
