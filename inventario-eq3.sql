-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-06-2018 a las 09:08:49
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `inventario-eq3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
`id_cliente` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `domicilio` varchar(100) DEFAULT NULL,
  `RFC` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefono` int(15) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre`, `domicilio`, `RFC`, `email`, `telefono`) VALUES
(1, 'Colores', 'AV Universidad', '1234567', 'Coloresa@gmail.com', 95312312),
(2, 'Joe Doe', 'Avenida Universidad, esquina con Lirio', 'JD53726289', 'john@example.com', 2147483647),
(3, 'Joe Doe', 'Avenida Universidad, esquina con Lirio', 'JD28907778', 'john@example.com', 2147483647),
(4, 'Nancy', 'AV Universidad', '1234567', 'Nancy@gmail.com', 95312312),
(5, 'Lupe', 'AV Universidad', '1234567', 'Nancy@gmail.com', 95312312);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE IF NOT EXISTS `factura` (
`id_factura` int(11) NOT NULL,
  `id_venta` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id_factura`, `id_venta`) VALUES
(31, 111);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
`id_producto` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `precio_compra` double DEFAULT NULL,
  `precio_venta` double DEFAULT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `descripcion`, `tipo`, `marca`, `precio_compra`, `precio_venta`, `cantidad`) VALUES
(52, 'Lavadora 10 kilos, color negro, ', 'Lavadora', 'Mabe', 1524.2, 1785.3, 4),
(53, 'Frigobar Daewoo 4 Pies Negro', 'Frigobar', 'DAEWOO', 4649, 5987, 5),
(58, 'Horno de Microondas Empotrable Io Mabe', 'Horno', 'MABE', 3749, 4999, 6),
(59, 'Refrigerador Mabe 2 Puertas 11Pies Rma1130Ymfe0 Grafito', 'Refrigerador', 'MABE', 7499, 9999, 7),
(62, 'Aspiradora Manual Koblenz', 'Aspiradora', 'KOBLENZ', 599, 799, 8),
(63, 'Máquina de Coser Singer 32 Puntadas', 'Máquina de Coser', 'SINGER', 3699, 4999, 6),
(64, 'Sofá Temani Black Wicker Pier 1 Imports', 'Sofá', 'PIER 1 IMPORTS', 8520.3, 15499, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE IF NOT EXISTS `venta` (
`id_venta` int(11) NOT NULL,
  `num_venta` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `num_venta`, `id_cliente`, `id_producto`, `fecha`, `cantidad`) VALUES
(111, 1, 1, 52, '2018-06-10', 2),
(112, 1, 1, 53, '2018-06-10', 3),
(113, 1, 1, 58, '2018-06-10', 3),
(114, 2, 3, 59, '2018-06-12', 4),
(115, 2, 3, 62, '2018-06-12', 5),
(116, 2, 3, 63, '2018-06-12', 2),
(117, 3, 5, 63, '2018-06-15', 2),
(118, 3, 5, 59, '2018-06-15', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
 ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
 ADD PRIMARY KEY (`id_factura`), ADD KEY `id_venta` (`id_venta`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
 ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
 ADD PRIMARY KEY (`id_venta`), ADD KEY `id_cliente` (`id_cliente`), ADD KEY `id_producto` (`id_producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
MODIFY `id_factura` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=65;
--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=120;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
