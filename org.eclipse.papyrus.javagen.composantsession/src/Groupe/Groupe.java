package Groupe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Groupe extends SqlUtils {
    private String id;
    private String eleveID;
    private String sujetID;
    private String ueID;

    public Groupe(String id, String eleveID, String sujetID, String ueID) {
        this.id = id;
        this.eleveID = eleveID;
        this.sujetID = sujetID;
        this.ueID = ueID;
    }

    public void save() {
        this.connect();
        this.requestUpdate(String.format("INSERT INTO GROUPE (id, eleveID, sujetID, ueID) VALUES('%s','%s','%s','%s')", 
            this.id, this.eleveID, this.sujetID, this.ueID));
        this.disconnect();
    }

    public void update() {
        this.connect();
        this.requestUpdate(String.format("UPDATE GROUPE SET eleveID='%s', sujetID='%s', ueID='%s' WHERE ID='%s'",
                this.eleveID, this.sujetID, this.ueID, this.id));
        this.disconnect();
    }

    public void delete() {
        this.connect();
        this.requestUpdate(String.format("DELETE FROM GROUPE WHERE ID='%s'", this.id));
        this.disconnect();
    }

    public static Groupe getById(String id) {
        SqlUtils sql = new SqlUtils();
        sql.connect();
        ResultSet set = sql.requestSelect(String.format("SELECT * FROM GROUPE WHERE ID='%s'", id));

        try {
            if (set.next()) {
                Groupe groupe = new Groupe(set.getString("ID"), set.getString("eleveID"), set.getString("sujetID"), set.getString("ueID"));
                sql.disconnect();
                return groupe;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.disconnect();
        return null;
    }

    public static List<Groupe> getAll() {
        
        SqlUtils sql = new SqlUtils();
        sql.connect();
        ResultSet set = sql.requestSelect("SELECT * FROM GROUPE");
        
        List<Groupe> result = new ArrayList<>();

        try {
            while (set.next()) {
                Groupe groupe = new Groupe(set.getString("ID"), set.getString("eleveID"), set.getString("sujetID"), set.getString("ueID"));
                result.add(groupe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            sql.disconnect();
            return result;
        }
        sql.disconnect();
		return result;
        
    }

    @Override
    public String toString() {
        return "id= " + id +" "+ ':'+ '\n' +
                "eleveID='" + eleveID + '\n' +
                "sujetID='" + sujetID + '\n' +
                "ueID='" + ueID + '\n' +
                '\n';
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getEleveID() { return eleveID; }
    public void setEleveID(String eleveID) { this.eleveID = eleveID; }
    public String getSujetID() { return sujetID; }
    public void setSujetID(String sujetID) { this.sujetID = sujetID; }
    public String getUeID() { return ueID; }
    public void setUeID(String ueID) { this.ueID = ueID; }
}
