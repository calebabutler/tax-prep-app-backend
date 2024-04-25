/* Fake data to stop H2 from complaining */
insert into PROFILES (
        first_name,
        middle_initial,
        last_name,
        date_of_birth,
        address,
        city,
        state,
        apt_number,
        zip_code,
        ssn,
        oauth_id
    )
values (
        'Tom',
        'B',
        'Jones',
        19010101,
        '123 Sesame St.',
        'Kansas City',
        'MO',
        null,
        11111,
        00000000,
        '' /* Insert oauth ID */
    );