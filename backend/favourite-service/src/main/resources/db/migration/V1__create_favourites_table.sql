
CREATE TABLE favourites (
	user_id INT NOT NULL,
	product_id INT NOT NULL,
	like_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated_at TIMESTAMP,
	PRIMARY KEY (user_id, product_id, like_date)
);

