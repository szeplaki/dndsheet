package com.codecool.dndsheet.dao;

import com.codecool.dndsheet.model.DndCharacter;

public interface CharacterDao {

    void add(DndCharacter character);
    DndCharacter get();
    DndCharacter find(int id);
    void update(DndCharacter character);
    void remove(int id);
}
