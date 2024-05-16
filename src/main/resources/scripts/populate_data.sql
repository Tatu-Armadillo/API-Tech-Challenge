-- Insert data into contact table
INSERT INTO contact (name, phone, email)
VALUES
  ('John Doe', '1234567890', 'john@example.com'),
  ('Jane Smith', '9876543210', 'jane@example.com'),
  ('Michael Johnson', '5555555555', 'michael@example.com');

-- Insert data into country table
INSERT INTO country (portuguese_name, english_name, image_link, image)
VALUES
  ('Brasil', 'Brazil', 'https://example.com/brasil.jpg', NULL),
  ('Espanha', 'Spain', 'https://example.com/espanha.jpg', NULL),
  ('França', 'France', 'https://example.com/franca.jpg', NULL);

-- Insert data into state table
INSERT INTO state (uf_code, name, uf, country)
VALUES
  (1, 'São Paulo', 'SP', 14),
  (2, 'Rio de Janeiro', 'RJ', 14),
  (3, 'Madrid', 'MD', 14),
  (4, 'Barcelona', 'BC', 15),
  (5, 'Paris', 'PA', 16),
  (6, 'Marseille', 'MR', 16);

-- Insert data into city table
INSERT INTO city (ibge_code, name, state)
VALUES
  ('1234567', 'São Paulo', 1),
  ('7654321', 'Rio de Janeiro', 2),
  ('1111111', 'Madrid', 3),
  ('2222222', 'Barcelona', 4),
  ('3333333', 'Paris', 5),
  ('4444444', 'Marseille', 6);

 -- Insert data into users table
INSERT INTO users (user_name, password)
VALUES
  ('john_doe', 'password123'),
  ('jane_smith', 'password456'),
  ('michael_johnson', 'password789');

-- Insert data into traveler table
INSERT INTO traveler (image_link, image, contact, user_id)
VALUES
  ('https://example.com/john.jpg', NULL, 14, 5),
  ('https://example.com/jane.jpg', NULL, 15, 6),
  ('https://example.com/michael.jpg', NULL, 16, 7);

-- Insert data into reviews table
INSERT INTO reviews (title, text, date_time, image_link, image)
VALUES
  ('Great experience!', 'I had a wonderful time during my trip.', CURRENT_TIMESTAMP, 'https://example.com/review1.jpg', NULL),
  ('Amazing place', 'The city is beautiful and full of life.', CURRENT_TIMESTAMP, 'https://example.com/review2.jpg', NULL),
  ('Highly recommended', 'I highly recommend visiting this destination.', CURRENT_TIMESTAMP, 'https://example.com/review3.jpg', NULL);

-- Insert data into itinerary table
INSERT INTO itinerary (resume, money_quantity, city)
VALUES
  ('Exploring São Paulo', 500.00, 3),
  ('Beach holiday in Rio de Janeiro', 700.00, 4),
  ('Touring Madrid', 600.00, 5);

-- Insert data into itinerary_reviews table
INSERT INTO itinerary_reviews (reviews, itinerary)
VALUES
  (1, 4),
  (2, 5),
  (3, 6);

-- Insert data into comments table
INSERT INTO comments (text, date_time, traveler, reviews)
VALUES
  ('Great place!', CURRENT_TIMESTAMP, 7, 1),
  ('I loved it!', CURRENT_TIMESTAMP, 8, 2),
  ('Will definitely come back', CURRENT_TIMESTAMP, 9, 3);


