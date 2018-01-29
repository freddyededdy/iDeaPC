create schema iDeaPc;
use iDeaPc;

/*Crea tabella clienti*/
create table Cliente
(
id_cli integer auto_increment, 
Nome char(20) not null ,
Cognome char(20) not null ,
data_nascita date not null ,
città_res char(25) not null,
via char(30) not null,
num_civico varchar(10) not null,
cellulare varchar(10) not null,
email char(30) not null,
pass char(16) not null,
t_carta char(25),
n_carta varchar(16),
primary key(id_cli)
);

/* Crea tabella Ordine*/
create table Ordine(
id_ordine integer auto_increment,
stato_pagamento char(15) not null, 
descrizione text, 
id_cli integer not null,
data_ordine timestamp not null,
primary key (id_ordine),
foreign key(id_cli) references Cliente(id_cli)
on update cascade
);

/* Crea tabella Prodotto*/
create table Prodotto(
id_prod integer auto_increment,
nome char(40) not null,
descrizione text,
prezzo double not null,
path_immagine text,
quantita integer,
primary key (id_prod)
);

/* Crea tabella composizione*/
create table Composizione(
id_ordine integer ,
id_prod integer,
quantità integer not null,
prezzo double not null,
nome_prodotto char(30) not null,
foreign key(id_ordine) references Ordine(id_ordine)
on delete cascade
on update cascade ,
foreign key(id_prod) references prodotto(id_prod)
on update cascade 
on delete set null

);

/* Crea tabella Fattura*/
create table Fattura(
id_fattura integer auto_increment primary key,
id_ordine integer,
iva integer not null,
totale_imponibile double not null,
totale_fattura double not null,
foreign key(id_ordine) references Ordine(id_ordine)
on delete cascade
on update cascade
);