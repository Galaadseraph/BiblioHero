#------------------------------------------------------------
#        Script SQLite  
#------------------------------------------------------------


#------------------------------------------------------------
# Table: avt_aventure
#------------------------------------------------------------
CREATE TABLE avt_aventure(
	idaventure     INTEGER autoincrement NOT NULL ,
	nom            TEXT NOT NULL ,
	auteur         TEXT NOT NULL ,
	isbnserie      TEXT NOT NULL ,
	synopsis       TEXT ,
	nbparagraphe   INTEGER NOT NULL ,
	nvrequis       INTEGER ,
	classerequise  TEXT ,
	dictionnaire   INTEGER NOT NULL ,
	version        TEXT ,
	codtheme       TEXT ,
	isbnaventure   TEXT ,
	idtheme        INTEGER NOT NULL ,
	idseries       INTEGER NOT NULL ,
	PRIMARY KEY (idaventure) ,
	
	FOREIGN KEY (idtheme) REFERENCES avt_theme(idtheme),
	FOREIGN KEY (idseries) REFERENCES avt_series(idseries)
);


#------------------------------------------------------------
# Table: avt_paragraphe
#------------------------------------------------------------
CREATE TABLE avt_paragraphe(
	idparagraphe             INTEGER autoincrement NOT NULL ,
	texte                    TEXT NOT NULL ,
	nbevenement              INTEGER ,
	numparagraphe            INTEGER NOT NULL ,
	idaventure               INTEGER ,
	idaventure_avt_aventure  INTEGER NOT NULL ,
	PRIMARY KEY (idparagraphe) ,
	
	FOREIGN KEY (idaventure_avt_aventure) REFERENCES avt_aventure(idaventure)
);


#------------------------------------------------------------
# Table: pers_personnage
#------------------------------------------------------------
CREATE TABLE pers_personnage(
	permadeath                   INTEGER ,
	hommeDeFer                   INTEGER ,
	idpersonnage                 INTEGER autoincrement NOT NULL ,
	nom                          TEXT NOT NULL ,
	race                         INTEGER NOT NULL ,
	classe                       INTEGER NOT NULL ,
	sexe                         INTEGER NOT NULL ,
	genre                        INTEGER NOT NULL ,
	niveau                       INTEGER NOT NULL ,
	richesse                     REAL ,
	experience                   REAL ,
	pv                           INTEGER NOT NULL ,
	forcep                       INTEGER NOT NULL ,
	dexteritep                   INTEGER NOT NULL ,
	endurance                    INTEGER NOT NULL ,
	intelligence                 INTEGER NOT NULL ,
	estactif                     INTEGER ,
	idequipe                     INTEGER NOT NULL ,
	idpersonnage_pers_pjpctempo  INTEGER NOT NULL ,
	idtyperace                   INTEGER NOT NULL ,
	idtypeclasse                 INTEGER NOT NULL ,
	idtypesexe                   INTEGER NOT NULL ,
	idtypegenre                  INTEGER NOT NULL ,
	PRIMARY KEY (idpersonnage) ,
	
	FOREIGN KEY (idequipe) REFERENCES pers_equipe(idequipe),
	FOREIGN KEY (idpersonnage_pers_pjpctempo) REFERENCES pers_pjpctempo(idpersonnage),
	FOREIGN KEY (idtyperace) REFERENCES pers_typerace(idtyperace),
	FOREIGN KEY (idtypeclasse) REFERENCES pers_typeclasse(idtypeclasse),
	FOREIGN KEY (idtypesexe) REFERENCES pers_typesexe(idtypesexe),
	FOREIGN KEY (idtypegenre) REFERENCES pers_typegenre(idtypegenre)
);


#------------------------------------------------------------
# Table: lot_equipement
#------------------------------------------------------------
CREATE TABLE lot_equipement(
	idequipement      INTEGER autoincrement NOT NULL ,
	nomequipement     TEXT NOT NULL ,
	classeequipement  TEXT NOT NULL ,
	description       TEXT NOT NULL ,
	niveau            INTEGER NOT NULL ,
	classerequise     TEXT NOT NULL ,
	attribut1         TEXT ,
	attribut2         TEXT ,
	attribut3         TEXT ,
	codelot           TEXT ,
	idtypeequiment    INTEGER NOT NULL ,
	idlotequipement   INTEGER NOT NULL ,
	PRIMARY KEY (idequipement) ,
	
	FOREIGN KEY (idtypeequiment) REFERENCES lot_typeequipement(idtypeequiment),
	FOREIGN KEY (idlotequipement) REFERENCES lot_lotequipement(idlotequipement)
);


