CREATE USER 'webshopuser'@'%' IDENTIFIED BY '240b2c6d58ff2ce2f508b49f';

CREATE DATABASE IF NOT EXISTS webshop;

CREATE DATABASE IF NOT EXISTS productdb;

CREATE DATABASE IF NOT EXISTS categorydb;

GRANT ALL PRIVILEGES ON *.* TO 'webshopuser'@'%';
FLUSH PRIVILEGES;