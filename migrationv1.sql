
CREATE TABLE dvd (
                     id UUID PRIMARY KEY,
                     title VARCHAR(255) NOT NULL,
                     genre VARCHAR(255) NOT NULL,
                     quantity INT NOT NULL
);


INSERT INTO dvd (id, title, genre, quantity)
VALUES
    (UUID(), 'Movie 1', 'Action', 5),
    (UUID(), 'Movie 2', 'Comedy', 3),
    (UUID(), 'Movie 3', 'Drama', 2),
    (UUID(), 'Movie 4', 'Thriller', 4),
    (UUID(), 'Movie 5', 'Sci-Fi', 1),
    (UUID(), 'Movie 6', 'Romance', 2),
    (UUID(), 'Movie 7', 'Horror', 3),
    (UUID(), 'Movie 8', 'Adventure', 2),
    (UUID(), 'Movie 9', 'Fantasy', 1),
    (UUID(), 'Movie 10', 'Animation', 4);
