# ------------------------------ Clients ----------------------------------
INSERT INTO fiapfoodt.client_entity (id, cpf, email, name)
VALUES ( UUID_TO_BIN(UUID()), '200.442.140-14', 'fulano@gmail.com', 'Fulano de tal Silva');

INSERT INTO fiapfoodt.client_entity (id, cpf, email, name)
VALUES ( UUID_TO_BIN(UUID()), '99197088013', 'zoani@gmail.com', 'Zoani Santos');

INSERT INTO fiapfoodt.client_entity (id, cpf, email, name)
VALUES ( UUID_TO_BIN(UUID()), '10217550010', 'giwa@gmail.com', 'Giwa de tal');

INSERT INTO fiapfoodt.client_entity (id, cpf, email, name)
VALUES ( UUID_TO_BIN(UUID()), '34173404034', 'gon_mekas@gmail.com', 'Mekas Gon');

# ------------------------------ Products ----------------------------------
INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (39.60, UUID_TO_BIN(UUID()), 'HAMBURGUER', 'Pão, queijo, hamburguer 160g, alface, tomate e cebola', '', 'X-SALADA', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (45.90, UUID_TO_BIN(UUID()), 'HAMBURGUER', 'Pão, queijo, bacon, hamburguer 160g, alface, tomate e cebola', '', 'X-SALADA-BACON', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (39.60, UUID_TO_BIN(UUID()), 'HAMBURGUER', 'Pão, queijo, bacon, hamburguer 160g', '', 'X-BACON', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (39.60, UUID_TO_BIN(UUID()), 'HAMBURGUER', 'Pão, queijo, milho, hamburguer 160g', '', 'X-MILHO', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (40.60, UUID_TO_BIN(UUID()), 'HAMBURGUER', 'Pão, queijo, tomate, hamburguer 200g', '', 'X-BURGUER', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (5.55, UUID_TO_BIN(UUID()), 'ACCOMPANIMENT', 'bacon em fatias', '', 'BACON', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (8.65, UUID_TO_BIN(UUID()), 'ACCOMPANIMENT', 'Batata frita P', '', 'Batata P', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (10.65, UUID_TO_BIN(UUID()), 'ACCOMPANIMENT', 'Batata frita M', '', 'Batata M', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (14.65, UUID_TO_BIN(UUID()), 'ACCOMPANIMENT', 'Batata frita G', '', 'Batata G', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (11.65, UUID_TO_BIN(UUID()), 'ACCOMPANIMENT', 'Cebola frita M', '', 'Cebola M', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (18.65, UUID_TO_BIN(UUID()), 'ACCOMPANIMENT', 'Batata frita M com  queijo cheddar e bacon', '',
        'Batata Frita Suprema', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (6.65, UUID_TO_BIN(UUID()), 'DESSERT', 'Sorvete de casquinha da máquina', '', 'Sorvete', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (9.99, UUID_TO_BIN(UUID()), 'DESSERT', 'Bolo de chocolate com sorvete', '', 'Bolo com Sorvete', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (5.99, UUID_TO_BIN(UUID()), 'DRINK', 'Refrigerante de laranja', '', 'Fanta Laranja', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (5.99, UUID_TO_BIN(UUID()), 'DRINK', 'Refrigerante de uva', '', 'Fanta uva', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (5.99, UUID_TO_BIN(UUID()), 'DRINK', 'Refrigerante de cola', '', 'Coca-Cola', 'ACTIVE');

INSERT INTO fiapfoodt.product_entity (price, id, category, description, images, name, status)
VALUES (5.99, UUID_TO_BIN(UUID()), 'DRINK', 'Refrigerante de limao', '', 'Soda', 'ACTIVE');