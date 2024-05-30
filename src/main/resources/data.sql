ALTER TABLE Dish
    ALTER COLUMN ACTIVE SET DEFAULT TRUE;

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('pasta alfredo met kip',
        'paleo',
        '00:20:00',
        'avondmaal',
        '/img/pasta_alfredo.jpg',
        'https://www.youtube.com/embed/CTTsN3QggDc?si=H38FL0DlVetOONCS');

INSERT INTO Ingredient (name, quantity, unit, img_file_name, dish_id)
VALUES ('fettuccine', 75, 'gr', '/img/fettucine.jpg', 1),
       ('roomboter', 22.5, 'gr', '/img/boter.png', 1),
       ('Parmezaanse kaas (geraspt)', 31.25, 'gr', '/img/parmesaan.png', 1),
       ('zwarte peper', 0, NULL, '/img/pepper.jpg', 1),
       ('kipstukjes (vega) (Garden Gourmet)', 62.5, 'gr', '/img/kip.jpg', 1),
       ('knoflook (fijngehakt)', 0.25, 'gr', '/img/knoflook.jpg', 1),
       ('peterselie (gehakt voor garnering)', 0, NULL, '/img/peterselie.jpg', 1),
       ('Kookvocht van de pasta (bewaar een scheut)', 0, NULL, '/img/kookvocht.jpg', 1);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('4 g', '500 mg', '1 g', '15 g', '30 g', '400 gr', '20 g', 1);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Pasta met zalm en spinazie',
        'paleo',
        '00:30:00',
        'avondmaal',
        '/img/pasta_zalm.jpg',
        'https://www.youtube.com/embed/ezNR7bSgPDU?si=3v6LV09oVqGV2Cem');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('tagliatelle', 350, 'gr', 2),
       ('kookroom (light)', 350, 'ml', 2),
       ('verse spinazie', 400, 'gr', 2),
       ('zalmfilet', 400, 'gr', 2),
       ('ui', 1, NULL, 2),
       ('peper en zout', 0, NULL, 2),
       ('cherrytomaatjes', 250, 'gr', 2),
       ('pijnboompitten (geroosterd)', 50, 'gr', 2),
       ('teentjes knoflook', 2, NULL, 2),
       ('olijfolie', 1, 'eetlepel', 2);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('6 g', '500 mg', '1 g', '8 g', '20 g', '400 gr', '30 g', 2);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Spinaziesoep',
        'vegetarisch',
        '00:20:00',
        'avondmaal',
        '/img/spinaziesoep.jpg',
        'https://www.youtube.com/embed/MmJtCXhJTYI?si=QfbKbYg9zpoHv6HM');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('gehakte spinazie (ontdooid)', 450, 'gr', 3),
       ('boter of margarine', 2, 'eetlepels', 3),
       ('ui', 1, NULL, 3),
       ('middelgrote aardappel', 200, 'gr', 3),
       ('water', 1000, 'ml', 3),
       ('groente bouillonblokjes', 2, NULL, 3),
       ('kookroom', 200, 'ml', 3);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('4 g', '600 mg', '1 g', '3 g', '5 g', '100 gr', '10 g', 3);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Spinazie feta bladerdeegrolletjes',
        'vegetarisch',
        '00:25:00',
        'snacks',
        '/img/spinaziebladerdeeg.jpg',
        'https://www.youtube.com/embed/4zJ_ynJ2aRk?si=rTqBHfdBB9l_K4bF');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('vers bladerdeeg', 0, NULL, 4),
       ('feta', 200, 'gr', 4),
       ('verse spinazie', 400, 'gr', 4),
       ('peper', 0, 'snuf', 4),
       ('ei', 1, NULL, 4),
       ('pijnboompitten', 2, 'eetlepels', 4);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('2 g', '200 mg', '1 g', '5 g', '6 g', '150 gr', '15 g', 4);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Glutenvrije pizza',
        'glutenvrij',
        '00:10:00',
        'middagmaal',
        '/img/glutenvrije_pizza.jpg',
        'https://www.youtube.com/embed/SRf0t-RCr98?si=8EoQidsl6g2hhEkL');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('glutenvrije zelfrijzende bakmix (Albert Heijn)', 100, 'gram', 5),
       ('olijfolie', 0, 'scheutje', 5),
       ('water', 1, 'eetlepel', 5),
       ('zout', 0, 'snuf', 5),
       ('bakpoeder', 0.5, 'theelepel', 5),
       ('tomatensaus', 3, 'eetlepels', 5),
       ('zongedroogde tomaten', 3, NULL, 5),
       ('rode paprika', 0.25, NULL, 5),
       ('Italiaanse kruiden', 1, 'eetlepel', 5),
       ('geraspte kaas (vegan)', 20, 'gram', 5),
       ('peper en zout', 0, 'snuf', 5);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('3 g', '200 mg', '3 g', '5 g', '10 g', '250 gr', '30 g', 5);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Snelle cranberry compote',
        'vegan',
        '00:20:00',
        'dessert',
        '/img/cranberry_compote.jpg',
        'https://www.youtube.com/embed/JZLaUvia708?si=nKd_FFJfUT359YkT');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('verse cranberries', 250, 'gr', 6),
       ('balsamico azijn', 2, 'eetlepels', 6),
       ('sinaasappelsap', 100, 'ml', 6),
       ('kaneel', 1, 'snuf', 6),
       ('witte basterdsuiker', 75, 'gr', 6);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('2 g', '50 mg', '8 g', '0.1 g', '0.5 g', '40 gr', '10 g', 6);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Snicker bliss balls',
        'dessert',
        '00:10:00',
        'snacks',
        '/img/snicker_balls.jpg',
        'https://www.youtube.com/embed/ytABtqsUo2g?si=fW8cxH_rCkrqQRwl');

INSERT INTO INGREDIENT(NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('pindakaas', 2, 'eetlepels', 7),
       ('dadels', 13, NULL, 7),
       ('pinda’s', 100, 'gr', 7),
       ('cacao poeder', 3, 'theelepels', 7),
       ('maple syrup', 2, 'eetlepels', 7),
       ('zout', 1, 'snuf', 7);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('3 g', '50 mg', '10 g', '4 g', '6 g', '150 gr', '15 g', 7);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Babi ketjap spiezen',
        'keto',
        '00:50:00',
        'avondmaal',
        '/img/babi_ketjap_spiezen.jpg',
        'https://www.youtube.com/embed/YlZn5YRGLG4?si=hmsLVY-IX_v4l2eL');

