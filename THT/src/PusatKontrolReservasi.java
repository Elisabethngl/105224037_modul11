import java.util.ArrayList;
import java.util.List;

public class PusatKontrolReservasi {
    private List<KeretaApi> daftarKereta;

    public PusatKontrolReservasi() {
        daftarKereta = new ArrayList<>();
    }
    public void tambahKereta(KeretaApi kereta) {
        daftarKereta.add(kereta);
    }
    public List<KeretaApi> getDaftarKereta() {
        return daftarKereta;
    }
    public void prosesPemesanan(String kodeKereta, String nik, String namaPenumpang, int jumlahTiket)
            throws RuteTidakDitemukanException, TiketHabisException {

        if (nik.length() != 16) {
            throw new DataPenumpangTidakValidException(
                "NIK harus tepat 16 karakter! NIK Anda: " + nik.length() + " karakter.");
        }
        for (char c : nik.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new DataPenumpangTidakValidException(
                    "NIK hanya boleh mengandung angka!");
            }
        }
        KeretaApi keretaDipilih = null;
        for (KeretaApi k : daftarKereta) {
            if (k.getKodeKereta().equalsIgnoreCase(kodeKereta)) {
                keretaDipilih = k;
                break;
            }
        }

        if (keretaDipilih == null) {
            throw new RuteTidakDitemukanException(
                "Kereta dengan kode '" + kodeKereta + "' tidak ditemukan!");
        }

        if (jumlahTiket > keretaDipilih.getSisaKursi()) {
            throw new TiketHabisException(
                "Kursi tidak mencukupi! Tiket diminta: " + jumlahTiket,
                keretaDipilih.getNamaKereta(),
                keretaDipilih.getSisaKursi());
        }

        keretaDipilih.kurangiKursi(jumlahTiket);
        System.out.println("  PESANAN TIKET BERHASIL!");
        System.out.println("  Nama Penumpang : " + namaPenumpang);
        System.out.println("  NIK            : " + nik);
        System.out.println("  Kereta         : " + keretaDipilih.getNamaKereta());
        System.out.println("  Rute           : " + keretaDipilih.getRute());
        System.out.println("  Jumlah Tiket   : " + jumlahTiket);
        System.out.println("  Sisa Kursi     : " + keretaDipilih.getSisaKursi());
    }
}