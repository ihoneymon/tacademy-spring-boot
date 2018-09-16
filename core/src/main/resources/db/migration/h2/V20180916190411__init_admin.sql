create table ADMIN (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_c0r9atamxvbhjjvy5j8da1kam` (`email`)
) DEFAULT CHARSET=utf8;

insert into admin(id, email, password) values(1, 'root', '{bcrypt}$2a$10$m.53XFySffL1obcELekQCui0BpsbE423jndwI9xADtlfWIdb.7bHe');