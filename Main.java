package Main;

import CustomerPage.Customer;
import SahamPage.saham;
import SuratBerhargaNegaraPage.SurarBerhargaNegara;
import adminPage.Admin;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static ArrayList<saham.Saham> daftarSaham = new ArrayList<>();
    static ArrayList<SurarBerhargaNegara.SuratBerhargaNegara> daftarSBN = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static Admin admin = new Admin("admin", "admin123");
    static Scanner scanner = new Scanner(System.in);
    static Customer currentCustomer = null;

    public static void main(String[] args) {
        customers.add(new Customer("user", "user123"));

        while (true) {
            System.out.println("===== MENU UTAMA =====");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            if (pilih == 1) {
                login();
            } else if (pilih == 2) {
                System.out.println("Terima kasih!");
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            menuAdmin();
        } else {
            for (Customer c : customers) {
                if (c.getUsername().equals(username) && c.getPassword().equals(password)) {
                    currentCustomer = c;
                    menuCustomer();
                    return;
                }
            }
            System.out.println("Login gagal.");
        }
    }

    public static void menuAdmin() {
        while (true) {
            System.out.println("===== MENU ADMIN =====");
            System.out.println("1. Saham");
            System.out.println("2. SBN");
            System.out.println("3. Logout");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            if (pilih == 1) {
                menuSaham();
            } else if (pilih == 2) {
                menuSBN();
            } else if (pilih == 3) {
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void menuSaham() {
        while (true) {
            System.out.println("===== MENU SAHAM =====");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Kembali");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            if (pilih == 1) {
                tambahSaham();
            } else if (pilih == 2) {
                ubahHargaSaham();
            } else if (pilih == 3) {
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void tambahSaham() {
        System.out.print("Kode: ");
        String kode = scanner.nextLine();
        System.out.print("Nama Perusahaan: ");
        String nama = scanner.nextLine();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();

        daftarSaham.add(new saham.Saham(kode, nama, harga));
        System.out.println("Saham berhasil ditambahkan.");
    }

    public static void ubahHargaSaham() {
        lihatDaftarSaham();
        System.out.print("Pilih indeks saham: ");
        int idx = scanner.nextInt();
        scanner.nextLine();
        if (idx >= 0 && idx < daftarSaham.size()) {
            System.out.print("Harga baru: ");
            double harga = scanner.nextDouble();
            scanner.nextLine();
            daftarSaham.get(idx).setHarga(harga);
            System.out.println("Harga saham berhasil diubah.");
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    public static void menuSBN() {
        while (true) {
            System.out.println("===== MENU SBN =====");
            System.out.println("1. Tambah SBN");
            System.out.println("2. Kembali");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            if (pilih == 1) {
                tambahSBN();
            } else if (pilih == 2) {
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void tambahSBN() {
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Bunga (%): ");
        double bunga = scanner.nextDouble();
        System.out.print("Jangka Waktu (tahun): ");
        int jangkaWaktu = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tanggal Jatuh Tempo: ");
        String tjt = scanner.nextLine();
        System.out.print("Kuota Nasional: ");
        double kuota = scanner.nextDouble();
        scanner.nextLine();

        daftarSBN.add(new SurarBerhargaNegara.SuratBerhargaNegara(nama, bunga, jangkaWaktu, tjt, kuota));
        System.out.println("SBN berhasil ditambahkan.");
    }

    public static void menuCustomer() {
        while (true) {
            System.out.println("===== MENU CUSTOMER =====");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Portofolio");
            System.out.println("6. Logout");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1:
                    beliSaham();
                    break;
                case 2:
                    jualSaham();
                    break;
                case 3:
                    beliSBN();
                    break;
                case 4:
                    simulasiSBN();
                    break;
                case 5:
                    lihatPortofolio();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void beliSaham() {
        lihatDaftarSaham();
        System.out.print("Pilih indeks saham: ");
        int idx = scanner.nextInt();
        scanner.nextLine();
        if (idx >= 0 && idx < daftarSaham.size()) {
            saham.Saham saham = daftarSaham.get(idx);
            System.out.print("Jumlah lembar: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Pembelian saham berhasil.");
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    public static void jualSaham() {
        lihatPortofolioSaham();
        System.out.print("Pilih indeks saham: ");
        int idx = scanner.nextInt();
        scanner.nextLine();
        if (idx >= 0 && idx < currentCustomer.getPortofolioSaham().size()) {
            saham.Saham saham = (saham.Saham) currentCustomer.getPortofolioSaham().keySet().toArray()[idx];
            System.out.print("Jumlah lembar yang dijual: ");
            int jual = scanner.nextInt();
            scanner.nextLine();
            int dimiliki = (int) currentCustomer.getPortofolioSaham().get(saham);
            if (jual > dimiliki) {
                System.out.println("Gagal, lembar saham tidak cukup.");
            } else {
                currentCustomer.getPortofolioSaham().put(saham, dimiliki - jual);
                currentCustomer.getPortofolioSaham().get(saham);
                currentCustomer.getPortofolioSaham().remove(saham);
                System.out.println("Penjualan saham berhasil.");
            }
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    public static void beliSBN() {
        lihatDaftarSBN();
        System.out.print("Pilih indeks SBN: ");
        int idx = scanner.nextInt();
        scanner.nextLine();
        if (idx >= 0 && idx < daftarSBN.size()) {
            SurarBerhargaNegara.SuratBerhargaNegara sbn = daftarSBN.get(idx);
            System.out.print("Nominal pembelian: ");
            double nominal = scanner.nextDouble();
            scanner.nextLine();
            if (nominal <= sbn.getKuotaNasional()) {
                sbn.kurangiKuota(nominal);
                System.out.println("Pembelian SBN berhasil.");
            } else {
                System.out.println("Gagal, kuota nasional tidak cukup.");
            }
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    public static void simulasiSBN() {
        System.out.print("Masukkan nominal investasi: ");
        double nominal = scanner.nextDouble();
        System.out.print("Masukkan persen bunga: ");
        double bunga = scanner.nextDouble();
        double hasil = bunga / 12 / 100 * 0.9 * nominal;
        System.out.println("Estimasi kupon per bulan: Rp " + hasil);
    }

    public static void lihatPortofolio() {
        System.out.println("===== PORTOFOLIO =====");
        lihatPortofolioSaham();
        lihatPortofolioSBN();
    }

    public static void lihatPortofolioSaham() {
        System.out.println(">> SAHAM:");
        int i = 0;
        for (Map.Entry<Object, Object> entry : currentCustomer.getPortofolioSaham().entrySet()) {
            saham.Saham saham = (saham.Saham) entry.getKey();
            int jumlah = (int) entry.getValue();
            System.out.println(i++ + ". " + saham.getNamaPerusahaan() + " (" + saham.getKode() + ") - " + jumlah + " lembar");
        }
    }

    public static void lihatPortofolioSBN() {
        System.out.println(">> SBN:");
        for (Map.Entry<Object, Object> entry : currentCustomer.getPortofolioSBN().entrySet()) {
            SurarBerhargaNegara.SuratBerhargaNegara sbn = (SurarBerhargaNegara.SuratBerhargaNegara) entry.getKey();
            double nominal = (double) entry.getValue();
            double kupon = sbn.getBunga() / 12 / 100 * 0.9 * nominal;
            System.out.println("- " + sbn.getNama() + ": Rp " + nominal + " (Kupon/bulan: Rp " + kupon + ")");
        }
    }

    public static void lihatDaftarSaham() {
        System.out.println("===== DAFTAR SAHAM =====");
        for (int i = 0; i < daftarSaham.size(); i++) {
            saham.Saham s = daftarSaham.get(i);
            System.out.println(i + ". " + s.getKode() + " - " + s.getNamaPerusahaan() + " @ Rp" + s.getHarga());
        }
    }

    public static void lihatDaftarSBN() {
        System.out.println("===== DAFTAR SBN =====");
        for (int i = 0; i < daftarSBN.size(); i++) {
            SurarBerhargaNegara.SuratBerhargaNegara sbn = daftarSBN.get(i);
            System.out.println(i + ". " + sbn.getNama() + " - Bunga: " + sbn.getBunga() + "%, Kuota: Rp" + sbn.getKuotaNasional());
        }
    }
}
