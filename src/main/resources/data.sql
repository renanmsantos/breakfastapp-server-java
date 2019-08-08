insert into customer (active, cellphone, cpf, created_at, email, last_name, name, password, updated_at)
    values (true, '99999999999', '000.000.000-00', null, 'admin', 'da Silva', 'Admin', '$2a$10$ZRrNGH2kGz89GXnwTIHSeOn9GggGx1Q2WBkUbKPGqpSgfS/6nSHXi', null);

insert into address (active, cep, city, created_at, district, number, street, updated_at)
    values (true, '12311-000', 'Jacareí', null, 'Pq. Califórnia', 11, 'Rua Saadalah José Assad', null);
insert into address (active, cep, city, created_at, district, number, street, updated_at)
    values (true, '12311-002', 'Jacareí', null, 'Pq. Califórnia', 10, 'Rua Professor Benedito', null);

insert into customer_addresses (customer_id, addresses_id)
    values (1,1);

insert into segment (active, created_at, description, name, updated_at)
    values (true, null, 'Segmento de teste', 'Segmento de teste', null);
insert into segment (active, created_at, description, name, updated_at)
    values (true, null, 'Segmento de mercado', 'Segmento de teste', null);

insert into partner (active, cnpj, created_at, delivery_fee, email, name, password, phone, segment_id, updated_at)
    values (true, '123.32.432/0001-1', null, 15.00, 'partner@partner.com.br', 'Salgado do Joana', 'admin', '(12) 99999-5553', 1, null);
insert into partner (active, cnpj, created_at, delivery_fee, email, name, password, phone, segment_id, updated_at)
    values (true, '123.32.442/0001-1', null, 12.00, 'maria@partner.com.br', 'Bolos da vovó', 'admin', '(12) 99999-5553', 2, null);

insert into category (active, created_at, description, name, updated_at)
    values (true, null, 'Categoria de teste', 'Categoria 1', null);
insert into category (active, created_at, description, name, updated_at)
    values (true, null, 'Categoria de teste', 'Categoria 2', null);

insert into product (active, available, category_id, created_at, days_produce, name, partner_id, price, quantity, updated_at, url_image)
    values (true, true, 1, null, 2, 'Bolo de cenoura', 2, 20.5, 20, null, 'https://api.adorable.io/avatars/50/abott@adorable.png');
insert into product (active, available, category_id, created_at, days_produce, name, partner_id, price, quantity, updated_at, url_image)
    values (true, true, 1, null, 2, 'Bolo de aipim', 2, 32.0, 20, null, 'https://api.adorable.io/avatars/50/abott@adorable1.png');
insert into product (active, available, category_id, created_at, days_produce, name, partner_id, price, quantity, updated_at, url_image)
    values (true, true, 1, null, 2, 'Bolo de laranja', 2, 20.0, 20, null, 'https://api.adorable.io/avatars/50/abott@adorable2.png');
insert into product (active, available, category_id, created_at, days_produce, name, partner_id, price, quantity, updated_at, url_image)
    values (true, true, 1, null, 2, 'Bolo de recheado', 2, 55.0, 20, null, 'https://api.adorable.io/avatars/50/abott@adorable3.png');
insert into product (active, available, category_id, created_at, days_produce, name, partner_id, price, quantity, updated_at, url_image)
    values (true, true, 1, null, 2, 'Cento de salgado de frango', 1, 100.0, 20, null, 'https://api.adorable.io/avatars/50/abott@adorable5.png');
insert into product (active, available, category_id, created_at, days_produce, name, partner_id, price, quantity, updated_at, url_image)
    values (true, true, 1, null, 2, 'Cento de salgado de carne', 1, 100.0, 20, null, 'https://api.adorable.io/avatars/50/abott@adorable3.png');

