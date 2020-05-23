use `form`;

CREATE TABLE `customer`
(
    `id`       INT auto_increment NOT NULL,
    `email`    varchar(128)       NOT NULL,
    `password` varchar(128)       NOT NULL,
    `name`     varchar(128)       NOT NULL,
    `login`    varchar(128)       NOT NULL,
    `enabled`  boolean            NOT NULL default true,
    `role`     varchar(16)        NOT NULL default 'USER',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `email_unique` (`email` ASC)
);

create table `form`
(
    `id`       INT auto_increment NOT NULL PRIMARY KEY,
    `name` varchar(128) NOT NULL,
    `date` datetime NOT NULL,
    `customer_id` INT NOT NULL,
    `description` varchar(1000) NOT NULL
);
create table `comment`
(
    `id`       INT auto_increment NOT NULL PRIMARY KEY,
    `customer_id` INT NOT NULL,
    `date` datetime NOT NULL,
    `form_id` INT NOT NULL,
    `comment` varchar(1000) NOT NULL
);
create table `reset`
(
    `id`          INT auto_increment NOT NULL PRIMARY KEY,
    `token`       varchar(128)       NOT NULL,
    `customer_id` INT                NOT NULL
);

