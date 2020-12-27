CREATE TABLE `restapi`.`developers` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`account_id` BIGINT NOT NULL,
PRIMARY KEY (`id`),
INDEX `acc_key_idx` (`account_id` ASC) VISIBLE,
CONSTRAINT `acc_key`
FOREIGN KEY (`account_id`)
REFERENCES `restapi`.`accounts` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;