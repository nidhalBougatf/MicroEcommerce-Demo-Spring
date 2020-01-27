DROP TABLE IF EXISTS Product;
create table Product (id int primary key,name varchar(50), price int, providerprice int) ;
INSERT INTO product VALUES(1, 'Computer' , 350, 120);
INSERT INTO product VALUES(2, 'PlayStation' , 500, 200);
INSERT INTO product VALUES(3, 'TV' , 750, 400);