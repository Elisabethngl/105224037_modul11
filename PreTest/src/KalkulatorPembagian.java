import java.util.*;

public class KalkulatorPembagian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Masukkan angka pertama (pembilang): ");
            int pembilang = scanner.nextInt();
            
            System.out.print("Masukkan angka kedua (penyebut): ");
            int penyebut = scanner.nextInt();
            
            int hasil = pembilang / penyebut;
            System.out.println("Hasil pembagian: " + hasil);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: penyebut tidak boleh angka nol!");
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka.");
            
        } finally {
            scanner.close();
            System.out.println("Proses kalkulasi selesai dan resource memori telah dibersihkan.");
        }
    }
}