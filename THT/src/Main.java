import java.util.Scanner;

public class Main {

    static PusatKontrolReservasi sistem = new PusatKontrolReservasi();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        sistem.tambahKereta(new KeretaApi("K01", "Argo Bromo",  "JKT-SBY", 50));
        sistem.tambahKereta(new KeretaApi("K02", "Parahyangan", "JKT-BDG", 15));

        boolean running = true;
        while (running) {
            tampilkanMenu();
            try {
                int pilihan = Integer.parseInt(scanner.nextLine().trim());
                switch (pilihan) {
                    case 1:
                        lihatJadwal();
                        break;
                    case 2:
                        pesanTiket();
                        break;
                    case 3:
                        running = false;
                        System.out.println();
                        break;
                    default:
                        System.out.println("[!] Pilihan tidak valid. Masukkan angka 1-3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[!] Erorr, harus masukkan angka.");
            }
        }

        try {
            tutupSistem();
        } finally {
            System.out.println("Sistem ditutup");
        }
    }

    static void tampilkanMenu() {
        System.out.println("\nMENU UTAMA");
        System.out.println("1. Lihat Jadwal Kereta");
        System.out.println("2. Pesan Tiket");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu: ");
    }

    static void lihatJadwal() {
        System.out.println("\nJADWAL KERETA TERSEDIA");
        System.out.printf("| %-5s | %-15s | %-10s | %s%n","Kode", "Nama Kereta", "Rute", "Kursi");
        for (KeretaApi k : sistem.getDaftarKereta()) {
            System.out.println(k);
        }
    }

    static void pesanTiket() {
        System.out.println("\nFORM PEMESANAN TIKET ");

        try {
            System.out.print("Kode Kereta   : ");
            String kodeKereta = scanner.nextLine().trim();
            System.out.print("NIK harus 16 digit : ");
            String nik = scanner.nextLine().trim();
            System.out.print("Nama Penumpang: ");
            String nama = scanner.nextLine().trim();
            System.out.print("Jumlah Tiket  : ");
            int jumlahTiket;
            try {
                jumlahTiket = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[!] Jumlah tiket harus berupa angka.");
                return;
            }

            sistem.prosesPemesanan(kodeKereta, nik, nama, jumlahTiket);

        } catch (DataPenumpangTidakValidException e) {
            System.out.println("[ERROR] Data tidak valid: " + e.getMessage());
        } catch (RuteTidakDitemukanException e) {
            System.out.println("[ERROR] Rute tidak ditemukan: " + e.getMessage());
        } catch (TiketHabisException e) {
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println("        Kereta         : " + e.getNamaKereta());
            System.out.println("        Sisa kursi     : " + e.getSisaKursi());
        }
    }

    static void tutupSistem() {
        System.out.println("Data disimpan");
    }
}