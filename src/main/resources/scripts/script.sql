create sequence customer_seq
    increment by 50;

alter sequence customer_seq owner to postgres;

create sequence event_seq
    increment by 50;

alter sequence event_seq owner to postgres;

create sequence organization_seq
    increment by 50;

alter sequence organization_seq owner to postgres;

create sequence reward_seq
    increment by 50;

alter sequence reward_seq owner to postgres;

create table customer
(
    id    bigint  not null
        primary key,
    coins integer not null,
    name  varchar(255)
);

alter table customer
    owner to postgres;

create table organization
(
    id          bigint not null
        primary key,
    description varchar(255),
    name        varchar(255)
);

alter table organization
    owner to postgres;

create table event
(
    id              bigint  not null
        primary key,
    coins           integer not null,
    description     varchar(255),
    end_date        timestamp(6),
    location        varchar(255),
    spots           integer not null,
    start_date      timestamp(6),
    status          varchar(255),
    title           varchar(255),
    organization_id bigint
        constraint fkkarqc3c84scr3r5ncv5stqbk2
            references organization
);

alter table event
    owner to postgres;

create table customer_events
(
    customer_id bigint not null
        constraint fkhqmkii5eg8l3bgmahpq5o8pks
            references customer,
    event_id    bigint not null
        constraint fk6rt1q10p30ia2fym96quspno
            references event
);

alter table customer_events
    owner to postgres;

create table organization_events
(
    organization_entity_id bigint not null
        constraint fk6ciwv95wnwdkt4t9u6t2fhvii
            references organization,
    events_id              bigint not null
        constraint uk_6b7eadsi5tuhcg38954epa6q6
            unique
        constraint fkjvu5owuviolcpcdbkxh8ki2ha
            references event
);

alter table organization_events
    owner to postgres;

create table reward
(
    id          bigint not null
        primary key,
    description varchar(255),
    name        varchar(255),
    price       integer
);

alter table reward
    owner to postgres;

create table customer_rewards
(
    customer_id bigint not null
        constraint fkj5dgwq8b1m4v6yhe0xjdj1176
            references customer,
    reward_id   bigint not null
        constraint fkrx7lrpcsjbofopwao14hw0e31
            references reward
);

alter table customer_rewards
    owner to postgres;

