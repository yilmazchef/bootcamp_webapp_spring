create table if not exists roles
(
    role_id   int unique auto_increment,
    role_name varchar(50)
);

create table if not exists users
(
    user_id   int auto_increment unique,
    role_id   int,
    email     varchar(255) not null unique,
    phone     varchar(14)  not null,
    pass_code varchar(255),

    constraint role_to_user_fk foreign key (role_id) references roles (role_id),

    primary key (user_id)

);

create table if not exists adults
(

    adult_id      int auto_increment unique,
    first_name    varchar(100) not null,
    last_name     varchar(100) not null,
    user_id       int          not null,
    date_of_birth date,

    primary key (adult_id),

    constraint user_to_adult_fk foreign key (user_id) references users (user_id)

);

create table if not exists children
(

    child_id      int auto_increment unique,
    adult_id      int          not null,
    first_name    varchar(100) not null,
    last_name     varchar(100) not null,
    user_id       int          not null,
    date_of_birth date,

    primary key (child_id),

    constraint adult_to_child_fk foreign key (adult_id) references adults (adult_id),
    constraint user_to_child_fk foreign key (user_id) references users (user_id)

);

create table if not exists bootcamp_events
(

    bootcamp_id int auto_increment unique,
    title       varchar(255) not null,
    description longtext     not null,
    event_date  date,
    event_time  time,
    image_url   blob,

    primary key (bootcamp_id)

);

create table if not exists bootcamp_registrations
(
    child_id    int,
    bootcamp_id int,

    constraint child_to_registration_fk foreign key (child_id) references children (child_id),
    constraint bootcamp_to_registration_fk foreign key (bootcamp_id) references bootcamp_events (bootcamp_id),

    primary key (child_id, bootcamp_id)

);
