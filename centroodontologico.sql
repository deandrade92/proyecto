-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 29-01-2014 a las 21:19:26
-- Versión del servidor: 5.6.14
-- Versión de PHP: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `bitacora`
--

INSERT INTO `bitacora` (`bitacora`, `bit_nombreusuario`, `bit_modulo`, `bit_accion`, `bit_fechahora`) VALUES
(1, 'jesus', 'Registro y Consulta de Pacientes', 'Guardo paciente CI: E-21203413', '2014-01-02 19:12:16'),
(2, 'jesus', 'Registro y Consulta de Pacientes', 'Guardo paciente CI: V-21203417', '2014-01-02 19:19:16'),
(3, 'null', 'Registro y Consulta de Pacientes', 'Guardo paciente CI: V-24156088', '2014-01-04 15:28:58'),
(4, 'null', 'Registro y Consulta de Pacientes', 'Guardo paciente CI: V-12345678', '2014-01-17 12:42:08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE IF NOT EXISTS `citas` (
  `pac_cedula` varchar(10) CHARACTER SET latin1 NOT NULL,
  `pac_nombre` varchar(50) CHARACTER SET latin1 NOT NULL,
  `fecha_cita` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`pac_cedula`, `pac_nombre`, `fecha_cita`) VALUES
('24156088', 'Ariany CriselRodriguez Rangel', '2014-01-25');

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
-- Estructura de tabla para la tabla `historia_clinica`
--

