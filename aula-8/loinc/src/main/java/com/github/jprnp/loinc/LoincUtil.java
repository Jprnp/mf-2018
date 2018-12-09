package com.github.jprnp.loinc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoincUtil {
    public static Loinc createFromResultSet(ResultSet rs) throws SQLException {
        Loinc loinc = new Loinc();
        loinc.setLoincNum(rs.getString("loinc_num"));
        loinc.setComponent(rs.getString("component"));
        loinc.setProperty(rs.getString("property"));
        loinc.setSyst(rs.getString("syst"));
        loinc.setScaleTyp(rs.getString("scale_typ"));
        loinc.setMethodTyp(rs.getString("method_typ"));
        loinc.setClasse(rs.getString("class"));
        loinc.setStatus(rs.getString("status"));
        loinc.setConsumerName(rs.getString("consumer_name"));
        loinc.setClassType(rs.getInt("classtype"));
        loinc.setSpecies(rs.getString("species"));
        loinc.setShortName(rs.getString("shortname"));
        return loinc;
    }

    public static Loinc getByLoincNum(String loincNum) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM loinc WHERE loinc_num = " + loincNum;
        MySQLAccess sql = new MySQLAccess();

        return sql.select(query).get(0);
    }

    public static ArrayList<Loinc> getLikeLoincNum(String loincNum) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM loinc WHERE loinc_num LIKE %" + loincNum + "%";
        MySQLAccess sql = new MySQLAccess();

        return sql.select(query);
    }
}
