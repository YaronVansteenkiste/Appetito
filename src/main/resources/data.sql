INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'pasta alfredo met kip',
           'paleo',
           '00:20:00',
           'avondmaal',
           'pasta_alfredo.jpg',
           '1. Begin met het koken van de fettuccine volgens de aanwijzingen op de verpakking. Vergeet niet een kopje van het kookvocht te bewaren voordat je de pasta afgiet.//'
               '2. Terwijl de pasta kookt, kruid je de kipstukjes naar smaak en bak je ze in een aparte pan tot ze volledig gaar en goudbruin zijn. Zet de kip even opzij.//'
               '3. Smelt de roomboter in een diepe pan op middelhoog vuur. Voeg het fijngehakte teentje knoflook toe en laat het een minuutje zachtjes bakken, zodat de smaken goed vrijkomen.//'
               '4. Voeg de gekookte fettuccine toe aan de pan met gesmolten boter en knoflook. Giet er een goed scheutje van het bewaarde kookvocht bij om de saus smeuïg te maken.//'
               '5. Strooi de geraspte Parmezaanse kaas over de pasta en roer alles goed door elkaar totdat de kaas volledig is gesmolten en een romige saus vormt.//'
               '6. Voeg nu de gebakken kipstukjes toe aan de pan en meng alles goed door elkaar. Breng op smaak met zwarte peper.//'
               '7. Serveer de pasta alfredo op borden en garneer met de gehakte peterselie voor een frisse touch.//'
               '8. Sandra’s tip: Voor een extra portie groen kun je deze heerlijke pasta alfredo serveren met gestoomde broccoli of erwtjes. Zo krijg je meteen je dagelijkse portie groenten binnen!//'
       );

INSERT INTO Ingredient (name, quantity, unit, dish_id)
VALUES
    ('fettuccine', 75, 'gr', 1),
    ('roomboter', 22.5, 'gr', 1),
    ('Parmezaanse kaas (geraspt)', 31.25, 'gr', 1),
    ('zwarte peper', 0, NULL, 1),
    ('kipstukjes (vega) (Garden Gourmet)', 62.5, 'gr', 1),
    ('knoflook (fijngehakt)', 0.25, 'gr', 1),
    ('peterselie (gehakt voor garnering)', 0, NULL, 1),
    ('Kookvocht van de pasta (bewaar een scheut)', 0, NULL, 1);
INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Pasta met zalm en spinazie',
           'paleo',
           '00:30:00',
           'avondeten',
           'pasta_zalm.jpg',
           '1. Kook de pasta volgens verpakking beetgaar. Snipper ondertussen de ui en de teentjes knoflook fijn. Bak deze glazig in een grote hapjes of wokpan in een eetlepel olie.//'
               '2. Voeg de zalm toe en bak rondom aan, steek met een spatel in stukken. Voeg dan in etappes de spinazie toe totdat deze wat geslonken is. Schenk de kookroom erbij en breng op maak met flink wat peper en zout.//'
               '3. Halveer de tomaatjes en meng deze met de zalm en spinazie. Verwarm een paar minuten door en voeg dan de tagliatelle toe. Mix alles door elkaar en schep op borden. Bestrooi met geroosterde pijnboompitten.//'
       );

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES
    ('tagliatelle', 350, 'gr', 2),
    ('kookroom (light)', 350, 'ml', 2),
    ('verse spinazie', 400, 'gr', 2),
    ('zalmfilet', 400, 'gr', 2),
    ('ui', 1, NULL, 2),
    ('peper en zout', 0, NULL, 2),
    ('cherrytomaatjes', 250, 'gr', 2),
    ('pijnboompitten (geroosterd)', 50, 'gr', 2),
    ('teentjes knoflook', 2, NULL, 2),
    ('olijfolie', 1, 'eetlepel', 2);