INSERT INTO INGREDIENT(NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('varkenslappen', 400, 'gr', 8),
       ('sjalotje', 1, NULL, 8),
       ('teentje knoflook', 1, NULL, 8),
       ('sambal', 0.5, 'theelepel', 8),
       ('ketchup', 3, 'eetlepels', 8),
       ('ketjap', 100, 'ml', 8),
       ('gemalen korianderzaad', 0, NULL, 8),
       ('gemalen gember', 0, NULL, 8),
       ('gebakken uitjes', 0, NULL, 8),
       ('bosui', 0, NULL, 8);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('3 g', '800 mg', '15 g', '10 g', '20 g', '300 gr', '20 g', 8);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Yoghurt met fruit ontbijt',
        'vegetarisch',
        '00:05:00',
        'ontbijt',
        '/img/yoghurt_granola_ontbijt.jpg',
        'https://www.youtube.com/embed/3TgqMjiwFhE?si=7gK1ki3gtySHu0bO');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('Griekse yoghurt (of plantaardige yoghurt)', 500, 'gr', 9),
       ('granola', 40, 'gr', 9),
       ('mango', 1, NULL, 9),
       ('banaan', 1, NULL, 9),
       ('blauwe bessen', 200, 'gr', 9),
       ('hennepzaad', 2, 'eetlepels', 9);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('2 g', '80 mg', '20 g', '4 g', '5 g', '200 gr', '30 g', 9);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Pompoensoep',
        'veganistisch',
        '00:30:00',
        'avondmaal',
        '/img/pompoensoep.jpg',
        'https://www.youtube.com/embed/-s9sdXVV5cg?si=fOLi8ftAIkIctD7Q');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('Pompoen', 500, 'gr', 10),
       ('Ui', 100, 'gr', 10),
       ('Knoflook', 2, 'tenen', 10),
       ('Groentebouillon', 500, 'ml', 10),
       ('Kokosmelk', 200, 'ml', 10),
       ('Nootmuskaat', 1, 'snufje', 10);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('3 g', '500 mg', '5 g', '2 g', '6 g', '30 g', '4 g', 10);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Kip Caesar Salade',
        'glutenvrij',
        '00:20:00',
        'middagmaal',
        '/img/kipcaesarsalade.jpg',
        'https://www.youtube.com/embed/DPio7tGzOgU?si=GApY0fmuN2W1g5xd');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('Kipfilet', 200, 'gr', 11),
       ('Romeinse sla', 150, 'gr', 11),
       ('Caesar dressing', 50, 'ml', 11),
       ('Parmezaanse kaas', 30, 'gr', 11),
       ('Glutenvrije croutons', 30, 'gr', 11);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('2 g', '600 mg', '3 g', '5 g', '15 g', '18 g', '25 g', 11);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Linzensalade met Geitenkaas',
        'vegetarisch',
        '00:25:00',
        'middagmaal',
        '/img/linzen_salade_met_geitenkaas.jpg',
        'https://www.youtube.com/embed/cArBwqq6ALs?si=r67f2tsyUWg0TCJu');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('Groene linzen', 200, 'gr', 12),
       ('Tomaten', 150, 'gr', 12),
       ('Komkommer', 100, 'gr', 12),
       ('Rode ui', 50, 'gr', 12),
       ('Verse peterselie', 10, 'gr', 12),
       ('Geitenkaas', 50, 'gr', 12),
       ('Olijfolie', 20, 'ml', 12),
       ('Citroensap', 10, 'ml', 12);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('7 g', '320 mg', '4 g', '6 g', '10 g', '40 g', '18 g', 12);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Gegrilde Zalm met Asperges',
        'pescotarisch',
        '00:20:00',
        'avondmaal',
        '/img/gegrildezalmasperges.jpg',
        'https://www.youtube.com/embed/5oBOsumL8Uo?si=xiqoZz7gLzzITKJi');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('Zalmfilets', 200, 'gr', 13),
       ('Asperges', 200, 'gr', 13),
       ('Olijfolie', 10, 'ml', 13),
       ('Citroen', 0.5, 'stuks', 13);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('3 g', '75 mg', '2 g', '3 g', '10 g', '5 g', '23 g', 13);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Veganistische Burger',
        'vegan',
        '00:15:00',
        'avondmaal',
        '/img/veganburger.jpg',
        'https://www.youtube.com/embed/IXqseoFJBg0?si=aECQVzH7fzJeQYaM');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('Zwarte bonen', 150, 'gr', 14),
       ('Quinoa', 100, 'gr', 14),
       ('Specerijen', 5, 'gr', 14),
       ('Volkoren broodje', 1, 'stuks', 14),
       ('Sla', 30, 'gr', 14),
       ('Tomaat', 50, 'gr', 14),
       ('Veganistische mayonaise', 20, 'ml', 14);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('6 g', '460 mg', '5 g', '1 g', '8 g', '35 g', '10 g', 14);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Zoete Aardappel Curry',
        'vegan',
        '00:35:00',
        'avondmaal',
        '/img/zoete_aardappel_curry.jpg',
        'https://www.youtube.com/embed/aRL-v5pOlPg?si=wBNxvZtw_Eoue2Ux');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('Zoete aardappel', 300, 'gr', 15),
       ('Currypasta', 30, 'gr', 15),
       ('Kokosmelk', 200, 'ml', 15),
       ('Kikkererwten', 150, 'gr', 15),
       ('Spinazie', 100, 'gr', 15),
       ('Basmatirijst', 150, 'gr', 15),
       ('Koriander', 10, 'gr', 15);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('5 g', '380 mg', '6 g', '5 g', '10 g', '50 g', '12 g', 15);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Ontbijt Burrito',
        'vegetarisch',
        '00:15:00',
        'ontbijt',
        '/img/ontbijt_burrito.jpg',
        'https://www.youtube.com/embed/yNp5PHHgMS0?si=mVY92RCeTUG3L9PH');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('Eieren', 2, 'stuks', 16),
       ('Zwarte bonen', 50, 'gr', 16),
       ('Kaas', 30, 'gr', 16),
       ('Paprika', 50, 'gr', 16),
       ('Volkoren tortilla', 1, 'stuks', 16);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('6 g', '550 mg', '2 g', '6 g', '15 g', '45 g', '22 g', 16);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Quinoa Salade met Avocado',
        'vegan',
        '00:20:00',
        'middagmaal',
        '/img/quinoa_salade_avocado.jpg',
        'https://www.youtube.com/embed/OQ9mU_zAtEs?si=XWlWDdHHeMLLjChx');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('Quinoa', 150, 'gr', 17),
       ('Avocado', 1, 'stuks', 17),
       ('Komkommer', 100, 'gr', 17),
       ('Tomaat', 100, 'gr', 17),
       ('Rode ui', 50, 'gr', 17),
       ('Verse koriander', 10, 'gr', 17),
       ('Limoen', 1, 'stuks', 17),
       ('Olijfolie', 20, 'ml', 17);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('7 g', '100 mg', '3 g', '2 g', '12 g', '45 g', '8 g', 17);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Mediterrane Pasta',
        'vegetarisch',
        '00:25:00',
        'avondmaal',
        '/img/mediterrane_pasta.jpg',
        'https://www.youtube.com/embed/EUu90_qILH4?si=fVVTqAt6fVcZe_y0');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('Volkorenpasta', 200, 'gr', 18),
       ('Olijven', 50, 'gr', 18),
       ('Zongedroogde tomaten', 50, 'gr', 18),
       ('Artisjokharten', 100, 'gr', 18),
       ('Feta', 50, 'gr', 18),
       ('Olijfolie', 20, 'ml', 18),
       ('Knoflook', 2, 'tenen', 18),
       ('Basilicum', 5, 'gr', 18);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('2 g', '80 mg', '20 g', '4 g', '5 g', '200 g', '30 g', 18);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Garnalencocktail',
        'pescotarisch',
        '00:10:00',
        'snacks',
        '/img/garnalencocktail.jpg',
        'https://www.youtube.com/embed/fcyxWiHAfW8?si=QGT0SyZS44al8TZO');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('Gekookte garnalen', 150, 'gr', 19),
       ('Cocktailsaus', 50, 'ml', 19),
       ('Sla', 50, 'gr', 19),
       ('Citroen', 0.5, 'stuks', 19);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('1 g', '850 mg', '4 g', '0 g', '2 g', '6 g', '20 g', 19);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, VIDEO_URL)
