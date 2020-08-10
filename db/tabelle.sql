drop database IF EXISTS società_di_esports;
create database Società_di_esports;

use Società_di_esports;

create table Staff(
	cf varchar(16) primary key not null,
    cognome varchar(30) not null,
    nome varchar(20) not null
);
create table Recapito(
	numero varchar(10) primary key not null,
    cf varchar(16) not null,
    foreign key (cf) references Staff(cf)
);
create table Torneo(
	id int auto_increment primary key not null,
    nome varchar(50) not null,
    data date not null,
    numero_team int default (0)
);
create table Tecnico(
	cf varchar(16) primary key not null,
    descrizione varchar(100) not null,
    foreign key (cf) references Staff(cf)
);
create table Coach(
	cf varchar(16) primary key not null,
    anni_di_esperienza int not null,
    foreign key (cf) references Staff(cf)
);
create table Manager(
	cf varchar(16) primary key not null,
	foreign key (cf) references Staff(cf)
);
create table Team(
	nome varchar(40) primary key not null,
    sigla varchar(10) not null,
    cf_coach varchar(16) not null unique,
    cf_manager varchar(16) not null,
    foreign key (cf_coach) references Coach(cf), 
    foreign key (cf_manager) references Manager(cf)
);
create table Player(
	cf varchar(16) primary key not null,
    nome varchar(40),
    ruolo enum("MidLaner", "Jungler", "Support", "TopLaner", "ADC") not null,
    tessera_GEC varchar(6) not null,
    nome_player varchar(30)  not null,
    Cognome varchar(20) not null,
    Nickname varchar(30) not null,
    foreign key (nome) references Team(nome)
);
create table Sponsor(
	nome varchar(20) primary key not null,
    cf varchar(16),
    foreign key (cf) references Manager(cf)
);
create table Partecipa(
	nome varchar(40) not null,
    id int not null,
    primary key (nome, id),
    foreign key (nome) references Team(nome),
    foreign key(id) references Torneo(id)
);
create table UserTable(
	nome_utente varchar(20) primary key not null unique,
    password_utente varchar(20) default null,
    admUser int default (0)
) ;
-- select * from UserTable;
