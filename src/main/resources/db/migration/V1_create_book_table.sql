CREATE TABLE `book` (
  `id` bigint NOT NULL,
  `cover_image_url` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;