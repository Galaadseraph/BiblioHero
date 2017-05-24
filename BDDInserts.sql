INSERT INTO pers_typerace (coderace, nom)
VALUES
("hm","humaine"),
("elf","elfique"),
("nains","naine")
;

INSERT INTO pers_typeclasse (codeclasse, nom)
VALUES
("gurr","guerrier"),
("mage","magicien"),
("clerc","pretre")
;


INSERT INTO pers_typesexe (codesexe, nom)
VALUES
("M","Masculin"),
("F","Feminin"),
("D","Dick Girl"),
("C","Cunt Boy"),
("H","Hermaphrodite"),
("A","Asexué")
;



INSERT INTO pers_typegenre (codegenre, nom)
VALUES
("CM","Cisgenre Maculin"),
("CF","Cisgenre Feminin"),
("CN","Cisgenre Neutrois"),
("TMTF","Trans Masculin vers Feminin"),
("TFTM","Trans Feminin vers Masculin"),
("A","A-genre"),
("B","Bi-genre")
;


INSERT INTO pers_restrictionsexegenre (codesexe, codegenre)
VALUES
("M","CM"),
("M","TMTF"),
("M","A"),
("M","B"),

("F","CF"),
("F","TFTM"),
("F","A"),
("F","B"),

("D","CM"),
("D","TMTF"),
("D","A"),
("D","B"),

("C","CF"),
("C","TFTM"),
("C","A"),
("C","B"),

("H","CN"),
("H","A"),
("H","B"),

("A","CN"),
("A","A")
;

INSERT INTO pers_lotequipement (codelot, nom)
VALUES
( "BASIQUE","Lot de base")
;


INSERT INTO pers_lotsort (codelot, nom)
VALUES
( "BASIQUE","Lot de base")
;


INSERT INTO pers_typeequipement (codeequipement, nom)
VALUES
( "ARMCONT","Arme Contondante"),
( "ARMPERF","Arme Perforante"),
( "ARMTRANCH","Arme Tranchante"),
( "ARMJET","Arme de Jet"),
( "ARMLNG","Arme longue"),
( "BLNDLG","Armure Légère"),
( "BLNDIT","Armure Intermédiaire"),
( "BLNDLRD","Armure Lourde"),
( "POT","Potions"),
( "PARCH","Parchemins"),
( "BIJOUX","Bijouterie"),
( "AUTS","Autres")
;


INSERT INTO avt_theme (codetheme, nomtheme)
VALUES
("HST","Historique"),
("MF","Medieval Fantastique"),
("SF","Science-Fiction"),
("HR","Horreur")
;

INSERT INTO avt_typeaction (codeaction, nom)
VALUES
( 0,"Paragraphe suivant"),
( 1,"Test de passage snippet"),
( 2,"Combat"),
( 4,"Template (comming soon)"),
( 5,"Ajout objet"),
( 6, "Accès aventure fille"),
( 7, "Accès aventure mère")
;


INSERT INTO lot_lotequipement (codelot, nom)
VALUES
( "BASIQUE","Lot de base")
;

INSERT INTO lot_lotsort (codelot, nom)
VALUES
( "BASIQUE","Lot de base")
;


INSERT INTO lot_typeequipement (codeequipement, nom)
VALUES
( "ARMCONT","Arme Contondante"),
( "ARMPERF","Arme Perforante"),
( "ARMTRANCH","Arme Tranchante"),
( "ARMJET","Arme de Jet"),
( "ARMLNG","Arme longue"),
( "BLNDLG","Armure Légère"),
( "BLNDIT","Armure Intermédiaire"),
( "BLNDLRD","Armure Lourde"),
( "POT","Potion"),
( "PARCH","Parchemin"),
( "BIJOUX","Bijouterie"),
( "AUTS","Autre")
;



