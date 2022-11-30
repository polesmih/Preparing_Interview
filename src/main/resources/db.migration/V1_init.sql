DROP TABLE students IF EXISTS;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    age int
);

INSERT INTO students (name, age) VALUES
('Curt', 19),
('Tor', 20),
('Jacob', 20),
('Susan', 18),
('Leib', 19);