VALUES ('Fruitsalade met Munt',
        'vegan',
        '00:10:00',
        'dessert',
        '/img/fruitsalade_munt.jpg',
        'https://www.youtube.com/embed/Qw498kjEeTE?si=RqTawGtZHvYiecmJ');

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES ('Meloen', 200, 'gr', 20),
       ('Bessen', 100, 'gr', 20),
       ('Druiven', 100, 'gr', 20),
       ('Munt', 10, 'gr', 20),
       ('Honing of agavesiroop', 20, 'ml', 20);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES ('4 g', '10 mg', '24 g', '0 g', '1 g', '55 g', '2 g', 20);


-- INSERT INTO DISH_NUTRITIONS(DISH_ID,NUTRITIONS_ID)
-- VALUES
--     (1,1),
--     (2,2),
--     (3,3),
--     (4,4),
--     (5,5),
--     (6,6),
--     (7,7),
--     (8,8),
--     (9,9);


INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
VALUES ('admin', '$2a$10$9MIX8kYPkuB7uE/H5nHF8.KG6.YdjBA/voOnjSZnZDxLXL/2BIerS', true);
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
VALUES ('admin', 'ADMIN');
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
VALUES ('stefferke', '$2a$10$a3/jTRNSkn0Rt/vENxt8.u2pxbJtWV8f1li3QmrIGt/C5RQ2R1wpG', true);
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
VALUES ('stefferke', 'USER');
INSERT INTO "PUBLIC"."CHEF" (USERNAME, NAME, SURNAME, EMAIL)
VALUES ('stefferke', 'stefferke', 'coulson', 'stefferke@stefferke.com');
INSERT INTO "PUBLIC"."CHEF" (USERNAME, NAME, SURNAME, EMAIL)
VALUES ('admin', 'admin', '', 'admin@appetito.com');

ALTER TABLE Beverage
    ALTER COLUMN ACTIVE SET DEFAULT TRUE;

INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('Coca Cola', '/img/Cola.jpg');
INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('Sprite', '/img/Sprite.jpg');
INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('Ice-Tea', '/img/Lipton_Ice_Tea.jpg');
INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('Cappuccino', '/img/Cappucciono.jpg');
INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('Latte', '/img/Latte.webp');
INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('Macchiato', '/img/Macchiato.jpg');
INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('Duvel', '/img/Duvel_666.jpg');
INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('Jupiler', '/img/Jupiler.jpg');
INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('La Chouffe', '/img/La_Chouffe.jpg');
INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('Leffe', '/img/Leffe.jpg');
INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('Chardonnay', '/img/Chardonnay.webp');
INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('Bordeaux', '/img/Bordeaux.jpg');
INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('Twinings English Breakfast', '/img/Twinings_English_Breakfast.webp');
INSERT INTO BEVERAGE (NAME, IMG_FILE)
VALUES ('PG tips', '/img/PG_Tips.webp');

INSERT INTO DISH_BEVERAGES (DISHES_ID, BEVERAGES_ID)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 8),
       (1, 11),
       (2, 1),
       (2, 2),
       (2, 3),
       (2, 11),
       (3, 1),
       (3, 2),
       (3, 3),
       (3, 13),
       (3, 14),
       (4, 4),
       (4, 5),
       (4, 6),
       (4, 13),
       (4, 14),
       (5, 1),
       (5, 2),
       (5, 3),
       (5, 8),
       (6, 13),
       (6, 14),
       (7, 4),
       (7, 5),
       (7, 11),
       (8, 3),
       (8, 7),
       (8, 13),
       (9, 13),
       (9, 14),
       (10, 1),
       (10, 12),
       (11, 4),
       (11, 5),
       (11, 11),
       (12, 2),
       (12, 8),
       (12, 14),
       (13, 3),
       (13, 7),
       (13, 13),
       (13, 6),
       (14, 7),
       (14, 3),
       (15, 9),
       (15, 11),
       (16, 6),
       (16, 10),
       (16, 1),
       (17, 1),
       (17, 14),
       (18, 13),
       (18, 2),
       (18, 5),
       (19, 3),
       (19, 12),
       (20, 9),
       (20, 11),
       (20, 2),
       (20, 8);

--     INSERT INTO FAVORITE_DISHES (DISH_ID, CHEF_ID)
-- VALUES
-- (1, 1);


