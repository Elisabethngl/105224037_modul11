public class Pelanggan {
    String nama;
    int umur;
    int stokKopi = 5;

    public Pelanggan(String nama, int umur){
        this.nama = nama;
        this.umur = umur;
    }

    public void daftarMember (int umur){
        if (umur < 17){
            throw new IllegalArgumentException(
                "umur anda belum mencukupi untuk jadi member VIP"
            );
        }
        System.out.println("anda berhasil terdaftar jadi member VIP");
    }

    public void pesanKopi (int jumlahPesanan){
        if (jumlahPesanan > stokKopi){
            throw new KopiHabisException ( "stok kopi habis! stok tersedia: " + stokKopi + "pesanan :" + jumlahPesanan);
        }
        stokKopi -= jumlahPesanan;
        System.out.println("pesanan berhasil! kopi di pesan:" + jumlahPesanan + "gelas. Sisa stok :" + stokKopi);
    }

}
