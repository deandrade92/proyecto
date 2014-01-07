-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 07-01-2014 a las 19:03:55
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `bitacora`
--

INSERT INTO `bitacora` (`bitacora`, `bit_nombreusuario`, `bit_modulo`, `bit_accion`, `bit_fechahora`) VALUES
(1, 'jesus', 'Registro y Consulta de Pacientes', 'Guardo paciente CI: E-21203413', '2014-01-02 19:12:16'),
(2, 'jesus', 'Registro y Consulta de Pacientes', 'Guardo paciente CI: V-21203417', '2014-01-02 19:19:16'),
(3, 'null', 'Registro y Consulta de Pacientes', 'Guardo paciente CI: V-24156088', '2014-01-04 15:28:58');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

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
(20, 'V-', '24156088', 'ariany crisel', 'rodriguez rangel', 'F', '1992-09-07', '21', 'ruezga sur', '', '', '0426', '3527278', '0251', '9296475', 'ariany', 'hotmail', 'com', 'A');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario`, `usu_tipocedula`, `usu_cedula`, `usu_nombres`, `usu_apellidos`, `usu_id`, `usu_contraseña`, `usu_nivel`, `usu_status`) VALUES
(1, 'V-', '21203413', 'jesus', 'de andrade', 'deandrade92', '4294967296', '1', 'A'),
(2, 'V-', '8741965', 'mercedes', 'de andrade', 'merce', '123456', '1', 'A'),
(3, 'V-', '24308951', 'tulio', 'vargas', 'tulito', '12345', '1', 'A'),
(4, 'V-', '18432760', 'a', 'c', 'v', 'aa', '1', 'A'),
(5, 'V-', '00000000', 'a', 'c', 'v', '12', '1', 'A'),
(6, 'V-', '24156088', 'ariany crisel', 'rodriguez rangel', 'ary', '12345', '1', 'A');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
