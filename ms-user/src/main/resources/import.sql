INSERT INTO tb_common_user (id, uuid, transfer_limit) VALUES (1, '123e4567-e89b-12d3-a456-426614174000', 1000.0);
INSERT INTO tb_common_user (id, uuid, transfer_limit) VALUES (2, '123e4567-e89b-12d3-a456-426614174001', 500.0);
INSERT INTO tb_common_user (id, uuid, transfer_limit) VALUES (3, '123e4567-e89b-12d3-a456-426614174002', 700.0);

INSERT INTO tb_role (id, uuid, role_type) VALUES (1, '123e4567-e89b-12d3-a456-426614174001', 0);

INSERT INTO tb_shop_keeper (id, uuid, years_in_the_company) VALUES (1, '123e4567-e89b-12d3-a456-426614174002', 5);
INSERT INTO tb_shop_keeper (id, uuid, years_in_the_company) VALUES (2, '123e4567-e89b-12d3-a456-426614174003', 7);
INSERT INTO tb_shop_keeper (id, uuid, years_in_the_company) VALUES (3, '123e4567-e89b-12d3-a456-426614174004', 10);

INSERT INTO tb_user (id, uuid, full_name, email, password, cpfcnpj, user_type, balance, shop_keeper_id, common_user_id) VALUES (1, '123e4567-e89b-12d3-a456-426614174003', 'Emanuel Castro', 'emanuelsmcastro3@gmail.com','sadasd213124sdfd','12345678901', 0, 500.0, null,1);
INSERT INTO tb_user (id, uuid, full_name, email, password, cpfcnpj, user_type, balance, shop_keeper_id, common_user_id) VALUES (2, '123e4567-e89b-12d3-a456-426614174004', 'Fulano', 'fulano@gmail.com','sadasd213124sdfd','12345678902', 0, 500.0, 2, null);
INSERT INTO tb_user (id, uuid, full_name, email, password, cpfcnpj, user_type, balance, shop_keeper_id, common_user_id) VALUES (3, '123e4567-e89b-12d3-a456-426614174005', 'Fulano2', 'fulano2@gmail.com','sadasd213124sdfd','12345678903', 0, 5000.0, 3, 3);
INSERT INTO tb_user (id, uuid, full_name, email, password, cpfcnpj, user_type, balance, shop_keeper_id, common_user_id) VALUES (4, '123e4567-e89b-12d3-a456-426614174006', 'Fulano3', 'fulano3@gmail.com','sadasd213124sdfd','12345678904', 0, 5000.0, null, null);
