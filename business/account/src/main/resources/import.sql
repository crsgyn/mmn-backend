-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

-- ADMIN ACCOUNT
insert into account(
    id, email, phone, invite_token, reset_token, name, last_name, role, account_status, creation_date, password, payment_active
    ) values (
    'bbef6274-3a0a-4c7c-9747-324aefa267fc',
    'admin@travined.com',
    '0',
    'YzNiYjNiZTYtOTFmOS00YmI0LThlYjctNGU3M2YyYzBjMDZi',
    'OGMxZmRmMzktNTg3Ni00NGM1LTk5OGMtMTBjMWFjZmU5Njk2',
    'Travined',
    'Admin',
    'ADMIN',
    'Authenticated',
    '2019-12-16',
    '$2a$10$XWgghRZSzIkBzvvNYikoLupuoqRjz.TQEogCy5huxfdgvZ.os/3ui',
     true
    );

insert into account(
    id, email, phone, password, name, last_name,
    street, city, state, zip, country,
    invite_token, reset_token, role, account_status, creation_date, payment_active
    ) values (
    '997f3881-3abe-4736-8b92-6f38651c239c',
    'michael@travined.com',
    '8135031224',
    '$2a$10$9gBjIojZYZILc.i/7Pzg6uqoKZKShtV1iXDVuqasOm8CzlV8YsZIi',
    'Michell',
    'Moraes',
    '2742 Sand Arbor Cir',
    'Orlando',
    'FL',
    '32824',
    'United States of America',
    'OTEyMzJhZmEtOGNjMS00MjAzLWJmODgtMjNhNDRkNmY3N2U4',
    'NjVmZWYwNjYtYTVjOC00NjA5LWI4NzItZjEwMzY0MjgwYTZh',
    'ADMIN',
    'Authenticated',
    '2020-01-04',
     true
    );

insert into account(
    id, email, phone, password, name, last_name,
    street, city, state, zip, country,
    invite_token, reset_token, role, account_status, creation_date, payment_active
    ) values (
    '800a3609-5adc-4d4a-88b1-d09ce1984f21',
    'adonis@travined.com',
    '5619295429',
    '$2a$10$8goIgywtdlwC5ZxTA8/hcu/VwJOxgRcr3L6ZGkzf8PLSSXB/aZfZ2',
    'Adonis',
    'Balbuena',
    '7625 Heritage Crossing Way Apt 302',
    'Reunion',
    'FL',
    '34747',
    'United States of America',
    'NGM5MjEyY2QtNDY4Yi00NmIzLTgyMDEtZjM2NzNlMDc4NTRj',
    'ZmMyNmU5ZmUtM2NiMi00Y2M3LTkwMjYtYTM2YWVkOGQwYjgy',
    'ADMIN',
    'Authenticated',
    '2020-01-05',
     true
    );

-- DEVELOPER ACCOUNT
insert into account(
    id, email, phone, password, name, last_name,
    birth_date, street, city, state, zip, country,
    invite_token, reset_token, role, account_status, creation_date, payment_active
    ) values (
    'c5e06fac-6208-4fcc-8cd2-c533da92242a',
    'jhordeym@gmail.com',
    '+351968084553',
    '$2a$10$LKAaJBLG8k4atKKvK0Uw1.GGVUyVXlVS6kf/qXy3euUCDsHhijzYO',
    'Jhordeym',
    'Santos',
    '1997-03-25',
    'Rua',
    'Estoril',
    'Lisboa',
    '9999-999',
    'Portugal',
    'ZmM1MjIyOGQtYzkwZS00NGU5LTg3YjUtM2Y0MzM0N2EwZGM3',
    'MTQyYTMxZTQtODM5ZS00OTY4LWJiNzktZjNmMjg0NjEwYmNk',
    'ADMIN',
    'Authenticated',
    '2019-12-16',
     true
    );

-- INVESTOR ACCOUNT
insert into account(
    id, email, phone, password, name, last_name,
    birth_date, street, city, state, zip, country,
    invite_token, reset_token, role, account_status, creation_date, payment_active
    ) values (
    '621d71c9-5eb9-433a-a5f7-a8d99bd6c5d8',
    'Drek44@hotmail.com',
    '+18635586377',
    '$2a$10$OJsA5lzcj3A7SripUTr3WOhWOOUEMOw.aAGj12wrKEFaDqzXK8iV2',
    'Derick',
    'Alers',
    '1977-12-25',
    '2103 Shadow Creek',
    'Dr Kisimmee',
    'FL',
    '34746',
    'United States of America',
    'Y2FkMDlmOGQtZDBhNS00OTNmLWE0N2QtZTkxYWNhOGNkNzUz',
    'MDU1MTZlODQtNWI3Yi00YzRmLTg2MDItNGZjMTAxMTZiZTVm',
    'INVESTOR',
    'Authenticated',
    '2020-01-07',
     true
    );

