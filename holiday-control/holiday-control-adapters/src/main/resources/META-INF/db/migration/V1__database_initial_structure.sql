create table holiday.holiday(
    id bigserial not null,
    description text not null,
    country_code varchar(10) not null,
    method varchar(100) not null,
    argument json not null,
    active boolean not null default true,
    constraint pk_holiday primary key (id)
);

