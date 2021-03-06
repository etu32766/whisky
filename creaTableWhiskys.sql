drop schema whiskyproject;

create schema whiskyProject;

drop table if exists whiskyproject.translation;
drop table if exists whiskyproject.langue;
drop table if exists whiskyproject.commandline;
drop table if exists whiskyproject.whisky;
drop table if exists whiskyproject.categorie;
drop table if exists whiskyproject.whiskyorder;
drop table if exists whiskyproject.persistable_user;

create table whiskyProject.persistable_user(
	username varchar(50) primary key,
    password varchar(60) default null,
    authorities varchar(500) default "ROLE_USER",
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    email varchar(100) not null unique check(email REGEXP '[a-z|A-Z|0-9|\-|\.|\_]+\@([a-z|A-Z|0-9|\-|\.]+)\.([a-z|A-Z]{2,4})'),
    adresse varchar(100) not null,
    telephone varchar(30) default null check(telephone REGEXP '(0|((00|\\+)[0-9]{2}))?(\\/|\\.|\\-|\\ )?[0-9]{2,3}(\\/|\\.|\\-|\\ )?((([0-9]{2}(\\/|\\.|\\-|\\ )?){3,4})|(([0-9]{3}(\\/|\\.|\\-|\\ )?){2,3}))'),
    non_expired tinyint(1) default 1,
    non_locked tinyint(1) default 1,
    credentials_non_expired tinyint(1) default 1,
    enabled tinyint(1) default 1
);

create table whiskyproject.whiskyorder(
	id int(65) not null AUTO_INCREMENT,
    dateOrder date not null,
    validity tinyint(1) not null,
    utilisateur varchar(50) not null,
    promotion double,
    totalprice double,
    primary key(id),
    constraint utilisateur foreign key(utilisateur) references whiskyproject.persistable_user(username)
);

create table whiskyproject.categorie( nom varchar(50) primary key);

create table whiskyproject.whisky(
	id int(65) primary key,
    whiskyname varchar(50) not null,
    age int(3),
    selection varchar(50),
    brand varchar(50),
    region varchar(50),
    country varchar(50),
    productiondate int(10),
    alcoholcontent int(3),
    volume int(6) ,
    stockquantity int(5) default 100,
    categorie varchar(50),
    img varchar(50),
    price double(10,2),
    promotion double(5,2),
    constraint categorie foreign key(categorie) references whiskyproject.categorie(nom),
    constraint check_age check(age=null||(age>=0&&age<999)),
    constraint check_alcoholcontent check(alcoholcontent=null||(alcoholcontent>=0&&alcoholcontent<=100)),
    constraint check_volume check(volume=null||(volume>0&&volume<999999)),
    constraint check_price check(price=null||price>0),
    constraint check_promotion check(promotion=null||(promotion>=0 ||promotion<=100))
);

create table whiskyproject.commandline(
	id int(65) not null AUTO_INCREMENT,
    realprice double(15,2),
    quantity int(3) not null,
    whiskyorder int(65) not null,
    whisky int(65) not null,
    primary key(id),
    constraint whiskyorder foreign key(whiskyorder) references whiskyproject.whiskyorder(id),
    constraint whisky foreign key(whisky) references whiskyproject.whisky(id),
    check(quantity > 0)
);

create table whiskyproject.langue(
	id varchar(50) primary key
);

create table whiskyproject.translation(
	id int(65) primary key,
	descriptions varchar(12000) not null,
    whiskyid int(65) not null,
    languageid varchar(50) not null,
    constraint whiskyid foreign key(whiskyid) references whiskyproject.whisky(id),
    constraint languageid foreign key(languageid) references whiskyproject.langue(id)
);

