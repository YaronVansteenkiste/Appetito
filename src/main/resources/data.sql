ALTER TABLE Dish
    ALTER COLUMN ACTIVE SET DEFAULT TRUE;

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'pasta alfredo met kip',
           'paleo',
           '00:20:00',
           'avondmaal',
           '/img/pasta_alfredo.jpg',
           '1. Begin met het koken van de fettuccine volgens de aanwijzingen op de verpakking. Vergeet niet een kopje van het kookvocht te bewaren voordat je de pasta afgiet.//'
               '2. Terwijl de pasta kookt, kruid je de kipstukjes naar smaak en bak je ze in een aparte pan tot ze volledig gaar en goudbruin zijn. Zet de kip even opzij.//'
               '3. Smelt de roomboter in een diepe pan op middelhoog vuur. Voeg het fijngehakte teentje knoflook toe en laat het een minuutje zachtjes bakken, zodat de smaken goed vrijkomen.//'
               '4. Voeg de gekookte fettuccine toe aan de pan met gesmolten boter en knoflook. Giet er een goed scheutje van het bewaarde kookvocht bij om de saus smeuïg te maken.//'
               '5. Strooi de geraspte Parmezaanse kaas over de pasta en roer alles goed door elkaar totdat de kaas volledig is gesmolten en een romige saus vormt.//'
               '6. Voeg nu de gebakken kipstukjes toe aan de pan en meng alles goed door elkaar. Breng op smaak met zwarte peper.//'
               '7. Serveer de pasta alfredo op borden en garneer met de gehakte peterselie voor een frisse touch.//'
               '8. Sandra’s tip: Voor een extra portie groen kun je deze heerlijke pasta alfredo serveren met gestoomde broccoli of erwtjes. Zo krijg je meteen je dagelijkse portie groenten binnen!//'
       );

INSERT INTO Ingredient (name, quantity, unit, dish_id,estimated_price)
VALUES
    ('fettuccine', 75, 'gr', 1,2.0),
    ('roomboter', 22.5, 'gr', 1,3.0),
    ('Parmezaanse kaas (geraspt)', 31.25, 'gr', 1,4.50),
    ('zwarte peper', 0, NULL, 1,3.99),
    ('kipstukjes (vega) (Garden Gourmet)', 62.5, 'gr', 1,8.0),
    ('knoflook (fijngehakt)', 0.25, 'gr', 1,7.0),
    ('peterselie (gehakt voor garnering)', 0, NULL, 1,5.0),
    ('Kookvocht van de pasta (bewaar een scheut)', 0, NULL, 1,6.50);



INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES('4 g', '500 mg', '1 g', '15 g', '30 g', '400 gr', '20 g', 1);


INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Pasta met zalm en spinazie',
           'paleo',
           '00:30:00',
           'avondeten',
           '/img/pasta_zalm.jpg',
           '1. Kook de pasta volgens verpakking beetgaar. Snipper ondertussen de ui en de teentjes knoflook fijn. Bak deze glazig in een grote hapjes of wokpan in een eetlepel olie.//'
               '2. Voeg de zalm toe en bak rondom aan, steek met een spatel in stukken. Voeg dan in etappes de spinazie toe totdat deze wat geslonken is. Schenk de kookroom erbij en breng op maak met flink wat peper en zout.//'
               '3. Halveer de tomaatjes en meng deze met de zalm en spinazie. Verwarm een paar minuten door en voeg dan de tagliatelle toe. Mix alles door elkaar en schep op borden. Bestrooi met geroosterde pijnboompitten.//'
       );

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID,ESTIMATED_PRICE)
VALUES
    ('tagliatelle', 350, 'gr', 2,6.99),
    ('kookroom (light)', 350, 'ml', 2,5.99),
    ('verse spinazie', 400, 'gr', 2,4.99),
    ('zalmfilet', 400, 'gr', 2,6.50),
    ('ui', 1, NULL, 2,5.0),
    ('peper en zout', 0, NULL, 2,3.99),
    ('cherrytomaatjes', 250, 'gr', 2,6.99),
    ('pijnboompitten (geroosterd)', 50, 'gr', 2,8.0),
    ('teentjes knoflook', 2, NULL, 2,3.50),
    ('olijfolie', 1, 'eetlepel', 2,7.50);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES('6 g', '500 mg', '1 g', '8 g', '20 g', '400 gr', '30 g', 2);


