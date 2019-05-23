--
-- Скрипт сгенерирован Devart dbForge Studio 2019 for MySQL, Версия 8.1.45.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 23.05.2019 19:43:29
-- Версия сервера: 5.1.47-community
-- Версия клиента: 4.1
--

-- 
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установить режим SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Установка кодировки, с использованием которой клиент будет посылать запросы на сервер
--
SET NAMES 'utf8';

--
-- Установка базы данных по умолчанию
--
USE shop;

--
-- Удалить функцию `fun`
--
DROP FUNCTION IF EXISTS fun;

--
-- Удалить таблицу `role`
--
DROP TABLE IF EXISTS role;

--
-- Удалить таблицу `role_permission`
--
DROP TABLE IF EXISTS role_permission;

--
-- Удалить таблицу `permission`
--
DROP TABLE IF EXISTS permission;

--
-- Удалить таблицу `basket`
--
DROP TABLE IF EXISTS basket;

--
-- Удалить таблицу `user_role`
--
DROP TABLE IF EXISTS user_role;

--
-- Удалить таблицу `user`
--
DROP TABLE IF EXISTS user;

--
-- Удалить таблицу `basket_product`
--
DROP TABLE IF EXISTS basket_product;

--
-- Удалить таблицу `delivery_type`
--
DROP TABLE IF EXISTS delivery_type;

--
-- Удалить таблицу `order`
--
DROP TABLE IF EXISTS `order`;

--
-- Удалить таблицу `order_product`
--
DROP TABLE IF EXISTS order_product;

--
-- Удалить таблицу `product`
--
DROP TABLE IF EXISTS product;

--
-- Установка базы данных по умолчанию
--
USE shop;

--
-- Создать таблицу `product`
--
CREATE TABLE product (
  id int(11) NOT NULL AUTO_INCREMENT,
  description varchar(50) DEFAULT NULL,
  existence varchar(255) DEFAULT NULL,
  name varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать таблицу `order_product`
--
CREATE TABLE order_product (
  order_id int(11) NOT NULL,
  product_id int(11) NOT NULL,
  PRIMARY KEY (order_id, product_id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE order_product
ADD CONSTRAINT FK_order_product_product_id FOREIGN KEY (product_id)
REFERENCES product (id) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Создать таблицу `order`
--
CREATE TABLE `order` (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  date datetime DEFAULT NULL,
  PRIMARY KEY (id, user_id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать индекс `FK_order_user_id` для объекта типа таблица `order`
--
ALTER TABLE `order`
ADD INDEX FK_order_user_id (user_id);

--
-- Создать внешний ключ
--
ALTER TABLE `order`
ADD CONSTRAINT FK_order_order_product_order_id FOREIGN KEY (id)
REFERENCES order_product (order_id) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Создать таблицу `delivery_type`
--
CREATE TABLE delivery_type (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) DEFAULT NULL,
  order_id int(11) NOT NULL,
  PRIMARY KEY (id, order_id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE delivery_type
ADD CONSTRAINT FK_delivery_type_order_id FOREIGN KEY (order_id)
REFERENCES `order` (id) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Создать таблицу `basket_product`
--
CREATE TABLE basket_product (
  basket_id int(11) NOT NULL,
  product_id int(11) NOT NULL,
  PRIMARY KEY (basket_id, product_id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать индекс `UK_basket_product_basket_id` для объекта типа таблица `basket_product`
--
ALTER TABLE basket_product
ADD UNIQUE INDEX UK_basket_product_basket_id (basket_id);

--
-- Создать внешний ключ
--
ALTER TABLE basket_product
ADD CONSTRAINT FK_basket_product_product_id FOREIGN KEY (product_id)
REFERENCES product (id) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Создать таблицу `user`
--
CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  login varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  nickname varchar(255) DEFAULT NULL,
  basket_id int(11) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 5,
AVG_ROW_LENGTH = 4096,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать индекс `FK_user_basket_id` для объекта типа таблица `user`
--
ALTER TABLE user
ADD INDEX FK_user_basket_id (basket_id);

--
-- Создать таблицу `user_role`
--
CREATE TABLE user_role (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  PRIMARY KEY (role_id, user_id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE user_role
ADD CONSTRAINT FK_user_role_user_id FOREIGN KEY (user_id)
REFERENCES user (id) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Создать таблицу `basket`
--
CREATE TABLE basket (
  id int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE basket
ADD CONSTRAINT FK_basket_user_basket_id FOREIGN KEY (id)
REFERENCES user (basket_id) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Создать внешний ключ
--
ALTER TABLE basket
ADD CONSTRAINT FK_basket_basket_product_basket_id FOREIGN KEY (id)
REFERENCES basket_product (basket_id) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Создать таблицу `permission`
--
CREATE TABLE permission (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать таблицу `role_permission`
--
CREATE TABLE role_permission (
  role_id int(11) NOT NULL,
  permission_id int(11) NOT NULL,
  PRIMARY KEY (role_id, permission_id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE role_permission
ADD CONSTRAINT FK_role_permission_permission_id FOREIGN KEY (permission_id)
REFERENCES permission (id) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Создать таблицу `role`
--
CREATE TABLE role (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE role
ADD CONSTRAINT FK_role_user_role_role_id FOREIGN KEY (id)
REFERENCES user_role (role_id) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Создать внешний ключ
--
ALTER TABLE role
ADD CONSTRAINT FK_role_role_permission_role_id FOREIGN KEY (id)
REFERENCES role_permission (role_id) ON DELETE NO ACTION ON UPDATE NO ACTION;

DELIMITER $$

--
-- Создать функцию `fun`
--
CREATE DEFINER = 'root'@'localhost'
FUNCTION fun (my_arg int, my_arg2 int)
RETURNS int(101)
BEGIN
  RETURN (my_arg + my_arg2);

END
$$

DELIMITER ;

-- 
-- Вывод данных для таблицы product
--
-- Таблица shop.product не содержит данных

-- 
-- Вывод данных для таблицы user
--
INSERT INTO user VALUES
(1, 'aaa', 'bbb', 'bbb', 1),
(2, 'ttt', 'xxx', 'ccc', 2),
(3, 'ooo', 'bbb', 'nnn', 3),
(4, 'vvv', 'bbb', 'nnn', 4);

-- 
-- Вывод данных для таблицы permission
--
-- Таблица shop.permission не содержит данных

-- 
-- Вывод данных для таблицы order_product
--
-- Таблица shop.order_product не содержит данных

-- 
-- Вывод данных для таблицы user_role
--
-- Таблица shop.user_role не содержит данных

-- 
-- Вывод данных для таблицы role_permission
--
-- Таблица shop.role_permission не содержит данных

-- 
-- Вывод данных для таблицы `order`
--
-- Таблица shop.`order` не содержит данных

-- 
-- Вывод данных для таблицы basket_product
--
-- Таблица shop.basket_product не содержит данных

-- 
-- Вывод данных для таблицы role
--
-- Таблица shop.role не содержит данных

-- 
-- Вывод данных для таблицы delivery_type
--
-- Таблица shop.delivery_type не содержит данных

-- 
-- Вывод данных для таблицы basket
--
-- Таблица shop.basket не содержит данных

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;