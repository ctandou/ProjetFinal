package DAO;

import Model.DiscountCode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class DAO {

    protected final DataSource myDataSource;

    public DAO(DataSource dataSource) {
        this.myDataSource = dataSource;
    }

    //ajouter
    public void ajouterCode(String code, float taux) throws DAOException {
        // Une requête SQL paramétrée
        String sql = "INSERT INTO DISCOUNT_CODE VALUES (?, ?)";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            //Parametre 1
            stmt.setString(1, code);
            //Parametre 2
            stmt.setFloat(2, taux);

            //On execute la requete
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }
    }

    //delete
    public void deleteCode(String code) throws DAOException {

        // Une requête SQL paramétrée
        String sql = "DELETE FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, code);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }
    }

    //Liste des codes
    public List<DiscountCode> listCode() throws DAOException {
        List<DiscountCode> result = new ArrayList<>();

        String sql = "SELECT * FROM DISCOUNT_CODE";
        try (Connection connection = myDataSource.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                result.add(new DiscountCode(rs.getString("DISCOUNT_CODE"), rs.getFloat("RATE")));
            }

        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }

        return result;

    }
}
