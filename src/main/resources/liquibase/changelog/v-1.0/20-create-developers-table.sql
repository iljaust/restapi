CREATE TABLE `heroku_3200fdebdafe424`.`developers` (
                                        `id` BIGINT NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(45) NOT NULL,
                                        `account_id` BIGINT NOT NULL,
                                        PRIMARY KEY (`id`),
                                        INDEX `acc_key_idx` (`account_id` ASC),
                                        CONSTRAINT `acc_key`
                                            FOREIGN KEY (`account_id`)
                                                REFERENCES `heroku_3200fdebdafe424`.`accounts` (`id`)
                                                ON DELETE CASCADE
                                                ON UPDATE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;