INSERT INTO `avt_action` (`idaction`, `description`, `codeaction`, `effet`, `paragraphesuite`) VALUES
(1, 'aller en direction du bruit de foule,', 0, '', 2),
(2, 's éloigner de ce bruit,', 0, '', 3),
(3, 'examiner de plus près les environs, [menu] (vous trouvez de nouveaux habits, une pancarte, et une bouteille de whisky presque vide.', 2, '', 1),
(4, 'demander à quelqu’un si l’on est connu ou reconnu ? ', 0, '', 4),
(5, 'demander a quelqu’un quel est le sujet de la manifestation ?', 0, '', 5),
(6, 'leurs parler, ', 0, '', 6),
(7, 'leur demander de boire,', 0, '', 7),
(8, 'Les ignorer,', 2, '', 15),
(9, 'fuite vers la manif,', 0, '', 8),
(10, 'Crier plus fort', 0, '', 9),
(11, 'suivre la manifestation, pour voir vers où elle vas aboutir,', 0, '', 10),
(12, 'aller vers le barman,', 0, '', 11),
(13, 'l’aider à se relever et l’essayer de s’échapper avec le journaliste et son cameraman,', 1, 'test>5:12', 15),
(14, 'essayer de s’enfuir quitte à marcher sur le journaliste, même si la caméra filme toute la scène en direct, ', 0, '', 13),
(15, 'donner un coup de poing au cadreur et lui prendre la caméra, ', 0, '', 14),
(16, 'Combat de Chef…', 2, 'test>5:7', 14),
(17, 'lancer le dés pour savoir la suite…', 1, 'test>9:1', 15),
(18, 'lancez le dés, pour savoir si vous réussissez,', 1, 'test>2:3', 15),
(19, 'répondre à la violence par la violence, lancer le dés..  ', 1, 'test>8:3', 15),
(20, 'mort', 0, '', 15),
(21, 'l’on meurt intoxiqué par un alcool frelaté', 1, 'test>8:15', 5),
(22, 'rendez-vous-punk ...', 0, '', 3),
(23, 'pour avoir piétiner à mort un homme devant les caméras, lancer de dés… ', 1, 'test>2:3', 15),
(24, 'combat médiatique', 2, 'test>5:12', 15),
(25, 'tout nous semble flou ,', 0, '', 1);


INSERT INTO `avt_aventure` (`idaventure`, `nom`, `auteur`, `codetheme`, `synopsis`, `nbparagraphe`, `isbnserie`, `dictionnaire`, `isbnaventure`, `version`, `nvrequis`, `classerequise`) VALUES
(1, 'le coeur du chaos', 'Cyril Guillot', 'HST', 'dans les années 70 80 un groupe terroriste dechaine les foules', 15, 'ab4', 0, '1', '', 0, 'aucune');



