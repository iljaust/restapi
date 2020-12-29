CREATE TABLE heroku_3200fdebdafe424.developers_skills (
`developer_id` BIGINT NOT NULL,
`skill_id` BIGINT NOT NULL,
PRIMARY KEY (`developer_id`, `skill_id`),
INDEX `skill_id_fk_idx` (`skill_id` ASC),
CONSTRAINT `developer_id_fk`
FOREIGN KEY (`developer_id`)
REFERENCES `heroku_3200fdebdafe424`.`developers` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE,
CONSTRAINT `skill_id_fk`
FOREIGN KEY (`skill_id`)
REFERENCES `heroku_3200fdebdafe424`.`skills` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

