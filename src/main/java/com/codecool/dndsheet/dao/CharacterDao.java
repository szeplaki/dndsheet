package com.codecool.dndsheet.dao;

import com.codecool.dndsheet.model.DndCharacter;

import java.util.List;

public interface CharacterDao {

    void add(DndCharacter character);
    List<DndCharacter> getAll();
    DndCharacter find(int id);
    void update(DndCharacter character);
    void remove(int id);
}
