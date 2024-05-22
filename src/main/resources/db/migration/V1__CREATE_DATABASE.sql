CREATE TABLE traveler(
    id_traveler BIGSERIAL PRIMARY KEY,
    image_link VARCHAR(500),
    image BYTEA,
    contact BIGINT,
    user_id BIGINT
);

CREATE TABLE contact(
    id_contact BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    phone VARCHAR(13) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL
);

CREATE TABLE itinerary(
    id_itinerary BIGSERIAL PRIMARY KEY,
    resume VARCHAR(500),
    shared BOOLEAN NOT NULL,
    money_quantity NUMERIC(7,2),
    city BIGINT
);

CREATE TABLE country(
    id_country BIGSERIAL PRIMARY KEY,
    portuguese_name VARCHAR(100) NOT NULL,
    english_name VARCHAR(100) NOT NULL,
    image_link VARCHAR(500),
    image BYTEA
);

CREATE TABLE state(
    id_state BIGSERIAL PRIMARY KEY,
    uf_code BIGINT UNIQUE,
    name VARCHAR(100) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    country BIGINT
);

CREATE TABLE city(
    id_city BIGSERIAL PRIMARY KEY,
    ibge_code VARCHAR(7) NOT NULL,
    name VARCHAR(100) NOT NULL,
    state BIGINT
);

CREATE TABLE reviews(
    id_reviews BIGSERIAL PRIMARY KEY,
    title VARCHAR(500) NOT NULL,
    text TEXT NOT NULL,
    date_time TIMESTAMP NOT NULL,
    image_link VARCHAR(1000),
    image BYTEA
);

CREATE TABLE itinerary_reviews(
    id_itinerary_reviews BIGSERIAL PRIMARY KEY,
    reviews BIGINT,
    itinerary BIGINT
);

CREATE TABLE comments (
    id_comments BIGSERIAL PRIMARY KEY,
    text VARCHAR(250) NOT NULL,
    date_time TIMESTAMP NOT NULL,
    traveler BIGINT,
    reviews BIGINT
);

CREATE TABLE users(
    id_user BIGSERIAL PRIMARY KEY,
    user_name VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

ALTER TABLE itinerary ADD CONSTRAINT fk_city_itinerary FOREIGN KEY (city) REFERENCES city (id_city);
ALTER TABLE itinerary_reviews ADD CONSTRAINT fk_itinerary_reviews_reviews FOREIGN KEY (reviews) REFERENCES reviews (id_reviews);
ALTER TABLE itinerary_reviews ADD CONSTRAINT fk_itinerary_reviews_itinerary FOREIGN KEY (itinerary) REFERENCES itinerary (id_itinerary);
ALTER TABLE comments ADD CONSTRAINT fk_traveler_comments FOREIGN KEY (traveler) REFERENCES traveler (id_traveler);
ALTER TABLE comments ADD CONSTRAINT fk_reviews_comments FOREIGN KEY (reviews) REFERENCES reviews (id_reviews);
ALTER TABLE state ADD CONSTRAINT fk_country_state FOREIGN KEY (country) REFERENCES country (id_country);
ALTER TABLE city ADD CONSTRAINT fk_state_city FOREIGN KEY (state) REFERENCES state (uf_code);
ALTER TABLE traveler ADD CONSTRAINT fk_contact_traveler FOREIGN KEY (contact) REFERENCES contact (id_contact);
ALTER TABLE traveler ADD CONSTRAINT fk_traveler_users FOREIGN KEY (user_id) REFERENCES users (id_user);