INSERT INTO DISH ( NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (

           'Spinaziesoep',
           'vegetarisch',
           '00:20:00',
           'avondmaal','/img/spinaziesoep.jpg',
           '1. Snijd de ui fijn en bak in een pan met boter glazig.//'
               '2. Snijd de aardappel in blokjes. Voeg de aardappel en ontdooide spinazie toe aan de ui.//'
               '3. Giet het water erbij, breng aan de kook en verkruimel de bouillonblokjes boven de pan. Laat alles 10 min zachtjes doorkoken.//'
               '4. Pureer de soep met een staafmixer tot een gladde groene massa.//'
               '5. Roer de room erdoor.//'
               '6. Serveer de soep in borden of kommen en garneer eventueel met wat extra room, pijnboompitten en waterkers.//'
       );

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID,ESTIMATED_PRICE)
VALUES
    ('gehakte spinazie (ontdooid)', 450, 'gr', 3,4.50),
    ('boter of margarine', 2, 'eetlepels', 3,4.0),
    ('ui', 1, NULL, 3,4.50),
    ('middelgrote aardappel', 200, 'gr', 3,2.0),
    ('water', 1000, 'ml', 3, 1.50),
    ('groente bouillonblokjes', 2, NULL, 3,6.25),
    ('kookroom', 200, 'ml', 3,5.99);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES('4 g', '600 mg', '1 g', '3 g', '5 g', '100 gr', '10 g', 3);

INSERT INTO DISH ( NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Spinazie feta bladerdeegrolletjes',
           'vegetarisch',
           '00:25:00',
           'snacks','/img/spinaziebladerdeeg.jpg',
           '1. Verwarm de oven voor op 200° graden.//'
               '2. Bak de spinazie in een grote pan tot deze geslonken is. Je kunt ook eventueel spinazie uit de diepvries ontdooien.//'
               '3. Laat de spinazie goed uitlekken en druk met de bolle kant van een lepel zo veel mogelijk vocht eruit.//'
               '4. Breng de spinazie op smaak met een flinke snuf peper.//'
               '5. Rol het bladerdeeg uit.//'
               '6. Verdeel de spinazie over het bladerdeeg en kruimel hier de feta in kleine stukjes over.//'
               '7. Bestrooi met wat pijnboompitten.//'
               '8. Rol het bladerdeeg voorzichtig op.//'
               '9. Snijd met een scherp mes de rol in plakjes. Is dit lastig? Dan kun je de rol een half uurtje in de koelkast leggen zodat hij wat opstijft.//'
               '10. Leg de plakjes op een bakplaat met bakpapier en bestrijk met een los geklopt ei.//'
               '11. Bak de rolletjes 15 tot 20 minuten in de oven totdat ze goudbruin zijn.//'
       );

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID,ESTIMATED_PRICE)
VALUES
    ('vers bladerdeeg', 0, NULL, 4,8.50),
    ('feta', 200, 'gr', 4,5.50),
    ('verse spinazie', 400, 'gr', 4,2.0),
    ('peper', 0, 'snuf', 4,2.50),
    ('ei', 1, NULL, 4,2.50),
    ('pijnboompitten', 2, 'eetlepels', 4,2.0);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES('2 g', '200 mg', '1 g', '5 g', '6 g', '150 gr', '15 g', 4);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Glutenvrije pizza',
           'glutenvrij',
           '00:10:00',
           'middagmaal',
           '/img/glutenvrije_pizza.jpg',
           '1. Verwarm de oven voor op 225° graden.'
               '2. Meng het meel, olijfolie, zout, bakpoeder en water. Kneed dit tot dat er een mooie bal ontstaat. Als het te droog is kun je een klein beetje extra water toevoegen.//'
               '3. Verdeel wat glutenvrij meel over het aanrecht of gebruik bakpapier en rol het deeg uit tot een platte cirkel.//'
               '4. Verdeel de tomatensaus met een lepel over de pizza.//'
               '5. Snijd de paprika en zongedroogde tomaten en leg deze vervolgens op de tomatensaus.//'
               '6. Strooi de Italiaanse kruiden, geraspte kaas en een snuf peper en zout hier overheen.//'
               '7. Bak de pizza voor 15 minuten op 225° graden.//'
       );


INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID,ESTIMATED_PRICE)
VALUES
    ('glutenvrije zelfrijzende bakmix (Albert Heijn)', 100, 'gram', 5,5.0),
    ('olijfolie', 0, 'scheutje', 5,4.99),
    ('water', 1, 'eetlepel', 5,1.50),
    ('zout', 0, 'snuf', 5,1.99),
    ('bakpoeder', 0.5, 'theelepel', 5,6.50),
    ('tomatensaus', 3, 'eetlepels', 5,8.50),
    ('zongedroogde tomaten', 3, NULL, 5,8.0),
    ('rode paprika', 0.25, NULL, 5,4.99),
    ('Italiaanse kruiden', 1, 'eetlepel', 5,4.99),
    ('geraspte kaas (vegan)', 20, 'gram', 5,5.99),
    ('peper en zout', 0, 'snuf', 5,3.99);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES('3 g', '200 mg', '3 g', '5 g', '10 g', '250 gr', '30 g', 5);

INSERT INTO DISH(NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Snelle cranberry compote',
           'vegan',
           '00:20:00',
           'dessert',
           '/img/cranberry_compote.jpg',
           '1. Verwarm het sinaasappelsap met de basterdsuiker in een pannetje.//'
               '2. Voeg de balsamico azijn en een snuf kaneel toe.//'
               '3. Voeg dan de cranberries toe en breng zachtjes aan de kook.//'
               '4. Roer af en toe door en wacht tot de cranberries zacht worden en uit elkaar vallen, waardoor er een saus ontstaat. Dit duurt ongeveer 15 minuten.//'
               'De cranberry compote is lekker bij een stukje wild of bij het dessert en is een onmisbaar gerecht bij het kerstdiner. Bewaar de saus afgedekt in de koelkast. De cranberry compote is enkele weken tot maanden houdbaar.//'
       );


INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID, ESTIMATED_PRICE)
VALUES ('verse cranberries', 250, 'gr', 6, 12.50),
       ('balsamico azijn', 2, 'eetlepels',6, 10.0),
       ('sinaasappelsap', 100, 'ml',6, 2.50),
       ('kaneel', 1, 'snuf',6, 4.0),
       ('witte basterdsuiker', 75, 'gr',6, 5.99);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES('2 g', '50 mg', '8 g', '0.1 g', '0.5 g', '40 gr', '10 g', 6);


INSERT INTO DISH(NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Snicker bliss balls',
           'dessert',
           '00:10:00',
           'snack',
           '/img/snicker_balls.jpg',
           '1. Als de dadels hard zijn, laat je ze even weken in een schaal met water. Als ze goed zacht zijn, is dit niet nodig.//'
               '2. Doe de pinda’s in een keukenmachine en maal ze tot kleinere stukjes. Haal ze er daarna weer uit.//'
               '3. Doe vervolgens de dadels in de keukenmachine en maal ze fijn.//'
               '4. Voeg de gemalen pinda’s, pindakaas, maple syrup, cacao poeder en snuf zout toe aan de dadels in de keukenmachine.//'
               '5. Meng alles goed totdat het een samenhangend mengsel vormt.//'
               '6. Maak met je handen balletjes van het mengsel.//'
               '7. Bewaar de balletjes het beste in de koelkast.//'
       );
INSERT INTO INGREDIENT(NAME, QUANTITY, UNIT, DISH_ID,ESTIMATED_PRICE)
VALUES
    ('pindakaas', 2, 'eetlepels', 7,6.99),
    ('dadels', 13, NULL, 7,5.0),
    ('pinda’s', 100, 'gr', 7,6.0),
    ('cacao poeder', 3, 'theelepels', 7,7.0),
    ('maple syrup', 2, 'eetlepels', 7,5.99),
    ('zout', 1, 'snuf', 7,1.99);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES('3 g', '50 mg', '10 g', '4 g', '6 g', '150 gr', '15 g', 7);


