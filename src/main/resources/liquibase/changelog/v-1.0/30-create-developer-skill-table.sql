CREATE TABLE `restapi`.`developers_skills` (
`developer_id` BIGINT NOT NULL,
`skill_id` BIGINT NOT NULL,
PRIMARY KEY (`developer_id`, `skill_id`),
INDEX `skill_id_fk_idx` (`skill_id` ASC) VISIBLE,
CONSTRAINT `developer_id_fk`
FOREIGN KEY (`developer_id`)
REFERENCES `restapi`.`developers` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE,
CONSTRAINT `skill_id_fk`
FOREIGN KEY (`skill_id`)
REFERENCES `restapi`.`skills` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

