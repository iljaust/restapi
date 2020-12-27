CREATE TABLE IF NOT EXISTS `restapi`.`accounts` (
                                      `id` BIGINT NOT NULL AUTO_INCREMENT,
                                      `data` VARCHAR(245) NOT NULL,
                                      `status` INT NOT NULL,
                                      PRIMARY KEY (`id`))
    ENGINE = InnoDB;