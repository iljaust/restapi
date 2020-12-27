CREATE TABLE `restapi`.`developers_skills`(
`Developer_id` BIGINT NOT NULL,
`skillSet_id` BIGINT NOT NULL,
`table_id` INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (`table_id`),
INDEX `developer_id_idx` (`Developer_id` ASC) VISIBLE,
INDEX `skill_id_idx` (`skillSet_id` ASC) VISIBLE,
CONSTRAINT `developer_id`
FOREIGN KEY (`Developer_id`)
REFERENCES `restapi`.`developers` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE,
CONSTRAINT `skill_id`
FOREIGN KEY (`skillSet_id`)
REFERENCES `restapi`.`skills` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
