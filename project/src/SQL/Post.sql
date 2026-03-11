-- Active: 1767840762825@@127.0.0.1@3306@aloha
CREATE DATABASE IF NOT EXISTS post;

USE post;

DROP TABLE IF EXISTS post;

CREATE TABLE `post` (
    `no` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id` VARCHAR(50) DEFAULT NULL UNIQUE,
    `title` VARCHAR(255) NOT NULL,
    `writer` VARCHAR(100) NOT NULL,
    `content` text,
    `created_at` TIMESTAMP NULL DEFAULT current_timestamp,
    `updated_at` TIMESTAMP NULL DEFAULT current_timestamp
)