INSERT INTO DISH(NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Babi ketjap spiezen',
           'keto',
           '00:50:00',
           'avondmaal',
           '/img/babi_ketjap_spiezen.jpg',
           '1. Snijd de varkenslappen in stukken en bestrooi met gemalen korianderzaad en gemalen gember. Voeg een scheutje ketjap toe en schep door elkaar. Laat minimaal een half uur marineren.//'
               '2. Snipper ondertussen het sjalotje en de knoflook zo fijn mogelijk.//'
               '3. Verhit in een pannetje een beetje olie en bak de ui en knoflook aan. Voeg de ketchup en de sambal toe en bak 1 minuutje mee. Voeg een scheut ketjap toe (ongeveer 100 ml) en breng aan de kook. Voeg ongeveer eenzelfde hoeveelheid water toe en laat het pruttelen tot het begint in te dikken.//'
               '4. Rijg het gemarineerde vlees aan de spiezen en bak in een pan (of op de BBQ) in ongeveer 7 minuten gaar.//'
               '5. Serveer de spiezen met de ketjap saus erover en garneer met gebakken uitjes en bosui. Lekker met rijst en/of roerbakgroente.//'
       );


INSERT INTO INGREDIENT(NAME, QUANTITY, UNIT, DISH_ID,ESTIMATED_PRICE)
VALUES
    ('varkenslappen', 400, 'gr', 8,10.0),
    ('sjalotje', 1, NULL, 8,7.99),
    ('teentje knoflook', 1, NULL, 8,1.75),
    ('sambal', 0.5, 'theelepel', 8,6.0),
    ('ketchup', 3, 'eetlepels', 8,4.99),
    ('ketjap', 100, 'ml', 8,4.99),
    ('gemalen korianderzaad', 0, NULL, 8,9.0),
    ('gemalen gember', 0, NULL, 8, 9.99),
    ('gebakken uitjes', 0, NULL, 8, 5.99),
    ('bosui', 0, NULL, 8 , 6.0);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES('3 g', '800 mg', '15 g', '10 g', '20 g', '300 gr', '20 g', 8);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Yoghurt met fruit ontbijt',
           'vegetarisch',
           '00:05:00',
           'ontbijt',
           '/img/yoghurt_granola_ontbijt.jpg',
           '1. Schep de Griekse yoghurt (of plantaardige yoghurt) in een kom.//'
               '2. Snijd de mango en banaan in plakjes en voeg deze toe aan de kom.//'
               '3. Voeg de blauwe bessen toe aan de kom.//'
               '4. Strooi de granola over de yoghurt en het fruit.//'
               '5. Garneer met hennepzaad.//'
       );

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID,ESTIMATED_PRICE)
VALUES
    ('Griekse yoghurt (of plantaardige yoghurt)', 500, 'gr', 9,3.99),
    ('granola', 40, 'gr', 9,5.0),
    ('mango', 1, NULL, 9,9.99),
    ('banaan', 1, NULL, 9,4.99),
    ('blauwe bessen', 200, 'gr', 9,8.0),
    ('hennepzaad', 2, 'eetlepels', 9,6.90);

INSERT INTO NUTRITION (FIBER, SALT, SUGAR, SATURATED_FAT, FAT, CARBS, PROTEINS, DISH_ID)
VALUES('2 g', '80 mg', '20 g', '4 g', '5 g', '200 gr', '30 g', 9);



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
INSERT INTO "PUBLIC"."CHEF" (USERNAME, NAME, SURNAME, EMAIL) VALUES
('stefferke', 'stefferke', 'coulson', 'stefferke@stefferke.com');



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
VALUES
    (1,1),
    (1,2),
    (1,3),
    (1,8),
    (1,11),
    (2,1),
    (2,2),
    (2,3),
    (2,11),
    (3,1),
    (3,2),
    (3,3),
    (3,13),
    (3,14),
    (4,4),
    (4,5),
    (4,6),
    (4,13),
    (4,14),
    (5,1),
    (5,2),
    (5,3),
    (5,8),
    (6,13),
    (6,14),
    (7,4),
    (7,5),
    (7,11),
    (8,3),
    (8,7),
    (8,13),
    (9,13),
    (9,14);
