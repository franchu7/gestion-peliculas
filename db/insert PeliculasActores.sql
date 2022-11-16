DELETE FROM `peliculasActoresDB`.`Peliculas_has_Actores`;
DELETE FROM `peliculasActoresDB`.`Peliculas`;
DELETE FROM `peliculasActoresDB`.`Actores`;

ALTER TABLE `peliculasActoresDB`.`Peliculas` AUTO_INCREMENT = 1 ;
INSERT INTO `peliculasActoresDB`.`Peliculas` VALUES (1,'Star Wars: El ascenso de Skywalker', 2019, 141, 'Estados Unidos', 'J.J. Abrams', 'Ciencia ficción', 'Un año después de los eventos de "Los últimos Jedi", los restos de la Resistencia se enfrentarán una vez más a la Primera Orden, involucrando conflictos del pasado y del presente. Mientras tanto, el antiguo conflicto entre los Jedi y los Sith llegará a su clímax, lo que llevará a la saga de los Skywalker a un final definitivo. Final de la trilogía iniciada con "El despertar de la Fuerza".', 'https://pics.filmaffinity.com/star_wars_the_rise_of_skywalker-619389738-mmed.jpg');
INSERT INTO `peliculasActoresDB`.`Peliculas` VALUES (2,'Historia de un matrimonio', 2019, 136, 'Estados Unidos', 'Noah Baumbach', 'Drama', 'Charlie, un director de teatro neoyorquino y su mujer actriz, Nicole, luchan por superar un proceso de divorcio que les lleva al extremo tanto en lo personal como en lo creativo.', 'https://pics.filmaffinity.com/marriage_story-714238540-mmed.jpg');
INSERT INTO `peliculasActoresDB`.`Peliculas` VALUES (3,'Jojo Rabbit', 2019, 108, 'Nueva Zelanda', 'Taika Waititi', 'Comedia dramática', 'Jojo "Rabbit" Betzler (Roman Griffin Davis) es un solitario niño alemán perteneciente a las Juventudes Hitlerianas que ve su mundo puesto patas arriba cuando descubre que su joven madre Rosie (Scarlett Johansson) esconde en su ático a una niña judía (Thomasin McKenzie). Con la única ayuda de su mejor amigo imaginario, el mismísimo Adolf Hitler (Taika Waititi), Jojo deberá afrontar su ciego nacionalismo con las contradicciones de una guerra absurda.', 'https://pics.filmaffinity.com/jojo_rabbit-509852787-mmed.jpg');

ALTER TABLE `peliculasActoresDB`.`Actores` AUTO_INCREMENT = 1 ;
INSERT INTO `peliculasActoresDB`.`Actores` VALUES (1, 'Adam Driver', '1983-11-19', 'Estados Unidos');
INSERT INTO `peliculasActoresDB`.`Actores` VALUES (2, 'Scarlett Johansson', '1984-11-22', 'Estados Unidos');
INSERT INTO `peliculasActoresDB`.`Actores` VALUES (3 ,'Roman Griffin Davis', '2007-04-10', 'Reino Unido');
INSERT INTO `peliculasActoresDB`.`Actores` VALUES (4 ,'Laura Dern', '1967-02-10', 'Estados Unidos');
INSERT INTO `peliculasActoresDB`.`Actores` VALUES (5 ,'Daisy Ridley', '1992-04-10', 'Reino Unido');
INSERT INTO `peliculasActoresDB`.`Actores` VALUES (6 ,'Oscar Isaac', '1979-03-09', 'Guatemala');
INSERT INTO `peliculasActoresDB`.`Actores` VALUES (7 ,'Sam Rockwell', '1968-11-05', 'Estados Unidos');
INSERT INTO `peliculasActoresDB`.`Actores` VALUES (8 ,'John Boyega', '1992-03-17', 'Reino Unido');

INSERT INTO `peliculasActoresDB`.`Peliculas_has_Actores` VALUES (1, 1);
INSERT INTO `peliculasActoresDB`.`Peliculas_has_Actores` VALUES (1, 5);
INSERT INTO `peliculasActoresDB`.`Peliculas_has_Actores` VALUES (1, 6);
INSERT INTO `peliculasActoresDB`.`Peliculas_has_Actores` VALUES (1, 8);
INSERT INTO `peliculasActoresDB`.`Peliculas_has_Actores` VALUES (2, 1);
INSERT INTO `peliculasActoresDB`.`Peliculas_has_Actores` VALUES (2, 2);
INSERT INTO `peliculasActoresDB`.`Peliculas_has_Actores` VALUES (2, 4);
INSERT INTO `peliculasActoresDB`.`Peliculas_has_Actores` VALUES (3, 2);
INSERT INTO `peliculasActoresDB`.`Peliculas_has_Actores` VALUES (3, 3);
INSERT INTO `peliculasActoresDB`.`Peliculas_has_Actores` VALUES (3, 7);