#------------------------------------------------------------
# Table: lot_typeequipement
#------------------------------------------------------------
CREATE TABLE lot_typeequipement(
	idtypeequiment  INTEGER autoincrement NOT NULL ,
	PRIMARY KEY (idtypeequiment)
);


#------------------------------------------------------------
# Table: parametresaffichage
#------------------------------------------------------------
CREATE TABLE parametresaffichage(
	idparamaffichage  INTEGER autoincrement NOT NULL ,
	PRIMARY KEY (idparamaffichage)
);


#------------------------------------------------------------
# Table: avt_enemie
#------------------------------------------------------------
CREATE TABLE avt_enemie(
	idenemie  INTEGER autoincrement NOT NULL ,
	PRIMARY KEY (idenemie)
);


#------------------------------------------------------------
# Table: avt_action
#------------------------------------------------------------
CREATE TABLE avt_action(
	idaction         INTEGER autoincrement NOT NULL ,
	description      TEXT NOT NULL ,
	typeaction       INTEGER NOT NULL ,
	effet            TEXT NOT NULL ,
	paragraphesuite  INTEGER NOT NULL ,
	idcombat         INTEGER NOT NULL ,
	idtypeaction     INTEGER NOT NULL ,
	PRIMARY KEY (idaction) ,
	
	FOREIGN KEY (idcombat) REFERENCES avt_combat(idcombat),
	FOREIGN KEY (idtypeaction) REFERENCES avt_typeaction(idtypeaction)
);


#------------------------------------------------------------
# Table: avt_combat
#------------------------------------------------------------
CREATE TABLE avt_combat(
	idcombat  INTEGER autoincrement NOT NULL ,
	PRIMARY KEY (idcombat)
);


#------------------------------------------------------------
# Table: avt_parametreaventure
#------------------------------------------------------------
CREATE TABLE avt_parametreaventure(
	idparamaventure  INTEGER autoincrement NOT NULL ,
	idaventure       INTEGER NOT NULL ,
	PRIMARY KEY (idparamaventure) ,
	
	FOREIGN KEY (idaventure) REFERENCES avt_aventure(idaventure)
);


#------------------------------------------------------------
# Table: pers_equipe
#------------------------------------------------------------
CREATE TABLE pers_equipe(
	idequipe  INTEGER autoincrement NOT NULL ,
	PRIMARY KEY (idequipe)
);


#------------------------------------------------------------
# Table: avt_des
#------------------------------------------------------------
CREATE TABLE avt_des(
	iddes  INTEGER autoincrement NOT NULL ,
	PRIMARY KEY (iddes)
);


#------------------------------------------------------------
# Table: lot_sorts
#------------------------------------------------------------
CREATE TABLE lot_sorts(
	idsort        INTEGER autoincrement NOT NULL ,
	nomsort       TEXT NOT NULL ,
	capacite      TEXT NOT NULL ,
	ecoledemagie  TEXT NOT NULL ,
	description   TEXT NOT NULL ,
	duree         INTEGER ,
	codelot       TEXT ,
	idlotsort     INTEGER NOT NULL ,
	PRIMARY KEY (idsort) ,
	
	FOREIGN KEY (idlotsort) REFERENCES lot_lotsort(idlotsort)
);


#------------------------------------------------------------
# Table: pers_inventaire
#------------------------------------------------------------
CREATE TABLE pers_inventaire(
	idinventaire                  INTEGER autoincrement NOT NULL ,
	typeinventaire                TEXT NOT NULL ,
	nom                           TEXT NOT NULL ,
	nbemplacement                 INTEGER NOT NULL ,
	idpersonnage                  INTEGER ,
	idpersonnage_pers_personnage  INTEGER NOT NULL ,
	idtypeinventaire              INTEGER NOT NULL ,
	PRIMARY KEY (idinventaire) ,
	
	FOREIGN KEY (idpersonnage_pers_personnage) REFERENCES pers_personnage(idpersonnage),
	FOREIGN KEY (idtypeinventaire) REFERENCES pers_typeDInventaire(idtypeinventaire)
);


#------------------------------------------------------------
# Table: pers_typeDInventaire
#------------------------------------------------------------
CREATE TABLE pers_typeDInventaire(
	idtypeinventaire  INTEGER autoincrement NOT NULL ,
	code              TEXT NOT NULL ,
	nom               TEXT NOT NULL ,
	PRIMARY KEY (idtypeinventaire)
);


#------------------------------------------------------------
# Table: pers_compagnons
#------------------------------------------------------------
CREATE TABLE pers_compagnons(
	estjoueur     INTEGER ,
	idpersonnage  INTEGER NOT NULL ,
	PRIMARY KEY (idpersonnage) ,
	
	FOREIGN KEY (idpersonnage) REFERENCES pers_personnage(idpersonnage)
);


