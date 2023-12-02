INSERT INTO tb_common_user (id, uuid, transfer_limit) VALUES (1, '123e4567-e89b-12d3-a456-426614174000', 1000.0);


INSERT INTO tb_role (id, uuid, role_type) VALUES (1, '123e4567-e89b-12d3-a456-426614174001', 0);


INSERT INTO tb_shop_keeper (id, uuid, years_in_the_company) VALUES (1, '123e4567-e89b-12d3-a456-426614174002', 5);

INSERT INTO tb_user (id, uuid, full_name, email, password, cpfcnpj, user_type, balance, shop_keeper_id, common_user_id) VALUES (1, '123e4567-e89b-12d3-a456-426614174003', 'Emanuel Castro', 'emanuelsmcastro3@gmail.com','sadasd213124sdfd','12345678901', 0, 500.0, null,1);