INSERT INTO DISH ( NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (

           'Spinaziesoep',
           'vegetarisch',
           '00:20:00',
           'avondmaal','spinaziesoep.jpg',
           '1. Snijd de ui fijn en bak in een pan met boter glazig.//'
               '2. Snijd de aardappel in blokjes. Voeg de aardappel en ontdooide spinazie toe aan de ui.//'
               '3. Giet het water erbij, breng aan de kook en verkruimel de bouillonblokjes boven de pan. Laat alles 10 min zachtjes doorkoken.//'
               '4. Pureer de soep met een staafmixer tot een gladde groene massa.//'
               '5. Roer de room erdoor.//'
               '6. Serveer de soep in borden of kommen en garneer eventueel met wat extra room, pijnboompitten en waterkers.//'
       );

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES
    ('gehakte spinazie (ontdooid)', 450, 'gr', 3),
    ('boter of margarine', 2, 'eetlepels', 3),
    ('ui', 1, NULL, 3),
    ('middelgrote aardappel', 200, 'gr', 3),
    ('water', 1000, 'ml', 3),
    ('groente bouillonblokjes', 2, NULL, 3),
    ('kookroom', 200, 'ml', 3);

INSERT INTO DISH ( NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Spinazie feta bladerdeegrolletjes',
           'vegetarisch',
           '00:25:00',
           'snacks','spinaziebladerdeeg.jpg',
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

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES
    ('vers bladerdeeg', 0, NULL, 4),
    ('feta', 200, 'gr', 4),
    ('verse spinazie', 400, 'gr', 4),
    ('peper', 0, 'snuf', 4),
    ('ei', 1, NULL, 4),
    ('pijnboompitten', 2, 'eetlepels', 4);

INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Glutenvrije pizza',
           'glutenvrij',
           '00:10:00',
           'middagmaal',
           'glutenvrije_pizza.jpg',
           '1. Verwarm de oven voor op 225° graden.'
               '2. Meng het meel, olijfolie, zout, bakpoeder en water. Kneed dit tot dat er een mooie bal ontstaat. Als het te droog is kun je een klein beetje extra water toevoegen.//'
               '3. Verdeel wat glutenvrij meel over het aanrecht of gebruik bakpapier en rol het deeg uit tot een platte cirkel.//'
               '4. Verdeel de tomatensaus met een lepel over de pizza.//'
               '5. Snijd de paprika en zongedroogde tomaten en leg deze vervolgens op de tomatensaus.//'
               '6. Strooi de Italiaanse kruiden, geraspte kaas en een snuf peper en zout hier overheen.//'
               '7. Bak de pizza voor 15 minuten op 225° graden.//'
       );


INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES
    ('glutenvrije zelfrijzende bakmix (Albert Heijn)', 100, 'gram', 5),
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

INSERT INTO DISH(NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Snelle cranberry compote',
           'vegan',
           '00:20:00',
           'dessert',
           'cranberry_compote.jpg',
           '1. Verwarm het sinaasappelsap met de basterdsuiker in een pannetje.//'
               '2. Voeg de balsamico azijn en een snuf kaneel toe.//'
               '3. Voeg dan de cranberries toe en breng zachtjes aan de kook.//'
               '4. Roer af en toe door en wacht tot de cranberries zacht worden en uit elkaar vallen, waardoor er een saus ontstaat. Dit duurt ongeveer 15 minuten.//'
               'De cranberry compote is lekker bij een stukje wild of bij het dessert en is een onmisbaar gerecht bij het kerstdiner. Bewaar de saus afgedekt in de koelkast. De cranberry compote is enkele weken tot maanden houdbaar.//'
       );


INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES
    ('verse cranberries', 250, 'gr', 6),
    ('balsamico azijn', 2, 'eetlepels', 6),
    ('sinaasappelsap', 100, 'ml', 6),
    ('kaneel', 1, 'snuf', 6),
    ('witte basterdsuiker', 75, 'gr', 6),
    ('verse cranberries', 250, 'gr', 6),
    ('balsamico azijn', 2, 'eetlepels', 6),
    ('sinaasappelsap', 100, 'ml', 6),
    ('kaneel', 1, 'snuf', 6),
    ('witte basterdsuiker', 75, 'gr', 6);

INSERT INTO DISH(NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Snicker bliss balls',
           'dessert',
           '00:10:00',
           'snack',
           'snicker_balls.jpg',
           '1. Als de dadels hard zijn, laat je ze even weken in een schaal met water. Als ze goed zacht zijn, is dit niet nodig.//'
               '2. Doe de pinda’s in een keukenmachine en maal ze tot kleinere stukjes. Haal ze er daarna weer uit.//'
               '3. Doe vervolgens de dadels in de keukenmachine en maal ze fijn.//'
               '4. Voeg de gemalen pinda’s, pindakaas, maple syrup, cacao poeder en snuf zout toe aan de dadels in de keukenmachine.//'
               '5. Meng alles goed totdat het een samenhangend mengsel vormt.//'
               '6. Maak met je handen balletjes van het mengsel.//'
               '7. Bewaar de balletjes het beste in de koelkast.//'
       );
INSERT INTO INGREDIENT(NAME, QUANTITY, UNIT, DISH_ID)
VALUES
    ('pindakaas', 2, 'eetlepels', 7),
    ('dadels', 13, NULL, 7),
    ('pinda’s', 100, 'gr', 7),
    ('cacao poeder', 3, 'theelepels', 7),
    ('maple syrup', 2, 'eetlepels', 7),
    ('zout', 1, 'snuf', 7);

INSERT INTO DISH(NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Babi ketjap spiezen',
           'keto',
           '00:50:00',
           'avondmaal',
           'babi_ketjap_spiezen.jpg',
           '1. Snijd de varkenslappen in stukken en bestrooi met gemalen korianderzaad en gemalen gember. Voeg een scheutje ketjap toe en schep door elkaar. Laat minimaal een half uur marineren.//'
           '2. Snipper ondertussen het sjalotje en de knoflook zo fijn mogelijk.//'
           '3. Verhit in een pannetje een beetje olie en bak de ui en knoflook aan. Voeg de ketchup en de sambal toe en bak 1 minuutje mee. Voeg een scheut ketjap toe (ongeveer 100 ml) en breng aan de kook. Voeg ongeveer eenzelfde hoeveelheid water toe en laat het pruttelen tot het begint in te dikken.//'
           '4. Rijg het gemarineerde vlees aan de spiezen en bak in een pan (of op de BBQ) in ongeveer 7 minuten gaar.//'
           '5. Serveer de spiezen met de ketjap saus erover en garneer met gebakken uitjes en bosui. Lekker met rijst en/of roerbakgroente.//'
       );


INSERT INTO INGREDIENT(NAME, QUANTITY, UNIT, DISH_ID)
VALUES
    ('varkenslappen', 400, 'gr', 8),
    ('sjalotje', 1, NULL, 8),
    ('teentje knoflook', 1, NULL, 8),
    ('sambal', 0.5, 'theelepel', 8),
    ('ketchup', 3, 'eetlepels', 8),
    ('ketjap', 100, 'ml', 8),
    ('gemalen korianderzaad', 0, NULL, 8),
    ('gemalen gember', 0, NULL, 8),
    ('gebakken uitjes', 0, NULL, 8),
    ('bosui', 0, NULL, 8);


INSERT INTO DISH (NAME, DIET_PREFERENCES, PREPARATION_TIME, OCCASION, IMG_FILE_NAME, PREPARATION)
VALUES (
           'Yoghurt met fruit ontbijt',
           'vegetarisch',
           '00:05:00',
           'ontbijt',
           'yoghurt_granola_ontbijt.jpg',
           '1. Schep de Griekse yoghurt (of plantaardige yoghurt) in een kom.//'
           '2. Snijd de mango en banaan in plakjes en voeg deze toe aan de kom.//'
           '3. Voeg de blauwe bessen toe aan de kom.//'
           '4. Strooi de granola over de yoghurt en het fruit.//'
           '5. Garneer met hennepzaad.//'
       );

INSERT INTO INGREDIENT (NAME, QUANTITY, UNIT, DISH_ID)
VALUES
    ('Griekse yoghurt (of plantaardige yoghurt)', 500, 'gr', 9),
    ('granola', 40, 'gr', 9),
    ('mango', 1, NULL, 9),
    ('banaan', 1, NULL, 9),
    ('blauwe bessen', 200, 'gr', 9),
    ('hennepzaad', 2, 'eetlepels', 9);