#------------------------------------------------------------
# Table: avt_typeaction
#------------------------------------------------------------
CREATE TABLE avt_typeaction(
	idtypeaction  INTEGER autoincrement NOT NULL ,
	code          TEXT NOT NULL ,
	nom           TEXT NOT NULL ,
	PRIMARY KEY (idtypeaction)
);


#------------------------------------------------------------
# Table: lot_lotequipement
#------------------------------------------------------------
CREATE TABLE lot_lotequipement(
	idlotequipement  INTEGER autoincrement NOT NULL ,
	codlot           TEXT NOT NULL ,
	nom              TEXT NOT NULL ,
	PRIMARY KEY (idlotequipement)
);


#------------------------------------------------------------
# Table: lot_lotsort
#------------------------------------------------------------
CREATE TABLE lot_lotsort(
	idlotsort  INTEGER autoincrement NOT NULL ,
	codlot     TEXT NOT NULL ,
	nom        TEXT NOT NULL ,
	PRIMARY KEY (idlotsort)
);


#------------------------------------------------------------
# Table: avt_theme
#------------------------------------------------------------
CREATE TABLE avt_theme(
	idtheme   INTEGER autoincrement NOT NULL ,
	nomtheme  TEXT NOT NULL ,
	codtheme  TEXT NOT NULL ,
	PRIMARY KEY (idtheme)
);


#------------------------------------------------------------
# Table: pers_pjpctempo
#------------------------------------------------------------
CREATE TABLE pers_pjpctempo(
	idpersonnage                  INTEGER autoincrement NOT NULL ,
	richesse                      REAL ,
	experience                    REAL ,
	pv                            INTEGER NOT NULL ,
	forcep                        INTEGER NOT NULL ,
	dexteritep                    INTEGER NOT NULL ,
	endurance                     INTEGER NOT NULL ,
	intelligence                  INTEGER NOT NULL ,
	background                    TEXT NOT NULL ,
	idpersonnage_pers_personnage  INTEGER NOT NULL ,
	PRIMARY KEY (idpersonnage) ,
	
	FOREIGN KEY (idpersonnage_pers_personnage) REFERENCES pers_personnage(idpersonnage)
);


#------------------------------------------------------------
# Table: pers_typesexe
#------------------------------------------------------------
CREATE TABLE pers_typesexe(
	idtypesexe  INTEGER autoincrement NOT NULL ,
	codesexe    TEXT ,
	nom         TEXT ,
	PRIMARY KEY (idtypesexe)
);


#------------------------------------------------------------
# Table: pers_typeclasse
#------------------------------------------------------------
CREATE TABLE pers_typeclasse(
	idtypeclasse  INTEGER autoincrement NOT NULL ,
	codeclasse    TEXT ,
	nom           TEXT ,
	PRIMARY KEY (idtypeclasse)
);


#------------------------------------------------------------
# Table: pers_typerace
#------------------------------------------------------------
CREATE TABLE pers_typerace(
	idtyperace  INTEGER autoincrement NOT NULL ,
	coderace    TEXT ,
	nom         TEXT ,
	PRIMARY KEY (idtyperace)
);


#------------------------------------------------------------
# Table: pers_typegenre
#------------------------------------------------------------
CREATE TABLE pers_typegenre(
	idtypegenre  INTEGER autoincrement NOT NULL ,
	codegenre    TEXT ,
	nom          TEXT ,
	PRIMARY KEY (idtypegenre)
);


#------------------------------------------------------------
# Table: avt_series
#------------------------------------------------------------
CREATE TABLE avt_series(
	idseries   INTEGER autoincrement NOT NULL ,
	isbnserie  TEXT ,
	nomserie   TEXT ,
	PRIMARY KEY (idseries)
);


#------------------------------------------------------------
# Table: pers_sort
#------------------------------------------------------------
CREATE TABLE pers_sort(
	idsort        INTEGER autoincrement NOT NULL ,
	nomsort       TEXT NOT NULL ,
	capacite      TEXT NOT NULL ,
	ecoledemagie  TEXT NOT NULL ,
	description   TEXT NOT NULL ,
	duree         INTEGER ,
	codelot       TEXT ,
	idlotsort     INTEGER NOT NULL ,
	PRIMARY KEY (idsort) ,
	
	FOREIGN KEY (idlotsort) REFERENCES pers_lotsort(idlotsort)
);


#------------------------------------------------------------
# Table: pers_lotsort
#------------------------------------------------------------
CREATE TABLE pers_lotsort(
	idlotsort  INTEGER autoincrement NOT NULL ,
	codlot     TEXT NOT NULL ,
	nom        TEXT NOT NULL ,
	PRIMARY KEY (idlotsort)
);


