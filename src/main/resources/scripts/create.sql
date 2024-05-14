DROP SCHEMA IF EXISTS challenge_trips CASCADE;
CREATE SCHEMA challenge_trips;
SET search_path TO challenge_trips;

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

CREATE TABLE trips(
    id_trips BIGSERIAL PRIMARY KEY,
    city BIGINT
);

CREATE TABLE itinerary(
    id_itinerary BIGSERIAL PRIMARY KEY,
    key_itinerary VARCHAR(100),
    valor VARCHAR(500),
    image_link VARCHAR(500),
    image BYTEA,
    trip BIGINT
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

CREATE TABLE trip_reviews(
    id_trip_reviews BIGSERIAL PRIMARY KEY,
    reviews BIGINT,
    trip BIGINT
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

ALTER TABLE trips ADD CONSTRAINT fk_city_trips FOREIGN KEY (city) REFERENCES city (id_city);
ALTER TABLE itinerary ADD CONSTRAINT fk_trip_itinerary FOREIGN KEY (trip) REFERENCES trips (id_trips);
ALTER TABLE trip_reviews ADD CONSTRAINT fk_trip_reviews_reviews FOREIGN KEY (reviews) REFERENCES reviews (id_reviews);
ALTER TABLE trip_reviews ADD CONSTRAINT fk_trip_reviews_trips FOREIGN KEY (trip) REFERENCES trips (id_trips);
ALTER TABLE comments ADD CONSTRAINT fk_traveler_comments FOREIGN KEY (traveler) REFERENCES traveler (id_traveler);
ALTER TABLE comments ADD CONSTRAINT fk_reviews_comments FOREIGN KEY (reviews) REFERENCES reviews (id_reviews);
ALTER TABLE state ADD CONSTRAINT fk_country_state FOREIGN KEY (country) REFERENCES country (id_country);
ALTER TABLE city ADD CONSTRAINT fk_state_city FOREIGN KEY (state) REFERENCES state (uf_code);
ALTER TABLE traveler ADD CONSTRAINT fk_contact_traveler FOREIGN KEY (contact) REFERENCES contact (id_contact);
ALTER TABLE traveler ADD CONSTRAINT fk_traveler_users FOREIGN KEY (user_id) REFERENCES users (id_user);
