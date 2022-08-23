DROP TABLE IF EXISTS dnd_character;
CREATE TABLE dnd_character (
    id SERIAL PRIMARY KEY,
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