CREATE TABLE `Users`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `alias` VARCHAR(255) NOT NULL,
    `profilPictureUrl` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `biography` VARCHAR(255) NOT NULL
)ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

CREATE TABLE `Posts`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `created_at` DATETIME NOT NULL
)ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

CREATE TABLE `Medias`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `post_id` INT NOT NULL,
    `mediaUrl` VARCHAR(255) NOT NULL,
    `mediaType` ENUM('Video','Image') NOT NULL
)ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

ALTER TABLE `Posts` 
ADD CONSTRAINT `posts_user_id_foreign` 
FOREIGN KEY(`user_id`) REFERENCES `Users`(`id`) 
ON DELETE CASCADE;

ALTER TABLE `Medias` 
ADD CONSTRAINT `medias_post_id_foreign` 
FOREIGN KEY(`post_id`) REFERENCES `Posts`(`id`) 
ON DELETE CASCADE;