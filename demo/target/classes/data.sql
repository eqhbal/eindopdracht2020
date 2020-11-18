insert into users (username, password, enabled)
values

('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 1),    -- password: password
('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 1)    -- password: password
ON DUPLICATE KEY UPDATE username=username;


insert into authorities (username, authority)
values
('user', 'ROLE_USER'),
('admin', 'ROLE_USER'),
('admin', 'ROLE_ADMIN')
ON DUPLICATE KEY UPDATE username=username;

insert into kapper (beschikbaar, naam)
values
(1, 'Dave'),
(1, 'Henk'),
(1, 'Borris')
ON DUPLICATE KEY UPDATE id=id;

insert into klant (naam)
values
( 'Joost'),
('Henry'),
( 'Karen')
ON DUPLICATE KEY UPDATE id=id;

insert into reservation (kapper_id, klant_id, `date`)
values
(1,2, '2020-11-20'),
(2, 1, '2020-11-19'),
(3, 3, '2020-11-19')