INSERT INTO GROCERY (CHEF_ID)
VALUES (2),
       (1);

INSERT INTO GROCERY_INGREDIENTS (GROCERY_ID, INGREDIENTS_ID)
VALUES (1, 1);


INSERT INTO Step (description, image, dish_id)
VALUES ('Begin met het koken van de fettuccine volgens de aanwijzingen op de verpakking. Vergeet niet een kopje van het kookvocht te bewaren voordat je de pasta afgiet.',
        '/img/pasta_alfredo_stap1.jpg', 1),
       ('Terwijl de pasta kookt, kruid je de kipstukjes naar smaak en bak je ze in een aparte pan tot ze volledig gaar en goudbruin zijn. Zet de kip even opzij.',
        '/img/pasta_alfredo_stap2.jpg', 1),
       ('Smelt de roomboter in een diepe pan op middelhoog vuur. Voeg het fijngehakte teentje knoflook toe en laat het een minuutje zachtjes bakken, zodat de smaken goed vrijkomen.',
        '/img/pasta_alfredo_stap3.jpg', 1),
       ('Voeg de gekookte fettuccine toe aan de pan met gesmolten boter en knoflook. Giet er een goed scheutje van het bewaarde kookvocht bij om de saus smeuïg te maken.',
        '/img/pasta_alfredo_stap4.jpg', 1),
       ('Strooi de geraspte Parmezaanse kaas over de pasta en roer alles goed door elkaar totdat de kaas volledig is gesmolten en een romige saus vormt.',
        '/img/pasta_alfredo_stap5.jpg', 1),
       ('Voeg nu de gebakken kipstukjes toe aan de pan en meng alles goed door elkaar. Breng op smaak met zwarte peper.',
        '/img/pasta_alfredo_stap6.jpg', 1),
       ('Serveer de pasta alfredo op borden en garneer met de gehakte peterselie voor een frisse touch.',
        '/img/pasta_alfredo.jpg', 1);

INSERT INTO Step (description, dish_id)
VALUES ('Kook de pasta volgens verpakking beetgaar. Snipper ondertussen de ui en de teentjes knoflook fijn. Bak deze glazig in een grote hapjes of wokpan in een eetlepel olie.',
        2),
       ('Halveer de tomaatjes en meng deze met de zalm en spinazie. Verwarm een paar minuten door en voeg dan de tagliatelle toe. Mix alles door elkaar en schep op borden. Bestrooi met geroosterde pijnboompitten.',
        2);
INSERT INTO Step (description, dish_id, image)
VALUES ('Voeg de zalm toe en bak rondom aan, steek met een spatel in stukken. Voeg dan in etappes de spinazie toe totdat deze wat geslonken is. Schenk de kookroom erbij en breng op maak met flink wat peper en zout.',
        2, '/img/Pasta met zalm en spinazie_stap1.jpg');

INSERT INTO Step (description, dish_id)
VALUES ('Snijd de ui fijn en bak in een pan met boter glazig.', 3),
       ('Snijd de aardappel in blokjes. Voeg de aardappel en ontdooide spinazie toe aan de ui.', 3),
       ('Giet het water erbij, breng aan de kook en verkruimel de bouillonblokjes boven de pan. Laat alles 10 min zachtjes doorkoken.',
        3),
       ('Pureer de soep met een staafmixer tot een gladde groene massa.', 3),
       ('Roer de room erdoor.', 3),
       ('Serveer de soep in borden of kommen en garneer eventueel met wat extra room, pijnboompitten en waterkers.', 3);

INSERT INTO Step (description, dish_id)
VALUES ('Verwarm de oven voor op 200° graden.', 4),
       ('Bak de spinazie in een grote pan tot deze geslonken is. Je kunt ook eventueel spinazie uit de diepvries ontdooien.',
        4),
       ('Laat de spinazie goed uitlekken en druk met de bolle kant van een lepel zo veel mogelijk vocht eruit.', 4),
       ('Breng de spinazie op smaak met een flinke snuf peper.', 4),
       ('Rol het bladerdeeg uit.', 4),
       ('Verdeel de spinazie over het bladerdeeg en kruimel hier de feta in kleine stukjes over.', 4),
       ('Bestrooi met wat pijnboompitten.', 4),
       ('Rol het bladerdeeg voorzichtig op.', 4),
       ('Snijd met een scherp mes de rol in plakjes. Is dit lastig? Dan kun je de rol een half uurtje in de koelkast leggen zodat hij wat opstijft.',
        4),
       ('Leg de plakjes op een bakplaat met bakpapier en bestrijk met een los geklopt ei.', 4),
       ('Bak de rolletjes 15 tot 20 minuten in de oven totdat ze goudbruin zijn.', 4);

INSERT INTO Step (description, dish_id)
VALUES ('Verwarm de oven voor op 225° graden.', 5),
       ('Meng het meel, olijfolie, zout, bakpoeder en water. Kneed dit tot dat er een mooie bal ontstaat. Als het te droog is kun je een klein beetje extra water toevoegen.',
        5),
       ('Verdeel wat glutenvrij meel over het aanrecht of gebruik bakpapier en rol het deeg uit tot een platte cirkel.',
        5),
       ('Verdeel de tomatensaus met een lepel over de pizza.', 5),
       ('Snijd de paprika en zongedroogde tomaten en leg deze vervolgens op de tomatensaus.', 5),
       ('Strooi de Italiaanse kruiden, geraspte kaas en een snuf peper en zout hier overheen.', 5),
       ('Bak de pizza voor 15 minuten op 225° graden.', 5);

INSERT INTO Step (description, dish_id)
VALUES ('Verwarm het sinaasappelsap met de basterdsuiker in een pannetje.', 6),
       ('Voeg de balsamico azijn en een snuf kaneel toe.', 6),
       ('Voeg dan de cranberries toe en breng zachtjes aan de kook.', 6),
       ('Roer af en toe door en wacht tot de cranberries zacht worden en uit elkaar vallen, waardoor er een saus ontstaat. Dit duurt ongeveer 15 minuten.',
        6);

INSERT INTO Step (description, dish_id)
VALUES ('Als de dadels hard zijn, laat je ze even weken in een schaal met water. Als ze goed zacht zijn, is dit niet nodig.',
        7),
       ('Doe de pinda’s in een keukenmachine en maal ze tot kleinere stukjes. Haal ze er daarna weer uit.', 7),
       ('Doe vervolgens de dadels in de keukenmachine en maal ze fijn.', 7),
       ('Voeg de gemalen pinda’s, pindakaas, maple syrup, cacao poeder en snuf zout toe aan de dadels in de keukenmachine.',
        7),
       ('Meng alles goed totdat het een samenhangend mengsel vormt.', 7),
       ('Maak met je handen balletjes van het mengsel.', 7),
       ('Bewaar de balletjes het beste in de koelkast.', 7);

