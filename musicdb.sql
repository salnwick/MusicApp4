create database if not exists Music;

use Music;

drop table if exists Tracks;
drop table if exists Albums;
drop table if exists Artists;

create table if not exists Artists(
artist_id int(11) not null auto_increment,
artist varchar(25) not null,
primary key(artist_id)
);

create table if not exists Albums(
album_id int(11) not null auto_increment,
album varchar(25) not null,
artist_id int(11) not null,
primary key(album_id),
foreign key(artist_id) references Artists(artist_id)
);

create table if not exists Tracks(
track_id int(11) not null auto_increment,
track varchar(25) not null,
artist_id int(11) not null,
album_id int(11) not null,
primary key(track_id),
foreign key(artist_id) references Artists(artist_id),
foreign key(album_id) references Albums(album_id)
);
