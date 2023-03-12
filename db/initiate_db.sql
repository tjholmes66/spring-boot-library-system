use library_db;

drop table if exists book;
drop table if exists category;
drop table if exists role;
drop table if exists token;
drop table if exists user;
create table book (book_id bigint not null auto_increment, book_author varchar(255), book_description varchar(255), book_name varchar(255), book_pages bigint, book_published date, checked_out_date date, category_id bigint, checked_out_user bigint, primary key (book_id));
create table category (category_id bigint not null auto_increment, category_code varchar(255), category_name varchar(255), edited_by bigint, edited_date datetime, enabled bit, entered_by bigint, entered_date datetime, primary key (category_id));
create table role (role_id bigint not null auto_increment, edited_by bigint, edited_date datetime, entered_by bigint, entered_date datetime, role_code varchar(255), role_name varchar(255), primary key (role_id));
create table token (token_id bigint not null auto_increment, created datetime, token varchar(255), user_id bigint, primary key (token_id));
create table user (user_id bigint not null auto_increment, cell_phone varchar(255), dob date, edited_by bigint, edited_date datetime, email_address varchar(255), enabled bit, entered_by bigint, entered_date datetime, first_name varchar(255), last_name varchar(255), middle_initial varchar(255), salted_password varchar(255), prefix varchar(255), reset_key varchar(255), suffix varchar(255), username varchar(255), work_phone varchar(255), role_id bigint, primary key (user_id));
alter table book add constraint FKam9riv8y6rjwkua1gapdfew4j foreign key (category_id) references category (category_id);
alter table book add constraint FK7qg23euhry9505vymss5c8g1u foreign key (checked_out_user) references user (user_id);
alter table token add constraint FKe32ek7ixanakfqsdaokm4q9y2 foreign key (user_id) references user (user_id);
alter table user add constraint FKn82ha3ccdebhokx3a8fgdqeyy foreign key (role_id) references role (role_id);