CREATE TABLE IF NOT EXISTS `historia_clinica` (
  `hist_nro` int(9) NOT NULL AUTO_INCREMENT,
  `hist_pac_paciente` int(11) NOT NULL,
  `hist_Estado` tinyint(1) NOT NULL,
  `hist_enfermedades` bigint(14) NOT NULL,
  `pre_id1` int(11) DEFAULT NULL,
  `pre_id2` int(11) DEFAULT NULL,
  `pre_id3` int(11) DEFAULT NULL,
  `hist_alergia` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `hist_ronca` tinyint(1) NOT NULL,
  `hist_respira_boca` int(1) NOT NULL,
  `hist_resfrio` tinyint(1) NOT NULL,
  `hist_ad_sinus` tinyint(1) NOT NULL,
  `pre_id4` int(11) DEFAULT NULL,
  `pre_id5` int(11) DEFAULT NULL,
  PRIMARY KEY (`hist_nro`),
  UNIQUE KEY `nro` (`hist_nro`),
  KEY `pac_paciente` (`hist_pac_paciente`),
  KEY `pre_id1` (`pre_id1`),
  KEY `pre_id2` (`pre_id2`),
  KEY `pre_id3` (`pre_id3`),
  KEY `pre_id4` (`pre_id4`),
  KEY `pre_id5` (`pre_id5`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `historia_clinica`
--

INSERT INTO `historia_clinica` (`hist_nro`, `hist_pac_paciente`, `hist_Estado`, `hist_enfermedades`, `pre_id1`, `pre_id2`, `pre_id3`, `hist_alergia`, `hist_ronca`, `hist_respira_boca`, `hist_resfrio`, `hist_ad_sinus`, `pre_id4`, `pre_id5`) VALUES
(1, 22, 1, 10000000000001, NULL, 20189150, 20189150, '100,humo', 1, 1, 0, 1, 20189150, 20189150),
(2, 20, 1, 10011011001011, 24156088, 24156088, 24156088, '100,humo', 1, 1, 0, 0, 24156088, 24156088);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `pac_paciente` int(11) NOT NULL AUTO_INCREMENT,
  `pac_tipocedula` varchar(2) CHARACTER SET latin1 NOT NULL,
  `pac_cedula` varchar(10) CHARACTER SET latin1 NOT NULL,
  `pac_nombres` varchar(35) CHARACTER SET latin1 NOT NULL,
  `pac_apellidos` varchar(35) CHARACTER SET latin1 NOT NULL,
  `pac_sexo` varchar(1) CHARACTER SET latin1 NOT NULL,
  `pac_fecha` date NOT NULL,
  `pac_edad` varchar(2) CHARACTER SET latin1 NOT NULL,
  `pac_direccion` varchar(100) CHARACTER SET latin1 NOT NULL,
  `pac_nombrespm` varchar(35) CHARACTER SET latin1 NOT NULL,
  `pac_apellidospm` varchar(35) CHARACTER SET latin1 NOT NULL,
  `pac_codtmovil` varchar(4) CHARACTER SET latin1 NOT NULL,
  `pac_numtmovil` varchar(7) CHARACTER SET latin1 NOT NULL,
  `pac_codtfijo` varchar(4) CHARACTER SET latin1 NOT NULL,
  `pac_numtfijo` varchar(7) CHARACTER SET latin1 NOT NULL,
  `pac_usuariocorreo` varchar(40) CHARACTER SET latin1 NOT NULL,
  `pac_tipocorreo` varchar(7) CHARACTER SET latin1 NOT NULL,
  `pac_extensioncorreo` varchar(4) CHARACTER SET latin1 NOT NULL,
  `pac_status` varchar(1) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`pac_paciente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=23 ;

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
(21, 'V-', '12345678', 'manuel', 'aesefes', 'M', '2006-03-17', '8', 'sbfhibeshbflskf', 'sfesfs', 'aesefes', '0414', '1597862', '', '', 'esfsefsefsef', 'hotmail', 'com', 'A'),
(22, 'V-', '20189150', 'luis Alberto', 'Soto Ocanto', 'M', '1992-02-14', '88', 'carrrera 6 entre calles 5 y 6', '', '', '0426', '2574359', '', '', '', '', '', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta_dificultad_mas`
--

CREATE TABLE IF NOT EXISTS `pregunta_dificultad_mas` (
  `pre_id4` int(11) NOT NULL,
  `pre_descripcion` varchar(30) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL,
  PRIMARY KEY (`pre_id4`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pregunta_dificultad_mas`
--

INSERT INTO `pregunta_dificultad_mas` (`pre_id4`, `pre_descripcion`) VALUES
(20189150, 'nose'),
(24156088, 'Diente Chueco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta_dolor_cabeza`
--

CREATE TABLE IF NOT EXISTS `pregunta_dolor_cabeza` (
  `pre_id3` int(11) NOT NULL,
  `pre_descripcion` varchar(30) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL,
  PRIMARY KEY (`pre_id3`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pregunta_dolor_cabeza`
--

INSERT INTO `pregunta_dolor_cabeza` (`pre_id3`, `pre_descripcion`) VALUES
(20189150, 'Dol'),
(24156088, 'dol');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta_estacion_med`
--

CREATE TABLE IF NOT EXISTS `pregunta_estacion_med` (
  `pre_id1` int(11) NOT NULL,
  `pre_descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`pre_id1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pregunta_estacion_med`
--

INSERT INTO `pregunta_estacion_med` (`pre_id1`, `pre_descripcion`) VALUES
(24156088, 'ataques, se le va el ojo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta_medicamentos`
--

CREATE TABLE IF NOT EXISTS `pregunta_medicamentos` (
  `pre_id2` int(11) NOT NULL,
  `pre_descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`pre_id2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pregunta_medicamentos`
--

INSERT INTO `pregunta_medicamentos` (`pre_id2`, `pre_descripcion`) VALUES
(20189150, 'dexometasona y dormir wdd d'),
(24156088, 'fenobarbital');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta_orl`
--

CREATE TABLE IF NOT EXISTS `pregunta_orl` (
  `pre_id5` int(11) NOT NULL,
  `pre_descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `pre_cuando` date NOT NULL,
  `pre_operacion` smallint(3) NOT NULL,
  PRIMARY KEY (`pre_id5`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pregunta_orl`
--

INSERT INTO `pregunta_orl` (`pre_id5`, `pre_descripcion`, `pre_cuando`, `pre_operacion`) VALUES
(20189150, 'tabique desviado', '2011-01-08', 101),
(24156088, 'Nariz torcida', '2012-01-05', 110);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE IF NOT EXISTS `servicio` (
  `servicio` int(11) NOT NULL AUTO_INCREMENT,
  `ser_nombre` int(11) NOT NULL,
  `ser_precio` int(11) NOT NULL,
  `ser_descripcion` int(11) NOT NULL,
  `ser_status` int(11) NOT NULL,
  PRIMARY KEY (`servicio`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`servicio`, `ser_nombre`, `ser_precio`, `ser_descripcion`, `ser_status`) VALUES
(1, 0, 123, 0, 0),
(2, 0, 123, 0, 0),
(3, 0, 1500, 0, 0),
(4, 0, 800, 0, 0),
(5, 0, 477, 0, 0);

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

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historia_clinica`
--
ALTER TABLE `historia_clinica`
  ADD CONSTRAINT `historia_clinica_ibfk_1` FOREIGN KEY (`hist_pac_paciente`) REFERENCES `paciente` (`pac_paciente`) ON UPDATE CASCADE,
  ADD CONSTRAINT `historia_clinica_ibfk_2` FOREIGN KEY (`pre_id1`) REFERENCES `pregunta_estacion_med` (`pre_id1`) ON UPDATE CASCADE,
  ADD CONSTRAINT `historia_clinica_ibfk_3` FOREIGN KEY (`pre_id2`) REFERENCES `pregunta_medicamentos` (`pre_id2`) ON UPDATE CASCADE,
  ADD CONSTRAINT `historia_clinica_ibfk_4` FOREIGN KEY (`pre_id3`) REFERENCES `pregunta_dolor_cabeza` (`pre_id3`) ON UPDATE CASCADE,
  ADD CONSTRAINT `historia_clinica_ibfk_5` FOREIGN KEY (`pre_id4`) REFERENCES `pregunta_dificultad_mas` (`pre_id4`) ON UPDATE CASCADE,
  ADD CONSTRAINT `historia_clinica_ibfk_6` FOREIGN KEY (`pre_id5`) REFERENCES `pregunta_orl` (`pre_id5`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
