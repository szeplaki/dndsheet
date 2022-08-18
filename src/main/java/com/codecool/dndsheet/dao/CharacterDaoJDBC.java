package com.codecool.dndsheet.dao;

import com.codecool.dndsheet.model.DndCharacter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharacterDaoJDBC implements CharacterDao {

    private DataSource dataSource;

    public CharacterDaoJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void add(DndCharacter character) {

    }

    @Override
    public DndCharacter get() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM dnd_character";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            List<DndCharacter> result = new ArrayList<>();
            while (rs.next()) {
                DndCharacter dndCharacter = new DndCharacter(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
                dndCharacter.setId(rs.getInt(1));
                result.add(dndCharacter);
            }
            return result.get(0);
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading all authors", e);
        }
    }

    @Override
    public DndCharacter find(int id) {
        return null;
    }

    @Override
    public void update(DndCharacter character) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "UPDATE dnd_character SET character_name = ?, class_name = ?, character_level = ?, strength = ?, dexterity = ?, constitution = ?, intelligence = ?, wisdom = ?, charisma = ? WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, character.getCharacterName());
            st.setInt(2, character.getClassName());
            st.setInt(3, character.getCharacterLevel());
            st.setInt(4, character.getStrength());
            st.setInt(5, character.getDexterity());
            st.setInt(6, character.getConstitution());
            st.setInt(7, character.getIntelligence());
            st.setInt(8, character.getWisdom());
            st.setInt(9, character.getCharisma());
            st.setInt(10, character.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {

    }
}
