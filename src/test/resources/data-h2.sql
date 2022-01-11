INSERT INTO employees (id, degree, first_name, last_name, salary)
VALUES
    (1, 2, 'Іванна', 'Іванова', 23400),
    (2, 2, 'Петро', 'Петров', 22000),
    (3, 2, 'Семен', 'Семенов', 23500),
    (4, 2, 'Павло', 'Павлов', 20000),
    (5, 1, 'Гаврило', 'Гаврилов', 14750),
    (6, 1, 'Олександр', 'Олександров', 15250),
    (7, 1, 'Костянтин', 'Костянтинов', 16000),
    (8, 1, 'Валентина', 'Валентинова', 17300),
    (9, 1, 'Геогрій', 'Георгієв', 14000),
    (10, 1, 'Антоніна', 'Антонінова', 15050),
    (11, 0, 'Інокентій', 'Інокентієв', 10450),
    (12, 0, 'Антон', 'Антонов', 9650),
    (13, 0, 'Кирило', 'Кирилов', 7850),
    (14, 0, 'Ігнат', 'Ігнатов', 8325),
    (15, 0, 'Аліса', 'Алісова', 9200),
    (16, 0, 'Ольга', 'Ольгова', 7000);
INSERT INTO departments (id, department_name, head_id)
VALUES
    (1, 'Механіко-математичний факультет', 1),
    (2, 'Факультет кібернетики', 2),
    (3, 'Фізичний факультет', 3),
    (4, 'Факультет інформаційних технологій', 4);
INSERT INTO departments_employees (departments_id, employees_id)
VALUES
    (1, 1), (2, 2), (3, 3), (4, 4), (1, 5), (1, 6), (1, 7), (2,8),
    (3, 9), (3, 10), (1, 11), (2, 12), (3, 13), (3, 14), (4, 15),
    (4, 16),
    (1, 3), (1, 10), (1, 12),
    (2, 5), (2, 6),
    (3, 1), (3, 15),
    (4, 2);