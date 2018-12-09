package com.github.jprnp.loinc;

import java.sql.*;
import java.util.ArrayList;

public class MySQLAccess {
    private Connection connect = null;

    public MySQLAccess() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://localhost/loinc?"
                                + "user=sqluser&password=sqluser&serverTimezone=UTC&useSSL=false");
    }

    public ArrayList<Loinc> select(String query) throws SQLException {
        ArrayList<Loinc> result = new ArrayList<Loinc>();

        PreparedStatement pstmt = this.connect.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery(query);

        while(rs.next()) {
            result.add(LoincUtil.createFromResultSet(rs));
        }

        rs.close();
        pstmt.close();
        this.close();

        return result;
    }

    private void close() throws SQLException {
        this.connect.close();
    }
}