#------------------------------------------------------------
# Table: pers_equipement
#------------------------------------------------------------
CREATE TABLE pers_equipement(
	idequipement      INTEGER autoincrement NOT NULL ,
	nomequipement     TEXT NOT NULL ,
	classeequipement  TEXT NOT NULL ,
	description       TEXT NOT NULL ,
	niveau            INTEGER NOT NULL ,
	classerequise     TEXT NOT NULL ,
	attribut1         TEXT ,
	attribut2         TEXT ,
	attribut3         TEXT ,
	codelot           TEXT ,
	idtypeequiment    INTEGER NOT NULL ,
	idlotequipement   INTEGER NOT NULL ,
	PRIMARY KEY (idequipement) ,
	
	FOREIGN KEY (idtypeequiment) REFERENCES pers_typeequipement(idtypeequiment),
	FOREIGN KEY (idlotequipement) REFERENCES pers_lotequipement(idlotequipement)
);


#------------------------------------------------------------
# Table: pers_typeequipement
#------------------------------------------------------------
CREATE TABLE pers_typeequipement(
	idtypeequiment  INTEGER autoincrement NOT NULL ,
	PRIMARY KEY (idtypeequiment)
);


#------------------------------------------------------------
# Table: pers_lotequipement
#------------------------------------------------------------
CREATE TABLE pers_lotequipement(
	idlotequipement  INTEGER autoincrement NOT NULL ,
	codlot           TEXT NOT NULL ,
	nom              TEXT NOT NULL ,
	PRIMARY KEY (idlotequipement)
);


#------------------------------------------------------------
# Table: avt_combatenemis
#------------------------------------------------------------
CREATE TABLE avt_combatenemis(
	idcombat  INTEGER NOT NULL ,
	idenemie  INTEGER NOT NULL ,
	PRIMARY KEY (idcombat,idenemie) ,
	
	FOREIGN KEY (idcombat) REFERENCES avt_combat(idcombat),
	FOREIGN KEY (idenemie) REFERENCES avt_enemie(idenemie)
);


#------------------------------------------------------------
# Table: avt_desaventure
#------------------------------------------------------------
CREATE TABLE avt_desaventure(
	iddes       INTEGER NOT NULL ,
	idaventure  INTEGER NOT NULL ,
	PRIMARY KEY (iddes,idaventure) ,
	
	FOREIGN KEY (iddes) REFERENCES avt_des(iddes),
	FOREIGN KEY (idaventure) REFERENCES avt_aventure(idaventure)
);


#------------------------------------------------------------
# Table: avt_parageapheaction
#------------------------------------------------------------
CREATE TABLE avt_parageapheaction(
	idaction      INTEGER NOT NULL ,
	idparagraphe  INTEGER NOT NULL ,
	PRIMARY KEY (idaction,idparagraphe) ,
	
	FOREIGN KEY (idaction) REFERENCES avt_action(idaction),
	FOREIGN KEY (idparagraphe) REFERENCES avt_paragraphe(idparagraphe)
);


#------------------------------------------------------------
# Table: pers_restrictionsexegenre
#------------------------------------------------------------
CREATE TABLE pers_restrictionsexegenre(
	idtypegenre  INTEGER NOT NULL ,
	idtypesexe   INTEGER NOT NULL ,
	PRIMARY KEY (idtypegenre,idtypesexe) ,
	
	FOREIGN KEY (idtypegenre) REFERENCES pers_typegenre(idtypegenre),
	FOREIGN KEY (idtypesexe) REFERENCES pers_typesexe(idtypesexe)
);


#------------------------------------------------------------
# Table: pers_personnagesort
#------------------------------------------------------------
CREATE TABLE pers_personnagesort(
	idinventaire  INTEGER NOT NULL ,
	idsort        INTEGER NOT NULL ,
	PRIMARY KEY (idinventaire,idsort) ,
	
	FOREIGN KEY (idinventaire) REFERENCES pers_inventaire(idinventaire),
	FOREIGN KEY (idsort) REFERENCES pers_sort(idsort)
);


#------------------------------------------------------------
# Table: pers_inventaireequipement
#------------------------------------------------------------
CREATE TABLE pers_inventaireequipement(
	idinventaire  INTEGER NOT NULL ,
	idequipement  INTEGER NOT NULL ,
	PRIMARY KEY (idinventaire,idequipement) ,
	
	FOREIGN KEY (idinventaire) REFERENCES pers_inventaire(idinventaire),
	FOREIGN KEY (idequipement) REFERENCES pers_equipement(idequipement)
);


