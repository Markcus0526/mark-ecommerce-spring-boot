
CREATE TABLE verification_tokens (
    verification_token_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    credential_id INT,
    verif_token VARCHAR(255),
    expire_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NULL
);
