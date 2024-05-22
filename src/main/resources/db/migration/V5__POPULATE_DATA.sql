 -- Insert data into users table
INSERT INTO challenge_trips."users" (user_name, password)
VALUES
  ('john_doe', 'password123'),
  ('jane_smith', 'password456'),
  ('michael_johnson', 'password789');

-- Insert data into traveler table
INSERT INTO challenge_trips.traveler (image_link, image, name, phone, email, users)
VALUES
  ('https://example.com/john.jpg', NULL, 'John Doe', '1234567890', 'john@example.com', 1),
  ('https://example.com/jane.jpg', NULL, 'Jane Smith', '9876543210', 'jane@example.com', 2),
  ('https://example.com/michael.jpg', NULL, 'Michael Johnson', '5555555555', 'michael@example.com', 3);

-- Insert data into reviews table
INSERT INTO challenge_trips.reviews (title, text, date_time, image_link, image)
VALUES
  ('Great experience!', 'I had a wonderful time during my trip.', CURRENT_TIMESTAMP, 'https://example.com/review1.jpg', NULL),
  ('Amazing place', 'The city is beautiful and full of life.', CURRENT_TIMESTAMP, 'https://example.com/review2.jpg', NULL),
  ('Highly recommended', 'I highly recommend visiting this destination.', CURRENT_TIMESTAMP, 'https://example.com/review3.jpg', NULL);

-- Insert data into itinerary table
INSERT INTO challenge_trips.itinerary (resume, shared, money_quantity, departure_date, return_date, city, traveler)
VALUES
  ('Exploring São Paulo', 'true', 500.00, CURRENT_DATE, CURRENT_DATE, 1, 1),
  ('Beach holiday in Rio de Janeiro', 'true', 700.00, CURRENT_DATE, CURRENT_DATE, 2, 2),
  ('Touring Madrid', 'true', 600.00, CURRENT_DATE, CURRENT_DATE, 3, 3);

-- Insert data into itinerary_reviews table
INSERT INTO challenge_trips.itinerary_reviews (reviews, itinerary)
VALUES
  (1, 1),
  (2, 2),
  (3, 3);

-- Insert data into comments table
INSERT INTO challenge_trips."comments" (text, date_time, traveler, reviews)
VALUES
  ('Great place!', CURRENT_TIMESTAMP, 1, 1),
  ('I loved it!', CURRENT_TIMESTAMP, 2, 2),
  ('Will definitely come back', CURRENT_TIMESTAMP, 3, 3);


