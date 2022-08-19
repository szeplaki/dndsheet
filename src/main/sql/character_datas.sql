DROP TABLE IF EXISTS dnd_character;
CREATE TABLE dnd_character (
    id serial NOT NULL PRIMARY KEY,
    character_name text,
    dice integer,
    character_level integer,
    strength integer,
    dexterity integer,
    constitution integer,
    intelligence integer,
    wisdom integer,
    charisma integer
);
INSERT INTO dnd_character (character_name, dice, character_level, strength, dexterity, constitution, intelligence, wisdom, charisma)  VALUES ('Thoradin Fireforge', 12, 3, 10, 10, 10, 10, 10, 10);
