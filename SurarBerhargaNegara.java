package SuratBerhargaNegaraPage;

import java.time.LocalDate;

public class SurarBerhargaNegara {
    public  LocalDate gettanggalterbit;


    // Class untuk menyimpan data SBN
    public static class SuratBerhargaNegara {
        private String nama;
        private double bunga; // bunga tahunan
        private int jangkaWaktu; // dalam tahun
        private LocalDate tanggalJatuhTempo;
        private double kuotaNasional; // sisa kuota yang tersedia

        // Constructor SBN
        public SuratBerhargaNegara(String nama, double bunga, int jangkaWaktu, LocalDate tanggalJatuhTempo, double kuotaNasional) {
            this.nama = nama;
            this.bunga = bunga;
            this.jangkaWaktu = jangkaWaktu;
            this.tanggalJatuhTempo = tanggalJatuhTempo;
            this.kuotaNasional = kuotaNasional;
        }

        public SuratBerhargaNegara(String nama, double bunga, int jangkaWaktu, String tjt, double kuota) {

        }

        // Getter nama SBN
        public String getNama() {
            return nama;
        }

        // Getter bunga
        public double getBunga() {
            return bunga;
        }

        // Getter jangka waktu
        public int getJangkaWaktu() {
            return jangkaWaktu;
        }

        // Getter tanggal jatuh tempo
        public LocalDate getTanggalJatuhTempo() {
            return tanggalJatuhTempo;
        }

        // Getter kuota nasional
        public double getKuotaNasional() {
            return kuotaNasional;
        }

        // Method untuk mengurangi kuota nasional
        public void kurangiKuota(double jumlah) {
            this.kuotaNasional -= jumlah;
        }
    }

}