INSERT INTO `avt_paragraphe` (`idparagraphe`, `texte`, `nbevenement`, `numparagraphe`, `idaventure`) VALUES
(1, 'En ouvrant les yeux, le réveil ce fait difficile, la vision est floue, un peu étourdie, je ne sais ni où je suis réellement, ni qui suis-je... tout ce je sais c est ce que j observe, c est à dire une ruelle plutôt obscure, la pancarte indique rue du cherche midi. un important bruit de foule indistincte se fait entendre de plus en plus fort. Sur mon bras gauche, un bracelet blanc très similaire à ceux des patients d un hôpital sur lequel est écrit mon prénom suivit d un numéro à dix chiffres, un symbole qui ne signifie rien pour moi, ainsi qu un code barre. en passant devant la vitrine d une boutique, le regard un peu brouillé me montre un reflet de moi que je ne reconnais pas [description du personnage], rapidement le commerçant de l’échoppe ferme la grille, apeuré...', 3, 1, 1),
(2, 'En s approchant du bruit l on se rend compte que c est une, manifestation, on se mélange à la foule qui se dirige vers l hôtel des invalides, nous sommes donc à Paris. Une importante question se pose et se répète en tête : « mais qui suis je donc réellement , où sommes nous et aussi quand ? ».', 2, 2, 1),
(3, 'En continuant dans la rue l on se retrouve à passer devant un groupe de punk qui ont l’aire d être en partie ivres et dont les chines aboient férocement.', 4, 3, 1),
(4, 'L on se retrouve à crier dans une foule, au hasard, comme un fou : « Je suis perdu, est-ce que quelqu’un sait qui je suis, je veux le savoir... » Personne ne répond et l on semble passer inaperçu… Cependant l on découvre qu un barman semble vouloir profiter de la situation, en sortant, un fût de bière  et vendre son breuvage aux passants.', 3, 4, 1),
(5, 'En cherchant dans la foule énervé, quelqu un a qui parler, l on tombe sur un journaliste Tv et on le fait chuter alors qu il était en cour de faire un rapport de situation en direct sur une chaîne populaire. L on aperçois derrière la grille d un magasin de TV, la diffusion du reportage. La foule se dirige vers le journaliste en criant.', 3, 5, 1),
(6, 'Combat de Chef…', 2, 6, 1),
(7, 'en leurs expliquant que l on a très très soif, et que l on est intéressé par la bouteille qu ils se passent les uns les autres… l un d entre eux nous tend le récipient contenant le dangereux liquide, qui sent particulièrement fort… lancer le dés pour savoir la suite…', 2, 7, 1),
(8, '« lâchez les chiens , ratrapez le », crie l un d entre eux, celui au chapeau…', 2, 8, 1),
(9, 'L on est pris pour un fou, et un grand costaud s approche, il a l aire décidé à nous faire taire. c’est un partisan communiste qui brandit un drapeau rouge avec le portrait du Che Guevara, il n’a qu’une idée en tête nous faire taire de façon énergique.', 2, 9, 1),
(10, 'happé par la foule l on meurt étouffer,', 1, 10, 1),
(11, 'A discuter avec le barman, il nous propose de boire une bière, lancer le dés, pour voir si l on meurt intoxiqué par un alcool frelaté 14. ou si l on rejoint la foule en titubant, 4.', 2, 11, 1),
(12, 'l on réussit à s’enfuir péniblement, [-20PV, +30EXP], et l on se retrouve nez à nez avec un groupe de punks, 2.', 1, 12, 1),
(13, 'L on devient l’ennemi numéro un, du tout Paris, voire de la France entière, et peux être même de la planète, pour avoir piétiner à mort un homme devant les caméras,', 1, 13, 1),
(14, 'combat médiatique, mort ,', 2, 14, 1),
(15, 'La mort est un curieux brouillard où tout nous semble flou , ', 1, 15, 1);




INSERT INTO `avt_paragrapheaction` (`idparagrapheaction`, `idparagraphe`, `idaction`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 2, 4),
(5, 2, 5),
(6, 3, 6),
(7, 3, 7),
(8, 3, 8),
(9, 3, 9),
(10, 4, 10),
(11, 4, 11),
(12, 4, 12),
(13, 5, 13),
(14, 5, 14),
(15, 5, 15),
(16, 6, 16),
(17, 7, 17),
(18, 8, 18),
(19, 9, 19),
(20, 10, 20),
(21, 11, 21),
(22, 12, 22),
(23, 13, 23),
(24, 14, 24),
(25, 15, 25);


INSERT INTO `pers_typerace` (`coderace`, `nom`) VALUES
('DO', 'drôle d''oiseau'),
('INS', 'Insect-mantis');


INSERT INTO `pers_personnage` (`idpersonnage`, `nom`, `coderace`, `codeclasse`, `codesexe`, `codegenre`, `niveau`, `richesse`, `experience`, `pv`, `forcep`, `dexteritep`, `endurance`, `intelligence`, `moral`, `estactif`, `hommedefer`) VALUES
(1, 'Guigui la colombe', 'DO', 'mage', 'M', 'CM', 100, 10, 135, 20, 10, 69, 80, 105, 5, 1,0),
(2, 'Reptyck', 'INS', 'gurr', 'M', 'CM', 100, 1, 69, 80, 65, 100, 85, 25, 125, 0,1);

