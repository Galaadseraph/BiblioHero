CREATE TABLE avt_aventure(
	idaventure     INTEGER  NOT NULL ,
	nom            TEXT NOT NULL ,
	auteur         TEXT NOT NULL ,
	isbnserie      TEXT ,
	synopsis       TEXT ,
	nbparagraphe   INTEGER NOT NULL ,
	nvrequis       INTEGER ,
	classerequise  TEXT ,
	dictionnaire   BIT ,
	version        TEXT ,
	codetheme      TEXT ,
	isbnaventure   TEXT ,
	PRIMARY KEY (idaventure) ,

	FOREIGN KEY (codetheme) REFERENCES avt_theme(codetheme),
	FOREIGN KEY (isbnserie) REFERENCES avt_series(isbnserie)
);



CREATE TABLE avt_paragraphe(
	idparagraphe             INTEGER  NOT NULL ,
	texte                    TEXT NOT NULL ,
	nbevenement              INTEGER ,
	numparagraphe            INTEGER NOT NULL ,
	idaventure               INTEGER NOT NULL,
	PRIMARY KEY (idparagraphe) ,

	FOREIGN KEY (idaventure) REFERENCES avt_aventure(idaventure)
);



CREATE TABLE pers_personnage(
	permadeath                   BIT ,
	hommeDeFer                   BIT ,
	idpersonnage                 INTEGER  NOT NULL ,
	nom                          TEXT NOT NULL UNIQUE ,
	
	niveau                       INTEGER NOT NULL ,
	richesse                     REAL ,
	experience                   REAL ,
	pv                           INTEGER NOT NULL ,
	forcep                       INTEGER NOT NULL ,
	dexteritep                   INTEGER NOT NULL ,
	endurance                    INTEGER NOT NULL ,
	intelligence                 INTEGER NOT NULL ,
	moral			     INTEGER NOT NULL ,	
	estactif                     BIT ,
	codeequipe                   TEXT ,
	coderace                     TEXT NOT NULL ,
	codeclasse                   TEXT NOT NULL ,
	codesexe                     TEXT NOT NULL ,
	codegenre                    TEXT NOT NULL ,
	PRIMARY KEY (idpersonnage) ,

	FOREIGN KEY (codeequipe) REFERENCES pers_equipe(codeequipe),
	FOREIGN KEY (coderace) REFERENCES pers_typerace(coderace),
	FOREIGN KEY (codeclasse) REFERENCES pers_typeclasse(codeclasse),
	FOREIGN KEY (codesexe) REFERENCES pers_typesexe(codesexe),
	FOREIGN KEY (codegenre) REFERENCES pers_typegenre(codegenre)
);



CREATE TABLE lot_equipement(
	idequipement      INTEGER  NOT NULL ,
	nomequipement     TEXT NOT NULL ,
	codeequipement    TEXT NOT NULL ,
	description       TEXT NOT NULL ,
	niveau            INTEGER NOT NULL ,
	classerequise     TEXT NOT NULL ,
	attribut1         TEXT ,
	attribut2         TEXT ,
	attribut3         TEXT ,
	codelot           TEXT ,
	
	
	PRIMARY KEY (idequipement) ,

	FOREIGN KEY (codeequipement) REFERENCES lot_typeequipement(codeequipement),
	FOREIGN KEY (codelot) REFERENCES lot_lotequipement(codelot)
);



CREATE TABLE lot_typeequipement(
	idtypeequipement  	INTEGER  NOT NULL ,
	codeequipement 		TEXT NOT NULL UNIQUE ,
	nom 			TEXT NOT NULL ,
	PRIMARY KEY (idtypeequipement)
);



CREATE TABLE parametresaffichage(
	idparamaffichage  INTEGER  NOT NULL ,
	PRIMARY KEY (idparamaffichage)
);



CREATE TABLE avt_ennemi(
	idenemi  	INTEGER  NOT NULL ,
	coderace 	TEXT NOT NULL ,
	codeclasse 	TEXT NOT NULL ,
	niveau 		INTEGER NOT NULL ,
	forcep		INTEGER NOT NULL ,
	dexteritep	INTEGER NOT NULL ,
	endurance	INTEGER NOT NULL ,
	intelligence	INTEGER NOT NULL ,
	moral		INTEGER NOT NULL ,
	PRIMARY KEY (idenemi),

FOREIGN KEY (coderace) REFERENCES avt_typerace(coderace),
FOREIGN KEY (codeclasse) REFERENCES avt_typeclasse(codeclasse)
);



CREATE TABLE avt_action(
	idaction         INTEGER  NOT NULL ,
	description      TEXT NOT NULL ,
	effet            TEXT NOT NULL ,
	paragraphesuite  INTEGER NOT NULL ,
	codetypeaction   TEXT NOT NULL ,
	codecombat	 TEXT ,
	PRIMARY KEY (idaction) ,

	FOREIGN KEY (codeaction) REFERENCES avt_typeaction(codeaction),
	FOREIGN KEY (codecombat) REFERENCES avt_combat(codecombat)
);



