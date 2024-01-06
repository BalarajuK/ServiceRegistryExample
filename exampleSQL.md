create database db_ecomproductservice;
create user usr_ecomproductservice;
grant all privileges on db_ecomproductservice.* to usr_ecomproductservice;

commit;

create database db_ecomuserservice;
create user usr_ecomuserservice;
grant all privileges on db_ecomuserservice.* to usr_ecomuserservice;

select * from product;

show databases;

use db_ecomproductservice;
select count(*) from product