INSERT INTO Step (description, dish_id)
VALUES ('Begin met het koken van de fettuccine volgens de aanwijzingen op de verpakking. Vergeet niet een kopje van het kookvocht te bewaren voordat je de pasta afgiet.',
        8),
       ('Terwijl de pasta kookt, kruid je de kipstukjes naar smaak en bak je ze in een aparte pan tot ze volledig gaar en goudbruin zijn. Zet de kip even opzij.',
        8),
       ('Smelt de roomboter in een diepe pan op middelhoog vuur. Voeg het fijngehakte teentje knoflook toe en laat het een minuutje zachtjes bakken, zodat de smaken goed vrijkomen.',
        8),
       ('Voeg de gekookte fettuccine toe aan de pan met gesmolten boter en knoflook. Giet er een goed scheutje van het bewaarde kookvocht bij om de saus smeuïg te maken.',
        8),
       ('Strooi de geraspte Parmezaanse kaas over de pasta en roer alles goed door elkaar totdat de kaas volledig is gesmolten en een romige saus vormt.',
        8),
       ('Voeg nu de gebakken kipstukjes toe aan de pan en meng alles goed door elkaar. Breng op smaak met zwarte peper.',
        8),
       ('Serveer de pasta alfredo op borden en garneer met de gehakte peterselie voor een frisse touch.', 8);

INSERT INTO Step (description, dish_id)
VALUES ('Begin met het koken van de fettuccine volgens de aanwijzingen op de verpakking. Vergeet niet een kopje van het kookvocht te bewaren voordat je de pasta afgiet.',
        9),
       ('Terwijl de pasta kookt, kruid je de kipstukjes naar smaak en bak je ze in een aparte pan tot ze volledig gaar en goudbruin zijn. Zet de kip even opzij.',
        9),
       ('Smelt de roomboter in een diepe pan op middelhoog vuur. Voeg het fijngehakte teentje knoflook toe en laat het een minuutje zachtjes bakken, zodat de smaken goed vrijkomen.',
        9),
       ('Voeg de gekookte fettuccine toe aan de pan met gesmolten boter en knoflook. Giet er een goed scheutje van het bewaarde kookvocht bij om de saus smeuïg te maken.',
        9),
       ('Strooi de geraspte Parmezaanse kaas over de pasta en roer alles goed door elkaar totdat de kaas volledig is gesmolten en een romige saus vormt.',
        9),
       ('Voeg nu de gebakken kipstukjes toe aan de pan en meng alles goed door elkaar. Breng op smaak met zwarte peper.',
        9),
       ('Serveer de pasta alfredo op borden en garneer met de gehakte peterselie voor een frisse touch.', 9);

INSERT INTO Step (description, dish_id)
VALUES ('Snijn een pompoen in blokjes en kook deze in een pan met water tot ze zacht zijn.', 10),
       ('Giet de pompoenblokjes af en pureer ze met een staafmixer tot een gladde puree.', 10),
       ('Voeg de pompoenpuree toe aan een pan en voeg de groentebouillon toe.', 10),
       ('Voeg de kokosmelk, nootmuskaat, peper en zout toe en laat de soep 10 minuten zachtjes koken.', 10),
       ('Serveer de soep in kommen en garneer met een scheutje kokosmelk en een snufje nootmuskaat.', 10);

INSERT INTO Step (description, dish_id)
VALUES ('Grill kipfilet en snijd in plakjes.', 11),
       ('Meng Romeinse sla met Caesar dressing en voeg de kip toe.', 11),
       ('Bestrooi met Parmezaanse kaas en voeg glutenvrije croutons toe.', 11);

INSERT INTO Step (description, dish_id)
VALUES ('Kook groene linzen gaar.', 12),
       ('Meng met gehakte tomaten, komkommer, rode ui, en verse peterselie.', 12),
       ('Voeg geitenkaas en een dressing van olijfolie en citroensap toe.', 12);

INSERT INTO Step (description, dish_id)
VALUES ('Kruid zalmfilets en gril tot ze gaar zijn.', 13),
       ('Gril asperges in olijfolie tot ze knapperig zijn.', 13),
       ('Serveer de zalm met een schijfje citroen en de asperges.', 13);

INSERT INTO Step (description, dish_id)
VALUES ('Maak een burger van zwarte bonen, quinoa en specerijen.', 14),
       ('Bak de burger in een pan tot beide kanten goudbruin zijn.', 14),
       ('Serveer op een volkoren broodje met sla, tomaat, en veganistische mayonaise.', 14);

INSERT INTO Step (description, dish_id)
VALUES ('Kook zoete aardappelblokjes in een pan met currypasta en kokosmelk.', 15),
       ('Voeg kikkererwten en spinazie toe en laat sudderen.', 15),
       ('Serveer met basmatirijst en garneer met koriander.', 15);

INSERT INTO Step (description, dish_id)
VALUES ('Bak roerei en meng met zwarte bonen, kaas, en gehakte paprika.', 16),
       ('Vul een volkoren tortilla met het ei-mengsel.', 16),
       ('Rol de tortilla op en bak kort in een hete pan.', 16);

INSERT INTO Step (description, dish_id)
VALUES ('Kook quinoa en laat afkoelen.', 17),
       ('Meng met blokjes avocado, komkommer, tomaat, en rode ui.', 17),
       ('Voeg een limoen-olijfolie dressing toe en garneer met verse koriander.', 17);

INSERT INTO Step (description, dish_id)
VALUES ('Kook volkorenpasta al dente.', 18),
       ('Meng met olijven, zongedroogde tomaten, artisjokharten, en feta.', 18),
       ('Voeg een dressing van olijfolie, knoflook, en basilicum toe.', 18);

INSERT INTO Step (description, dish_id)
VALUES ('Meng gekookte garnalen met een zelfgemaakte cocktailsaus.', 19),
       ('Serveer in een cocktailglas met gehakte slabladeren en een schijfje citroen.', 19);

