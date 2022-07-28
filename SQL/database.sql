create database movies;


CREATE TABLE IF NOT EXISTS `movie` (
  `movie_id` int AUTO_INCREMENT  PRIMARY KEY,
  `color` varchar(50),
  `duration` int,
  `year` int,
  `title` varchar(150) NOT NULL,
  `language` varchar(50) NOT NULL,
  `country` varchar(50)
);

CREATE TABLE IF NOT EXISTS `genre` (
  `genre_id` int AUTO_INCREMENT  PRIMARY KEY,
  `genre` varchar(18) NOT NULL
);


CREATE TABLE IF NOT EXISTS `director` (
  `director_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS `movie_director` (
  `director_id` int NOT NULL,
  `movie_id` int NOT NULL,
  
  FOREIGN KEY (director_id) REFERENCES director(director_id),
  FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
  PRIMARY KEY (`director_id`,`movie_id`)
);

CREATE TABLE IF NOT EXISTS `movie_genre` (
  `genre_id` int NOT NULL,
  `movie_id` int NOT NULL,
  
  FOREIGN KEY (genre_id) REFERENCES genre(genre_id),
  FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
  PRIMARY KEY (`genre_id`,`movie_id`)
);
