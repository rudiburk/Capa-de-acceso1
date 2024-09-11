package org.example.capadeacceso_desafiodia11.dao.daoimpl;

import org.example.capadeacceso_desafiodia11.connection.MysqlConnection;
import org.example.capadeacceso_desafiodia11.dao.ProviderDAO;
import org.example.capadeacceso_desafiodia11.model.ProviderDTO;
import org.example.capadeacceso_desafiodia11.service.serviceimpl.ProviderServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProviderDAOimpl implements ProviderDAO {

    private static final String SELECT_ALL_PROVIDERS="SELECT id, nombre, rut, email, direccion, numero_telefono, contacto, numero_contacto FROM providers";
    private static final String SELECT_PROVIDER_BY_ID = "SELECT id, nombre, rut, email, direccion, numero_telefono, contacto, numero_contacto FROM providers WHERE id=?";
    private static final String INSERT_PROVIDER_SQL="INSERT INTO providers (nombre, rut, email, direccion, numero_telefono, contacto, numero_contacto) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE_PROVDER_SQL="UPDATE providers SET nombre = ?,rut = ?, email = ?, direccion = ?, numero_telefono = ?, contacto = ?, numero_contacto = ? WHERE id =?";
    private static final String DELETE_PROVIDER_SQL="DELETE FROM providers WHERE id = ?";

    public ProviderDAOimpl(){
    }
    @Override
    public ProviderDTO selectProvider(int id) {
        ProviderDTO provider = null;
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(SELECT_PROVIDER_BY_ID)){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("nombre");
                String rut = rs.getString("rut");
                String addres = rs.getString("direccion");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("numero_telefono");
                String contact = rs.getString("contacto");
                String phoneNumberContact = rs.getString("numero_contacto");
                provider = new ProviderDTO(id, name,rut, addres, email, phoneNumber, contact, phoneNumberContact);
            }
        }catch (SQLException e) {
                 e.printStackTrace();
        }
        return provider;
    }

    @Override
    public List<ProviderDTO> selectAllProviders() {
        List<ProviderDTO> providers = new ArrayList<>();
        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_PROVIDERS)){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("nombre");
                String rut = rs.getString("rut");
                String addres = rs.getString("direccion");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("numero_telefono");
                String contact = rs.getString("contacto");
                String phoneNumberContact = rs.getString("numero_contacto");
                providers.add(new ProviderDTO(id,name,rut,addres,email,phoneNumber,contact,phoneNumberContact));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return providers;
    }

    @Override
    public ProviderDTO insertProvider(ProviderDTO provider) {
        ProviderDTO newProvider = null;
        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(INSERT_PROVIDER_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, provider.getName());
            pstmt.setString(2, provider.getRut());
            pstmt.setString(3, provider.getEmail());
            pstmt.setString(4, provider.getAddress());
            pstmt.setString(5, provider.getPhoneNumber());
            pstmt.setString(6, provider.getContact());
            pstmt.setString(7, provider.getPhoneNumberContact());
            int affectedRows = pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    newProvider = new ProviderDTO(id, provider.getName(), provider.getRut(), provider.getAddress(), provider.getEmail(), provider.getPhoneNumber(), provider.getContact(), provider.getPhoneNumberContact());
                } else {
                    throw new SQLException("No se pudo obtener el ID generado para el proveedor insertado.");
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newProvider;
    }

    @Override
    public ProviderDTO updateProvider(ProviderDTO provider) {
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(UPDATE_PROVDER_SQL)) {
            pstmt.setString(1, provider.getName());
            pstmt.setString(2, provider.getRut());
            pstmt.setString(3, provider.getEmail());
            pstmt.setString(4, provider.getAddress());
            pstmt.setString(5, provider.getPhoneNumber());
            pstmt.setString(6, provider.getContact());
            pstmt.setString(7, provider.getPhoneNumberContact());
            pstmt.setInt(8, provider.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return provider;
    }

    @Override
    public boolean deleteProvider(int id) {
        boolean rowDeleted;
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(DELETE_PROVIDER_SQL)){
            pstmt.setInt(1,id);
            rowDeleted = pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return rowDeleted;

    }
}