INSERT INTO Step (description, dish_id)
VALUES ('Snijd diverse soorten fruit zoals meloen, bessen, en druiven.', 20),
       ('Meng het fruit met fijngesneden munt en een beetje honing of agavesiroop.', 20),
       ('Koel voor het serveren om de smaken te laten mengen.', 20);

INSERT INTO Footer (id, street, city, country, postal_code, phone, email)
VALUES (1, 'Koning Albertstraat 1', 'Antwerpen', 'België', '2000', '+32 3 123 45 67', 'admin@appetito.com');


INSERT INTO MENU (NAME, ACTIVE, NUMBER_OF_PEOPLE, chef_id, description)
VALUES
    ('Kerstmenu', TRUE, 6, 2, 'Een feestelijk kerstmenu met klassieke gerechten zoals spinaziesoep, Snicker bliss balls en  cranberry compote, perfect voor een gezellige avond met familie en vrienden.'),
    ('Paasmenu', TRUE, 4, 2, 'Geniet van een heerlijk Paasmenu met gerechten zoals burrito, zoete aardappel Curry en een frisse lente salade. Perfect om samen Pasen te vieren.'),
    ('Zomerse gerechten', TRUE, 1, 2, 'Verfrissende en lichte zomerse gerechten. Ideaal voor warme dagen.'),
    ('Gezonde maaltijden', TRUE, 1, 2, 'Gezonde en voedzame maaltijden met verse ingrediënten!');


INSERT INTO MENU_DAY (DAY_NUMBER, MENU_ID)
VALUES (1, 1),
       (2, 1),
       (1, 2),
         (2, 2),
         (5, 3),
         (6, 3),
         (7, 4);

INSERT INTO MENU_DAY_DISHES (MENU_DAY_ID, DISHES_ID)
VALUES (1, 3),
       (1, 7),
       (1, 8),
       (1, 6),
       (2, 5),
       (3, 17),
       (5, 11),
       (7, 9),
       (7, 11),
       (3, 16),
       (3, 15),
       (4, 11),
       (6, 9);


INSERT INTO RATING (rating, dish_id)
VALUES (5, 3),
       (3, 2),
       (2, 1),
       (4, 4),
       (5, 5),
       (5, 6),
       (5, 4),
       (4, 7),
       (4, 8),
       (5, 9),
       (1, 10),
       (3, 11),
       (4, 11),
       (5, 11),
       (1, 12),
       (1, 13),
       (2, 14),
       (2, 15),
       (3, 16),
       (5, 17),
       (2, 18),
       (1, 19),
       (3, 20);

INSERT INTO BASIC(IMAGE,ACTION,DESCRIPTION)
VALUES ('/img/snijden.jpg','Snijden','hoe moet je snijden?');

INSERT INTO TECHNIQUE(NAME,TECHNIQUE_DESCRIPTION,IMAGE,BASIC_ID)
VALUES ('Julienne (Luciferhoutjes','Deze techniek wordt gebruikt om groenten in dunne, lange reepjes te snijden, ongeveer de grootte van luciferhoutjes. Het is ideaal voor salades, roerbakgerechten en garnituren.',null,1),
    ('Brunoise (Blokvormig)','Een brunoise is een dobbelsteensnede, meestal 3 mm x 3 mm. Deze techniek wordt vaak gebruikt voor soepen, sauzen, of als een fijne garnituur.',null,1),
    ('Chiffonade (Fijne reepjes)','Deze snijtechniek is ideaal voor bladgroenten en kruiden. ' ||
    'De bladeren worden opgestapeld, opgerold en dan in zeer dunne reepjes gesneden. ' ||
    'Dit wordt vaak gebruikt om soepen, salades en andere gerechten te garneren.',null,1),
    ('Diceren (in blokjes snijden','Groter dan brunoise, meestal 1 cm x 1 cm, deze snede is goed voor stoofschotels, salades, en wanneer grotere stukjes gewenst zijn.',null,1),
    ('Mincen (fijnhakken','Dit is het fijnhakken van ingrediënten tot ze zeer klein zijn, vaak gebruikt voor kruiden, knoflook of uien waar je wilt dat de smaak goed verdeeld wordt door het gerecht zonder grote stukjes.',null,1);

INSERT INTO BASIC(IMAGE,ACTION,DESCRIPTION)
VALUES ('/img/bakken.jpg','Bakken','hoe moet je bakken?');

INSERT INTO TECHNIQUE(NAME,TECHNIQUE_DESCRIPTION,IMAGE,BASIC_ID)
VALUES ('Sauteren','Sauteren houdt in dat je ingrediënten snel bakt op relatief ' ||
                   'hoge temperatuur met een kleine hoeveelheid vet (olie of boter).' ||
                   ' Het doel is om de ingrediënten bruin en knapperig te krijgen aan de ' ||
                   'buitenkant terwijl ze binnenin sappig blijven. Groenten blijven helder en' ||
                   ' enigszins knapperig, en vlees wordt mooi bruin en sappig.',null,2),
    ('Pan-frying (panbakken)','Deze techniek is vergelijkbaar met sauteren, maar gebruikt meer vet en een iets lagere temperatuur, ' ||
                              'waardoor de ingrediënten meer tijd hebben om te garen. ' ||
                              'Het is ideaal voor iets dikkere stukken vlees of groenten.',null,2),
    ('Roerbakken','Roerbakken is een techniek die snel koken op hoge temperatuur combineert, ' ||
                  'meestal in een wok, waarbij de ingrediënten constant worden bewogen. ' ||
                  'Dit zorgt ervoor dat alles gelijkmatig kookt en hun crunch behoudt.',null,2),
    ('Deep-frying (frituren)','Bij diep frituren worden de ingrediënten volledig ondergedompeld in hete olie. ' ||
                              'Dit zorgt voor een snel en gelijkmatig gaar proces, wat resulteert ' ||
                              'in een krokant buitenlaagje terwijl de binnenkant zacht en sappig blijft.',null,2),
    ('Stir-frying','Dit is een snelle kookmethode waarbij ingrediënten in een zeer hete pan worden gebakken met een klein beetje olie. ' ||
                   'Ingrediënten worden snel en continu bewogen, vergelijkbaar met roerbakken ' ||
                   'maar vaak met nog hogere snelheid en hitte voor een zeer snelle bereiding.',null,2);

INSERT INTO BASIC(IMAGE,ACTION,DESCRIPTION)
VALUES ('/img/koken.jpg','Koken','hoe moet je koken?');

