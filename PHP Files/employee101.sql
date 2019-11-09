-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 25, 2019 at 06:08 AM
-- Server version: 10.0.10-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employee101`
--

-- --------------------------------------------------------

--
-- Table structure for table `bus_route_price`
--

DROP TABLE IF EXISTS `bus_route_price`;
CREATE TABLE IF NOT EXISTS `bus_route_price` (
  `routeid` int(20) NOT NULL AUTO_INCREMENT,
  `frombustop` varchar(50) NOT NULL,
  `tobustop` varchar(50) NOT NULL,
  `price` int(50) NOT NULL,
  PRIMARY KEY (`routeid`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus_route_price`
--

INSERT INTO `bus_route_price` (`routeid`, `frombustop`, `tobustop`, `price`) VALUES
(1, 'Marathahalli', 'Marathahalli', 100),
(4, 'Marathahalli', 'Silkboard', 20),
(5, 'Marathahalli', 'Tinfactory', 10),
(6, 'Marathahalli', 'Hebbal', 25),
(7, 'Marathahalli', 'Banashankari', 50),
(8, 'Marathahalli', 'IndiraNagar', 30),
(9, 'Marathahalli', 'KRPuram', 60),
(10, 'Silkboard', 'Silkboard', 130),
(11, 'Silkboard', 'Marathahalli', 20),
(12, 'Silkboard', 'Tinfactory', 60),
(13, 'Silkboard', 'Hebbal', 30),
(14, 'Silkboard', 'Banashankari', 22),
(15, 'Silkboard', 'IndiraNagar', 35),
(16, 'Silkboard', 'KRPuram', 15),
(17, 'Tinfactory', 'Tinfactory', 200),
(18, 'Tinfactory', 'Marathahalli', 10),
(19, 'Tinfactory', 'Silkboard', 60),
(20, 'Tinfactory', 'Hebbal', 25),
(21, 'Tinfactory', 'Banashankari', 20),
(22, 'Tinfactory', 'IndiraNagar', 10),
(23, 'Tinfactory', 'KRPuram', 20),
(24, 'Hebbal', 'Marathahalli', 25),
(25, 'Hebbal', 'Silkboard', 30),
(26, 'Hebbal', 'Hebbal', 230),
(27, 'Hebbal', 'Tinfactory', 60),
(28, 'Hebbal', 'Banashankari', 16),
(29, 'Hebbal', 'IndiraNagar', 50),
(30, 'Hebbal', 'KRPuram', 50),
(31, 'Banashankari', 'Marathahalli', 20),
(32, 'Banashankari', 'Banashankari', 300),
(33, 'Banashankari', 'Marathahalli', 20),
(34, 'Banashankari', 'Silkboard', 10),
(35, 'Banashankari', 'Tinfactory', 31),
(36, 'Banashankari', 'Hebbal', 12),
(37, 'Banashankari', 'IndiraNagar', 31),
(38, 'Banashankari', 'KRPuram', 30),
(47, 'IndiraNagar', 'IndiraNagar', 200),
(48, 'IndiraNagar', 'Marathahalli', 21),
(49, 'IndiraNagar', 'Silkboard', 33),
(50, 'IndiraNagar', 'Tinfactory', 50),
(51, 'IndiraNagar', 'Hebbal', 20),
(52, 'IndiraNagar', 'Banashankari', 20),
(53, 'IndiraNagar', 'KRPuram', 50),
(63, 'KRPuram', 'Marathahalli', 50),
(64, 'KRPuram', 'Silkboard', 20),
(65, 'KRPuram', 'Tinfactory', 50),
(66, 'KRPuram', 'Tinfactory', 40),
(67, 'KRPuram', 'Hebbal', 20),
(68, 'KRPuram', 'Banashankari', 60),
(69, 'KRPuram', 'IndiraNagar', 40),
(70, 'KRPuram', 'KRPuram', 30);

-- --------------------------------------------------------

--
-- Table structure for table `employee_data`
--

DROP TABLE IF EXISTS `employee_data`;
CREATE TABLE IF NOT EXISTS `employee_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `contact` text NOT NULL,
  `age` text NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_data`
--

