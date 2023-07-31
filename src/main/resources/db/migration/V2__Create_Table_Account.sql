CREATE TABLE `account` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account_number` varchar(9) NOT NULL,
  `balance` decimal(38,2) NOT NULL,
  `bank_number` varchar(3) NOT NULL,
  `branch_number` varchar(4) NOT NULL,
  `opening_date` datetime(6) NOT NULL,
  `status` varchar(12) NOT NULL,
  `type_account` varchar(12) NOT NULL,
  `client_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
);