insert into account(
    id, email, phone, password, name, last_name,
    birth_date, street, city, state, zip, country,
    invite_token, reset_token, role, account_status, creation_date, payment_active
    ) values (
    'eecaa5f8-a189-4a86-b2e6-b8cb51a1ff00',
    'pablomayuri@hotmail.com',
    '+19546084402',
    '$2a$10$OJsA5lzcj3A7SripUTr3WOhWOOUEMOw.aAGj12wrKEFaDqzXK8iV2',
    'Pablo',
    'Mayuri',
    '1979-01-08',
    '4810 Kingston Cir.',
    'Dr Kisimmee',
    'FL',
    '34746',
    'United States of America',
    'MjI4OGQ3NDAtMmM2Yy00ZGYyLThmMTItYmFhZTU4MzBlZWVj',
    'OWQ2MTQzNzktMDBhNS00OTMwLWJlMjYtY2IzYmY4NDExODYx',
    'INVESTOR',
    'Authenticated',
    '2020-01-07',
     true
    );

insert into account(
    id, email, phone, password, name, last_name,
    birth_date, street, city, state, zip, country,
    invite_token, reset_token, role, account_status, creation_date, payment_active
    ) values (
    '393a6ead-bcde-4990-b74e-771f9b3a5cfd',
    'moreto.fernando@gmail.com',
    '+3512765477',
    '$2a$10$OJsA5lzcj3A7SripUTr3WOhWOOUEMOw.aAGj12wrKEFaDqzXK8iV2',
    'Fernando',
    'Moreto',
    '1971-01-01',
    'Egas Moniz 262 2 esq',
    'Sao Joao Estoril',
    'Lisboa',
    '34746',
    'Portugal',
    'ZDQ3YTViMjAtNDQ1MS00NWRkLTk2MzQtMTc2MzY5MDUwNmI0',
    'YzhjOGM1ZGMtNDIwZi00YmUxLTg4MmYtZTRjNTdjY2EyNGI3',
    'INVESTOR',
    'Authenticated',
    '2020-01-07',
     true
    );

--AMBASSADOR
insert into account(
    id, account_status, city, country, state, street, zip, birth_date, creation_date, 
    email, invite_token, last_name, name, password, payment_active, phone, reset_token, role
    ) values (
    '2aaad9ae-8fae-4241-8433-a63df49b3b4e',
    'Authenticated',
    'Orlando',
    'United States of America',
    'Fl',
    '208 W. Sand Lake Rd? ?Suite 305',
    '32819',
    '2000-02-18',
    '2020-01-07',
    'polilandim@gmail.com',
    'ODA2ZWVhYzAtZDMyMC00MmFiLThlZTgtOGE2ZDAzYTA1NWI2',
    'LANDIM',
    'POLIANA',
    '$2a$10$OJsA5lzcj3A7SripUTr3WOhWOOUEMOw.aAGj12wrKEFaDqzXK8iV2',
    false,
    '+17722849682',
    'Y2UyNjA5MmMtMTM1ZC00YzJkLTgzMDgtZGEwNjJjYWM1NTMz',
    'AMBASSADOR');
insert into account(
    id, account_status, city, country, state, street, zip, birth_date, creation_date, 
    email, invite_token, last_name, name, password, payment_active, phone, reset_token, role
    ) values (
    '4e9204e3-65cb-4245-a87b-76b61d8305ed',
    'Authenticated',
    'Orlando',
    'United States of America',
    'Fl',
    '208 W. Sand Lake Rd? ?Suite 305',
    '32819',
    '1996-10-20',
    '2020-01-07',
    'mcgarren14@gmail.com',
    'MDNlYjIwMzEtMWU3MS00MzNmLTkwNTEtODUwMzI5NGNkZTQx',
    'JONES',
    'WENDY',
    '$2a$10$OJsA5lzcj3A7SripUTr3WOhWOOUEMOw.aAGj12wrKEFaDqzXK8iV2',
    false,
    '+18018348674',
    'NTRjODJiNTctNDdlMi00NzRiLWE5ZWYtMGZiNjA4ZDU4ZWYy',
    'AMBASSADOR'
    );