INSERT INTO TECHNIQUE(NAME,TECHNIQUE_DESCRIPTION,IMAGE,BASIC_ID)
VALUES ('Boiling','Dit is waarschijnlijk de meest basale vorm van koken. ' ||
                  'Je brengt een pot met water (of een andere vloeistof) ' ||
                  'aan de kook en voegt voedsel toe, zoals pasta, granen, of groenten. ' ||
                  'Het koken is effectief voor het gaar maken van voedsel door het te onderdompelen ' ||
                  'in kokend water.',null,3),
    ('Simmering','Stoven is vergelijkbaar met koken, maar gebeurt op een veel lagere temperatuur, ' ||
                 'net onder het kookpunt. Deze methode is ideaal voor het langzaam garen van voedsel,' ||
                 ' wat helpt om de smaken te ontwikkelen zonder het voedsel te overgaren. ',null,3),
    ('Poaching','Bij pocheren worden ingrediënten gegaard in een zacht kokende vloeistof die net niet het kookpunt bereikt. ' ||
                'Deze methode is bijzonder goed voor delicate voedingsmiddelen zoals eieren, ' ||
                'vis, of fruit, omdat het zachtjes gaart zonder de structuur te beschadigen.',null,3),
    ('Blanching','Blancheren is een kooktechniek waarbij voedsel kort wordt gekookt in kokend water en vervolgens ' ||
                 'onmiddellijk wordt afgekoeld in ijswater. Het wordt vaak gebruikt om groenten te koken ' ||
                 'voordat ze worden ingevroren of om de huid van fruit te verwijderen.',null,3),
    ('Steaming','Stomen gebruikt de stoom van kokend water om voedsel te garen. Dit is een zeer gezonde kookmethode omdat er geen vet nodig is ' ||
                'en de meeste voedingsstoffen in het voedsel behouden blijven. ' ||
                'Het is ideaal voor groenten, vis en zelfs sommige desserts.',null,3);

INSERT INTO BASIC(IMAGE,ACTION,DESCRIPTION)
VALUES ('/img/stomen.jpg','Stomen','hoe moet je stomen?');

INSERT INTO TECHNIQUE(NAME,TECHNIQUE_DESCRIPTION,IMAGE,BASIC_ID)
VALUES ('Traditioneel stomen','Bij deze basisvorm van stomen plaats je het voedsel in een stoommandje ' ||
                              'boven kokend water in een pot of wok. De deksel wordt op de pot ' ||
                              'geplaatst om de stoom binnen te houden. Dit is ideaal voor groenten, ' ||
                              'vis, en zelfs voor het koken van rijst.',null,4),
    ('Stomen met aromas','Deze techniek voegt extra smaak toe aan het voedsel door kruiden, specerijen, ' ||
                         'of aromatische vloeistoffen zoals wijn of kokosmelk aan ' ||
                         'het kookwater toe te voegen. De stoom draagt de aroma''s ' ||
                         'naar het voedsel terwijl het gaart.',null,4),
    ('Stomen in bananenblad','Deze traditionele methode wordt vaak gebruikt in de Aziatische keuken. ' ||
                              'Voedsel wordt gewikkeld in bananenbladeren en gestoomd, wat een ' ||
                              'unieke smaak en textuur aan het gerecht geeft.',null,4),
    ('Stomen in papillot','Bij deze methode wordt het voedsel samen met smaakmakers zoals kruiden, boter, en specerijen in bakpapier of aluminiumfolie verpakt. ' ||
                          'Het pakketje wordt dan in de oven geplaatst, waar de inhoud ' ||
                          'door de eigen sappen en de toegevoegde vloeistoffen gaart.',null,4),
    ('Stomen in een stoomoven','Stoomovens zijn speciale apparaten die voedsel garen met behulp van stoom. ' ||
                               'Deze ovens zijn ideaal voor het behouden van voedingsstoffen en smaak in het voedsel, ' ||
                               'en zijn vaak uitgerust met verschillende stoomniveaus voor verschillende soorten voedsel.',null,4);




INSERT INTO BASIC(IMAGE,ACTION,DESCRIPTION)
VALUES ('/img/blancheren.jpg','Blancheren','hoe moet je blancheren?');

INSERT INTO TECHNIQUE(NAME,TECHNIQUE_DESCRIPTION,IMAGE,BASIC_ID)
VALUES ('Standaard Blancheren','Bij deze techniek breng je een grote pot water snel aan de kook, ' ||
                    'voegt zout toe en dompelt dan de voedselitems kort onder in het ' ||
                    'kokende water. De tijd varieert afhankelijk van het soort voedsel, ' ||
                    'maar meestal gaat het om enkele minuten voor groenten. ' ||
                    'Daarna haal je het voedsel snel uit het kokende water en ' ||
                    'dompel je het onder in ijswater om het kookproces te stoppen.',null,5),
    ('Blancheren met soda','Een snufje bakingsoda toevoegen aan het kokende water kan helpen ' ||
                           'de heldere kleur van sommige groenten, zoals groene bonen en erwten, ' ||
                           'te behouden. Wees echter voorzichtig met deze methode, want te veel ' ||
                           'soda kan de structuur van de groente verzachten en de smaak beïnvloeden.',null,5),
    ('Blancheren voor invriezen','Blancheren is een belangrijke stap bij het invriezen van groenten. ' ||
                                  'Door groenten kort te blancheren voordat je ze invriest, ' ||
                                  'blijven ze langer vers en behouden ze hun smaak en voedingsstoffen. ' ||
                                  'Na het blancheren, laat je de groenten uitlekken en drogen voordat je ze invriest.',null,5),
    ('Blancheren voor het koken','Sommige recepten vereisen dat je groenten eerst blancheert voordat je ze ' ||
                                  'verder kookt. Dit helpt om de groenten voor te bereiden en ' ||
                                  'hun kleur en textuur te behouden tijdens het koken.',null,5),
    ('Blancheren voor het schillen','Blancheren is een handige techniek om de schil van sommige groenten ' ||
                                    'zoals tomaten, paprika''s, of amandelen gemakkelijker te verwijderen. ' ||
                                    'Door de groenten kort te blancheren, wordt de schil losser en ' ||
                                    'kun je deze gemakkelijk verwijderen.',null,5);



INSERT INTO BASIC(IMAGE,ACTION,DESCRIPTION)
VALUES ('/img/grillen.jpg','Grillen','hoe moet je grillen?');

