public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] hargaMenu = new int[3];

        for (int i = 0; i < 4; i++) {
            try {
                System.out.print("Masukkan harga menu ke-" + (i + 1) + ": ");
                hargaMenu[i] = scanner.nextInt();
                System.out.println("Harga menu ke-" + (i + 1) + " tersimpan: Rp " + hargaMenu[i]);
            } catch (InputMismatchException e) {
                System.out.println("Error: Input harga harus berupa angka!");
                scanner.next();
                i--;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Kapasitas memori harga sudah penuh!");
            }
        }

        Pelanggan pelanggan = new Pelanggan("Neila", 15);

        try {
            pelanggan.daftarMember(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Tertangkap: " + e.getMessage());
        }
        try {
            pelanggan.daftarMember(20); 
        } catch (IllegalArgumentException e) {
            System.out.println("Tertangkap: " + e.getMessage());
        }

        System.out.println();
        Pelanggan pelanggan2 = new Pelanggan("Elisabeth", 20);

        try {
            pelanggan2.pesanKopi(10);
        } catch (KopiHabisException e) {
            System.out.println("Tertangkap: " + e.getMessage());
        }

        System.out.println();
        MesinKasir kasir = new MesinKasir();

        try {
            kasir.bayar(50000, 30000); 
        } catch (UangKurangException e) {
            System.out.println("Tertangkap: " + e.getMessage());
        }

        try {
            kasir.bayar(50000, 70000); 
        } catch (UangKurangException e) {
            System.out.println("Tertangkap: " + e.getMessage());
        }

        System.out.println();
        try {
            kasir.cetakStruk(false); 
        } catch (Exception e) {
            System.out.println("Tertangkap: " + e.getMessage());
        } finally {
            System.out.println("Terima kasih telah berkunjung ke Cafe Java Bean. Program kasir ditutup.");
        }

        scanner.close();
    }
}