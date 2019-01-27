CREATE TABLE product_categories (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  description varchar(2000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO product_categories (name,description) VALUES('Kids','Very long and detailed descriptions of kids ...');
INSERT INTO product_categories (name,description) VALUES('Pajamas','Very long and detailed descriptions of pajamas ...');

CREATE TABLE product_info (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  article int(10) unsigned NOT NULL,
  photo_link_short varchar(100) NOT NULL,
  photo_link_long varchar(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO product_info (name,article,photo_link_short,photo_link_long) VALUES('Кидсы голубые', 300101 , 'link_short_1' , 'link_long_1');
INSERT INTO product_info (name,article,photo_link_short,photo_link_long) VALUES('Кидсы розовые', 300102 , 'link_short_2' , 'link_long_2');
INSERT INTO product_info (name,article,photo_link_short,photo_link_long) VALUES('Пижама супермена', 400101 , 'link_short_3' , 'link_long_3');

CREATE TABLE product_sizes (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  size varchar(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO product_sizes (size) VALUES('Size S');
INSERT INTO product_sizes (size) VALUES('Size M');
INSERT INTO product_sizes (size) VALUES('Size L');

CREATE TABLE products (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  product_info_id int(10) unsigned NOT NULL,
  product_category_id int(10) unsigned NOT NULL,
  product_size_id int(10) unsigned NOT NULL,
  price decimal(7,2) unsigned NOT NULL,
  quantity int(10) unsigned NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (product_category_id) REFERENCES product_categories (id),
  FOREIGN KEY (product_size_id) REFERENCES product_sizes (id),
  FOREIGN KEY (product_info_id) REFERENCES product_info (id),
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO products (product_info_id,product_category_id,product_size_id,price, quantity) VALUES(1,1,1,100.0,10);
INSERT INTO products (product_info_id,product_category_id,product_size_id,price, quantity) VALUES(1,2,2,200.0,20);
INSERT INTO products (product_info_id,product_category_id,product_size_id,price, quantity) VALUES(3,2,3,300.0,30);

CREATE TABLE order_clients (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  phone varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO order_clients (name,email,phone) VALUES('Vadim','vadim@google.com','38-050-111-22-33');
INSERT INTO order_clients (name,email,phone) VALUES('Andrey','andrey@google.com','38-050-999-99-77');

CREATE TABLE order_statuses (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO order_statuses (name) VALUES('Новый');
INSERT INTO order_statuses (name) VALUES('В работе');
INSERT INTO order_statuses (name) VALUES('Доставка');

CREATE TABLE orders (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  date datetime NOT NULL,
  order_status int(2) unsigned NOT NULL,
  client_id int(10) unsigned NOT NULL,
  shipping_address varchar(100) NOT NULL,
  shipping_details varchar(200) NOT NULL,
  comments varchar(100) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (order_status) REFERENCES order_statuses (id),
  FOREIGN KEY (client_id) REFERENCES order_clients (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO orders (date,order_status,client_id, shipping_address, shipping_details, comments) VALUES('1970-01-01 00:00:01.0',1,1, 'shipping address 1', 'shipping details 1','comments 1');
INSERT INTO orders (date,order_status,client_id, shipping_address, shipping_details, comments) VALUES('1970-01-01 00:00:01.0',2,2, 'shipping address 2', 'shipping details 2','comments 2');

CREATE TABLE sales (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  order_id int(10) unsigned NOT NULL,
  product_id int(10) unsigned NOT NULL,
  price decimal(7,2) unsigned NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (order_id) REFERENCES orders (id),
  FOREIGN KEY (product_id) REFERENCES products (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO sales (order_id,product_id, price) VALUES(1,1,100.0);
INSERT INTO sales (order_id,product_id, price) VALUES(1,2,200.0);
INSERT INTO sales (order_id,product_id, price) VALUES(2,1,100.0); 
  