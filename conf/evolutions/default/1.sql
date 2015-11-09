# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table amostra (
  id                        bigint not null,
  coleta_id                 bigint not null,
  data_insercao             timestamp,
  data_exclusao             timestamp,
  data_coleta               timestamp,
  descricao                 varchar(255),
  constraint pk_amostra primary key (id))
;

create table calha (
  id                        varchar(255) not null,
  dados_historicos          varchar(255),
  constraint pk_calha primary key (id))
;

create table coleta (
  id                        bigint not null,
  tipo                      varchar(255),
  data                      timestamp,
  descricao                 varchar(255),
  constraint pk_coleta primary key (id))
;

create table dado_historico (
  id                        bigint not null,
  dado_historico            varchar(255),
  constraint pk_dado_historico primary key (id))
;

create table descricao (
  id                        bigint not null,
  laje_id                   bigint not null,
  descricao                 varchar(255),
  constraint pk_descricao primary key (id))
;

create table laje (
  id                        bigint not null,
  calha_id                  varchar(255) not null,
  constraint pk_laje primary key (id))
;


create table coleta_laje (
  coleta_id                      bigint not null,
  laje_id                        bigint not null,
  constraint pk_coleta_laje primary key (coleta_id, laje_id))
;

create table laje_coleta (
  laje_id                        bigint not null,
  coleta_id                      bigint not null,
  constraint pk_laje_coleta primary key (laje_id, coleta_id))
;
create sequence amostra_seq;

create sequence calha_seq;

create sequence coleta_seq;

create sequence dado_historico_seq;

create sequence descricao_seq;

create sequence laje_seq;

alter table amostra add constraint fk_amostra_coleta_1 foreign key (coleta_id) references coleta (id);
create index ix_amostra_coleta_1 on amostra (coleta_id);
alter table descricao add constraint fk_descricao_laje_2 foreign key (laje_id) references laje (id);
create index ix_descricao_laje_2 on descricao (laje_id);
alter table laje add constraint fk_laje_calha_3 foreign key (calha_id) references calha (id);
create index ix_laje_calha_3 on laje (calha_id);



alter table coleta_laje add constraint fk_coleta_laje_coleta_01 foreign key (coleta_id) references coleta (id);

alter table coleta_laje add constraint fk_coleta_laje_laje_02 foreign key (laje_id) references laje (id);

alter table laje_coleta add constraint fk_laje_coleta_laje_01 foreign key (laje_id) references laje (id);

alter table laje_coleta add constraint fk_laje_coleta_coleta_02 foreign key (coleta_id) references coleta (id);

# --- !Downs

drop table if exists amostra cascade;

drop table if exists calha cascade;

drop table if exists coleta cascade;

drop table if exists coleta_laje cascade;

drop table if exists dado_historico cascade;

drop table if exists descricao cascade;

drop table if exists laje cascade;

drop table if exists laje_coleta cascade;

drop sequence if exists amostra_seq;

drop sequence if exists calha_seq;

drop sequence if exists coleta_seq;

drop sequence if exists dado_historico_seq;

drop sequence if exists descricao_seq;

drop sequence if exists laje_seq;

