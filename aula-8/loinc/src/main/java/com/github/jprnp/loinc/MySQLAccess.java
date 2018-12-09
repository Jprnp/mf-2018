package com.github.jprnp.loinc;

import java.sql.*;
import java.util.ArrayList;

public class MySQLAccess {
    private Connection connect = null;

    public MySQLAccess() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://localhost/loinc?"
                                + "user=sqluser&password=sqluser");
    }

    public ArrayList<Loinc> select(String query) throws SQLException {
        ArrayList<Loinc> result = new ArrayList<Loinc>();

        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while(rs.next()) {
            result.add(LoincUtil.createFromResultSet(rs));
        }

        rs.close();
        statement.close();
        this.close();

        return result;
    }

    private void close() throws SQLException {
        this.connect.close();
    }
}
