SET search_path TO seguros;

drop table if exists CAR_DRIVERS;

drop table if exists CLAIMS;

drop table if exists INSURANCES;

drop table if exists CUSTOMER;

drop table if exists CARS;

drop table if exists DRIVERS;

/*==============================================================*/
/* Table: CARS                                                  */
/*==============================================================*/
create table CARS 
(
   ID_CAR               NUMERIC(11)                    not null,
   DE_MODEL             VARCHAR(100)                   not null,
   DE_MANUFACTURER      VARCHAR(200)                   not null,
   DE_YEAR              VARCHAR(4)                     not null,
   VR_FIPE_VALUE        DECIMAL(11,2)                  not null,
   constraint PK_CARS primary key (ID_CAR)
);

comment on table CARS is 
'Veículos';

comment on column CARS.ID_CAR is 
'Id do Carro';

comment on column CARS.DE_MODEL is 
'Modelo do veículo';

comment on column CARS.DE_MANUFACTURER is 
'Fabricante do veículo';

comment on column CARS.DE_YEAR is 
'Ano do Modelo do Veículo';

comment on column CARS.VR_FIPE_VALUE is 
'Valor do veículo';

/*==============================================================*/
/* Table: CAR_DRIVERS                                           */
/*==============================================================*/
create table CAR_DRIVERS 
(
   ID_DRIVER            NUMERIC(11)                    not null,
   ID_CAR               NUMERIC(11)                    not null,
   IS_MAIN_DRIVER       BOOLEAN                        not null,
   constraint PK_CAR_DRIVERS primary key (ID_DRIVER, ID_CAR)
);

comment on table CAR_DRIVERS is 
'Motoristas dos Veículos';

comment on column CAR_DRIVERS.ID_DRIVER is 
'Id do Motorista';

comment on column CAR_DRIVERS.ID_CAR is 
'Id do Carro';

comment on column CAR_DRIVERS.IS_MAIN_DRIVER is 
'Flag que sinaliza se o motorista é o principal condutor do veículo';

/*==============================================================*/
/* Table: CLAIMS                                                */
/*==============================================================*/
create table CLAIMS 
(
   ID_CLAIM             NUMERIC(11)                    not null,
   ID_CAR               NUMERIC(11)                    not null,
   ID_DRIVER            NUMERIC(11)                    not null,
   DT_EVENT             TIMESTAMP                      not null,
   constraint PK_CLAIMS primary key (ID_CLAIM)
);

comment on table CLAIMS is 
'Sinistros';

comment on column CLAIMS.ID_CLAIM is 
'Id do Sinistro';

comment on column CLAIMS.ID_CAR is 
'Id do Carro';

comment on column CLAIMS.ID_DRIVER is 
'Id do Motorista';

comment on column CLAIMS.DT_EVENT is 
'Data do evento do sinistro';

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
create table CUSTOMER 
(
   ID_CUSTOMER          NUMERIC(11)                    not null,
   ID_DRIVER            NUMERIC(11)                    not null,
   DE_NAME              VARCHAR(200)                   not null,
   constraint PK_CUSTOMER primary key (ID_CUSTOMER)
);

comment on table CUSTOMER is 
'Clientes';

comment on column CUSTOMER.ID_CUSTOMER is 
'Id do Cliente';

comment on column CUSTOMER.ID_DRIVER is 
'Id do Motorista';

comment on column CUSTOMER.DE_NAME is 
'Nome do cliente';

/*==============================================================*/
/* Table: DRIVERS                                               */
/*==============================================================*/
create table DRIVERS 
(
   ID_DRIVER            NUMERIC(11)                    not null,
   NU_DOCUMENT          NUMERIC(11)                    not null,
   DT_BIRTHDATE         DATE                           not null,
   constraint PK_DRIVERS primary key (ID_DRIVER)
);

comment on table DRIVERS is 
'Motoristas';

comment on column DRIVERS.ID_DRIVER is 
'Id do Motorista';

comment on column DRIVERS.NU_DOCUMENT is 
'CNH do motorista';

comment on column DRIVERS.DT_BIRTHDATE is 
'Data de nascimento do motorista';

/*==============================================================*/
/* Table: INSURANCES                                            */
/*==============================================================*/
create table INSURANCES 
(
   ID_INSURANCE         NUMERIC(11)                    not null,
   ID_CUSTOMER          NUMERIC(11)                    not null,
   ID_CAR               NUMERIC(11)                    not null,
   DT_CREATION          TIMESTAMP                      not null,
   DT_UPDATED           TIMESTAMP                      null,
   IS_ACTIVE            BOOLEAN                        not null,
   constraint PK_INSURANCES primary key (ID_INSURANCE)
);

comment on table INSURANCES is 
'Seguros';

comment on column INSURANCES.ID_INSURANCE is 
'Id da proposta de seguro';

comment on column INSURANCES.ID_CUSTOMER is 
'Id do Cliente';

comment on column INSURANCES.ID_CAR is 
'Id do Carro';

comment on column INSURANCES.DT_CREATION is 
'Data da solicitação do orçamento';

comment on column INSURANCES.DT_UPDATED is 
'Data da atualização do orçamento';

comment on column INSURANCES.IS_ACTIVE is 
'flag se o orçamento está ativo';

alter table CAR_DRIVERS
   add constraint FK_CAR_DRIVERS_CARS foreign key (ID_CAR)
      references CARS (ID_CAR)
      on update restrict
      on delete restrict;

alter table CAR_DRIVERS
   add constraint FK_CAR_DRIVERS_DRIVERS foreign key (ID_DRIVER)
      references DRIVERS (ID_DRIVER)
      on update restrict
      on delete restrict;

alter table CLAIMS
   add constraint FK_CLAIMS_CARS foreign key (ID_CAR)
      references CARS (ID_CAR)
      on update restrict
      on delete restrict;

alter table CLAIMS
   add constraint FK_CLAIMS_DRIVERS foreign key (ID_DRIVER)
      references DRIVERS (ID_DRIVER)
      on update restrict
      on delete restrict;

alter table CUSTOMER
   add constraint FK_CUSTOMER_DRIVERS foreign key (ID_DRIVER)
      references DRIVERS (ID_DRIVER)
      on update restrict
      on delete restrict;

alter table INSURANCES
   add constraint FK_INSURANCES_CARS foreign key (ID_CAR)
      references CARS (ID_CAR)
      on update restrict
      on delete restrict;

alter table INSURANCES
   add constraint FK_INSURANCES_CUSTOMER foreign key (ID_CUSTOMER)
      references CUSTOMER (ID_CUSTOMER)
      on update restrict
      on delete restrict;
