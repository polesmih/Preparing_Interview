DROP TABLE students IF EXISTS;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    mark int
);
