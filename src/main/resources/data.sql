INSERT INTO roles (id,name) VALUES (1,'ADMIN');
INSERT INTO roles (id,name) VALUES (2,'USER');





INSERT INTO brands (id, name) VALUES (1,'Ford');
INSERT INTO brands (id, name) VALUES (2,'Renault');

INSERT INTO models (id, category, name, brand_id)
 VALUES (1,'CAR','Mustang',1);
INSERT INTO models (id, category, name, brand_id)
VALUES (2,'CAR','Captur',2);
INSERT INTO models (id, category, name, brand_id)
VALUES (3,'CAR','Duster',2);

INSERT INTO users (id,first_name, image_url, is_active, last_name, password, username)
VALUES (1,'Ivet','https://unsplash.com/s/photos/profile',true,'Lazarova','test','ivet01');

INSERT INTO users (id,first_name, image_url, is_active, last_name, password, username)
VALUES (2,'Peter','https://addran.tcu.edu/view/peter-worthing',true,'Welman','softeng','gameOver');

INSERT INTO users_roles(user_id, roles_id) values (1,1);
INSERT INTO users_roles(user_id, roles_id) values (1,2);
INSERT INTO users_roles(user_id, roles_id) values (2,2);

INSERT INTO offers (id, description, image_url, mileage, price, year, model_id, seller_id)
VALUES (1,'very good condition,economy','https://www.euroncap.com/en/results/ford/mustang/26063',12000,8000,2014,1,1);
INSERT INTO offers (id, description, image_url, mileage, price, year, model_id, seller_id)
VALUES (2,'economy','https://img.autoabc.lv/Renault-Captur/Renault-Captur_2012_Apvidus_1751733214_28.jpg',50000,10000,2016,2,2);