CREATE TABLE avt_combat(
	idcombat  	INTEGER  NOT NULL ,
	codecombat 	TEXT NOT NULL ,
	PRIMARY KEY (idcombat)
);



CREATE TABLE avt_parametreaventure(
	idparamaventure  INTEGER  NOT NULL ,
	idaventure       INTEGER NOT NULL ,
	nomvariable 	 TEXT NOT NULL ,
	valeur		 TEXT NOT NULL ,
	PRIMARY KEY (idparamaventure) ,

	FOREIGN KEY (idaventure) REFERENCES avt_aventure(idaventure)
);



CREATE TABLE pers_equipe(
	idequipe 	  INTEGER  NOT NULL ,
	nom		  TEXT NOT NULL ,
	codeequipe	  TEXT NOT NULL,
	PRIMARY KEY (idequipe)
);



CREATE TABLE avt_des(
	iddes 		 INTEGER NOT NULL ,
	nombredefaces	 INTEGER NOT NULL ,
	nom		 TEXT NOT NULL ,
	PRIMARY KEY (iddes)
);



CREATE TABLE lot_sorts(
	idsort        INTEGER  NOT NULL ,
	nomsort       TEXT NOT NULL ,
	capacite      TEXT NOT NULL ,
	ecoledemagie  TEXT NOT NULL ,
	description   TEXT NOT NULL ,
	duree         INTEGER ,
	codelot       TEXT ,
	PRIMARY KEY (idsort) ,

	FOREIGN KEY (codelot) REFERENCES lot_lotsort(codelot)
);



CREATE TABLE pers_inventaire(
	idinventaire                  INTEGER  NOT NULL ,
	typeinventaire                TEXT NOT NULL ,
	nom                           TEXT NOT NULL ,
	nbemplacement                 INTEGER NOT NULL ,
	idpersonnage                  INTEGER NOT NULL ,
	codeinventaire                TEXT NOT NULL ,
	PRIMARY KEY (idinventaire) ,

	FOREIGN KEY (idpersonnage) REFERENCES pers_personnage(idpersonnage),
	FOREIGN KEY (codeinventaire) REFERENCES pers_typeDInventaire(codeinventaire)
);



CREATE TABLE pers_typeinventaire(
	idtypeinventaire  INTEGER  NOT NULL ,
	codeinventaire    TEXT NOT NULL UNIQUE ,
	nom               TEXT NOT NULL ,
	PRIMARY KEY (idtypeinventaire)
);




CREATE TABLE avt_typeaction(
	idtypeaction   INTEGER  NOT NULL ,
	codetypeaction TEXT NOT NULL UNIQUE ,
	nom            TEXT NOT NULL ,
	PRIMARY KEY (idtypeaction)
);



CREATE TABLE lot_lotequipement(
	idlotequipement  INTEGER  NOT NULL ,
	codelot          TEXT NOT NULL UNIQUE ,
	nom              TEXT NOT NULL ,
	PRIMARY KEY (idlotequipement)
);



CREATE TABLE lot_lotsort(
	idlotsort  INTEGER  NOT NULL ,
	codelot    TEXT NOT NULL UNIQUE ,
	nom        TEXT NOT NULL ,
	PRIMARY KEY (idlotsort)
);



CREATE TABLE avt_theme(
	idtheme   INTEGER  NOT NULL ,
	nomtheme  TEXT NOT NULL ,
	codetheme TEXT NOT NULL UNIQUE ,
	PRIMARY KEY (idtheme)
);



CREATE TABLE pers_pjpctempo(
	idpersonnage                  INTEGER  NOT NULL ,
	richesse                      REAL ,
	experience                    REAL ,
	pv                            INTEGER NOT NULL ,
	forcep                        INTEGER NOT NULL ,
	dexteritep                    INTEGER NOT NULL ,
	endurance                     INTEGER NOT NULL ,
	intelligence                  INTEGER NOT NULL ,
	moral			      INTEGER NOT NULL ,
	background                    TEXT NOT NULL ,
	PRIMARY KEY (idpersonnage) ,

	FOREIGN KEY (idpersonnage) REFERENCES pers_personnage(idpersonnage)
);



CREATE TABLE pers_typesexe(
	idtypesexe  INTEGER  NOT NULL ,
	codesexe    TEXT UNIQUE ,
	nom         TEXT ,
	PRIMARY KEY (idtypesexe)
);



CREATE TABLE pers_typeclasse(
	idtypeclasse  INTEGER  NOT NULL ,
	codeclasse    TEXT UNIQUE ,
	nom           TEXT ,
	PRIMARY KEY (idtypeclasse)
);



CREATE TABLE pers_typerace(
	idtyperace  INTEGER  NOT NULL ,
	coderace    TEXT UNIQUE ,
	nom         TEXT ,
	PRIMARY KEY (idtyperace)
);



