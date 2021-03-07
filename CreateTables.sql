CREATE DATABASE `aedificiumdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `books` (
  `stickerID` varchar(20) NOT NULL,
  `title` varchar(45) NOT NULL,
  `yearPublished` year DEFAULT NULL,
  `checkedOut` tinyint DEFAULT NULL,
  `isbn` varchar(15) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`stickerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `borrowers` (
  `badgeId` varchar(45) NOT NULL,
  `ldap` varchar(45) DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`badgeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `checkouts` (
  `bookSticker` varchar(45) NOT NULL,
  `bookTitle` varchar(45) DEFAULT NULL,
  `borrowerLdap` varchar(45) DEFAULT NULL,
  `dueDate` date DEFAULT NULL,
  `overdue` tinyint DEFAULT NULL,
  PRIMARY KEY (`bookSticker`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `librarians` (
  `badgeId` varchar(45) NOT NULL,
  `ldap` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`badgeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
