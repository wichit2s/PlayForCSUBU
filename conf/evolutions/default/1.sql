# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table todo (
  id                            uuid not null,
  text                          varchar(255),
  done                          boolean,
  created_date                  timestamp,
  constraint pk_todo primary key (id)
);


# --- !Downs

drop table if exists todo;

