CREATE TABLE IF NOT EXISTS `task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `due_date` datetime DEFAULT NULL,
  `duration` varchar(50) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `priority` varchar(50) DEFAULT NULL,
  `is_finish` tinyint DEFAULT '0' NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;