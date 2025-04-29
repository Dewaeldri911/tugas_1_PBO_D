package CustomerPage;

import SahamPage.saham;
import SuratBerhargaNegaraPage.SurarBerhargaNegara;

import java.util.HashMap;
import java.util.Map;

// Customer adalah turunan dari User
public class Customer {
    private Map<saham.Saham, Integer> sahamDimiliki; // menyimpan saham yang dibeli beserta jumlahnya
    private Map<SurarBerhargaNegara.SuratBerhargaNegara, Double> sbnDimiliki; // menyimpan SBN yang dibeli dan nominal

    public Customer(String username, String password) {
        sahamDimiliki = new HashMap<>();
        sbnDimiliki = new HashMap<>();
    }

    // Getter daftar saham
    public Map<saham.Saham, Integer> getSahamDimiliki() {
        return sahamDimiliki;
    }

    // Getter daftar SBN
    public Map<SurarBerhargaNegara.SuratBerhargaNegara, Double> getSbnDimiliki() {
        return sbnDimiliki;
    }

    public Object getPassword() {
    return null;
    }
    public Object getUsername() {
    return null;
    }

    public <K, V> Map<K,V> getPortofolioSaham() {
    return null;
    }
    public <K, V> Map<K,V> getPortofolioSBN() {
        return Map.of();
    }
}

