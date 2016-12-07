import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Car implements CarInterface{

    public String marka;
    public String model;
    public int rocznik;
    public float pojemnosc;

    Car(){}
    Car(String mar, String mod, int rok, float poj ){
        this.marka=mar;
        this.model=mod;
        this.rocznik=rok;
        this.pojemnosc=poj;
    }


    public void insertCar(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Connect.conn = Connect.getConnection();
            stmt= Connect.conn.prepareStatement("insert into samochod(marka,model,rocznik,pojemnosc) values ('"+marka+"','"+model+"','"+rocznik+"','"+pojemnosc+"')");
            rs = stmt.executeQuery();
            System.out.println("Car "+marka+" "+model+" added !");

            rs.close();
            rs = null;
            stmt.close();
            stmt = null;
            Connect.conn.close(); // Return to connection pool
            Connect.conn = null;  // Make sure we don't close it twice
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            // Always make sure result sets and statements are closed,
            // and the connection is returned to the pool
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { ; }
                rs = null;
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { ; }
                stmt = null;
            }
            if (Connect.conn != null) {
                try { Connect.conn.close(); } catch (SQLException e) { ; }
                Connect.conn = null;
            }
        }
    }

    public static ArrayList<Car> getCars(){
        ArrayList<Car> cars = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Connect.conn = Connect.getConnection();
            stmt= Connect.conn.prepareStatement("select marka, model, rocznik, pojemnosc from samochod");
            rs = stmt.executeQuery();
            while(rs.next()){
                Car nowy = new Car();
                nowy.setMarka(rs.getString("marka"));
                nowy.setModel(rs.getString("model"));
                nowy.setRocznik(rs.getInt("rocznik"));
                nowy.setPojemnosc(rs.getFloat("pojemnosc"));
                cars.add(nowy);
            }
            rs.close();
            rs = null;
            stmt.close();
            stmt = null;
            Connect.conn.close(); // Return to connection pool
            Connect.conn = null;  // Make sure we don't close it twice
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            // Always make sure result sets and statements are closed,
            // and the connection is returned to the pool
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { ; }
                rs = null;
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { ; }
                stmt = null;
            }
            if (Connect.conn != null) {
                try { Connect.conn.close(); } catch (SQLException e) { ; }
                Connect.conn = null;
            }
        }
        return cars;
    }

    public static void selectCars(ArrayList<Car> cars){
        for(Car selected : cars){
            String mar=selected.getMarka();
            String mod=selected.getModel();
            int rok=selected.getRocznik();
            float poj=selected.getPojemnosc();

            System.out.println(mar+"\t"+mod+"\t"+rok+"\t"+poj);
        }
    }


    public String getMarka(){
        return this.marka;
    }
    public String getModel(){
        return this.model;
    }
    public int getRocznik(){
        return this.rocznik;
    }
    public float getPojemnosc(){
        return this.pojemnosc;
    }
    public void setMarka(String mar) {
        this.marka = mar;
    }
    public void setModel(String mod) {
        this.model = mod;
    }
    public void setRocznik(int rok) {
        this.rocznik = rok;
    }
    public void setPojemnosc(float poj) {
        this.pojemnosc = poj;
    }


}

