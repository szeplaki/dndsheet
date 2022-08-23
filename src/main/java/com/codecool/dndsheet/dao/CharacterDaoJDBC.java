package com.codecool.dndsheet.dao;

import com.codecool.dndsheet.model.DndCharacter;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterDaoJDBC implements CharacterDao {

    private DataSource dataSource;

    public CharacterDaoJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void add(DndCharacter character) {
        try(Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO dnd_character (character_name, dice, character_level, strength, dexterity, constitution, intelligence, wisdom, charisma) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, character.getCharacterName());
            st.setInt(2, character.getDice());
            st.setInt(3, character.getCharacterLevel());
            st.setInt(4, character.getStrength());
            st.setInt(5, character.getDexterity());
            st.setInt(6, character.getConstitution());
            st.setInt(7, character.getIntelligence());
            st.setInt(8, character.getWisdom());
            st.setInt(9, character.getCharisma());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            character.setId(rs.getInt(1));

        } catch (SQLException throwables) {
            throw new RuntimeException("Error while adding new Dnd Character.", throwables);
        }
    }

    @Override
    public List<DndCharacter> getAll() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM dnd_character";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            List<DndCharacter> result = new ArrayList<>();
            while (rs.next()) {
                DndCharacter dndCharacter = new DndCharacter(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
                dndCharacter.setId(rs.getInt(1));
                result.add(dndCharacter);
            }
            if (result.isEmpty()) {
                return null;
            }
            //return result.get(0);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading all authors", e);
        }
    }

    @Override
    public DndCharacter find(int id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT character_name, dice, character_level, strength, dexterity, constitution, intelligence, wisdom, charisma FROM dnd_character WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
            DndCharacter dndCharacter = new DndCharacter(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
            dndCharacter.setId(id);
            return dndCharacter;
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading character with id: " + id, e);
        }
    }


    @Override
    public void update(DndCharacter character) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "UPDATE dnd_character SET character_name = ?, dice = ?, character_level = ?, strength = ?, dexterity = ?, constitution = ?, intelligence = ?, wisdom = ?, charisma = ? WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, character.getCharacterName());
            st.setInt(2, character.getDice());
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