CREATE TABLE pers_typegenre(
	idtypegenre  INTEGER  NOT NULL ,
	codegenre    TEXT UNIQUE ,
	nom          TEXT ,
	PRIMARY KEY (idtypegenre)
);



CREATE TABLE avt_series(
	idseries   INTEGER  NOT NULL ,
	isbnserie  TEXT NOT NULL UNIQUE ,
	nomserie   TEXT NOT NULL ,
	PRIMARY KEY (idseries)
);



CREATE TABLE pers_sort(
	idsort        INTEGER  NOT NULL ,
	nomsort       TEXT NOT NULL ,
	capacite      TEXT NOT NULL ,
	ecoledemagie  TEXT NOT NULL ,
	description   TEXT NOT NULL ,
	duree         INTEGER ,
	codelot       TEXT ,
	PRIMARY KEY (idsort) ,

	FOREIGN KEY (codelot) REFERENCES pers_lotsort(codelot)
);



CREATE TABLE pers_lotsort(
	idlotsort  INTEGER  NOT NULL ,
	codelot     TEXT NOT NULL UNIQUE ,
	nom        TEXT NOT NULL ,
	PRIMARY KEY (idlotsort)
);



CREATE TABLE pers_equipement(
	idequipement      INTEGER  NOT NULL ,
	nomequipement     TEXT NOT NULL ,
	classeequipement  TEXT NOT NULL ,
	description       TEXT NOT NULL ,
	niveau            INTEGER NOT NULL ,
	classerequise     TEXT NOT NULL ,
	attribut1         TEXT ,
	attribut2         TEXT ,
	attribut3         TEXT ,
	codelot           TEXT NOT NULL ,
	codeequipement    TEXT NOT NULL ,
	PRIMARY KEY (idequipement) ,

	FOREIGN KEY (codeequipement) REFERENCES pers_typeequipement(codeequipement),
	FOREIGN KEY (codelot) REFERENCES pers_lotequipement(codelot)
);



CREATE TABLE pers_typeequipement(
	idtypeequipement	INTEGER  NOT NULL ,
	nom			TEXT NOT NULL ,
	codeequipement 		TEXT NOT NULL ,
	PRIMARY KEY (idtypeequipement)
);



CREATE TABLE pers_lotequipement(
	idlotequipement  INTEGER  NOT NULL ,
	codelot          TEXT NOT NULL UNIQUE ,
	nom              TEXT NOT NULL ,
	PRIMARY KEY (idlotequipement)
);



CREATE TABLE avt_combatennemi(
	idcombat  INTEGER NOT NULL ,
	idennemi  INTEGER NOT NULL ,
	PRIMARY KEY (idcombat,idennemi) ,

	FOREIGN KEY (idcombat) REFERENCES avt_combat(idcombat),
	FOREIGN KEY (idennemi) REFERENCES avt_ennemi(idennemi)
);



CREATE TABLE avt_desaventure(
	iddes       INTEGER NOT NULL ,
	idaventure  INTEGER NOT NULL ,
	
	PRIMARY KEY (iddes,idaventure) ,

	FOREIGN KEY (iddes) REFERENCES avt_des(iddes),
	FOREIGN KEY (idaventure) REFERENCES avt_aventure(idaventure)
);



CREATE TABLE avt_paragrapheaction(
	idparagrapheaction 	 INTEGER NOT NULL ,
	idaction     		 INTEGER NOT NULL ,
	idparagraphe		 INTEGER NOT NULL ,
	PRIMARY KEY (idparagrapheaction) ,

	FOREIGN KEY (idaction) REFERENCES avt_action(idaction),
	FOREIGN KEY (idparagraphe) REFERENCES avt_paragraphe(idparagraphe)
);



CREATE TABLE pers_restrictionsexegenre(
	codegenre  INTEGER NOT NULL ,
	codesexe   INTEGER NOT NULL ,
	PRIMARY KEY (codegenre,codesexe) ,

	FOREIGN KEY (codegenre) REFERENCES pers_typegenre(codegenre),
	FOREIGN KEY (codesexe) REFERENCES pers_typesexe(codesexe)
);



CREATE TABLE pers_personnagesort(
	idinventaire  INTEGER NOT NULL ,
	idsort        INTEGER NOT NULL ,
	PRIMARY KEY (idinventaire,idsort) ,

	FOREIGN KEY (idinventaire) REFERENCES pers_inventaire(idinventaire),
	FOREIGN KEY (idsort) REFERENCES pers_sort(idsort)
);



CREATE TABLE pers_inventaireequipement(
	idinventaire  INTEGER NOT NULL ,
	idequipement  INTEGER NOT NULL ,
	PRIMARY KEY (idinventaire,idequipement) ,

	FOREIGN KEY (idinventaire) REFERENCES pers_inventaire(idinventaire),
	FOREIGN KEY (idequipement) REFERENCES pers_equipement(idequipement)
);


