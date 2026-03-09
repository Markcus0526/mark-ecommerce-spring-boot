
CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    profile_picture_url VARCHAR(255) DEFAULT 'https://bootdey.com/img/Content/avatar/avatar1.png',
    email VARCHAR(255) DEFAULT 'test1@gmail.com',
    contact_number VARCHAR(255) DEFAULT '+1234567890',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NULL
);




