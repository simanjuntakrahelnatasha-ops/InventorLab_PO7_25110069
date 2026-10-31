package koneksi; // (Sesuaikan dengan nama package Anda)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class KoneksiDatabase {
    
    // KETIK / TEMPEL KODE KONFIGURASI DI SINI:
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db_inventori_lab";
    static final String USER = "root";
    static final String PASS = "";
    
    public static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;

    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil!");
            
            tampilkanData(); // Memanggil fungsi tampil data
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // KETIK / TEMPEL FUNGSI TAMPIL DATA DI SINI:
    public static void tampilkanData() {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM barang");
            
            System.out.println("\n--- DATA BARANG ---");
            while (rs.next()) {
                System.out.println("Kode: " + rs.getString("kode_barang") + 
                                   " | Nama: " + rs.getString("nama_barang"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}