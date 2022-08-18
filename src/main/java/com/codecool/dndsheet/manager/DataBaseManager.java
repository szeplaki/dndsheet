package com.codecool.dndsheet.manager;

import com.codecool.dndsheet.dao.CharacterDaoJDBC;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DataBaseManager {

        private CharacterDaoJDBC characterDaoJDBC;

        private DataSource dataSource;

        public void setup() throws SQLException {
            this.dataSource = connect();
            this.characterDaoJDBC = new CharacterDaoJDBC(dataSource);
        }

        public void run() {
            try {
                setup();
            } catch (SQLException throwable) {
                System.err.println("Could not connect to the database.");
                return;
            }
        }

        public CharacterDaoJDBC getCharacterDaoJDBC() {
            return this.characterDaoJDBC;
        }

        private DataSource connect() throws SQLException {
            PGSimpleDataSource dataSource = new PGSimpleDataSource();

            String dbName = System.getenv("PSQL_DB_NAME");
            String user = System.getenv("PSQL_USER_NAME");
            String password = System.getenv("PSQL_PASSWORD");

            dataSource.setDatabaseName(dbName);
            dataSource.setUser(user);
            dataSource.setPassword(password);

            dataSource.getConnection().close();
            System.out.println("Connection ok.");

            return dataSource;
        }
    }

