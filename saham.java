package SahamPage;

import java.util.HashMap;
import java.util.Map;

public class saham {
    // Class untuk menyimpan data saham
    public static class Saham {
        private String kode; // kode saham (contoh: BBCA)
        private String namaPerusahaan;
        private double harga; // harga per lembar

        // Constructor Saham
        public Saham(String kode, String namaPerusahaan, double harga) {
            this.kode = kode;
            this.namaPerusahaan = namaPerusahaan;
            this.harga = harga;
        }

        // Getter kode saham
        public String getKode() {
            return kode;
        }

        // Getter nama perusahaan
        public String getNamaPerusahaan() {
            return namaPerusahaan;
        }

        // Getter harga saham
        public double getHarga() {
            return harga;
        }

        // Setter harga saham
        public void setHarga(double harga) {
            this.harga = harga;
        }
    }

}
