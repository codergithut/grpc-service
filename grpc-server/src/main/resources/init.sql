CREATE TABLE `auth_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(45) NOT NULL,
  `secret_key` varchar(45) NOT NULL,
  `updated_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `config_system` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  `value` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


CREATE TABLE `ide` (
  `tbl_priv_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `tbl_name` varchar(45) NOT NULL,
  `priv_value` varchar(45) NOT NULL,
  `valid_start_date` datetime NOT NULL,
  `valid_end_date` datetime NOT NULL,
  PRIMARY KEY (`tbl_priv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role_data` (
  `rd_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `info_id` int(11) NOT NULL,
  `is_admin` int(11) NOT NULL,
  `priv_value` varchar(45) NOT NULL,
  `target_name` varchar(45) NOT NULL,
  `priv_type` varchar(45) NOT NULL,
  PRIMARY KEY (`rd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `text` blob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;