INSERT INTO TECHNIQUE(NAME,TECHNIQUE_DESCRIPTION,IMAGE,BASIC_ID)
VALUES ('Direct grillen','Bij direct grillen wordt het voedsel rechtstreeks boven de warmtebron geplaatst. Dit is ideaal voor het snel koken van dunne stukken vlees, groenten, en andere voedingsmiddelen die snel gaar worden. De hoge temperatuur zorgt voor een mooie grillstreep en een heerlijke korst.',null,6),
    ('Indirect grillen','Bij indirect grillen wordt het voedsel niet direct boven de warmtebron geplaatst, maar aan de zijkant van de grill. Dit is ideaal voor het langzaam garen van grotere stukken vlees, gevogelte, of vis, waarbij de warmte gelijkmatig wordt verdeeld en het voedsel langzaam gaart zonder te verbranden.',null,6),
    ('Grillen met rook','Grillen met rook voegt een extra smaakdimensie toe aan het voedsel door het te roken met houtsnippers of houtskool. Dit is ideaal voor het geven van een rokerige smaak aan vlees, vis, of groenten. Het voedsel wordt langzaam gegaard en krijgt een heerlijke rokerige smaak.',null,6),
    ('Sear-grilling','Deze methode combineert hoge directe hitte aanvankelijk om het voedsel snel dicht ' ||
                 'te schroeien en vervolgens een lagere, indirecte hitte om' ||
                 ' het gaarproces te voltooien. Dit is geweldig voor dikke steaks of' ||
                 ' grotere stukken vlees waarbij je een knapperige buitenkant en een' ||
                 ' sappige, gelijkmatig gegaarde binnenkant wilt.',null,6),
    ('Plankgrillen','Bij plankgrillen wordt het voedsel op een houten plank geplaatst en boven de warmtebron gegrild. ' ||
                  'Dit is ideaal voor het grillen van vis, gevogelte, of groenten, waarbij de plank ' ||
                  'een extra smaakdimensie toevoegt aan het voedsel en voorkomt dat het aanbrandt.',null,6);



INSERT INTO BASIC(IMAGE,ACTION,DESCRIPTION)
VALUES ('/img/roosteren.jpg','Roosteren','hoe moet je roosteren?');

INSERT INTO TECHNIQUE(NAME,TECHNIQUE_DESCRIPTION,IMAGE,BASIC_ID)
VALUES ('Traditioneel roosteren','Bij traditioneel roosteren wordt het voedsel in een voorverwarmde oven ' ||
'geplaatst, vaak op een rooster boven een bakplaat om luchtstroom rondom het voedsel ' ||
'mogelijk te maken. Dit is ideaal voor het gelijkmatig garen van grote stukken vlees, ' ||
'hele kippen, of grote groenten zoals pompoenen.',null,7),

    ('High heat roasting (Roosteren op hoge temperatuur','Deze methode gebruikt een hoge oventemperatuur (220°C of hoger) ' ||
'om het voedsel snel een knapperige korst te geven terwijl de binnenkant ' ||
'sappig blijft. Het is uitstekend geschikt voor groenten en dunner vlees ' ||
'dat baat heeft bij een kortere kooktijd.',null,7),

    ('Low and slow roasting','Dit houdt in dat voedsel op een lagere temperatuur voor een langere periode wordt geroosterd, ' ||
'wat ideaal is voor zeer grote of taaie stukken vlees die tijd nodig hebben' ||
' om mals te worden. Deze methode zorgt voor een zeer gelijkmatige ' ||
'garing en is perfect voor brisket of varkensschouder.',null,7),

('Conventioneel roosteren','Soms begin je met het voedsel op een hogere temperatuur om een mooie korst ' ||
'te krijgen en verlaag je dan de temperatuur om het garen te voltooien. ' ||
'Deze techniek is geweldig voor vlees zoals rosbief of een hele kalkoen.',null,7),

('Roosteren met bedruipen','Bij deze techniek bedruip je het roosterende voedsel regelmatig met zijn eigen sappen of met een marinade. ' ||
'Dit helpt om het voedsel vochtig te houden en voegt extra smaak toe ' ||
'tijdens het kookproces. Het is vooral nuttig voor droger vlees zoals kalkoen.',null,7);



INSERT INTO BASIC(IMAGE,ACTION,DESCRIPTION)
VALUES ('/img/marineren.jpg','Marineren','hoe moet je marineren?');

INSERT INTO TECHNIQUE(NAME,TECHNIQUE_DESCRIPTION,IMAGE,BASIC_ID)
VALUES('Zuur-gebaseerd marineren','Deze marinades bevatten ingrediënten zoals azijn, citroensap, ' ||
          'of wijn die helpen om de eiwitten in het voedsel af te breken, ' ||
          'wat resulteert in malser vlees. Het is belangrijk niet te lang te marineren, ' ||
          'vooral bij zachter vlees of vis, omdat het zuur het voedsel kan "koken" ' ||
          'of te papperig kan maken.',null,8),


('Yoghurt of zuivelgebaseerd marineren','Deze marinades gebruiken de milde zuren in yoghurt of andere zuivelproducten' ||
 ' om het vlees zacht te maken zonder de structuur te beschadigen. ' ||
'Zuivel werkt ook als een geweldige drager voor smaakstoffen en helpt bij het bruinen van het voedsel tijdens het koken.',null,8),

('Droog marineren','Droge marinades, ook bekend als rubs, ' ||
'bestaan uit droge kruiden en specerijen die rechtstreeks op het ' ||
'voedsel worden gewreven. Dit helpt om een rijke korst te vormen ' ||
'tijdens het koken, vooral bij grillen of roosteren.',null,8),

('Emzyn gebaseerd marineren','Sommige marinades bevatten enzymen die natuurlijk voorkomen in ' ||
'bepaalde vruchten zoals ananas, kiwi en papaja. Deze enzymen helpen de eiwitstructuren in het vlees af te breken, ' ||
'waardoor het malser wordt. Net als bij zuur-gebaseerde marinades is het belangrijk om voorzichtig te zijn met de ' ||
'markeertijd om te voorkomen dat het voedsel te zacht wordt.',null,8),

('Zoete Marinades','Marinades die ingrediënten met suiker bevatten, zoals honing, ahornsiroop, of melasse, ' ||
'kunnen helpen om een gecarameliseerde glazuur te vormen op het oppervlak van het voedsel wanneer het wordt gekookt. ' ||
'Deze zijn uitstekend voor het grillen, omdat de suiker helpt om mooie grillmarkeringen en een diepe, rijke smaak te ontwikkelen.',null,8);

