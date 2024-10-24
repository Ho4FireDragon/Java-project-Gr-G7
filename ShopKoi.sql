-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 24, 2024 lúc 07:14 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `shopkoi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `services`
--

CREATE TABLE `services` (
  `id` bigint(20) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  `nameservice` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `productcode` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `services`
--

INSERT INTO `services` (`id`, `content`, `images`, `nameservice`, `price`, `productcode`, `status`, `summary`, `img`, `image`) VALUES
(2, NULL, NULL, 'a', 2, '1', 'bình thường', 'f', NULL, NULL),
(3, NULL, NULL, 'a', 2, '1', 'bình thường', 'ư', NULL, NULL),
(4, NULL, NULL, '1', 2, '1', 'bình thường', 'f', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsvwTBr3yEqWkOtfYHBVFHl_VJlT893zJFBg&s', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `service_entity`
--

CREATE TABLE `service_entity` (
  `id` bigint(20) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  `nameservice` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `productcode` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staffs`
--

CREATE TABLE `staffs` (
  `staffid` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `staffemail` varchar(255) DEFAULT NULL,
  `staffname` varchar(255) DEFAULT NULL,
  `staffphone` varchar(255) DEFAULT NULL,
  `staffschdule` varchar(255) DEFAULT NULL,
  `staffpassword` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `staffs`
--

INSERT INTO `staffs` (`staffid`, `role`, `staffemail`, `staffname`, `staffphone`, `staffschdule`, `staffpassword`) VALUES
(54, 'ma', 'thespeak2004@gmail.com', 'test 1', '000', '1', NULL),
(56, 'Role', 'thespeak2004@gmail.com', 'staff Name', 'Phone', '0', NULL),
(58, '1', 'thespeak2004@gmail.com', 'j', '5', '1', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `email`, `first_name`, `last_name`, `password`, `username`) VALUES
(7, 'admin@shopkoi.com', 'Hoa22321', 'Lee', '123456', 'Hoanggg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `service_entity`
--
ALTER TABLE `service_entity`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `staffs`
--
ALTER TABLE `staffs`
  ADD PRIMARY KEY (`staffid`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `services`
--
ALTER TABLE `services`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `service_entity`
--
ALTER TABLE `service_entity`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `staffs`
--
ALTER TABLE `staffs`
  MODIFY `staffid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