INSERT INTO `employee_data` (`id`, `name`, `email`, `contact`, `age`, `username`, `password`) VALUES
(1, 'vignesh', 'narang', '0', '21', 'user', '123'),
(2, 'vignesh', 'email.com', '23232', '21', 'name', '12345'),
(3, 'vignesh', 'email.com', '23232', '21', 'name', '12345'),
(4, 'vignesh', 'email.com', '23232', '21', 'name', '12345'),
(5, 'vignesh', 'sadad', '233233', '21', 'sadsdasd', 'sadsd'),
(6, 'vignesh', 'sadadsad', '23323', '21', 'saddasdasd', 'vfdgfdg'),
(7, 'vignesh', 'iamvignesh9@adsad', '232322', '21', 'vig', 'pass'),
(8, 'hg', 'ghj', 'gjhg', 'hjg', 'jhg', 'hgj');

-- --------------------------------------------------------

--
-- Table structure for table `journey_details`
--

DROP TABLE IF EXISTS `journey_details`;
CREATE TABLE IF NOT EXISTS `journey_details` (
  `jid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `from_address` varchar(50) NOT NULL,
  `to_address` varchar(50) NOT NULL,
  `ticketdata` text NOT NULL,
  PRIMARY KEY (`jid`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `journey_details`
--

INSERT INTO `journey_details` (`jid`, `username`, `from_address`, `to_address`, `ticketdata`) VALUES
(1, '', '', '', ''),
(2, 'vig', '', '', ''),
(3, 'vig', '', '', ''),
(4, 'vig', 'Marathahalli', 'Marathahalli', ''),
(5, 'vig', 'Marathahalli', 'Marathahalli', ''),
(6, 'vig', 'Marathahalli', 'Marathahalli', ''),
(7, 'vig', 'Marathahalli', 'Tinfactory', ''),
(8, 'vig', 'Marathahalli', 'Silkboard', 'MarathahalliSilkboard25-10-2019-09:57:24'),
(9, 'vig', 'Marathahalli', 'Tinfactory', 'MarathahalliTinfactory25-10-2019-09:59:13'),
(10, 'vig', 'Marathahalli', 'Tinfactory', 'MarathahalliTinfactory25-10-2019-09:59:13'),
(11, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:04:45'),
(12, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:05:41'),
(13, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:06:51'),
(14, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:07:11'),
(15, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:07:39'),
(16, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:08:11'),
(17, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:08:43'),
(18, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:09:37'),
(19, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:10:16'),
(20, 'vig', 'Marathahalli', 'Tinfactory', 'MarathahalliTinfactory25-10-2019-10:15:08'),
(21, 'vig', 'Marathahalli', 'Tinfactory', 'MarathahalliTinfactory25-10-2019-10:15:08'),
(22, '', '', '', ''),
(23, 'vig', 'Marathahalli', 'Tinfactory', 'MarathahalliTinfactory25-10-2019-10:15:08'),
(24, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:42:49'),
(25, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:42:49'),
(26, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:47:16'),
(27, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:47:56'),
(28, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:48:52'),
(29, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:50:17'),
(30, 'vig', 'Tinfactory', 'Marathahalli', 'TinfactoryMarathahalli25-10-2019-10:50:17'),
(31, '', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:53:38'),
(32, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:53:52'),
(33, 'vig', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:54:35'),
(34, '', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:55:15'),
(35, '', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-10:57:26'),
(36, '', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-11:04:04'),
(37, '', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-11:04:58'),
(38, '', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-11:05:36'),
(39, '', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-11:06:29'),
(40, '', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-11:07:37'),
(41, '', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-11:08:56'),
(42, '', 'Silkboard', 'Marathahalli', 'SilkboardMarathahalli25-10-2019-11:12:11'),
(43, '', 'Silkboard', 'IndiraNagar', 'SilkboardIndiraNagar25-10-2019-11:12:11'),
(44, '', 'Tinfactory', 'Marathahalli', 'TinfactoryMarathahalli25-10-2019-11:14:37'),
(45, '', 'Tinfactory', 'IndiraNagar', 'TinfactoryIndiraNagar25-10-2019-11:22:31'),
(46, '', 'Marathahalli', 'Marathahalli', 'MarathahalliMarathahalli25-10-2019-11:24:15');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
CREATE TABLE IF NOT EXISTS `user_details` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `age` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`id`, `name`, `email`, `age`, `password`) VALUES
(1, 'vig', 'iamvignesh98@gmail.com', '21', 'error'),
(2, '', '', '', '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
