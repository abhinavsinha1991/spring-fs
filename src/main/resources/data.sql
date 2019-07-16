drop table if exists exchange_value;

CREATE TABLE exchange_value (
  id bigint(20) NOT NULL,
  conversion_multiple decimal(19,2) DEFAULT NULL,
  currency_from varchar(255) DEFAULT NULL,
  port int(11) NOT NULL,
  currency_to varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10001,'USD','INR',65,0);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10002,'EUR','INR',75,0);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10003,'AUD','INR',25,0);