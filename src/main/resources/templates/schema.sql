create table User (id bigint not null AUTO_INCREMENT, dob date, email varchar(50),
first_name varchar(50), last_name varchar(50), user_id varchar(15) unique
not null,password varchar(21) not null, primary key (id));