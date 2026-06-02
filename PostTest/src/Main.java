public class Main {
    public static void main(String[] args) {
        
        AkunBank nasabah = new AkunBank("1234-5678", 5000000);
        AkunBank rekeningLain = new AkunBank("9999-0000", 1000000);

        System.out.println("Rekening  : " + nasabah.nomorRekening);
        System.out.println("Saldo awal: Rp " + nasabah.saldo);
        System.out.println();

        try {
            System.out.println("tarik tunai Rp 5.000.000...");
            nasabah.tarikTunai(5000000);
            
            System.out.println("tarik lagi Rp 500.000 (saldo sudah habis)");
            nasabah.tarikTunai(500000); 

        } catch (SaldoTidakMencukupiException e) {
            System.out.println("GAGAL: " + e.getMessage());
        } finally {
            System.out.println();
        }

        AkunBank nasabah2 = new AkunBank("1234-5678", 20000000); 
        
        try {
            System.out.println("Transfer Rp 7.000.000 ke rekening lain...");
            nasabah2.transfer(rekeningLain, 7000000); 
            
            System.out.println("\nTransfer Rp 5.000.000 lagi (akan melebihi limit)...");
            nasabah2.transfer(rekeningLain, 5000000);
            
        } catch (SaldoTidakMencukupiException e) {
            System.out.println("GAGAL: " + e.getMessage());
        } catch (BatasTransferHarianException e) {
            System.out.println("GAGAL: " + e.getMessage());
        } finally {
            System.out.println();
        }

        // BLOK FINALLY PENUTUP
        try {
            System.out.println("Simulasi akhir sesi ATM...");
        } finally {
            System.out.println("Sesi transaksi ATM Anda telah diakhiri. Kartu dikeluarkan otomatis.");
        }
    }
}