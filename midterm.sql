-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2024 at 10:19 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `midterm`
--

-- --------------------------------------------------------

--
-- Table structure for table `oder`
--

CREATE TABLE `oder` (
  `code` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `oder`
--

INSERT INTO `oder` (`code`, `user_id`) VALUES
(18, 1),
(19, 1),
(20, 1),
(21, 1),
(22, 1),
(23, 1),
(24, 1),
(25, 1),
(26, 2),
(27, 5),
(28, 5);

-- --------------------------------------------------------

--
-- Table structure for table `oder_product`
--

CREATE TABLE `oder_product` (
  `code` int(11) NOT NULL,
  `oder_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `oder_product`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `code` int(11) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_product` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `order_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`code`, `brand`, `description`, `image_product`, `name`, `price`, `order_id`) VALUES
(18, 'Coca-Cola', 'Nước ngọt vị Cola truyền thống', 'cola-classic.jpg', 'Coca-Cola Classic', 0.99, NULL),
(19, 'Pepsi', 'Nước ngọt vị Cola', 'pepsi-blue.jpg', 'Pepsi Blue', 0.99, NULL),
(20, 'Dr Pepper', 'Nước ngọt vị đặc trưng', 'drpepper.jpg', 'Dr Pepper Original', 0.99, NULL),
(21, 'Fanta', 'Nước ngọt vị cam ngon ngọt', 'fanta-orange.jpg', 'Fanta Orange', 0.99, NULL),
(22, 'Sprite', 'Nước ngọt vị chanh không cồn', 'sprite.jpg', 'Sprite Lemon-Lime', 0.99, NULL),
(23, 'Mountain Dew', 'Nước ngọt vị chanh mạnh mẽ', 'mountain-dew.jpg', 'Mountain Dew', 0.99, NULL),
(24, '7-Up', 'Nước ngọt vị chanh-lime mát lạnh', '7up.jpg', '7-Up Refresh', 0.99, NULL),
(25, 'Mirinda', 'Nước ngọt vị cam tươi mới mẻ', 'mirinda-orange.jpg', 'Mirinda Orange', 0.99, NULL),
(26, 'Sierra Mist', 'Nước ngọt vị chanh-lime tự nhiên', 'sierra-mist.jpg', 'Sierra Mist Natural', 0.99, NULL),
(27, 'Pepsi', 'Nước ngọt vị Cherry', 'pepsi-cherry.jpg', 'Pepsi Cherry', 0.99, NULL),
(28, '7-Up', 'Nước ngọt vị chanh-lime mát lạnh', '7up.jpg', '7-Up Refresh', 0.99, NULL);


-- --------------------------------------------------------

--
-- Table structure for table `product_seq`
--

CREATE TABLE `product_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_seq`
--

INSERT INTO `product_seq` (`next_val`) VALUES
(351);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `code` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`code`, `email`, `password`, `username`) VALUES
(1, 'ttan1@gmail.com', '123', 'tan1'),
(2, 'ttan2@gmail.com', '123', 'tan2'),
(3, 'ttan3@gmail.com', '123', 'tan3'),
(4, 'ttan4@gmail.com', '123', 'tan4'),
(5, 'ttan5@gmail.com', '123', 'tan5');
-- --------------------------------------------------------

--
-- Table structure for table `user_seq`
--

CREATE TABLE `user_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_seq`
--

INSERT INTO `user_seq` (`next_val`) VALUES
(1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `oder`
--
ALTER TABLE `oder`
  ADD PRIMARY KEY (`code`),
  ADD KEY `FKry3k3lnvxl2omk0kbabigv36e` (`user_id`);

--
-- Indexes for table `oder_product`
--
ALTER TABLE `oder_product`
  ADD PRIMARY KEY (`code`),
  ADD KEY `FKfymxoyj4beeteeedg8nx6aono` (`oder_id`),
  ADD KEY `FKl9s9e2vure5kados2w4jn99wf` (`product_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`code`),
  ADD KEY `FKnavppkq766vec13jja2o37lp5` (`order_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `oder`
--
ALTER TABLE `oder`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `oder_product`
--
ALTER TABLE `oder_product`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=258;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `oder`
--
ALTER TABLE `oder`
  ADD CONSTRAINT `FKry3k3lnvxl2omk0kbabigv36e` FOREIGN KEY (`user_id`) REFERENCES `user` (`code`);

--
-- Constraints for table `oder_product`
--
ALTER TABLE `oder_product`
  ADD CONSTRAINT `FKfymxoyj4beeteeedg8nx6aono` FOREIGN KEY (`oder_id`) REFERENCES `oder` (`code`),
  ADD CONSTRAINT `FKl9s9e2vure5kados2w4jn99wf` FOREIGN KEY (`product_id`) REFERENCES `product` (`code`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FKnavppkq766vec13jja2o37lp5` FOREIGN KEY (`order_id`) REFERENCES `oder` (`code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
