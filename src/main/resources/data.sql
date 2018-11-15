INSERT INTO client(
    id,
    client_id,
    client_secret,
    authorized_grant_types
)
VALUES(
    1,
    'testclient',
    'testsecret',
    'password,refresh_token'
);