insert into account(
    id, account_status, city, country, state, street, zip, birth_date, creation_date,
    email, invite_token, last_name, name, password, payment_active, phone, reset_token, role
    ) values (
    '8053e8fa-6ccd-4172-8bba-6183ceeb39f9',
    'Authenticated',
    'Orlando',
    'United States of America',
    'Fl',
    '208 W. Sand Lake Rd? ?Suite 305','32819',
    '1986-01-08',
    '2020-01-07',
    'nossavidausa@gmail.com',
    'NTUwYjUzZGMtZDlkMC00MmRjLTlmM2ItZmFmZGQ1ZDYzNDBm',
    'SILVA',
    'ANDERSON',
    '$2a$10$JhkPgN4LLoC1EyZFuDF2duFTAAaDbM/s9CSyB4bahgabjb1qnDtWG',
    false,
    '+18573029846',
    'MDNkMTg1M2UtZjFkZC00MjVhLTkwMzQtZjI2MGQ5MDkwYTdm',
    'AMBASSADOR'
    );
insert into account(
    id, account_status, city, country, state, street, zip, birth_date, creation_date, 
    email, invite_token, last_name, name, password, payment_active, phone, reset_token, role
    ) values (
    '760a0481-34e9-40d6-8233-2a0aa7303654',
    'Authenticated',
    'Orlando',
    'United States of America',
    'Fl',
    '2742 SAND ARBOR CIR',
    '32819',
    '1984-04-05',
    '2020-01-07',
    'julianealmeida@me.com',
    'MzdjNTVlMmMtYjBiZi00NjhkLTg4MWMtNDU2NWU0NGNhZDg5',
    'ALMEIDA',
    'JULIANE',
    '$2a$10$ZCX.k5QU29S6RhAD4/U36.e2dfINaGWYELTJa7Dyv6jj0X6CRy6Um',
    true,
    '+18134492627',
    'OGFlODQxNDEtMWRhMy00YjQxLTgxNDItZTA0OTNiZWZkZWQ1',
    'AMBASSADOR'
    );
insert into account(
    id, account_status, city, country, state, street, zip, birth_date, creation_date,
    email, invite_token, last_name, name, password, payment_active, phone, reset_token, role
    ) values(
    '2529540b-1962-45a7-ab78-c8a0409866cb',
    'Authenticated',
    'Orlando',
    'United States of America',
    'Fl',
    '7208 W. Sand Lake Rd? ?Suite 305?',
    '32819',
    '1990-04-05',
    '2020-01-07',
    'annalayzabusiness@gmail.com',
    'NzBlZDU1ODQtY2M2Ny00NDM4LTk2MzMtM2NjZDFmZTI4ODFk',
    'LAYZA',
    'ANNA',
    '$2a$10$OJsA5lzcj3A7SripUTr3WOhWOOUEMOw.aAGj12wrKEFaDqzXK8iV2',
    true,
    '+14077795225',
    'NzQ0MjVmYjgtZDQ0Zi00MThhLTgxZGUtZGVhNGUwMDZkOGZj',
    'AMBASSADOR'
    );

--LEVEL    
insert into level(status, child_id, parent_id) values('Active','2aaad9ae-8fae-4241-8433-a63df49b3b4e','621d71c9-5eb9-433a-a5f7-a8d99bd6c5d8');
insert into level(status, child_id, parent_id) values('Active','4e9204e3-65cb-4245-a87b-76b61d8305ed','621d71c9-5eb9-433a-a5f7-a8d99bd6c5d8');
insert into level(status, child_id, parent_id) values('Active','8053e8fa-6ccd-4172-8bba-6183ceeb39f9','621d71c9-5eb9-433a-a5f7-a8d99bd6c5d8');
insert into level(status, child_id, parent_id) values('Active','760a0481-34e9-40d6-8233-2a0aa7303654','eecaa5f8-a189-4a86-b2e6-b8cb51a1ff00');
insert into level(status, child_id, parent_id) values('Active','2529540b-1962-45a7-ab78-c8a0409866cb','393a6ead-bcde-4990-b74e-771f9b3a5cfd');
