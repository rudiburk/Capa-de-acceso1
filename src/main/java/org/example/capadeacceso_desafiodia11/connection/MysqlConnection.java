package org.example.capadeacceso_desafiodia11.connection;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Getter
public class MysqlConnection {

        private static MysqlConnection instance;
        private Connection connection;
        private String jdbcURL = "jdbc:mysql://localhost:3306/providers";
        private String jdbcUsername = "root";
        private String jdbcPassword = "aikota11";

        private MysqlConnection() throws SQLException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (ClassNotFoundException | SQLException e) {
                throw new SQLException(e);
            }
        }
        public static MysqlConnection getInstance() throws SQLException {
            if (instance == null) {
                instance = new MysqlConnection();
            }
            return instance;
        }

    public Connection getConnection() {
        try {
            // Verificar si la conexión está cerrada o no válida antes de devolverla
            if (connection.isClosed() || !connection.isValid(10)) {
                this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Considera un manejo de excepciones más robusto en producción
        }
        return connection;
    }

    // Método para cerrar la conexión (opcional)
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Considera un manejo de excepciones más robusto en producción
        }
    }
    }

